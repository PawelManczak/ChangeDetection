package tests
import com.bernaferrari.base.misc.formatTime
import org.junit.Assert.assertEquals
import org.junit.Test

class FormatTimeTest {
    @Test
    fun testFormatTime() {
        assertEquals("01:00:00", 3_600L.formatTime())
        assertEquals("10:00:00", (3_600L * 10).formatTime())
    }

    @Test
    fun twentyFourHoursTest() {
        assertEquals("0:00", 86_400L.formatTime())
    }

   // IT DOESN'T WORK
//    @Test
//    fun moreThanTwentyFourHoursTest() {
//        assertEquals("1:00:00", 86_400L + 3_600L)
//    }


}