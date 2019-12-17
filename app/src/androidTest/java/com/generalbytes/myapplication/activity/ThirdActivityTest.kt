package com.generalbytes.myapplication.activity

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.facebook.testing.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@LargeTest
class ThirdActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<ThirdActivity> = ActivityTestRule(ThirdActivity::class.java)

    @Test
    fun useAppContext() {
         // TODO
        Screenshot.snapActivity(activityRule.activity).setName("A").record()
        Screenshot.snapActivity(activityRule.activity).setName("B").record()
        Screenshot.snapActivity(activityRule.activity).setName("C").record()
        Screenshot.snapActivity(activityRule.activity).setName("D").record()
    }

}