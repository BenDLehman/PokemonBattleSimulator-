package testBattleHandler;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import battlehandler.trainer.secondPlayer;
import battlehandler.trainer.trainer;
import pokemon.MockPokemon;
/**
 * Holds the tests of the player
 * @author nahesha
 */
public class testSecondPlayer {
	trainer sp;
	/**
	 * initializes the player
	 */
	@Before
	public void testInitialization()
	{
		sp = secondPlayer.getSecondPlayerInstance();
	}
	/**
	 *Tests that all the characteristics remain the same
	 */
	@Test
	public void testSecondPlayerInitialization()
	{
		assertEquals("PlayerTwo",sp.getName());
		assertEquals(1,sp.getLevel());
		sp.levelUp();
		assertEquals(2,sp.getLevel());
	}
	/**
	 * swaps the pokemon and ensures that the pokemon is in the right place.
	 */
	@Test
	public void swapPokemon()
	{
		MockPokemon groundPokemon = new MockPokemon(10, "Ground", "Nidoqueen", 5, 5,5,"something", null);
		MockPokemon firePokemon = new MockPokemon(10, "Fire", "Vulpix", 5, 5,5,"something", null);
		MockPokemon waterPokemon = new MockPokemon(10, "Water", "Lapras", 5, 5,5,"something", null);
		sp.selectPokemon(groundPokemon);
		assertTrue(sp.addPokemon(firePokemon));
		assertTrue(sp.addPokemon(waterPokemon));
		sp.switchPokemon(groundPokemon, firePokemon);
		sp.findInPokemonList(groundPokemon);
		assertEquals(2,sp.positionInPokemonList(groundPokemon));
	}

}
