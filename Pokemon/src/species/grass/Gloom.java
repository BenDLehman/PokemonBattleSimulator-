package species.grass;

import exceptions.PokemonException;
import pokemon.Pokemon;
/**
 * Decorator class for oddish to make gloom
 * @author Justin Study group 6
 *
 */
public class Gloom extends Pokemon
{
	/**
	 * Private constructor to pass through super
	 */
	private Gloom(int health, String type, String name, int atk, int lvl, int def, String sp1, String sp2)
	{
		super(health, type, name, atk, lvl, def, sp1, sp2);
	}

	/**
	 * Public class to use in actual program that then passes through private
	 * @param Oddish
	 * @throws PokemonException
	 */
	public Gloom(Pokemon Oddish) throws PokemonException
	{
		this(167, "Grass", "Gloom", 128, 50, 134, "/resources/sprites/044.gif", "/resources/sprites/044b.gif");

		if(!Oddish.getName().toLowerCase().contains("oddish"))
			throw new PokemonException("Can only evolve from Oddish");
	}

	/**
	 * Creates gloom without neding an oddish
	 */
	public Gloom()
	{
		this(167, "Grass", "Gloom", 128, 50, 134, "/resources/sprites/044.gif", "/resources/sprites/044b.gif");
	}
}
