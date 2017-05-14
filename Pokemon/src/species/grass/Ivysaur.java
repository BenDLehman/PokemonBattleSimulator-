package species.grass;

import exceptions.PokemonException;
import pokemon.Pokemon;

public class Ivysaur extends Pokemon
{
	/**
	 * Private constructor to pass through super
	 */
	private Ivysaur(int health, String type, String name, int atk, int lvl, int def, String sp1, String sp2)
	{
		super(health, type, name, atk, lvl, def, sp1, sp2);
	}

	/**
	 * Public class to use in actual program that then passes through private
	 * @param bulbasaur
	 * @throws PokemonException
	 */
	public Ivysaur(Pokemon Bulbasaur) throws PokemonException
	{
		this(167, "Grass", "Ivysaur", 125, 50, 126, "/resources/sprites/002.gif", "/resources/sprites/002b.gif");

		if(!Bulbasaur.getName().toLowerCase().contains("bulbasaur"))
			throw new PokemonException("Can only evolve from Bulbasaur");
	}

	/**
	 * Creates gloom without neding a bulbasaur
	 */
	public Ivysaur()
	{
		this(167, "Grass", "Ivysaur", 125, 50, 126, "/resources/sprites/002.gif", "/resources/sprites/002b.gif");
	}
}
