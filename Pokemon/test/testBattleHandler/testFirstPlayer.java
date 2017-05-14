package testBattleHandler;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import battlehandler.trainer.firstPlayer;
import battlehandler.trainer.trainer;
import pokemon.MockPokemon;
/***
 * holds the tests of the first player
 * @author nahesha
 *
 */
public class testFirstPlayer {

	trainer fp;
	/**
	 * initializes the player
	 */
	@Before
	public void testInitialization()
	{
		fp = firstPlayer.getFirstPlayerInstance();
	}
	/**
	 *
	 */
	@Test
	public void testFirstPlayerInitialization()
	{
		assertEquals("PlayerOne",fp.getName());
		assertEquals(1,fp.getLevel());
		fp.levelUp();
		assertEquals(2,fp.getLevel());
	}
	/**
	 * swaps the pokemon and ensures that the pokemon is in the right place.
	 */
	@Test
	public void swapPokemon()
	{
		MockPokemon groundPokemon = new MockPokemon(10, "Ground", "Stiglet", 5, 5,5,"something", null);
		MockPokemon firePokemon = new MockPokemon(10, "Fire", "Charmander", 5, 5,5,"something", null);
		MockPokemon waterPokemon = new MockPokemon(10, "Water", "Squirtle", 5, 5,5,"something", null);
		fp.selectPokemon(groundPokemon);
		assertTrue(fp.addPokemon(firePokemon));
		assertTrue(fp.addPokemon(waterPokemon));
		fp.switchPokemon(groundPokemon, firePokemon);
		fp.findInPokemonList(groundPokemon);
		assertEquals(2,fp.positionInPokemonList(groundPokemon));
	}

}
