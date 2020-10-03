package linkedlist;

import static org.junit.Assert.assertThrows;
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

    @Test
    // tests prepend
    void testprepend() {
    	DList<Object> d= new DList<>();
    	assertEquals("[]", d.toString());
        assertEquals("[]", d.toStringR());
        assertEquals(0, d.size());
    	
        d.prepend(7);
        assertEquals("[7]",d.toString());
        assertEquals("[7]",d.toStringR());
        assertEquals(1,d.size());
        
        d.prepend(77);
        assertEquals("[77, 7]",d.toString());
        assertEquals("[7, 77]",d.toStringR());
        assertEquals(2,d.size());
        
        d.prepend("yo mama!");
        assertEquals("[yo mama!, 77, 7]",d.toString());
        assertEquals("[7, 77, yo mama!]",d.toStringR());
        assertEquals(3,d.size());
    }

    @Test
    // tests getNode
    void testgetNode() {
    	
    	DList<Object> d= new DList<>();
    	for(int i=9;i>-1;i--) {
    		d.prepend(i);
    	}
    	assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]",d.toString());
    	
    	assertThrows(IllegalArgumentException.class, () -> {d.getNode(-1);});
    	assertThrows(IllegalArgumentException.class, () -> {d.getNode(10);});
    	assertThrows(IllegalArgumentException.class, () -> {d.getNode(77);});
    	DList<Object> d2= new DList<>();
    	assertThrows(IllegalArgumentException.class, () -> {d2.getNode(0);});
    	
    	//HOW DO I USE toString to test this??
    	//Do I need to test that it's done it that particular time?

    	assertEquals(0,d.getNode(0).value());
    	assertEquals(8,d.getNode(8).value());
    	assertEquals(6,d.getNode(7).pred().value());
    	assertEquals(8,d.getNode(7).succ().value());
    	
    	assertEquals(null,d.getNode(0).pred());
    	assertEquals(null,d.getNode(9).succ());
    	
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

    @Test
    // tests insertAfter
    void testinsertAfter() {
    	DList<Object> d= new DList<>();
    	for(int i=9;i>-1;i--) {
    		d.prepend(i);
    	}
    	
    	d.insertAfter(10,d.lastNode());
    	assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]",d.toString());
    	assertEquals("[10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", d.toStringR());
    	assertEquals(11,d.size());
    	
    	d.insertAfter("7 is the best", d.getNode(7));
    	assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 7 is the best, 8, 9, 10]", d.toString());
    	assertEquals("[10, 9, 8, 7 is the best, 7, 6, 5, 4, 3, 2, 1, 0]",d.toStringR());
    	assertEquals(12,d.size());
    	
    	DList<Object> d2= new DList<>();
    	assertThrows(AssertionError.class, () -> d2.insertAfter(2, d2.firstNode()));
    }
}
