package tests
import com.bernaferrari.changedetection.repo.findCharset
import org.junit.Assert.assertEquals
import org.junit.Test

class FindCharsetTest {

    @Test
    fun `findCharset finds charset in string`() {
        val stringWithCharset = "text/html; charset=utf-8"
        val charset = stringWithCharset.findCharset()
        assertEquals("utf-8", charset)
    }

    @Test
    fun `findCharset returns empty string if no charset found`() {
        val stringWithoutCharset = "text/html"
        val charset = stringWithoutCharset.findCharset()
        assertEquals("", charset)
    }

    @Test
    fun `findCharset returns charset ignoring case`() {
        val stringWithCharset = "text/html; charset=UTF-8"
        val charset = stringWithCharset.findCharset()
        assertEquals("UTF-8", charset)
    }

    @Test
    fun `findCharset returns charset when multiple parameters present`() {
        val stringWithCharset = "text/html; charset=utf-8; other=parameter"
        val charset = stringWithCharset.findCharset()
        assertEquals("utf-8", charset)
    }
}