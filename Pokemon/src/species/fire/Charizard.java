/**
 * Has the methods a charizard must have inorder to be consisted a pokemon
 * @author Nahesha paulection
 */
package species.fire;

import exceptions.PokemonException;
import pokemon.Pokemon;

public class Charizard extends Pokemon
{
	/**
	 * @param health the health of the charizard
	 * @param t the type of the pokemon
	 * @param n the name of the pokemon
	 * @param a the attack points of the pokemon
	 * @param l the level of the pokemon
	 * @param d the defense points of the pokemon
	 * @param sp the spriteimage of rhe pokemon
	 */
	private Charizard(int health, String t, String n, int a, int l,int d, String sp1, String sp2)
	{
		super(health, t, n, a, l,d, sp1, sp2);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Ensures that only charmeleon can make a charizard
	 * and ensures that the basis of the charizard is always consistent
	 * @param charmeleon the pokemon
	 * @throws PokemonException if the pokemon is not a charmeleon then it will be thrown
	 */
	public Charizard(Pokemon charmeleon) throws PokemonException
	{
		this(185,charmeleon.getType(), "Charizard",104,charmeleon.getLevel(),143, charmeleon.getSpritePathFront(), charmeleon.getSpritePathBack());
		if(!charmeleon.getName().toLowerCase().contains("charmeleon"))
			throw new PokemonException("Only can be from Charmeleon");
	}
	/**
	 * holds the functionalities of the pokemon without wrapping
	 */

	public Charizard()
	{
		this(185,"fire", "Charizard",104,50, 143, "/resources/sprites/006.gif", "/resources/sprites/006b.gif");
	}


}
