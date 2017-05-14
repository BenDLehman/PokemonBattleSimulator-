package testPokemon;

import static org.junit.Assert.*;
import org.junit.Test;
import pokemon.MockPokemon;

/**
 * Test pokemon class and heal inside of it
 * @author Justin
 *
 */
public class TestPokemon
{
	/**
	 * Test Initialization and make sure that all variables are set correctly
	 */
	@Test
	public void testInitialization()
	{
		MockPokemon p = new MockPokemon(10, "Fire", "Charmander", 5, 5,5,"something", null);
		assertEquals(5, p.getAttack());
		assertEquals(5, p.getLevel());
		assertEquals("Fire", p.getType());
		assertEquals(10, p.getHealth());
		assertEquals("something", p.getSpritePathFront());
	}

	/**
	 * Test heal and make sure can't heal past max
	 */
	@Test
	public void testHeal()
	{
		MockPokemon p = new MockPokemon(10, "Fire", "Charmander", 5, 5,5,"something", null);
		p.takeDamage(2);
		assertEquals(8, p.getHealth());
		//check for heal
		p.heal(1);
		assertEquals(9, p.getHealth());
		//make sure cant heal past maxHP
		p.heal(2);
		assertEquals(10, p.getHealth());
	}

	/**
	 * Make sure damage can't take health below 0
	 */
	@Test
	public void testDamage()
	{
		MockPokemon p = new MockPokemon(10, "Fire", "Charmander", 5, 5,5,"something", null);
		p.takeDamage(11);
		assertEquals(0, p.getHealth());
	}

}
