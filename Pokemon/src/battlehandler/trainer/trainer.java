package battlehandler.trainer;
import java.util.ArrayList;

import pokemon.Pokemon;

/**
 * Holds the charactertistics and methods only a trainer has
 * @author nahesha paulection
 *
 */
public abstract class trainer
{
	protected String name;
	protected int level;
	protected Pokemon pokemon;
	protected ArrayList<Pokemon> PokemonList;
	protected int lifepoints;
	protected boolean active;
	/**
	 * initiate the pokemon
	 * @param name the name of the trainer
	 */
	public trainer(String name)
	{
		this.name = name;
		level = 1;
		PokemonList = new ArrayList<Pokemon>();

	}

	/**
	 * returns the name of the trainer
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}
	/**
	 * First it adds a pokemon in the list when it first starts on pokemon list can be used
	 * the pokemon will always be added to the last position of the array
	 * @param pokemon
	 */
	public boolean addPokemon(Pokemon pokemon)
	{
		if(PokemonList.isEmpty())
		{
			PokemonList.add(0, pokemon);
			return true;
		}
		PokemonList.add(PokemonList.size(), pokemon);
		return true;


	}
	/**
	 * Gives you the opportunity to switch pokemons
	 * @param currentPoke the pokemon you have right now
	 * @param targetPoke the pokemon you want to switch to
	 */
	public void switchPokemon(Pokemon currentPoke, Pokemon targetPoke)
	{
		//put the original pokemon in the chosenpokemon spot in the arraylist
		Pokemon tempPoke;
		for(int i = 0; i < PokemonList.size(); i++)
			{
			if(PokemonList.get(i) == targetPoke)
				{
					tempPoke = currentPoke;
					selectPokemon(targetPoke);
					PokemonList.remove(i);
					PokemonList.add(i, tempPoke);
					break;
				}
			}
	}
	/**
	 * Ensures that the pokemon is in the list
	 * @param poke
	 * @return
	 */
	public boolean findInPokemonList(Pokemon poke)
	{
		for(int i = 0; i < PokemonList.size();i++)
		{
			if(PokemonList.contains(poke))
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * returns where the pokemon is in the list
	 */
	public int positionInPokemonList(Pokemon poke)
	{
		int position = 0;
		for(int i = 0; i < PokemonList.size();i++)
		{
			if(PokemonList.contains(poke))
			{
				position = i;
			}
		}
		return position;
	}
	/**
	 *selects the pokemon that will be used
	 * @param poke
	 */
	public void selectPokemon(Pokemon poke)
	{
		PokemonList.remove(0);
		PokemonList.add(0, poke);
		pokemon = poke;
	}
	/**
	 * levels up the trainer
	 */
	public void levelUp()
	{
		level++;
	}

	/**
	 * returns the level of the trainer
	 */
	public int getLevel()
	{
		return level;
	}
	/**
	 * returns the lifepoints
	 */
	public int getLifePoint()
	{
		return lifepoints;
	}
	/**
	 * returns the lifepoints
	 */
	public Pokemon getPokemon(int slot)
	{
		return PokemonList.get(slot);
	}

}


//package battlehandler.trainer;
//import java.util.ArrayList;
//
//import pokemon.Pokemon;
//
///**
// * Holds the charactertistics and methods only a trainer has
// * @author nahesha paulection
// *
// */
//public abstract class trainer
//{
//	protected String name;
//	protected int level;
//	protected Pokemon pokemon;
//	protected ArrayList<Pokemon> PokemonList;
//	protected int lifepoints;
//	/**
//	 * initiate the pokemon
//	 * @param name the name of the trainer
//	 */
//	public trainer(String name)
//	{
//		this.name = name;
//		level = 1;
//		PokemonList = new ArrayList<Pokemon>();
//
//	}
//
//	/**
//	 * returns the name of the trainer
//	 * @return
//	 */
//	public String getName()
//	{
//		return name;
//	}
//	/**
//	 * First it adds a pokemon in the list when it first starts on pokemon list can be used
//	 * the pokemon will always be added to the last position of the array
//	 * @param pokemon
//	 */
//	public boolean addPokemon(Pokemon pokemon)
//	{
//		if(PokemonList.isEmpty())
//		{
//			PokemonList.add(0, pokemon);
//			return true;
//		}
//		PokemonList.add(PokemonList.size(), pokemon);
//		return true;
//
//
//	}
//	/**
//	 * Gives you the opportunity to switch pokemons
//	 * @param currentPoke the pokemon you have right now
//	 * @param targetPoke the pokemon you want to switch to
//	 */
//	public void switchPokemon(Pokemon currentPoke, Pokemon targetPoke)
//	{
//		//put the original pokemon in the chosenpokemon spot in the arraylist
//		Pokemon tempPoke;
//		for(int i = 0; i < PokemonList.size(); i++)
//			{
//			if(PokemonList.contains(targetPoke))
//				{
//					tempPoke = currentPoke;
//					selectPokemon(targetPoke);
//					PokemonList.add(i, tempPoke);
//					break;
//				}
//			}
//	}
//	/**
//	 * Ensures that the pokemon is in the list, return true when the pokemon can be found in the list
//	 * otherwise it is false
//	 * @param poke the pokemon
//	 * @return
//	 */
//	public boolean findInPokemonList(Pokemon poke)
//	{
//		for(int i = 0; i < PokemonList.size();i++)
//		{
//			if(PokemonList.contains(poke))
//			{
//				return true;
//			}
//		}
//		return false;
//	}
//	/**
//	 * returns where the pokemon is in the list
//	 */
//	public int positionInPokemonList(Pokemon poke)
//	{
//		int position = 0;
//		for(int i = 0; i < PokemonList.size();i++)
//		{
//			if(PokemonList.contains(poke))
//			{
//				position = i;
//			}
//		}
//		return position;
//	}
//	/**
//	 *selects the pokemon that will be used
//	 * @param poke
//	 */
//	public void selectPokemon(Pokemon poke)
//	{
//		pokemon = poke;
//	}
//	/**
//	 * levels up the trainer
//	 */
//	public void levelUp()
//	{
//		level++;
//	}
//
//	/**
//	 * returns the level of the trainer
//	 */
//	public int getLevel()
//	{
//		return level;
//	}
//	/**
//	 * returns the lifepoints
//	 */
//	public int getLifePoint()
//	{
//		return lifepoints;
//	}
//
//}
