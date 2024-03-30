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
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class RenameWebsiteTest {

    val url = "https://bernaferrari.com"
    val title = "New Tracking"
    val newTitle = "New Title"

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        Espresso.onView(ViewMatchers.withId(R.id.floating_add_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.url)).perform(ViewActions.typeText(url))
        Espresso.onView(ViewMatchers.withId(R.id.title)).perform(ViewActions.typeText(title))
        Espresso.closeSoftKeyboard()

        Thread.sleep(500)
        Espresso.onView(ViewMatchers.withId(R.id.saveButton)).perform(ViewActions.click())
    }

    @Test
    fun renameWebsiteTest() {
        Espresso.onView(ViewMatchers.withText(title)).perform(ViewActions.longClick())
        Espresso.onView(ViewMatchers.withText("Edit")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.title)).perform(ViewActions.clearText())
        Espresso.onView(ViewMatchers.withId(R.id.title)).perform(ViewActions.typeText(newTitle))
        Espresso.closeSoftKeyboard()

        Thread.sleep(500)
        Espresso.onView(ViewMatchers.withId(R.id.saveButton)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText(newTitle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}