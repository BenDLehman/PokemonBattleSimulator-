package move;


import java.util.ArrayList;

import pokemon.Pokemon;

public class MoveFactory
{
	WaterMove water = new WaterMove();
	FireMove fire = new FireMove();
	GrassMove grass = new GrassMove();
	public ArrayList<Move> moves;
	public void createMoveList(Pokemon poke)
	{
		moves = poke.getMoveList();
		if(poke.getType() == "fire" || poke.getType() == "Fire")
		{
			moves = fire.getMoveList();
		}
		else if(poke.getType() == "grass" || poke.getType() == "Grass")
		{
			moves = grass.getMoveList();
		}
		else if(poke.getType() == "water" || poke.getType() == "Water")
		{
			moves = water.getMoveList();
		}
		poke.setMove(moves);
	}
}
