package com.generalbytes.myapplication.activity

import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.ActivityBinding
import com.generalbytes.myapplication.vm.ActivityViewModel
import javax.inject.Inject

class FirstActivity: BaseActivity<ActivityBinding, ActivityViewModel>(R.layout.activity) {

    @Inject lateinit var vm: ActivityViewModel
    // @Inject lateinit var fragmentManager: FragmentManager

    override fun createViewModel() = vm
}
