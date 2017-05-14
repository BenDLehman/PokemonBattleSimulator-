package species.grass;

import pokemon.Pokemon;

/**
 * Houses methods used by pokemon in water species
 * @author Justin Study Group 6
 */
public interface Grass 
{
	public void addToGrassSpecies(Pokemon poke);
	public void levelUp();
	public void setMoveBehavior();
	public boolean replaceMove();
	public void gainExperience(int amount);
	public String getType();
	public int getLifePoints();
	public int getAttackPoints();
	public boolean getImage();
	public String getName();
	public void doSpecialAttack();
	public void updateTime(int time);
}
