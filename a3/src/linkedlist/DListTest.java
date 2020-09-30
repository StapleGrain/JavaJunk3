package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class DListTest {

    @Test
    // tests toStringR and append
    void test1and2() {
        // cases to test
        DList<Object> a= new DList<>();
        assertEquals("[]", a.toStringR());
        assertEquals(0, a.size());
        assertEquals(null, a.firstNode());
        assertEquals(null, a.lastNode());
        a.append("a");
        assertEquals("[a]", a.toStringR());
        assertEquals(1, a.size());
        assertEquals("a", a.first());
        assertEquals("a", a.last());
        assertEquals(null, a.firstNode().pred());
        assertEquals(null, a.firstNode().succ());
        a.append(12);
        assertEquals("[12, a]", a.toStringR());
        assertEquals(2, a.size());
        assertEquals("a", a.first());
        assertEquals(12, a.last());
        assertEquals(null, a.firstNode().pred());
        assertEquals(12, a.firstNode().succ().value());
        assertEquals(null, a.lastNode().succ());
        assertEquals("a", a.lastNode().pred().value());
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
        assertEquals(5, d.size());
        d.delete(d.lastNode());
        assertEquals("[A, B, C, D]", d.toString());
        assertEquals(4, d.size());
        assertEquals("D", d.last());
        assertEquals(null, d.lastNode().succ());
        d.delete(d.firstNode());
        assertEquals("[B, C, D]", d.toString());
        assertEquals(3, d.size());
        assertEquals("B", d.first());
        assertEquals(null, d.firstNode().pred());
        d.delete(d.firstNode().succ());
        assertEquals("[B, D]", d.toString());
        assertEquals(2, d.size());
        assertEquals("D", d.firstNode().succ().value());
        assertEquals("B", d.lastNode().pred().value());
        d.delete(d.lastNode());
        assertEquals("[B]", d.toString());
        assertEquals(1, d.size());
        assertEquals(null, d.firstNode().succ());
        assertEquals(null, d.lastNode().pred());
        assertEquals("B", d.last());
        d.delete(d.lastNode());
        assertEquals("[]", d.toString());
        assertEquals(0, d.size());
        assertEquals(null, d.firstNode());
        assertEquals(null, d.lastNode());
    }

    // @Test
    // tests insertAfter
    void testinsertAfter() {
        fail("Not yet implemented");
    }
}
