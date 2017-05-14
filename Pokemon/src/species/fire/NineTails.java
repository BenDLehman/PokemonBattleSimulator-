/**
 * holds all the functions that make a ninetails a pokemon
 * @author Nahesha Paulection
 */
package species.fire;

import exceptions.PokemonException;
import pokemon.Pokemon;

public class NineTails extends Pokemon {
	/**
	 * these are the characteristics that make a Ninetail a pokemon
	 * @param health the heath of a Ninetail
	 * @param t the Species type
	 * @param n the name of the species
	 * @param a the attack points of the pokemon
	 * @param l the level of the pokemon
	 * @param d the level of defense of the pokemon
	 */
	private NineTails(int health, String t, String n, int a, int l,int d,String sp1, String sp2)
	{
		super(health, t, n, a, l,d,sp1, sp2);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Ensures that only vulpix can make a ninetails
	 * and ensures that the basis of the ninetails is always consistent
	 * @param vulpix the pokemon
	 * @throws PokemonException if the pokemon is not a vulpix then it will be thrown
	 */
	public NineTails(Pokemon vulpix) throws PokemonException
	{
		this(180,vulpix.getType() + ", evolved Fire", "NineTails",20,vulpix.getLevel(),139,vulpix.getSpritePathFront(), vulpix.getSpritePathBack());
		if(!vulpix.getName().toLowerCase().contains("vulpix"))
		{
			throw new PokemonException("Not the right pokemon to evolve for a Ninetails");
		}
	}
	/**
	 * Holds a functionality of ninetails
	 */
	public NineTails()
	{
		this(180,"fire", "NineTails",140,50,139,"/resources/sprites/038.gif", "/resources/sprites/038b.gif");
	}

}
