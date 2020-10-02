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

    @Test
    // tests prepend
    void testprepend() {
    	DList<Object> d= new DList<>();
    	assertEquals(null,d.firstNode());
    	assertEquals(null,d.lastNode());
    	assertEquals(0,d.size());
    	d.prepend(7);
    	assertEquals(7,d.first());
    	assertEquals(null,d.firstNode().pred());
    	assertEquals(null,d.firstNode().succ());
    	assertEquals(7,d.firstNode().value());
    	d.prepend(8);
    	d.prepend(9);
    	d.prepend(10);
    	assertEquals(10,d.first());
    	assertEquals(null,d.firstNode().pred());
    	assertEquals(9,d.firstNode().succ().value());
    	
    	assertEquals(10,d.firstNode().succ().pred().value());
    	assertEquals(8,d.firstNode().succ().succ().value());
    	
    }

    @Test
    // tests getNode
    void testgetNode() {
    	DList<Object> d= new DList<>();
    	for(int i=9;i>-1;i--) {
    		d.prepend(i);
    	}
    	d.getNode(3).value();
    	System.out.println(d.toString());
    	
    	System.out.println(d.getNode(3).value());
    	assertEquals(0,d.getNode(0).value());
    	assertEquals(8,d.getNode(8).value());
    	
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
    	assertEquals(10,d.last());
    	assertEquals(null,d.lastNode().succ());
    	assertEquals(9,d.lastNode().pred().value());
    }
}
