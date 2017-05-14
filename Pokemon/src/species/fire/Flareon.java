package species.fire;

import exceptions.PokemonException;
import pokemon.Pokemon;

public class Flareon extends Pokemon
{
	/**
	 * The characteristics of Flareon
	 * @param health the health of the pokemon
	 * @param newType the type of the pokemon
	 * @param newName the name of the pokemon
	 * @param attack the attack of the pokemon
	 * @param newLevel the level of the pokemon
	 * @param defense the defense of the pokemon
	 */

	private Flareon(int health, String newType, String newName, int attack, int newLevel, int defense,String sp1, String sp2)
	{
		super(health, newType, newName, attack, newLevel, defense,sp1, sp2);
	}
	/**
	 * Ensures that only Eevee can make a Flareon
	 * and ensures that the basis of the Flareon is always consistent
	 * @param Eevee the pokemon
	 * @throws PokemonException if the pokemon is not a Eevee then it will be thrown
	 */
	public Flareon(Pokemon Eevee) throws PokemonException
	{
		this(Eevee.getHealth(),Eevee.getType() + ", evolved Fire", "Flareon",20,Eevee.getLevel(),Eevee.getDefense(),
				Eevee.getSpritePathFront(), Eevee.getSpritePathBack());
		if(!Eevee.getName().toLowerCase().contains("vulpix"))
		{
			throw new PokemonException("not the right pokemon to evolve");
		}
	}
	/**
	 * Holds the functionalities of a pokemon
	 */
	public Flareon()
	{
		this(172,"fire","Flareon",200,50,123,"/resources/sprites/136.gif", "/resources/sprites/136b.gif");
	}

}
