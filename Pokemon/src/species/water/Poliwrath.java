package species.water;

import pokemon.Pokemon;
import exceptions.PokemonException;

public class Poliwrath extends Pokemon
{

	private Poliwrath(int health, String t, String n, int a, int l,int d, String sp1, String sp2)
	{
		super(health, t, n, a, l,d,sp1, sp2);

	}
	/**
	 *
	 * @param wartortle required for a blastoise
	 * @throws PokemonException
	 */
	public Poliwrath(Pokemon wartortle) throws PokemonException
	{
		this(197, "water", "Poliwrath", 150, 50, 161,"/resources/sprites/009.gif", "/resources/sprites/009b.gif");
		if(!wartortle.getName().toLowerCase().contains("wartortle"))
			throw new PokemonException("Only can be from Wartortle");
	}
	/**
	 * Can be instantiated without a wartortle to evolve from
	 */
	public Poliwrath()
	{
		this(197, "water", "Poliwrath", 150, 50, 161,"/resources/sprites/009.gif", "/resources/sprites/009b.gif");
	}

}
