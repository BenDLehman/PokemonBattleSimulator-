/**
 * Holds the functions to add pokemon into the Species fire list
 * @author Nahesha paulection
 */
package species.fire;
import java.util.ArrayList;
import exceptions.SpeciesException;
import pokemon.Pokemon;
public class fire extends Pokemon
{
	protected ArrayList<Pokemon> firePokemonList;
	/**
	 *All pokemon that is fire hold these characteristics
	 * @param health the health of the pokemon
	 * @param newType the type of the pokemon
	 * @param newName the name of the pokemon
	 * @param attack the attack of the pokemon
	 * @param newLevel the level of the pokemon
	 * @param defense the defense of the pokemon
	 */
	private fire(int health, String newType, String newName, int attack, int newLevel, int defense, String sp1, String sp2)
	{

		super(health, "fire", newName, attack, newLevel, defense,sp1, sp2);
		// TODO Auto-generated constructor stub
	}
	/**
	 * A pokemon is put into the fire species
	 * @param pokemon a pokemon
	 * @throws SpeciesException ensures that only fire pokemon can be put into fire
	 */
	public fire(Pokemon pokemon) throws SpeciesException
	{
		this(pokemon.getHealth(),pokemon.getType(),pokemon.getName(),pokemon.getAttack(),pokemon.getLevel(),pokemon.getDefense(),
				pokemon.getSpritePathFront(), pokemon.getSpritePathBack());
		firePokemonList = new ArrayList<Pokemon>();
		if(!pokemon.getType().toLowerCase().contains("fire"))
		{
			throw new SpeciesException("Only fire pokemon can be put into fire");
		}
	}

}
