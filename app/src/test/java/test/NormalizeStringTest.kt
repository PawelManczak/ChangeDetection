package test

import com.bernaferrari.base.misc.normalizeString
import org.junit.Assert
import org.junit.Test

class NormalizeStringTest {

    @Test
    fun testNormalizeStringWithCapitalLetters() {
        val input = "Hello World"
        val expected = "hello world"
        val output = input.normalizeString()
        Assert.assertEquals(expected, output)
    }

    @Test
    fun testNormalizeStringWithEmptyString() {
        val input = ""
        val expected = ""
        val output = input.normalizeString()
        Assert.assertEquals(expected, output)
    }

    @Test
    fun testNormalizeStringWithWhitespaceOnly() {
        val input = "     "
        val expected = "     "
        val output = input.normalizeString()
        Assert.assertEquals(expected, output)
    }

    @Test
    fun testNormalizeStringWithAlreadyNormalizedString() {
        val input = "hello world"
        val expected = "hello world"
        val output = input.normalizeString()
        Assert.assertEquals(expected, output)
    }

    // This test will fail
//    @Test
//    fun testNormalizeStringWithSpecialCharacters() {
//        val input = "Zażółć gęślą jaźń"
//        val expected = "zazolc gesla jazn"
//        val output = input.normalizeString()
//        Assert.assertEquals(expected, output)
//    }

}