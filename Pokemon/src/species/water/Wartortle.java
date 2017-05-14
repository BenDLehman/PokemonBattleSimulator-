package species.water;

import pokemon.Pokemon;
import exceptions.PokemonException;

public class Wartortle extends Pokemon
{
	private Wartortle(int health, String t, String n, int a, int l, int d, String sp1, String sp2)
	{
		super(health, t, n, a, l,d,sp1, sp2);
	}
	public Wartortle(Pokemon squirtle) throws PokemonException
	{
		this(166,squirtle.getType()+", evolved Water", "Wartortle",126,squirtle.getLevel(), 145, squirtle.getSpritePathFront(), squirtle.getSpritePathBack());
		if(!squirtle.getName().toLowerCase().contains("squirtle"))
			throw new PokemonException("Can only evolve from Squirtle");
	}
	public Wartortle()
	{
		this(166, "Water", "Wartortle", 126, 50, 145,"/resources/sprites/008.gif", "/resources/sprites/008b.gif");
	}
}
