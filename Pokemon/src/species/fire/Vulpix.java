/**
 * Holds all the methods for a Vulpix
 * @author Nahesha Paulection
 */
package species.fire;

import pokemon.Pokemon;

public class Vulpix extends Pokemon
{

	/**
	 * these are the characteristics that make a Vulpix a pokemon
	 * @param health the heath of a Vulpix
	 * @param t the Species type
	 * @param n the name of the species
	 * @param a the attack points of the pokemon
	 * @param l the level of the pokemon
	 * @param d defense number of the pokemon
	 */
	private Vulpix(int health, String t, String n, int a, int l,int d,String sp1, String sp2)
	{
		super(health, t, n, a, l,d,sp1, sp2);
	}
	/**
	 * ensures that all Vulpix starts the same
	 */
	public Vulpix()
	{
		this(145,"Fire","Vulpix", 102,50,101,"/resources/sprites/037.gif", "/resources/sprites/037b.gif");

	}

}
