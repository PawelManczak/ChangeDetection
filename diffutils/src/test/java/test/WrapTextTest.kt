import com.bernaferrari.diffutils.diffs.text.StringUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class WrapTextTest {

    @Test
    fun `wrapText correctly wraps text when column width is less than string length`() {
        val input = "This is a test string"
        val expected = "This is a <br/>test strin<br/>g"
        val actual = StringUtils.wrapText(input, 10)
        assertEquals(expected, actual)
    }

    @Test
    fun `wrapText correctly returns original string when column width is equal to or greater than string length`() {
        val input = "This is a test string"
        val expected = input
        val actual = StringUtils.wrapText(input, 50)
        assertEquals(expected, actual)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `wrapText throws IllegalArgumentException when column width is less than 0`() {
        val input = "This is a test string"
        StringUtils.wrapText(input, -1)
    }
}
