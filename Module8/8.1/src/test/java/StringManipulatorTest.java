import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    @Test
    void concatenate() {
        StringManipulator m = new StringManipulator();
        assertEquals("abcdef", m.concatenate("abc", "def"));
    }

    @Test
    void findLength() {
        StringManipulator m = new StringManipulator();
        assertEquals(3, m.findLength("abc"));
    }

    @Test
    void convertToLowerCase() {
        StringManipulator m = new StringManipulator();
        assertEquals("abc", m.convertToLowerCase("ABC"));
    }

    @Test
    void containsSubstring() {
        StringManipulator m = new StringManipulator();
        assertTrue(m.containsSubstring("abcdefghijk", "def"));
        assertFalse(m.containsSubstring("abcdefghijk", "xyz"));
    }
}