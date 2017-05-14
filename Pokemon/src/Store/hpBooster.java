package Store;

import pokemon.Pokemon;

public class hpBooster extends StoreItems {
	

	private hpBooster(String name, int cost) 
	{
		super(name, cost);
	}
	public hpBooster() 
	{
		this("Health Potion booster", 10);
	}
	/**
	 * pokemon gets 5% - 15% of their current lifepoints back
	 */
	public int calculateRecovery(int currentLP, int maxLP)
	{
		if(currentLP<maxLP)
		{
			double healthGenerator = 5 + (Math.random() * (10 - 5));
			double Generated = Math.ceil((healthGenerator/100)*maxLP);
			newAmount = currentLP + (int)Generated;
			if(newAmount > maxLP)
			{
				newAmount = maxLP;
			}
		}
		return newAmount;
	}
	public String getDescription()
	{
		String s = "The pokemon gets 5% to 10% of their lifepoints back";
		description = s;
		return description;
		
	}

}
