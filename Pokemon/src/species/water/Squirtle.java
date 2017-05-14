package species.water;

import pokemon.Pokemon;

public class Squirtle extends Pokemon
{

	private Squirtle(int health, String newType, String newName, int attack, int newLevel, int defense,String sp1, String sp2)
	{
		super(health, newType, newName, attack, newLevel, defense, sp1, sp2);
	}

	public Squirtle()
	{
		this(151, "Water", "Squirtle", 110, 50, 128,"/resources/sprites/007.gif", "/resources/sprites/007b.gif");
	}
}
