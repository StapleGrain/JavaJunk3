package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class DListTest {

    @Test
    // tests toStringR and append
    void testAppendAndToStringR() {
        // cases to test
        DList<Object> a= new DList<>();
        assertEquals("[]", a.toString());
        assertEquals("[]", a.toStringR());
        assertEquals(0, a.size());
        a.append("a");
        assertEquals("[a]", a.toString());
        assertEquals("[a]", a.toStringR());
        assertEquals(1, a.size());
        a.append(12);
        assertEquals("[a, 12]", a.toString());
        assertEquals("[12, a]", a.toStringR());
        assertEquals(2, a.size());
    }

    // @Test
    // tests prepend
    void testprepend() {
        fail("Not yet implemented");
    }

    // @Test
    // tests getNode
    void testgetNode() {
        fail("Not yet implemented");
    }

    @Test
    // tests delete
    void testdelete() {
        DList<Object> d= new DList<>();
        d.append("A");
        d.append("B");
        d.append("C");
        d.append("D");
        d.append("E");
        assertEquals("[A, B, C, D, E]", d.toString());
        assertEquals("[E, D, C, B, A]", d.toStringR());
        assertEquals(5, d.size());
        d.delete(d.lastNode());
        assertEquals("[A, B, C, D]", d.toString());
        assertEquals("[D, C, B, A]", d.toStringR());
        assertEquals(4, d.size());
        d.delete(d.firstNode());
        assertEquals("[B, C, D]", d.toString());
        assertEquals("[D, C, B]", d.toStringR());
        assertEquals(3, d.size());
        d.delete(d.firstNode().succ());
        assertEquals("[B, D]", d.toString());
        assertEquals("[D, B]", d.toStringR());
        assertEquals(2, d.size());
        d.delete(d.lastNode());
        assertEquals("[B]", d.toString());
        assertEquals("[B]", d.toStringR());
        assertEquals(1, d.size());
        d.delete(d.lastNode());
        assertEquals("[]", d.toString());
        assertEquals("[]", d.toStringR());
        assertEquals(0, d.size());
    }

    // @Test
    // tests insertAfter
    void testinsertAfter() {
        fail("Not yet implemented");
    }
}
