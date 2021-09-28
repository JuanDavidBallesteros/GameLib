package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exception.FullTable;
import exception.NullKeyException;

public class HasTableTADTest<K,V> {

	private HasTableTAD<Integer, Game> table;

	private void setupScenery1() { // Stack test
		table = null;
	}

	private void setupScenery2() { // Stack Empty
		table = new HasTableTAD<>();
	}

	private void setupScenery3() { // Stack test some values
		table = new HasTableTAD<>();

		for (int i = 0; i < 10; i++) {
			try {
				table.insert(i, new Game(i, i, "A", i*34322));
			} catch (NullKeyException | FullTable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testHasTable() throws Exception {
		setupScenery1();
		table = new HasTableTAD<>();
		assertTrue(table != null);
		assertEquals(0, table.getElements());
	}

	@Test
	public void testInsert() throws Exception {
		setupScenery2();
		table.insert(123, new Game(123, 123, "B", 54323));

		assertEquals(1, table.getElements());
	}

	@Test
	public void testSearch() throws Exception {
		setupScenery3();
		assertEquals(7, table.search(7).getId());
		assertEquals(7, table.search(7).getAmount());
		assertEquals(7*34322, table.search(7).getCost());
	}

	@Test
	public void testDelete() throws Exception {
		setupScenery3();
		System.out.println( table.getElements());
		table.delete(7);
System.out.println( table.getElements());
		assertEquals(9, table.getElements());
	}

	@Test
	public void testSetValue() throws Exception {
		setupScenery3();

		Game test = new Game(7744, 5, "G", 33400);

		table.setValue(7, test);

		assertEquals(7744, table.search(7).getId());
		assertEquals(5, table.search(7).getAmount());
		assertEquals(33400, table.search(7).getCost());
	}

}
