package Store;

public class superHPBooster extends StoreItems {

	private superHPBooster(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}
	public superHPBooster()
	{
		this("super Health Booster",50);
	}
	public int calculateRecovery(int currentLP, int maxLP)
	{
		if(currentLP<maxLP)
		{
			double healthGenerator = 50 + (Math.random() * (50 - 30));
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
		String s = "The pokemon gets 30% to 50% of their lifepoints back";
		description = s;
		return description;	
	}

}
