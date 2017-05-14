/**
 * uses decorator to ensure that evolved fire species can also be added to species
 * @author nahesha paulection
 */
package species.fire;

import exceptions.SpeciesException;

public abstract class EvolvedFire
{
	fire fire;

	/**
	 * sets this instance variable to the object that is being wrapped
	 * @param fire, the species type
	 * @throws SpeciesException
	 */
	public EvolvedFire(fire fire) throws SpeciesException
	{
		this.fire = fire;
	}
	/**
	 * returned the type of fire
	 */
	public String getType()
	{
		return fire.getType() + ", evolved Fire";
	}

}
