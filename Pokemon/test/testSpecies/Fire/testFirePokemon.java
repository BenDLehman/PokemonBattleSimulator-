package testSpecies.Fire;

import static org.junit.Assert.*;
import org.junit.Test;

import exceptions.PokemonException;
import exceptions.SpeciesException;
import pokemon.Pokemon;
import species.fire.Charizard;
import species.fire.Charmander;
import species.fire.Charmeleon;
import species.fire.Eevee;
import species.fire.NineTails;
import species.fire.Vulpix;
import species.fire.fire;
import species.grass.Bulbasaur;
public class testFirePokemon
{
	/**
	 * Tests the initialization of charmander is correct
	 */
	@Test
	public void testCharmanderInitialization()
	{
		Pokemon c = new Charmander();
 		assertEquals("Charmander",c.getName());
		assertEquals(146,c.getHealth());
		assertEquals(114,c.getAttack());
		assertEquals(50,c.getLevel());
		assertEquals("Fire",c.getType());
	}
	/**
	 * Tests the initialization of vulpix is correct
	 */
	@Test
	public void testVulpixInitialization()
	{
		Pokemon v = new Vulpix();
		assertEquals("Vulpix",v.getName());
		assertEquals(145,v.getHealth());
		assertEquals(102,v.getAttack());
		assertEquals(50,v.getLevel());
		assertEquals("Fire",v.getType());
	}
	/**
	 * Tests the initialization of Evee is correct
	 */
	@Test
	public void testEeveeInitialization()
	{
		Pokemon e = new Eevee();
		assertEquals("Eevee",e.getName());
		assertEquals(162,e.getHealth());
		assertEquals(117,e.getAttack());
		assertEquals(50,e.getLevel());
		assertEquals("fire",e.getType());
	}
	/**
	 * Tests the the initization of Ninetails
	 * @throws PokemonException
	 */
	@Test
	public void testNinetailsInitialization() throws PokemonException
	{
		Pokemon v = new Vulpix();
		Pokemon Ev = new NineTails(v);
		assertEquals("NineTails",Ev.getName());
		assertEquals(180,Ev.getHealth());
		assertEquals(20,Ev.getAttack());
		assertEquals(50,Ev.getLevel());
		assertEquals("Fire, evolved Fire",Ev.getType());
	}
	/**
	 * NineTails without a parameter
	 */
	@Test
	public void testNineTails()
	{
		Pokemon EV = new NineTails();
		assertEquals("NineTails",EV.getName());
		assertEquals(180,EV.getHealth());
		assertEquals(140,EV.getAttack());
		assertEquals(50,EV.getLevel());
		assertEquals("fire",EV.getType());
	}

	/**
	 * Tests the the initization of the Charmeleon
	 * @throws PokemonException
	 */
	@Test
	public void testCharmeleonInitialization() throws PokemonException
	{
		Pokemon c = new Charmander();
		Pokemon Ec = new Charmeleon(c);
		assertEquals("Charmeleon",Ec.getName());
		assertEquals(165,Ec.getHealth());
		assertEquals(127,Ec.getAttack());
		assertEquals(50,Ec.getLevel());
		assertEquals("Fire, evolved Fire",Ec.getType());


	}
	/**
	 * Test Charmeleon without the parameter
	 */
	@Test
	public void testCharmeleon()
	{
		Pokemon Ec = new Charmeleon();
		assertEquals("Charmeleon",Ec.getName());
		assertEquals(165,Ec.getHealth());
		assertEquals(127,Ec.getAttack());
		assertEquals(50,Ec.getLevel());
		assertEquals("fire",Ec.getType());
	}

	/**
	 * Tests the the initization of the Charizard
	 * @throws PokemonException
	 */
	@Test
	public void testCharizardInitialization() throws PokemonException
	{
		Pokemon Char = new Charmander();
		Pokemon c = new Charmeleon(Char);
		Pokemon Ec = new Charizard(c);
		assertEquals("Charizard",Ec.getName());
		assertEquals(185,Ec.getHealth());
		assertEquals(104,Ec.getAttack());
		assertEquals(50,Ec.getLevel());
		assertEquals("Fire, evolved Fire",Ec.getType());
	}
	/**
	 * Test Charizard without Parameters
	 */
	@Test
	public void testCharizard()
	{
		Pokemon Ec = new Charizard();
		assertEquals("Charizard",Ec.getName());
		assertEquals(185,Ec.getHealth());
		assertEquals(104,Ec.getAttack());
		assertEquals(50,Ec.getLevel());
		assertEquals("fire",Ec.getType());
	}
	/**
	 * test that only a charmander can be passed in charmeleon
	 * @throws PokemonException
	 */
	@Test(expected = PokemonException.class)
	public void testCharmeleonEvolvedCharizard() throws PokemonException
	{
		Pokemon c = new Charmander();
		@SuppressWarnings("unused")
		Pokemon Ec = new Charizard(c);

	}

	@Test(expected = PokemonException.class)
	public void testVulpixEvolvedNinetails() throws PokemonException
	{
		Pokemon c = new Charmander();
		@SuppressWarnings("unused")
		Pokemon n = new NineTails(c);
	}
	/**
	 * test that only a charmander can be passed in charmeleon
	 * @throws PokemonException
	 */
	@Test(expected = PokemonException.class)
	public void testCharmanderEvolvedCharmeleon() throws PokemonException
	{
		Pokemon c = new Vulpix();
		@SuppressWarnings("unused")
		Pokemon Ec = new Charmeleon(c);
	}


	/**
	 * Tests that all the fire types can be put in the list
	 * @throws PokemonException only the right pokemon combinations can evolve
	 * @throws SpeciesException only fire species can be a fire species
	 */
	@Test
	public void testFireList() throws SpeciesException, PokemonException
	{
		Pokemon Char = new Charmander();
		Pokemon c = new Charmeleon(Char);
		Pokemon Ec = new Charizard(c);
		Pokemon v = new Vulpix();
		Pokemon Ev = new NineTails(v);
		fire f = new fire(Char);
		assertEquals("fire",f.getType());
		assertEquals("Charmander",f.getName());
		fire F2 = new fire(c);
		assertEquals("fire",F2.getType());
		assertEquals("Charmeleon",F2.getName());
		fire F3 = new fire(Ec);
		assertEquals("fire",F3.getType());
		assertEquals("Charizard",F3.getName());
		fire F4 = new fire(v);
		assertEquals("fire",F4.getType());
		assertEquals("Vulpix",F4.getName());
		fire F6 = new fire(Ev);
		assertEquals("fire",F6.getType());
		assertEquals("NineTails",F6.getName());
	}
	/**
	 * Nothing but fire types can be added to fire
	 * @throws PokemonException
	 * @throws SpeciesException
	 */
	@Test(expected = SpeciesException.class)
	public void testWaterPokemon() throws SpeciesException
	{
		Pokemon s = new Bulbasaur(0, "grass", "bulbasaur", 0, 0,0,"something", null);
		@SuppressWarnings("unused")
		fire f = new fire(s);
	}
}
