package testMove;

import org.junit.Test;
import move.MoveFactory;
import pokemon.Pokemon;
import species.fire.Charizard;

public class TestMoves
{

	@Test
	public void testInitialization()
	{
		Pokemon poke = new Charizard();
		MoveFactory fact = new MoveFactory();
		fact.createMoveList(poke);
	}

}
