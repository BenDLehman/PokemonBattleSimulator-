package species.water;

import java.util.ArrayList;

import exceptions.SpeciesException;
import pokemon.Pokemon;

public class Water extends Pokemon
{
	protected ArrayList<Pokemon> waterPokemonList;
	private Water(int health, String newType, String newName, int attack, int newLevel, int defense, String sp1, String sp2)
	{
		super(health, newType, newName, attack, newLevel, defense,sp1, sp2);
	}

	public Water(Pokemon pokemon) throws SpeciesException
	{
		this(pokemon.getHealth(),pokemon.getType(),pokemon.getName(),pokemon.getAttack(),pokemon.getLevel(),pokemon.getDefense(),pokemon.getSpritePathFront(), pokemon.getSpritePathBack());
		waterPokemonList = new ArrayList<Pokemon>();
		if(!pokemon.getType().toLowerCase().contains("water"))
		{
			throw new SpeciesException("Only water pokemons can be evolved");
		}
	}
}
