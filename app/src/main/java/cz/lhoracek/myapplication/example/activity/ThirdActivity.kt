package cz.lhoracek.myapplication.example.activity

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import cz.lhoracek.myapplication.R
import cz.lhoracek.myapplication.databinding.ActivityThirdBinding

class ThirdActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityThirdBinding>(this, R.layout.activity_third)
    }
}
