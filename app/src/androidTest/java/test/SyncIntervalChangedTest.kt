package test

import android.view.View
import android.widget.SeekBar
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.bernaferrari.changedetection.MainActivity
import com.bernaferrari.changedetection.R
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class SyncIntervalChangedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun SyncIntervalChangedTest() {
        Espresso.onView( ViewMatchers.withId(R.id.settingsFragment)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.seekBar)).perform(setProgress(8))
        Espresso.onView(ViewMatchers.withText("24 hours")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun multipleIntervalChangeTest() {
        Espresso.onView(ViewMatchers.withId(R.id.settingsFragment)).perform(ViewActions.click())
        for (i in 1..4) {
            Espresso.onView(ViewMatchers.withId(R.id.seekBar)).perform(setProgress(i * 2))
            Thread.sleep(100)
        }
        Espresso.onView(ViewMatchers.withText("24 hours")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    fun setProgress(progress: Int): ViewAction {
        return object : ViewAction {
            override fun perform(uiController: UiController?, view: View) {
                val seekBar = view as SeekBar
                seekBar.progress = progress
            }

            override fun getDescription(): String {
                return "Set a progress on a SeekBar"
            }

            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(SeekBar::class.java)
            }
        }
    }
}