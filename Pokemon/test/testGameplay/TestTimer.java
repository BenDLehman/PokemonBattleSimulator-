package testGameplay;

import static org.junit.Assert.*;
import gameplay.GameTimer;


import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;


public class TestTimer {

	GameTimer timer = new GameTimer();
	Pokemon charizard1 = new MockPokemon(10, "Fire", "Char", 5, 3,1,"something", null);
	Pokemon charizard2 = new MockPokemon(10, "Fire", "Char", 5, 3,1,"something", null);
	Pokemon charizard3 = new MockPokemon(10, "Fire", "Char", 5, 3,1,"something", null);
	@Test
	public void testAdding()
	{
		timer.addTimeObserver(charizard1);
		assertTrue(timer.getTheObservers().contains(charizard1));
	}
	@Test
	public void testRemoving()
	{
		timer.addTimeObserver(charizard1);
		assertTrue(timer.getTheObservers().contains(charizard1));
		timer.removeTimeObserver(charizard1);
	}
	@Test
	public void testTimeChange()
	{
		timer.addTimeObserver(charizard1);
		timer.timeChanged();
		assertEquals(1, charizard1.getRound());
	}
	@Test
	public void testLargeTimeChange()
	{
		timer.addTimeObserver(charizard1);
		timer.addTimeObserver(charizard2);
		timer.addTimeObserver(charizard3);
		timer.timeChanged();
		assertEquals(1, charizard1.getRound());
		assertEquals(1, charizard2.getRound());
		assertEquals(1, charizard3.getRound());
	}

}
