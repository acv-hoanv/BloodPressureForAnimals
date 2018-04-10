package com.example.acvdev_android.bloodpressuremeasurementforanimals.realmdb

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class User(@PrimaryKey var id : Long = 0,
           var mUsername : String = "",
           var mBirthday : String ="",
           var mIsMale : Boolean = false,
           var mHeight : Int = 0,
           var mWeight : Int = 0,
           var avartar : String = ""
           ) : RealmObject() {
}