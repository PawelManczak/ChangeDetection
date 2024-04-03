package tests

import com.bernaferrari.changedetection.repo.regexEmail
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RegexEmailTest {

    @Test
    fun `regexEmail matches valid email addresses`() {
        val validEmail = "test@example.com"
        assertTrue(validEmail.matches(regexEmail()))
    }

    @Test
    fun `regexEmail does not match invalid email addresses`() {
        val invalidEmail = "not an email"
        assertFalse(invalidEmail.matches(regexEmail()))
    }

    @Test
    fun `regexEmail matches email addresses with subdomains`() {
        val emailWithSubdomain = "test@sub.example.com"
        assertTrue(emailWithSubdomain.matches(regexEmail()))
    }

    @Test
    fun `regexEmail does not match email addresses without domain`() {
        val emailWithoutDomain = "test@"
        assertFalse(emailWithoutDomain.matches(regexEmail()))
    }

    @Test
    fun `regexEmail does not match email addresses without local part`() {
        val emailWithoutLocalPart = "@example.com"
        assertFalse(emailWithoutLocalPart.matches(regexEmail()))
    }
}