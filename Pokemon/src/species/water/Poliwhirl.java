package species.water;

import exceptions.PokemonException;
import pokemon.Pokemon;

public class Poliwhirl extends Pokemon
{
	private Poliwhirl(int health, String t, String n, int a, int l,int d, String sp1, String sp2)
	{
		super(health, t, n, a, l,d,sp1, sp2);
	}

	public Poliwhirl(Pokemon poliwag) throws PokemonException
	{
		this(172,poliwag.getType()+ ", evolved Water", "Poliwhirl",65,poliwag.getLevel(),128,poliwag.getSpritePathFront(), poliwag.getSpritePathBack());
		if(!poliwag.getName().toLowerCase().contains("poliwag"))
		{
			throw new PokemonException("Only can be from a Poliwag");
		}
	}

	public Poliwhirl()
	{
		this(172, "water", "Poliwhirl", 65, 50, 128,"/resources/sprites/061.gif", "/resources/sprites/061b.gif");
	}
}
