package species.grass;

import exceptions.PokemonException;
import pokemon.Pokemon;
/**
 * Class to create vileplume from gloom
 * @author Justin
 */
public class Vileplume extends Pokemon
{
	/**
	 * Private constructor only used in this class that calls super
	 */
	private Vileplume(int health, String type, String name, int atk, int lvl, int def, String sp1, String sp2)
	{
		super(health, type, name, atk, lvl, def, sp1, sp2);
	}

	/**
	 * Called from other classes. Wraps Gloom
	 * @param Gloom
	 * @throws PokemonException
	 */
	public Vileplume(Pokemon Gloom) throws PokemonException
	{
		this(182, "Grass", "Vileplume", 145, 50, 150, "/resources/sprites/045.gif", "/resources/sprites/045b.gif");
		if(!Gloom.getName().toLowerCase().contains("gloom"))
		{
			throw new PokemonException("Not the right pokemon to evolve for a Vileplume");
		}
	}

	/**
	 * Creates vileplume without needing a gloom
	 */
	public Vileplume()
	{
		this(182, "Grass", "Vileplume", 145, 50, 150, "/resources/sprites/045.gif", "/resources/sprites/045b.gif");
	}

}
