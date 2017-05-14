package move;

import java.util.ArrayList;


public class WaterMove implements MoveBehavior {

	protected ArrayList<Move> waterMovesList;
	private Move Clamp = new Clamp() ;
	private Move AquaTail = new AquaTail();
	private Move WaterShuriken = new WaterSpout();
	private Move AquaJet = new AquaJet();

	public WaterMove()
	{
		waterMovesList = new ArrayList<Move>();
		learnMove();
	}

	@Override
	public void learnMove()
	{
		waterMovesList.add(AquaTail);
		waterMovesList.add(Clamp);
		waterMovesList.add(WaterShuriken);
		waterMovesList.add(AquaJet);
	}

	public ArrayList<Move> getMoveList()
	{
		return waterMovesList;
	}

}
