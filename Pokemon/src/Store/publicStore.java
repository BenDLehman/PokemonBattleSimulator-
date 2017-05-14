package Store;

import java.util.ArrayList;

import exceptions.NotFoundException;

public class publicStore {
	ArrayList<StoreItems> Store;
	protected int amountInStore = 0;
	protected int itemAmount;
	int j = 0;
	public publicStore()
	{
		
		Store = new ArrayList<StoreItems>();
		StoreItems hpBooster = new hpBooster();
		StoreItems sHPBooster = new superHPBooster();
		StoreItems hHpBooster = new hyperHPBooster();
		addStoreItems(hpBooster,10);
		addStoreItems(sHPBooster,5);
		addStoreItems(hHpBooster,5);
	}
	public void buy(StoreItems item, int amount) throws NotFoundException
	{
		int i = 0;
		while(i < amount)
		{
			Store.remove(item);
		}
		if(amount> getInventoryAmount())
		{
			removeAllItems(item);
		}
		if(!Store.contains(item))
			throw new NotFoundException("There is no more of "+item.getName());
	}
	public void getInventory(StoreItems item) 
	{
		for(int i = 0; i < Store.size(); i++)
		{
			if(Store.contains(item))
			{
				itemAmount++;
			}
		}
	}
	public int getInventoryAmount()
	{
		return itemAmount;
	}
	private void removeAllItems(StoreItems item)
	{
		for(int i = 0; i < Store.size(); i++)
		{
			if(Store.contains(item))
			{
				Store.remove(item);
			}
		}
	}
	private void addStoreItems(StoreItems item,int amount)
	{
		int i = 0;
		while( i < amount)
		{
			Store.add(item);
		}
	}
	
}
