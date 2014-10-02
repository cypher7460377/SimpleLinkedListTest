package test;

import java.util.Iterator;

import junit.framework.TestCase;
import list.Link;
import list.SimpleLinkedList;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.AnyVararg;


public class Test1 extends TestCase {
	private Link<Integer> head = new Link<Integer>(new Integer(1));
	private Link<Integer> middle = new Link<Integer>(new Integer(2));
	private Link<Integer> tail = new Link<Integer>(new Integer(3));
	
	@SuppressWarnings("rawtypes")
	private SimpleLinkedList<Link> testLLOne = new SimpleLinkedList<Link>();
	
	/*
	 * Stub methods from the Link class. 
	 * First we will stub the isMemberOf
	 * method to return true.
	 */
	
	/*@Test
	public void testIsMemberOfMock() {
		Link<Integer> link = Mockito.mock(Link.class);
		testLLOne.addFirst(link);
		//Mockito.stub(link.isMemberOf((SimpleLinkedList<? extends Linkable>) Mockito.anyList())).toReturn(true);
		//((Mockito) link).when(link.isMemberOf(testLLOne)).thenReturn(true);
		@SuppressWarnings("unused")
		boolean what = link.isMemberOf(testLLOne);
		assertTrue(link.isMemberOf(testLLOne));
	}
*/
	
	/*
	 * Stub methods from the Link class. 
	 * Now we will stub the getData
	 * method to return an Integer with a value 
	 * of 1.
	 */
	@Test
	public void testGetDataMock() {
		Link<Integer> link = Mockito.mock(Link.class);
		Mockito.stub(link.getData()).toReturn(1);
		Integer one = new Integer(1);
		
		assertTrue(link.getData() == 1);
	}
	
	/*
	 * Stub methods from the Link class. 
	 * Now we will stub the setData
	 * method and then we will use verify
	 * to check if the method was called.
	 */
	/*@Test
	public void testSetDataMock() {
		Link<Integer> link = Mockito.mock(Link.class);
		Mockito.stub(link.setData(Integer.valueOf(1)).toReturn(true);

		Mockito.verify(link, times(1)).setData();
	}*/
	
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
	 * Add some links to the end of a linked list.
	 * I should be able to pop it twice and get 
	 * the head of the list. I will check it with
	 * assertSame.
	 */
	@Test
	public void testAddLastWithPop() {
		testLLOne.addLast(head);
		testLLOne.addLast(middle);
		testLLOne.addLast(tail);
		
		testLLOne.pop();
		testLLOne.pop();
		assertSame(head, testLLOne.pop());
	}

	/*
	 * Add some links to the head of a linked list. 
	 * Get the first one, and check it against the last object
	 * you added.
	 */
	@Test
	public void testAddFirst() {
		testLLOne.addFirst(head);
		testLLOne.addFirst(middle);
		testLLOne.addFirst(tail);

		assertSame(tail, testLLOne.getFirst());
	}
	
	/*
	 * Add some links to the head of a linked list.
	 * I should be able to pop it twice and get 
	 * the tail of the list. I will check it with
	 * assertSame.
	 */
	@Test
	public void testAddFirstWithPop() {
		testLLOne.addFirst(tail);
		testLLOne.addFirst(middle);
		testLLOne.addFirst(head);

		assertSame(tail, testLLOne.pop());
	}

	/*
	 * Add "middle" link to the head of a linked list using
	 * insertBefore. Then add tail to head of the list with
	 * the same method. Then tail should be at head. Test it
	 * with assertSame. 
	 */
	@Test
	public void testInsertBefore() {
		testLLOne.insertBefore(null, middle);
		testLLOne.insertBefore(middle, tail);

		assertSame(tail, testLLOne.getFirst());
	}
	
	/*
	 * Add "middle" link to the head of a linked list using
	 * insertBefore. Then add tail to head of the list with
	 * the same method. Then middle should be at the tail of
	 * the list. I will test it with assertSame and pop(). 
	 */
	@Test
	public void testInsertBeforeWithPop() {
		testLLOne.insertBefore(null, middle);
		testLLOne.insertBefore(middle, tail);

		assertSame(middle, testLLOne.pop());
	}

	/*
	 * Add "middle" link to the tail of a linked list using
	 * insertAfter. Then add tail to tail of the list with
	 * the same method. Then tail should be at tail. Test it
	 * with assertSame. 
	 */
	@Test
	public void testInsertAfter() {
		testLLOne.insertAfter(null, middle);
		testLLOne.insertAfter(middle, tail);
		
		assertSame(tail, testLLOne.getLast());
	}
	
	/*
	 * Add "middle" link to the tail of a linked list using
	 * insertAfter. Then add tail to tail of the list with
	 * the same method. Then tail should be at tail. I will
	 * test it against middle with assertNotSame. 
	 */
	@Test
	public void testInsertAfterWithPop() {
		testLLOne.insertAfter(null, middle);
		testLLOne.insertAfter(middle, tail);
		
		assertNotSame(middle, testLLOne.pop());
	}

	/*
	 * Add "middle" and "head" links to the linked list.
	 * Remove "middle" from the list with remove.
	 * Assert that middle is not in the list with 
	 * assertFalse.
	 */
	@Test
	public void testRemove() {
		testLLOne.addFirst(middle);
		testLLOne.addFirst(head);
		
		testLLOne.remove(middle);
		
		assertFalse(testLLOne.contains(middle));
	}
	
	/*
	 * Add mock links to the linked list.
	 * Remove a mock from the list with remove.
	 * Assert that the size is only one with 
	 * assertEquals.
	 */
	@Test
	public void testRemoveMock() {
		Link<Integer> link = Mockito.mock(Link.class);
		testLLOne.addFirst(link);
		
		testLLOne.remove(link);
		
		assertFalse(testLLOne.contains(link));
	}

	/*
	 * Add "middle" and "head" links to the linked list.
	 * Assert that middle is in the list with 
	 * assertTrue.
	 */
	@Test
	public void testContains() {
		testLLOne.addFirst(middle);
		testLLOne.addFirst(head);
		
		assertTrue(testLLOne.contains(middle));
	}
	
	/*
	 * Add a mock link to the linked list.
	 * Assert that the mock is in the list 
	 * with assertTrue.
	 */
	@Test
	public void testContainsMock() {
		Link<Integer> link = Mockito.mock(Link.class);
		testLLOne.addFirst(link);
		
		assertTrue(testLLOne.contains(link));
	}

	/*
	 * Add head, middle, and tail links to a linked
	 * list. Clear the list using clear(), then
	 * check it using the size() method and
	 * assertEquals.
	 */
	@Test
	public void testClear() {
		testLLOne.addFirst(tail);
		testLLOne.addFirst(middle);
		testLLOne.addFirst(head);
		
		testLLOne.clear();
		
		assertEquals(0, testLLOne.size());
	}
	
	/*
	 * Add mock links to a linked
	 * list. Clear the list using clear(), then
	 * check it using the size() method and
	 * assertEquals.
	 */
	@Test
	public void testClearMock() {
		testLLOne.addFirst(Mockito.mock(Link.class));
		testLLOne.addFirst(Mockito.mock(Link.class));
		testLLOne.addFirst(Mockito.mock(Link.class));
		
		testLLOne.clear();
		
		assertEquals(0, testLLOne.size());
	}

	/*
	 * Add head, middle, and tail links to a linked
	 * list. Get the first one using the getFirst
	 * method and assertEquals.
	 */
	@Test
	public void testGetFirst() {
		testLLOne.addFirst(head);
		testLLOne.addFirst(middle);
		testLLOne.addFirst(tail);

		assertSame(tail, testLLOne.getFirst());
	}
	
	/*
	 * Add head, middle, and tail links to a linked
	 * list. Get the first one using the push
	 * method, and head should be at the start. I will
	 * check it with assertSame.
	 */
	@Test
	public void testGetFirstWithPush() {
		testLLOne.push(head);
		testLLOne.push(middle);
		testLLOne.push(tail);

		assertSame(head, testLLOne.getFirst());
	}

	/*
	 * Add head, middle, and tail links to the
	 * end of a linked list. Get the last one 
	 * using the getLast method and 
	 * assertEquals.
	 */
	@Test
	public void testGetLast() {
		testLLOne.addLast(head);
		testLLOne.addLast(middle);
		testLLOne.addLast(tail);
		
		assertSame(tail, testLLOne.getLast());
	}
	
	/*
	 * Add head, middle, and tail links to the
	 * end of a linked list. Tail should be at
	 * the end of the list. I will use the 
	 * getLast method and check it with
	 * assertSame.
	 */
	@Test
	public void testGetLastWithPush() {
		testLLOne.push(head);
		testLLOne.push(middle);
		testLLOne.push(tail);
		
		assertSame(tail, testLLOne.getLast());
	}

	/*
	 * Clear the list and add head, middle, and tail 
	 * links to a linked list.  Call size on the list 
	 * and assertEquals for size 3.
	 */
	@Test
	public void testSize() {
		testLLOne.clear();
		testLLOne.addFirst(head);
		testLLOne.addFirst(middle);
		testLLOne.addFirst(tail);
		
		assertEquals(3, testLLOne.size());
	}
	
	/*
	 * Add no links to a linked list and clear it. Call size on the 
	 * list and assertEquals for size 0.
	 */
	@Test
	public void testSizeZero() {
		testLLOne.clear();
		
		assertEquals(0, testLLOne.size());
	}
	
	/*
	 * Add some links to a linked list. Call size on the 
	 * list and assertFalse for size != 0.
	 */
	@Test
	public void testSizeNotZero() {
		testLLOne.push(head);
		testLLOne.push(middle);
		testLLOne.push(tail);
		
		assertFalse(0 == testLLOne.size());
	}

	/*
	 * Clear the linked list then assertTrue that
	 * isEmpty is true.
	 */
	@Test
	public void testIsEmpty() {
		testLLOne.clear();
		
		assertTrue(testLLOne.isEmpty());
	}
	
	/*
	 * Clear the linked list and add a link then 
	 * assertFalse that isEmpty is false.
	 */
	@Test
	public void testIsEmptyFalse() {
		testLLOne.addFirst(head);
		
		assertFalse(testLLOne.isEmpty());
	}
	
	/*
	 * Push a link onto the list and assertEquals the
	 * size of the list to 1.
	 */
	@Test
	public void testPush() {
		testLLOne.push(head);
		assertEquals(1, testLLOne.size());
	}

	/*
	 * Add head to a list, and then pop it and compare 
	 * the pop with head.
	 */
	@Test
	public void testPop() {
		testLLOne.addFirst(head);
		
		assertSame(testLLOne.pop(), head);
	}

	/*
	 * Create an iterator and assert that it is not null;
	 */
	@Test
	public void testIterator() {
		assertNotNull(testLLOne.iterator());
	}
	
	/*
	 * Create a mock iterator and assert that it is not null;
	 */
	@Test
	public void testMockIterator() {
		@SuppressWarnings("unchecked")
		Iterator<Link<Integer>> itr = Mockito.mock(Iterator.class);
		assertNotNull(itr);
	}

}
