package com.generalbytes.myapplication.activity

import android.widget.Button
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.endsWith
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class FirstActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<FirstActivity> = ActivityTestRule(FirstActivity::class.java)


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.generalbytes.myapplication", appContext.packageName)
    }

    val viewStartText = "All running :"
    @Test
    fun testFirstActivity() {
        // Type text and then press the button.
        onView(allOf(
            isAssignableFrom(TextView::class.java),
            withText(startsWith(viewStartText)))
        ).check(ViewAssertions.matches(withText(endsWith("NO"))))

        onView(allOf(
            isAssignableFrom(Button::class.java),
            withText("Service 01"))
        ).perform(click())

        onView(allOf(
            isAssignableFrom(TextView::class.java),
            withText(startsWith(viewStartText)))
        ).check(ViewAssertions.matches(withText(endsWith("NO"))))

        onView(allOf(
            isAssignableFrom(Button::class.java),
            withText("Service 02"))
        ).perform(click())

        onView(allOf(
            isAssignableFrom(TextView::class.java),
            withText(startsWith(viewStartText)))
        ).check(ViewAssertions.matches(withText(endsWith("NO"))))

        onView(allOf(
            isAssignableFrom(Button::class.java),
            withText("Service 03"))
        ).perform(click())

        onView(allOf(
            isAssignableFrom(TextView::class.java),
            withText(startsWith(viewStartText)))
        ).check(ViewAssertions.matches(withText(endsWith("YES"))))

        onView(allOf(
            isAssignableFrom(Button::class.java),
            withText("Service 01"))
        ).perform(click())

        onView(allOf(
            isAssignableFrom(TextView::class.java),
            withText(startsWith(viewStartText)))
        ).check(ViewAssertions.matches(withText(endsWith("NO"))))

        onView(allOf(
            isAssignableFrom(Button::class.java),
            withText("Service 02"))
        ).perform(click())

        onView(allOf(
            isAssignableFrom(TextView::class.java),
            withText(startsWith(viewStartText)))
        ).check(ViewAssertions.matches(withText(endsWith("NO"))))

        onView(allOf(
            isAssignableFrom(Button::class.java),
            withText("Service 03"))
        ).perform(click())

        onView(allOf(
            isAssignableFrom(TextView::class.java),
            withText(startsWith(viewStartText)))
        ).check(ViewAssertions.matches(withText(endsWith("NO"))))
    }

}