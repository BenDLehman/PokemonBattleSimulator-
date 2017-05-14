package pokemon;

import exceptions.PokemonException;
import species.fire.Charizard;
import species.fire.Charmander;
import species.fire.Charmeleon;
import species.fire.Eevee;
import species.fire.Flareon;
import species.fire.NineTails;
import species.fire.Vulpix;
import species.grass.Bulbasaur;
import species.grass.Gloom;
import species.grass.Ivysaur;
import species.grass.Oddish;
import species.grass.Venusaur;
import species.grass.Vileplume;
import species.water.Blastoise;
import species.water.Poliwag;
import species.water.Poliwhirl;
import species.water.Squirtle;
import species.water.Wartortle;

/**
 * Simple factory that calls createPokemon and brings pokemon to life
 * @author Justin Study Group6
 */
public class PokemonFactory 
{
	/**
	 * Constructor
	 */
	public PokemonFactory()
	{
	}
	
	/**
	 * Finds pokemons constructor and returns pokemon
	 * @param name
	 * @return Pokemon
	 * @throws PokemonException
	 */
	public Pokemon createPokemon(String name) throws PokemonException
	{
		/**
		 * Grass pokemon
		 */
		if(name == "Bulbasaur")
		{
			Pokemon Bulbasaur = new Bulbasaur();
			return Bulbasaur;
		}
		if(name == "Oddish")
		{
			Pokemon Oddish = new Oddish();
			return Oddish;
		}
		if(name == "Ivysaur")
		{
			Pokemon b = new Bulbasaur();
			Pokemon Ivysaur = new Ivysaur(b);
			return Ivysaur;
		}
		if(name == "Gloom")
		{
			Pokemon o = new Oddish();
			Pokemon Gloom = new Gloom(o);
			return Gloom;
		}
		if(name == "Venusaur")
		{
			Pokemon b = new Bulbasaur();
			Pokemon i = new Ivysaur(b);
			Pokemon Venusaur = new Venusaur(i);
			return Venusaur;
		}
		if(name == "Vileplume")
		{
			Pokemon o = new Oddish();
			Pokemon g = new Gloom(o);
			Pokemon Vileplume = new Vileplume(g);
			return Vileplume;
		}
		
		/**
		 * Fire pokemon
		 */
		if(name == "Charmander")
		{
			Pokemon Charmander = new Charmander();
			return Charmander;
		}
		if(name == "Vulpix")
		{
			Pokemon Vulpix = new Vulpix();
			return Vulpix;
		}
		if(name == "Charmeleon")
		{
			Pokemon c = new Charmander();
			Pokemon Charmeleon = new Charmeleon(c);
			return Charmeleon;
		}
		if(name == "Flareon")
		{
			Pokemon e = new Eevee();
			Pokemon Flareon = new Flareon(e);
			return Flareon;
		}
		if(name == "Charizard")
		{
			Pokemon c = new Charmander();
			Pokemon cm = new Charmeleon(c);
			Pokemon Charizard = new Charizard(cm);
			return Charizard;
		}
		if(name == "Ninetails")
		{
			Pokemon v = new Vulpix();
			Pokemon Ninetails = new NineTails(v);
			return Ninetails;
		}
		
		/**
		 * Water pokemon
		 */
		if(name == "Squirtle")
		{
			Pokemon Squirtle = new Squirtle();
			return Squirtle;
		}
		if(name == "Poliwag")
		{
			Pokemon Poliwag = new Poliwag();
			return Poliwag;
		}
		if(name == "Wartortle")
		{
			Pokemon s = new Squirtle();
			Pokemon Wartortle = new Wartortle(s);
			return Wartortle;
		}
		if(name == "Poliwhirl")
		{
			Pokemon p = new Poliwag();
			Pokemon Poliwhirl = new Poliwhirl(p);
			return Poliwhirl;
		}
		if(name == "Blastoise")
		{
			Pokemon s = new Squirtle();
			Pokemon w = new Wartortle(s);
			Pokemon Blastoise = new Blastoise(w);
			return Blastoise;
		}
		
		throw new PokemonException("That Pokemon can't be created right now!");
	}
}
