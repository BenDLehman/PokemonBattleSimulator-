/**
 * Has the methods a charmander must have inorder to be consisted a pokemon
 * @author Nahesha paulection
 */
package species.fire;

import pokemon.Pokemon;


public class Charmander extends Pokemon
{

	/**
	 * these are the characteristics that make a charmander a pokemon
	 * @param health the heath of charmander
	 * @param t the Species type
	 * @param n the name of the species
	 * @param a the attack points of the pokemon
	 * @param l the level of the pokemon
	 * @param d the defense number for the pokemon
	 */
	private Charmander(int health, String t, String n, int a, int l,int d,String sp1, String sp2)
	{
		super(health, t, n, a, l,d, sp1, sp2);
	}
	/**
	 * ensures that all Charmanders starts the same
	 */
	public Charmander()
	{
		this(146,"Fire","Charmander", 114,50,104,"/resources/sprites/004.gif", "/resources/sprites/004b.gif");

	}



}
