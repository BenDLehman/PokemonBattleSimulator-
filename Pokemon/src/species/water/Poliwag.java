package species.water;

import pokemon.Pokemon;

public class Poliwag extends Pokemon
{
	private Poliwag(int health, String t, String n, int a, int l,int d,String sp1, String sp2)
	{
		super(health, t, n, a, l,d,sp1, sp2);
	}

	public Poliwag()
	{
		this(147, "water", "Poliwag", 112, 50, 101,"/resources/sprites/060.gif", "/resources/sprites/060b.gif");
	}
}
