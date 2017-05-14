package species.grass;

import exceptions.PokemonException;
import pokemon.Pokemon;
/**
 * Creates a venusaur from an ivysaur
 * @author Justin Study group 6
 */
public class Venusaur extends Pokemon
{
	/**
	 * Private constructor to pass through super
	 */
	private Venusaur(int health, String type, String name, int atk, int lvl, int def, String sp1, String sp2)
	{
		super(health, type, name, atk, lvl, def, sp1, sp2);
	}

	/**
	 * Public class to use in actual program that then passes through private
	 * @param ivysaur
	 * @throws PokemonException
	 */
	public Venusaur(Pokemon Ivysaur) throws PokemonException
	{
		this(187, "Grass", "Venusaur", 147, 50, 148, "/resources/sprites/003.gif", "/resources/sprites/003b.gif");

		if(!Ivysaur.getName().toLowerCase().contains("ivysaur"))
			throw new PokemonException("Can only evolve from ivysaur");
	}

	/**
	 * Creates gloom without neding a bulbasaur
	 */
	public Venusaur()
	{
		this(187, "Grass", "Venusaur", 147, 50, 148, "/resources/sprites/003.gif", "/resources/sprites/003b.gif");
	}
}
