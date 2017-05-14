package species.water;

import exceptions.SpeciesException;
/**
 * 
 * @author Ben Lehman
 *
 */
public class EvolvedWater 
{
Water water;
	
	/**
	 * sets this instance variable to the object that is being wrapped
	 * @param fire, the species type
	 * @throws SpeciesException 
	 */
	public EvolvedWater(Water water) throws SpeciesException
	{
		this.water = water;
	}
	/**
	 * returned the type of fire
	 */
	public String getType()
	{
		return water.getType() + ", evolved Fire";
	}
}
