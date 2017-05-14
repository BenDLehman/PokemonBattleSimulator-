package species.grass;

import pokemon.Pokemon;

/**
 * Creates Bulbasaur
 * @author Justin Study Group 6
 */
public class Bulbasaur extends Pokemon
{
	/**
	 * Constructor that calls the super method in Pokemon to create poke
	 * @param health
	 * @param newType type of pokemon
	 * @param newName default name
	 * @param attack
	 * @param newLevel default level
	 */
	public Bulbasaur(int health, String newType, String newName, int attack, int newLevel,int defense, String sp1, String sp2)
	{
		super(health, newType, newName, attack, newLevel,defense,sp1, sp2);
	}

	/**
	 * Used when creating pokemon from different class
	 */
	public Bulbasaur()
	{
		this(152, "Grass", "Bulbasaur", 111, 50, 111, "/resources/sprites/001.gif", "/resources/sprites/001b.gif");
	}
}
