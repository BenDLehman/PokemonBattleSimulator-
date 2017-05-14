/**
 * Has the methods a charmeleon must have inorder to be consisted a pokemon
 * @author Nahesha paulection
 */
package species.fire;

import exceptions.PokemonException;
import pokemon.Pokemon;

public class Charmeleon extends Pokemon
{
	/**
	 * these are the characteristics that make a Charmeleon a pokemon
	 * @param health the heath of a charmeleon
	 * @param t the Species type
	 * @param n the name of the species
	 * @param a the attack points of the pokemon
	 * @param l the level of the pokemon
	 * @param d the defense of the pokemon
	 *
	 */
	private Charmeleon(int health, String t, String n, int a, int l,int d, String sp1, String sp2)
	{
		super(health, t, n, a, l,d, sp1, sp2);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Ensures that only charmander can make a charmeleon
	 * and ensures that the basis of the charmeleon is always consistent
	 * @param charmander the pokemon
	 * @throws PokemonException if the pokemon is not a charmander then it will be thrown
	 */
	public Charmeleon(Pokemon charmander) throws PokemonException
	{
		this(165,charmander.getType()+", evolved Fire", "Charmeleon",127,charmander.getLevel(),121,charmander.getSpritePathFront(), charmander.getSpritePathBack());
		if(!charmander.getName().toLowerCase().contains("charmander"))
			throw new PokemonException("Can only derive from Charmander");
	}
	public Charmeleon()
	{
		this(165,"fire", "Charmeleon",127,50,121,"/resources/sprites/005.gif", "/resources/sprites/005b.gif");
	}


}
