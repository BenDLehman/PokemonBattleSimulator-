package species.grass;

import pokemon.Pokemon;
/**
 * Creates an oddish
 * @author Justin Study group 6
 */
public class Oddish extends Pokemon
{
	/**
	 * private constructor only called from within this class
	 */
	private Oddish(int health, String newType, String newName, int attack, int newLevel, int defense, String sp1, String sp2)
	{
		super(health, newType, newName, attack, newLevel, defense, sp1, sp2);
	}

	/**
	 * Constructor called from PokemonFactory to call private Oddish()
	 */
	public Oddish()
	{
		this(152, "Grass", "Oddish", 112, 50, 117, "/resources/sprites/043.gif", "/resources/sprites/043b.gif");
	}
}
