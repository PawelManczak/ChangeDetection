package tests

import com.bernaferrari.base.misc.timestampString
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

class TimestampStringTest {
    @Test
    fun testTimestampStringWithValidDates() {
        val calendar = Calendar.getInstance()

        calendar.set(2022, 0, 1, 0, 0, 0)
        assertEquals("January1-120000AM", calendar.time.timestampString())

        calendar.set(2022, 11, 31, 23, 59, 59)
        assertEquals("December31-115959PM", calendar.time.timestampString())
    }

    @Test
    fun testTimestampStringWithZero() {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = 0L
        assertEquals("Invalid", calendar.time.timestampString())
    }

    @Test
    fun testTimestampStringWithNegative() {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = -1L
        assertEquals("Invalid", calendar.time.timestampString())
    }

    @Test
    fun testTimestampStringWithFutureDate() {
        val calendar = Calendar.getInstance()

        calendar.set(3000, 0, 1, 0, 0, 0)
        assertEquals("January1-120000AM", calendar.time.timestampString())
    }
}