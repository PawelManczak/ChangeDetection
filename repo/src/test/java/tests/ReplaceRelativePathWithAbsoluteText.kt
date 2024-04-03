package tests

import com.bernaferrari.changedetection.repo.replaceRelativePathWithAbsolute
import org.junit.Assert.assertEquals
import org.junit.Test

class ReplaceRelativePathWithAbsoluteText {

    @Test
    fun `replaceRelativePathWithAbsolute replaces relative paths with absolute paths`() {
        val stringWithRelativePath = "<img src=\"image.jpg\">"
        val stringWithAbsolutePath =
            stringWithRelativePath.replaceRelativePathWithAbsolute("http://example.com")
        assertEquals("<img src=\"http://example.com/image.jpg\">", stringWithAbsolutePath)
    }

    @Test
    fun `replaceRelativePathWithAbsolute does not replace absolute paths`() {
        val stringWithAbsolutePath = "<img src=\"http://example.com/image.jpg\">"
        val result = stringWithAbsolutePath.replaceRelativePathWithAbsolute("http://example.com")
        assertEquals(stringWithAbsolutePath, result)
    }

    @Test
    fun `replaceRelativePathWithAbsolute does not replace valid websites`() {
        val stringWithWebsite = "<a href=\"http://example.com\">Website</a>"
        val result = stringWithWebsite.replaceRelativePathWithAbsolute("http://example.com")
        assertEquals(stringWithWebsite, result)
    }
}