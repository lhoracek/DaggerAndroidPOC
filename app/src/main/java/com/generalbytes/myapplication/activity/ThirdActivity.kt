package com.generalbytes.myapplication.activity

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.ActivityThirdBinding

class ThirdActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityThirdBinding>(this, R.layout.activity_third)
    }
}
