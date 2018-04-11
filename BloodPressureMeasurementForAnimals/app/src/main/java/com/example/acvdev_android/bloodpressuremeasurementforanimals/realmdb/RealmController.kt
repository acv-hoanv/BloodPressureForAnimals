package com.example.acvdev_android.bloodpressuremeasurementforanimals.realmdb

import android.util.Log
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.kotlin.where

/**
 * Created by Administrator on 4/10/2018.
 */
class RealmController private constructor() {
    private object Holder { val INSTANCE = RealmController() }
    private var mRealm: Realm? = null
    init {
        mRealm = Realm.getDefaultInstance()
    }
    companion object {
        val instance: RealmController by lazy { Holder.INSTANCE }
    }
    fun getRealm(): Realm? = mRealm
    fun getAllUser(): RealmResults<User>? = mRealm!!.where(User::class.java).findAll()
    fun addOrInsertUser(user: User): Unit {
        mRealm!!.beginTransaction()
        mRealm!!.copyToRealmOrUpdate(user)
        mRealm!!.commitTransaction()
    }

    fun getUserById(id: Long): User? {
        return mRealm!!.where(User::class.java).equalTo("id", id).findFirst()
    }

    fun deleteUser(user: User) {
        mRealm!!.beginTransaction()
        user.deleteFromRealm()
        mRealm!!.commitTransaction()
    }

    fun save(user: RealmObject) {
        mRealm!!.beginTransaction()
        mRealm!!.copyToRealmOrUpdate(user)
        mRealm!!.commitTransaction()
    }
}