package move;

import java.util.ArrayList;

public class GrassMove implements MoveBehavior
{
	protected ArrayList<Move> grassMovesList;
	private Move BulletSeed = new BulletSeed();
	private Move HornLeech = new HornLeech();
	private Move LeafBlade = new LeafBlade();
	private Move SeedFlare = new SeedFlare();

	public GrassMove()
	{
		grassMovesList = new ArrayList<Move>();
		learnMove();
	}

	@Override
	public void learnMove()
	{
		grassMovesList.add(HornLeech);
		grassMovesList.add(BulletSeed);
		grassMovesList.add(LeafBlade);
		grassMovesList.add(SeedFlare);
	}

	public ArrayList<Move> getMoveList()
	{
		return grassMovesList;
	}

}
