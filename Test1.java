import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class Test1 extends TestCase {
	private Link<Integer> head = new Link<Integer>(new Integer(1));
	private Link<Integer> middle = new Link<Integer>(new Integer(2));
	private Link<Integer> tail = new Link<Integer>(new Integer(3));
	
	private SimpleLinkedList<Link> testLLOne = new SimpleLinkedList<Link>();
	private SimpleLinkedList<Link> testLLTwo = new SimpleLinkedList<Link>();
	
	/*
	 * Add some links to the end of a linked list. 
	 * Get the last one, and check it against the object you
	 * add last.
	 */
	@Test
	public void testAddLast() {
		testLLOne.addLast(head);
		testLLOne.addLast(middle);
		testLLOne.addLast(tail);
		
		assertSame(tail, testLLOne.getLast());
	}

	/*
	 * Add some links to the head of a linked list. 
	 * Get the first one, and check it against the last object
	 * you added.
	 */
	public void testAddFirst() {
		testLLOne.addFirst(head);
		testLLOne.addFirst(middle);
		testLLOne.addFirst(tail);

		assertSame(tail, testLLOne.getFirst());
	}

	/*
	 * Add "middle" link to the head of a linked list using
	 * insertBefore. Then add tail to head of the list with
	 * the same method. Then tail should be at head. Test it
	 * with assertSame. 
	 */
	public void testInsertBefore() {
		testLLOne.insertBefore(null, middle);
		testLLOne.insertBefore(middle, tail);

		assertSame(tail, testLLOne.getFirst());
	}

	/*
	 * Add "middle" link to the tail of a linked list using
	 * insertAfter. Then add tail to tail of the list with
	 * the same method. Then tail should be at tail. Test it
	 * with assertSame. 
	 */
	public void testInsertAfter() {
		testLLOne.insertAfter(null, middle);
		testLLOne.insertAfter(middle, tail);
		
		assertSame(tail, testLLOne.getLast());
	}

	/*
	 * Add "middle" and "head" links to the linked list.
	 * Remove "middle" from the list with remove.
	 * Assert that middle is not in the list with 
	 * assertFalse.
	 */
	public void testRemove() {
		testLLOne.addFirst(middle);
		testLLOne.addFirst(head);
		
		testLLOne.remove(middle);
		
		assertFalse(testLLOne.contains(middle));
	}

	/*
	 * Add "middle" and "head" links to the linked list.
	 * Assert that middle is in the list with 
	 * assertTrue.
	 */
	public void testContains() {
		testLLOne.addFirst(middle);
		testLLOne.addFirst(head);
		
		assertTrue(testLLOne.contains(middle));
	}

	/*
	 * Add head, middle, and tail links to a linked
	 * list. Clear the list using clear(), then
	 * check it using the size() method and
	 * assertEquals.
	 */
	public void testClear() {
		testLLOne.addFirst(tail);
		testLLOne.addFirst(middle);
		testLLOne.addFirst(head);
		
		testLLOne.clear();
		
		assertEquals(0, testLLOne.size());
	}

	/*
	 * Add head, middle, and tail links to a linked
	 * list. Get the first one using the getFirst
	 * method and assertEquals.
	 */
	public void testGetFirst() {
		testLLOne.addFirst(head);
		testLLOne.addFirst(middle);
		testLLOne.addFirst(tail);

		assertSame(tail, testLLOne.getFirst());
	}

	public void testGetLast() {
		testLLOne.addLast(head);
		testLLOne.addLast(middle);
		testLLOne.addLast(tail);
		
		assertSame(tail, testLLOne.getLast());
	}

	public void testGetNext() {
		fail("Not yet implemented");
	}

	public void testSize() {
		fail("Not yet implemented");
	}

	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	public void testPush() {
		fail("Not yet implemented");
	}

	public void testPop() {
		fail("Not yet implemented");
	}

	public void testIterator() {
		fail("Not yet implemented");
	}

}
