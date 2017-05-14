package move;

import java.util.ArrayList;
import move.Move;

public class FireMove implements MoveBehavior {
	protected ArrayList<Move> fireMovesList;
	private Move FlameCharge = new FlameCharge();
	private Move FireFang = new FireFang();
	private Move BlazeKick = new BlazeKick();
	private Move HeatCrash = new HeatCrash();

	public FireMove()
	{
		fireMovesList = new ArrayList<Move>();
		learnMove();
	}
	/**
	 * based on the level of the pokemon,
	 * the pokemon will learn a specific move
	 */
	public void learnMove()
	{
		fireMovesList.add(BlazeKick);
		fireMovesList.add(FireFang);
		fireMovesList.add(HeatCrash);
		fireMovesList.add(FlameCharge);
	}

	public ArrayList<Move> getMoveList()
	{
		return fireMovesList;
	}


}