package testSpecies.Grass;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.PokemonException;
import pokemon.Pokemon;
import species.grass.Bulbasaur;
import species.grass.Gloom;
import species.grass.Ivysaur;
import species.grass.Oddish;
import species.grass.Venusaur;
import species.grass.Vileplume;

/**
 * Tests the grass pokemon and their creation
 * @author Justin
 *
 */
public class TestGrassPokemon
{

	/**
	 * Make sure bulbasaur is initialized correctly
	 */
	@Test
	public void TestBulbasaur()
	{
		Pokemon b = new Bulbasaur();
 		assertEquals("Bulbasaur",b.getName());
		assertEquals(152,b.getHealth());
		assertEquals(111,b.getAttack());
		assertEquals(50,b.getLevel());
		assertEquals("Grass",b.getType());
		assertEquals(111, b.getDefense());
	}

	/**
	 * Make sure oddish is initialized correctly
	 */
	@Test
	public void TestOddish()
	{
		Pokemon o = new Oddish();
		assertEquals("Oddish", o.getName());
		assertEquals(152, o.getHealth());
		assertEquals(112, o.getAttack());
		assertEquals(117, o.getDefense());
		assertEquals("Grass", o.getType());
	}

	/**
	 * Make sure ivysaur is initialized correctly
	 */
	@Test
	public void TestIvysaur()
	{
		Pokemon i = new Ivysaur();
		assertEquals("Ivysaur", i.getName());
		assertEquals(167, i.getHealth());
		assertEquals(125, i.getAttack());
		assertEquals(126, i.getDefense());
		assertEquals("Grass", i.getType());
	}

	/**
	 * Make sure gloom is initialized correctly
	 */
	@Test
	public void TestGloom()
	{
		Pokemon g = new Gloom();
		assertEquals("Gloom", g.getName());
		assertEquals(167, g.getHealth());
		assertEquals(128, g.getAttack());
		assertEquals(134, g.getDefense());
		assertEquals("Grass", g.getType());
	}

	/**
	 * Make sure venusaur is initialized correctly
	 */
	@Test
	public void TestVenusaur()
	{
		Pokemon v = new Venusaur();
		assertEquals("Venusaur", v.getName());
		assertEquals(187, v.getHealth());
		assertEquals(147, v.getAttack());
		assertEquals(148, v.getDefense());
		assertEquals("Grass", v.getType());
	}

	/**
	 * Make sure Vileplume is initialized correctly
	 */
	@Test
	public void TestVileplume()
	{
		Pokemon v = new Vileplume();
		assertEquals("Vileplume", v.getName());
		assertEquals(182, v.getHealth());
		assertEquals(145, v.getAttack());
		assertEquals(150, v.getDefense());
		assertEquals("Grass", v.getType());
	}

	/**
	 * Test that bulbusaur can evolve into ivysaur and then venusaur
	 * @throws PokemonException
	 */
	@Test
	public void TestBulbusaurEvolution() throws PokemonException
	{
		Pokemon b = new Bulbasaur();
		Pokemon i = new Ivysaur(b);
		Pokemon v = new Venusaur(i);
		assertEquals("Venusaur", v.getName());
		assertEquals(187, v.getHealth());
		assertEquals(147, v.getAttack());
		assertEquals(148, v.getDefense());
		assertEquals("Grass", v.getType());
	}

	/**
	 * Test that oddish can evolve into gloom and then vileplume
	 */
	@Test
	public void TestOddishEvolution() throws PokemonException
	{
		Pokemon o = new Oddish();
		Pokemon g = new Gloom(o);
		Pokemon v = new Vileplume(g);
		assertEquals("Vileplume", v.getName());
		assertEquals(182, v.getHealth());
		assertEquals(145, v.getAttack());
		assertEquals(150, v.getDefense());
		assertEquals("Grass", v.getType());
	}

	/**
	 * Test that only a bulbasaur can be passed in ivysaur, not venusaur
	 * @throws PokemonException
	 */
	@Test(expected = PokemonException.class)
	public void testBulbusaurEvolvedVenusaur() throws PokemonException
	{
		Pokemon b = new Bulbasaur();
		@SuppressWarnings("unused")
		Pokemon v = new Venusaur(b);
	}

	/**
	 * Test that only a oddish can be passed in gloom, not vileplume
	 */
	@Test(expected = PokemonException.class)
	public void testOddishEvolvedVileplume() throws PokemonException
	{
		Pokemon o = new Oddish();
		@SuppressWarnings("unused")
		Pokemon v = new Vileplume(o);
	}














}
