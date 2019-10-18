package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpectatorTest {

	Spectator[] s;
	
	private void loadScene1() {
		
		s = new Spectator[5];
		s[0] = new Spectator("32-1234", "Johan", "Giraldo", "jg@gmail.com", "Male", "Colombia", "johan.jpg", "1999/12/25");
		s[1] = new Spectator("45-5134", "Esteban", "Ariza", "ea@gmail.com", "Male", "Japan", "img2.jpg", "1995/11/21");
		s[2] = new Spectator("12-1654", "Esteban", "Yusunguaira", "ey@gmail.com", "Female", "China", "rere.jpg", "1992/07/06");
		s[3] = new Spectator("54-5234", "Jhun", "Kim", "jk@gmail.com", "Male", "South Korea", "kim.jpg", "2000/01/10");
		s[4] = new Spectator("04-1834", "Juan", "Ossa", "jo@gmail.com", "Female", "Haiti", "ossa.jpg", "1997/04/06");
	}

	@Test
	public void testAddSpectator() {
		
		loadScene1();
		
		Spectator root = s[0];
		
		try {
			root.addSpectator(s[1]);
			root.addSpectator(s[2]);
			root.addSpectator(s[3]);
			root.addSpectator(s[4]);
			root.addSpectator(s[0]);
			fail();
		} 
		catch (DuplicateIdException e) {
			// 	
		}
		
		assertNotNull(root.getLeft());
		assertNotNull(root.getRight());
		assertNotNull(root.getRight().getRight());
		assertNotNull(root.getLeft().getLeft());
		assertEquals(root.getRight().getId(), s[1].getId());
		assertEquals(root.getLeft().getId(), s[2].getId());
		assertEquals(root.getRight().getRight().getId(), s[3].getId());
		assertEquals(root.getLeft().getLeft().getId(), s[4].getId());
		
	}
	
}
