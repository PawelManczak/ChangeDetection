package test

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.bernaferrari.changedetection.MainActivity
import com.bernaferrari.changedetection.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@RunWith(AndroidJUnit4::class)
@LargeTest
class AddWebsiteTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addWebsiteTest() {
        val url = "https://bernaferrari.com"
        val title = "New Tracking"
        Espresso.onView(ViewMatchers.withId(R.id.floating_add_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.url)).perform(ViewActions.typeText(url))
        Espresso.onView(ViewMatchers.withId(R.id.title)).perform(ViewActions.typeText(title))
        Espresso.closeSoftKeyboard()

        sleep(500)
        Espresso.onView(ViewMatchers.withId(R.id.saveButton)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText(title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}