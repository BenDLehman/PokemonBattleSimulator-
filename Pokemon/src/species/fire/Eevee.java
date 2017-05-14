/**
 * Holds the functions that make Eevee a pokemon
 */
package species.fire;

import pokemon.Pokemon;

public class Eevee extends Pokemon
{
	/**
	 *
	 * @param health the health of Eevee
	 * @param newType the type Eevee is
	 * @param newName the name of the pokemon
	 * @param attack the attack points of the pokemon
	 * @param newLevel the level of the pokemon
	 * @param defense the defense of the pokemon
	 */

	private Eevee(int health, String newType, String newName, int attack, int newLevel, int defense,String sp1, String sp2)
	{
		super(health, newType, newName, attack, newLevel, defense,sp1, sp2);
		// TODO Auto-generated constructor stub
	}
	/**
	 * The characteristics of the pokemon that cannot be changed when called
	 */
	public Eevee()
	{
		this(162,"fire","Eevee",117,50,128,"/resources/sprites/133.gif", "/resources/sprites/133b.gif");
	}

}
