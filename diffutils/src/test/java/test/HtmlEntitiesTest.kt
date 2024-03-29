package test

import com.bernaferrari.diffutils.diffs.text.StringUtils
import junit.framework.TestCase.assertEquals
import org.junit.Test

class HtmlEntitiesTest {
    @Test
    fun `htmlEntities correctly handles empty string`() {
        val input = ""
        val expected = ""
        val actual = StringUtils.htmlEntites(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `htmlEntities correctly handles string with no HTML entities`() {
        val input = "This is a test string"
        val expected = "This is a test string"
        val actual = StringUtils.htmlEntites(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `htmlEntities correctly handles string with HTML entities`() {
        val input = "<html><body>Hello, World!</body></html>"
        val expected = "&lt;html&gt;&lt;body&gt;Hello, World!&lt;/body&gt;&lt;/html&gt;"
        val actual = StringUtils.htmlEntites(input)
        assertEquals(expected, actual)
    }
}