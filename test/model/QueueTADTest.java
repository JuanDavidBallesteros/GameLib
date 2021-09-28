package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTADTest<T> {

	private QueueTAD<Client> queue;

	private void setupScenery1() { // Stack test
		queue = null;
	}

	private void setupScenery2() { // Stack Empty
		queue = new QueueTAD<>();
	}

	private void setupScenery3() { // Stack test some values
		queue = new QueueTAD<>();

		for (int i = 0; i < 10; i++) {
			queue.add(new Client(i + "", i));
		}
	}

	@Test
	public void testQueue() throws Exception {
		setupScenery1();
		queue = new QueueTAD<>();
		assertTrue(queue != null);
		assertEquals(0, queue.getSize());
	}

	@Test
	public void testAdd() throws Exception {
		setupScenery2();
		queue.add(new Client("123", 123));

		assertEquals(1, queue.getSize());
	}

	@Test
	public void testIsEmpty() throws Exception {
		setupScenery2();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testFront() throws Exception {
		setupScenery3();
		assertEquals("0", queue.front().getId());
	}

	@Test
	public void testDequeue() throws Exception {
		setupScenery3();

		Client test = queue.dequeue();
		assertEquals("0", test.getId());
		assertEquals(0, test.getArrivalNum());
		assertEquals(9, queue.getSize());
	}

	@Test
	public void testGetSize() throws Exception {
		setupScenery3();
		assertEquals(10, queue.getSize());
	}
}
