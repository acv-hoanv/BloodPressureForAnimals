package com.example.acvdev_android.bloodpressuremeasurementforanimals.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.acvdev_android.bloodpressuremeasurementforanimals.R

class SearchView : RelativeLayout, View.OnClickListener {
    var search_imv_Search: ImageView? = null
    var search_edt_Input: EditText? = null
    var isSearch: Boolean = true

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }


    private fun init(attrs: AttributeSet?) {
        val inflate = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflate.inflate(R.layout.layout_view_search, this, true)
        search_imv_Search = findViewById(R.id.search_imv_Search)
        search_edt_Input = findViewById(R.id.search_edt_Input)
        search_imv_Search!!.setOnClickListener(this)

    }

    fun View.hidekeyboard() {
        search_edt_Input!!.setText("")
        search_edt_Input!!.clearFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    fun View.showkeyboard(){
       val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(search_edt_Input,InputMethodManager.SHOW_IMPLICIT)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.search_imv_Search -> {
                if (isSearch) {
                    showkeyboard()
                    isSearch = false
                    search_imv_Search!!.setImageResource(R.drawable.ic_action_exit)
                    search_edt_Input!!.visibility = View.VISIBLE
                } else {
                    isSearch = true
                    search_imv_Search!!.setImageResource(R.drawable.ic_action_search)
                    search_edt_Input!!.visibility = View.GONE
                    hidekeyboard()
                }
            }

        }
    }
}