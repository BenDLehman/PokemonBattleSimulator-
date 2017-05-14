package move;

import Store.StoreItems;

public abstract class Move
{
	private String name;
	private int power;
	private int PP;
	private int currentPP;

	public Move(String newName, int newPower, int newPP)
	{
		name = newName;
		power = newPower;
		PP = newPP;
		currentPP = newPP;
	}
	public String getName()
	{
		return name;
	}

	public int getPower()
	{
		return power;
	}

	public int getPP()
	{
		return PP;
	}

	public int getCurrentPP()
	{
		return currentPP;
	}

	public void usePP()
	{
		currentPP--;
	}
}
