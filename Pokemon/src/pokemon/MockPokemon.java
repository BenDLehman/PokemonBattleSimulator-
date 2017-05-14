package pokemon;

import gameplay.TimeObserver;

/**
 * Class used to test pokemon, since it is an abstract class
 * @author Justin Study Group 6
 */
public class MockPokemon extends Pokemon implements TimeObserver
{
	public MockPokemon(int health, String newType, String newName, int attack, int newLevel, int defense, String sp1, String sp2)
	{
		super(health, newType, newName, attack, newLevel,defense, sp1, sp2);
	}

}
