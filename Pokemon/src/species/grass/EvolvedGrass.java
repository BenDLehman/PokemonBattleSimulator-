package species.grass;

import exceptions.SpeciesException;

public abstract class EvolvedGrass implements Grass
{
	Grass grass;
	
	/**
	 * sets this instance variable to the object that is being wrapped
	 * @param fire, the species type
	 * @throws SpeciesException 
	 */
	public EvolvedGrass(Grass grass) throws SpeciesException
	{
		this.grass = grass;
	}
	/**
	 * returned the type of fire
	 */
	public String getType()
	{
		return grass.getType() + ", evolved Fire";
	}
}
