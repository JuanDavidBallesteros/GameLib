package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackTADTest<T> {

	private StackTAD<Client> stack;

	private void setupScenery1() { // Stack test
		stack = null;
	}

	private void setupScenery2() { // Stack Empty
		stack = new StackTAD<>();
	}

	private void setupScenery3() { // Stack test some values
		stack = new StackTAD<>();

		for (int i = 0; i < 10; i++) {
			stack.push(new Client(i + "", i));
		}
	}

	@Test
	public void testStack() throws Exception {
		setupScenery1();
		stack = new StackTAD<>();
		assertTrue(stack != null);
		assertEquals(0, stack.getSize());
	}

	@Test
	public void testPush() throws Exception {
		setupScenery2();
		stack.push(new Client("123", 123));

		assertEquals(1, stack.getSize());
	}

	@Test
	public void testIsEmpty() throws Exception {
		setupScenery2();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testTop() throws Exception {
		setupScenery3();
		assertEquals("9", stack.pop().getId());
	}

	@Test
	public void testPop() throws Exception {
		setupScenery3();

		Client test = stack.pop();
		assertEquals("9", test.getId());
		assertEquals(9, test.getArrivalNum());
		assertEquals(9, stack.getSize());

	}

	@Test
	public void testGetSize() throws Exception {
		setupScenery3();
		assertEquals(10, stack.getSize());
	}

}
