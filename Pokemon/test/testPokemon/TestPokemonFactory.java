package testPokemon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.PokemonException;
import pokemon.Pokemon;
import pokemon.PokemonFactory;

/**
 * Tests pokemon creation via the Pokemon factory
 * @author Justin
 */
public class TestPokemonFactory
{
	/**
	 * Ensures pokemon factory correctly finds constructor for pokemon and
	 * that pokemon that have not been implemented yet will throw an exception.
	 * @throws PokemonException
	 */
	@Test
	public void TestPokemonFactoryInitialization() throws PokemonException
	{
		PokemonFactory pf = new PokemonFactory();

		Pokemon Oddish = pf.createPokemon("Oddish");
		Pokemon Gloom = pf.createPokemon("Gloom");
		Pokemon Vileplume = pf.createPokemon("Vileplume");

		Pokemon Charmander = pf.createPokemon("Charmander");
		Pokemon Charmeleon = pf.createPokemon("Charmeleon");
		Pokemon Charizard = pf.createPokemon("Charizard");

		Pokemon Squirtle = pf.createPokemon("Squirtle");
		Pokemon Wartortle = pf.createPokemon("Wartortle");
		Pokemon Blastoise = pf.createPokemon("Blastoise");

		assertEquals("Oddish", Oddish.getName());
		assertEquals(50, Gloom.getLevel());
		assertEquals(145, Vileplume.getAttack());

		assertEquals(146, Charmander.getHealth());
		assertEquals("Charmeleon", Charmeleon.getName());
		assertEquals("/resources/sprites/006.gif", Charizard.getSpritePathFront());

		assertEquals("Water", Squirtle.getType());
		assertEquals(145, Wartortle.getDefense());
		assertEquals("Blastoise", Blastoise.getName());
	}

	/**
	 * Illegal poke
	 * @throws PokemonException
	 */
	@Test(expected = PokemonException.class)
	public void TestPokemonFactoryUnavailablePokemon() throws PokemonException
	{
		PokemonFactory pf = new PokemonFactory();

		@SuppressWarnings("unused")
		Pokemon Mewtwo = pf.createPokemon("Mewtwo");
	}
}
