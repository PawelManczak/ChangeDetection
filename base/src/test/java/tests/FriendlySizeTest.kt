package tests

import com.bernaferrari.base.misc.friendlySize
import org.junit.Assert.assertEquals
import org.junit.Test

class FriendlySizeTest {

    @Test
    fun testFriendlySize() {
        assertEquals("999B", 999L.friendlySize())
    }

    @Test
    fun testFriendlySizeEdgeCases() {
        assertEquals("1KB", 1024L.friendlySize())
        assertEquals("1MB", 1_048_576L.friendlySize())
        assertEquals("1GB", 1_073_741_824L.friendlySize())
    }

    @Test
    fun testFriendlySizeZero() {
        assertEquals("0B", 0L.friendlySize())
    }

}