package species.water;

import exceptions.PokemonException;
import pokemon.Pokemon;
/**
 *
 * @author Ben Lehman
 *
 */
public class Blastoise extends Pokemon
{
	/**
	 * The basic constructor from Pokemon
	 * Private so the user can't change the params willy-nilly
	 * @param health
	 * @param t
	 * @param n
	 * @param a
	 * @param l
	 */
	private Blastoise(int health, String t, String n, int a, int l,int d, String sp1, String sp2)
	{
		super(health, t, n, a, l,d,sp1, sp2);

	}
	/**
	 *
	 * @param wartortle required for a blastoise
	 * @throws PokemonException
	 */
	public Blastoise(Pokemon wartortle) throws PokemonException
	{
		this(186 ,wartortle.getType()+ ", evolved Water", "Blastoise", 148, wartortle.getLevel(), 167,wartortle.getSpritePathFront(), wartortle.getSpritePathBack());
		if(!wartortle.getName().toLowerCase().contains("wartortle"))
			throw new PokemonException("Only can be from Wartortle");
	}
	/**
	 * Can be instantiated without a wartortle to evolve from
	 */
	public Blastoise()
	{
		this(186, "water", "Blastoise", 148, 50, 167,"/resources/sprites/009.gif", "/resources/sprites/009b.gif");
	}
}
