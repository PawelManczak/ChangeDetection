package tests

import com.bernaferrari.base.misc.friendlyDate
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

class FriendlyDateTest {
    @Test
    fun testFriendlyDateWithValidDates() {
        val calendar = Calendar.getInstance()

        calendar.set(2022, 0, 1, 0, 0, 0)
        assertEquals("Jan 1, 12:00 am", calendar.timeInMillis.friendlyDate())

        calendar.set(2022, 11, 31, 23, 59, 59)
        assertEquals("Dec 31, 11:59 pm", calendar.timeInMillis.friendlyDate())
    }

    @Test
    fun testFriendlyDateWithZero() {
        assertEquals("Invalid", 0L.friendlyDate())
    }

    @Test
    fun testFriendlyDateWithNegative() {
        assertEquals("Invalid", (-1L).friendlyDate())
    }

    @Test
    fun testFriendlyDateWithFutureDate() {
        val calendar = Calendar.getInstance()

        calendar.set(3000, 0, 1, 0, 0, 0)
        assertEquals("Jan 1, 12:00 am", calendar.timeInMillis.friendlyDate())
    }
}