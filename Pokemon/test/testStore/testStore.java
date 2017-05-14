package testStore;

import static org.junit.Assert.*;

import org.junit.Test;

import Store.StoreItems;
import Store.hpBooster;
import Store.hyperHPBooster;
import Store.superHPBooster;
import exceptions.NotEnoughMoneyException;
import exceptions.NotFoundException;
import move.HornLeech;
import move.Move;
import move.MoveFactory;
import pokemon.Pokemon;
import species.fire.Charmander;
import species.grass.Bulbasaur;
import species.water.Squirtle;

public class testStore 
{
	@Test
	public void testHPBooster() throws NotEnoughMoneyException, NotFoundException
	{
		Pokemon pk = new Charmander();
		StoreItems hp = new hpBooster();
		pk.buyItems(hp,3);
		assertEquals(70,pk.getAmountOfCoins());
		pk.takeDamage(80);
		System.out.println(pk.getName()+": current lifepoints is " + pk.getHealth());
		pk.useItem(hp);
		System.out.println(pk.getName()+": used " + hp.getName());
		pk.getHealth();
		System.out.println(pk.getName()+": current lifepoints is " +pk.getHealth());
		
	}
	
	@Test
	public void testSuperHPBooster() throws NotEnoughMoneyException, NotFoundException
	{
		Pokemon pk = new Squirtle();
		StoreItems shp = new superHPBooster();
		pk.buyItems(shp,1);
		assertEquals(50,pk.getAmountOfCoins());
		pk.takeDamage(150);
		System.out.println(pk.getName()+": current lifepoints is " + pk.getHealth());
		pk.useItem(shp);
		System.out.println(pk.getName()+": used " + shp.getName());
		pk.getHealth();
		System.out.println(pk.getName()+": current lifepoints is " +pk.getHealth());
		
	}
	@Test
	public void testHyperHPBooster() throws NotEnoughMoneyException, NotFoundException
	{
		Pokemon pk = new Bulbasaur();
		StoreItems hhp = new hyperHPBooster();
		pk.buyItems(hhp,1);
		assertEquals(20,pk.getAmountOfCoins());
		pk.takeDamage(150);
		System.out.println(pk.getName()+": current lifepoints is " + pk.getHealth());
		pk.useItem(hhp);
		System.out.println(pk.getName()+": used " + hhp.getName());
		pk.getHealth();
		System.out.println(pk.getName()+": current lifepoints is " +pk.getHealth());
		
	}
	@Test
	public void testEther() throws NotEnoughMoneyException, NotFoundException
	{
		
	}
}
