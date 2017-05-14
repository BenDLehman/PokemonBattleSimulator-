package testSpecies.Water;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import species.water.Blastoise;
import species.water.Poliwag;
import species.water.Poliwhirl;
import species.water.Poliwrath;
import species.water.Squirtle;
import species.water.Wartortle;

public class testWaterPokemon {

	@Test
	public void TestSquirtle() 
	{
		Pokemon b = new Squirtle();
 		assertEquals("Squirtle",b.getName());
		assertEquals(151,b.getHealth());
		assertEquals(110,b.getAttack());
		assertEquals(50,b.getLevel());
		assertEquals("Water",b.getType());
		assertEquals(128, b.getDefense());
	}

	/**
	 * Make sure oddish is initialized correctly
	 */
	@Test
	public void TestWartortle()
	{
		Pokemon o = new Wartortle();
		assertEquals("Wartortle", o.getName());
		assertEquals(166, o.getHealth());
		assertEquals(126, o.getAttack());
		assertEquals(145, o.getDefense());
		assertEquals("Water", o.getType());
	}
	
	/**
	 * Make sure ivysaur is initialized correctly
	 */
	@Test
	public void TestBlastoise()
	{
		Pokemon i = new Blastoise();
		assertEquals("Blastoise", i.getName());
		assertEquals(186, i.getHealth());
		assertEquals(148, i.getAttack());
		assertEquals(167, i.getDefense());
		assertEquals("Water", i.getType());
	}
	
	/**
	 * Make sure gloom is initialized correctly
	 */
	@Test
	public void TestPoliwag()
	{
		Pokemon g = new Poliwag();
		assertEquals("Poliwag", g.getName());
		assertEquals(147, g.getHealth());
		assertEquals(112, g.getAttack());
		assertEquals(101, g.getDefense());
		assertEquals("Water", g.getType());
	}
	
	/**
	 * Make sure venusaur is initialized correctly
	 */
	@Test
	public void TestPoliwhirl()
	{
		Pokemon v = new Poliwhirl();
		assertEquals("Poliwhirl", v.getName());
		assertEquals(172, v.getHealth());
		assertEquals(165, v.getAttack());
		assertEquals(128, v.getDefense());
		assertEquals("Water", v.getType());
	}
	
	/**
	 * Make sure Vileplume is initialized correctly
	 */
	@Test
	public void TestPoliwrath()
	{
		Pokemon v = new Poliwrath();
		assertEquals("Poliwrath", v.getName());
		assertEquals(197, v.getHealth());
		assertEquals(150, v.getAttack());
		assertEquals(161, v.getDefense());
		assertEquals("Water", v.getType());
	}

}
