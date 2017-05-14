package Store;
public abstract class StoreItems{
	protected String name;
	protected int cost;
	protected int newAmount;
	protected String description;
	public StoreItems(String name,int cost)
	{
		this.name = name;
		this.cost = cost;
	}
	public String getName()
	{
		return name;
	}
	
	public int getCost()
	{
		return cost;
	}
	public int calculateRecovery(int current,int max)
	{
		return newAmount;
	}
	public String getDescription()
	{
		return description;
	}
	
	

}
