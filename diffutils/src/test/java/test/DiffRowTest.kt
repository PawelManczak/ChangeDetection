import org.junit.Assert.assertEquals
import org.junit.Test
import com.bernaferrari.diffutils.diffs.text.DiffRow
import com.bernaferrari.diffutils.diffs.text.DiffRow.Tag
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull

class DiffRowTest {

    @Test
    fun testTag() {
        val diffRow = DiffRow(Tag.INSERT, "oldLine", "newLine")
        assertEquals(Tag.INSERT, diffRow.tag)
    }

    @Test
    fun testOldLine() {
        val diffRow = DiffRow(Tag.INSERT, "oldLine", "newLine")
        assertEquals("oldLine", diffRow.oldLine)
    }

    @Test
    fun testNewLine() {
        val diffRow = DiffRow(Tag.INSERT, "oldLine", "newLine")
        assertEquals("newLine", diffRow.newLine)
    }

    @Test
    fun testEquals() {
        val diffRow1 = DiffRow(Tag.INSERT, "oldLine", "newLine")
        val diffRow2 = DiffRow(Tag.INSERT, "oldLine", "newLine")
        assertEquals(diffRow1, diffRow2)
    }

    @Test
    fun testHashCode() {
        val diffRow = DiffRow(Tag.INSERT, "oldLine", "newLine")
        val expectedHashCode = diffRow.hashCode()
        assertEquals(expectedHashCode, diffRow.hashCode())
    }

    @Test
    fun testToString() {
        val diffRow = DiffRow(Tag.INSERT, "oldLine", "newLine")
        val expectedString = "[INSERT,oldLine,newLine]"
        assertEquals(expectedString, diffRow.toString())
    }

    @Test
    fun testDifferentOldAndNewLines() {
        val diffRow = DiffRow(Tag.INSERT, "oldLine", "newLine")
        assertNotEquals(diffRow.oldLine, diffRow.newLine)
    }

    @Test
    fun testNullOldLine() {
        val diffRow = DiffRow(Tag.INSERT, null, "newLine")
        assertNull(diffRow.oldLine)
        assertNotNull(diffRow.newLine)
    }

    @Test
    fun testNullNewLine() {
        val diffRow = DiffRow(Tag.INSERT, "oldLine", null)
        assertNotNull(diffRow.oldLine)
        assertNull(diffRow.newLine)
    }

    @Test
    fun testChangeTag() {
        val diffRow = DiffRow(Tag.INSERT, "oldLine", "newLine")
        diffRow.tag = Tag.DELETE
        assertEquals(Tag.DELETE, diffRow.tag)
    }
}