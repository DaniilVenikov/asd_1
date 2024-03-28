import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    private LinkedList emptyList;
    private LinkedList singleList;
    private LinkedList list;

    @Before
    public void setup() {
        emptyList = new LinkedList();
        singleList = new LinkedList();
        singleList.addInTail(new Node(1));
        list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(2));
    }

    @Test
    public void testAddInTail() {
        emptyList.addInTail(new Node(1));
        assertEquals(1, emptyList.head.value);
        assertEquals(1, emptyList.tail.value);

        singleList.addInTail(new Node(2));
        assertEquals(1, singleList.head.value);
        assertEquals(2, singleList.tail.value);

        list.addInTail(new Node(4));
        assertEquals(4, list.tail.value);
    }

    @Test
    public void testFind() {
        assertNull(emptyList.find(1));

        Node foundNode = list.find(2);
        assertNotNull(foundNode);
        assertEquals(2, foundNode.value);

        assertNull(list.find(4));
    }

    @Test
    public void testFindAll() {
        assertEquals(0, emptyList.findAll(1).size());

        assertEquals(1, list.findAll(1).size());
        assertEquals(2, list.findAll(2).size());
        assertEquals(3, list.findAll(3).get(0).value);

        assertEquals(0, list.findAll(4).size());
    }

    @Test
    public void testRemove() {
        assertFalse(emptyList.remove(1));

        assertTrue(singleList.remove(1));

        assertTrue(list.remove(2));
        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);

        assertFalse(list.remove(4));
    }

    @Test
    public void testRemoveAll() {
        emptyList.removeAll(1);
        assertEquals(0, emptyList.count());

        singleList.remove(2);
        assertEquals(1, singleList.count());

        list.removeAll(1);
        assertEquals(3, list.count());
        assertEquals(2, list.head.value);
        assertEquals(2, list.tail.value);

        list.removeAll(2);
        assertEquals(1, list.count());
        assertEquals(3, list.head.value);
        assertEquals(3, list.tail.value);
        assertEquals(1, list.count());

        list.removeAll(3);
        assertEquals(0, list.count());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testClear() {
        emptyList.clear();
        assertNull(emptyList.head);
        assertNull(emptyList.tail);

        singleList.clear();
        assertNull(singleList.head);
        assertNull(singleList.tail);

        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testCount() {
        assertEquals(0, emptyList.count());
        assertEquals(1, singleList.count());
        assertEquals(4, list.count());
    }

    @Test
    public void testInsertAfter() {
        emptyList.insertAfter(null, new Node(1));
        assertEquals(1, emptyList.head.value);
        assertEquals(1, emptyList.tail.value);

        singleList.insertAfter(singleList.tail, new Node(2));
        assertEquals(1, singleList.head.value);
        assertEquals(2, singleList.tail.value);

        list.insertAfter(list.head, new Node(4));
        assertEquals(4, list.head.next.value);
        assertEquals(2, list.tail.value);
    }
}

