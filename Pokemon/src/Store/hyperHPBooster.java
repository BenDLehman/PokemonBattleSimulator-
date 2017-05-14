package Store;

public class hyperHPBooster extends StoreItems {

	private hyperHPBooster(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}
	public hyperHPBooster()
	{
		this("Hyper Health Booster",80);
	}
	public int calculateRecovery(int currentLP, int maxLP)
	{
		if(currentLP<maxLP)
		{
			double healthGenerator = 80 + (Math.random() * (100 - 80));
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
		String s = "The pokemon gets 80% to 100% of their lifepoints back";
		description = s;
		return description;	
	}

}


