package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest {

	Event e;
	Spectator[] s;
	
	private void loadScene1() {
		
		e = new Event();
		s = new Spectator[5];
		s[0] = new Spectator("32-1234", "Johan", "Giraldo", "jg@gmail.com", "Male", "Colombia", "johan.jpg", "1999/12/25");
		s[1] = new Spectator("45-5134", "Esteban", "Ariza", "ea@gmail.com", "Male", "Japan", "img2.jpg", "1995/11/21");
		s[2] = new Spectator("12-1654", "Esteban", "Yusunguaira", "ey@gmail.com", "Female", "China", "rere.jpg", "1992/07/06");
		s[3] = new Spectator("54-5234", "Jhun", "Kim", "jk@gmail.com", "Male", "South Korea", "kim.jpg", "2000/01/10");
		s[4] = new Spectator("04-1834", "Juan", "Ossa", "jo@gmail.com", "Female", "Haiti", "ossa.jpg", "1997/04/06");
		
	}
	
	@Test
	public void testAddParticipant() {
		
		loadScene1();
		
		e.addSpectator(s[0]);
		e.addSpectator(s[1]);
		e.addSpectator(s[2]);
		e.addSpectator(s[3]);
		e.addSpectator(s[4]);
		
		assertNotNull(e.getRoot());
		assertNotNull(e.getRoot().getLeft());
		assertNotNull(e.getRoot().getRight());
		assertNotNull(e.getRoot().getRight().getRight());
		assertNotNull(e.getRoot().getLeft().getLeft());
		assertEquals(e.getRoot().getRight().getId(), s[1].getId());
		assertEquals(e.getRoot().getLeft().getId(), s[2].getId());
		assertEquals(e.getRoot().getRight().getRight().getId(), s[3].getId());
		assertEquals(e.getRoot().getLeft().getLeft().getId(), s[4].getId());
			
	}

	@Test
	public void testSearchSpectator() {
		
		loadScene1();
		
		Spectator root = s[0];
		
		try {
			root.addSpectator(s[1]);
			root.addSpectator(s[2]);
			root.addSpectator(s[3]);
			root.addSpectator(s[4]);
		}
		catch (DuplicateIdException e) {
			fail();
		}
		
		assertEquals(root.searchSpectator("32-1234"), s[0]);
		assertEquals(root.searchSpectator("45-5134"), s[1]);
		assertEquals(root.searchSpectator("12-1654"), s[2]);
		assertEquals(root.searchSpectator("54-5234"), s[3]);
		assertEquals(root.searchSpectator("04-1834"), s[4]);
		
	}

}
