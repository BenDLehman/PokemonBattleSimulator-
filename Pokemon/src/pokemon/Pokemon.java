package pokemon;

import java.util.ArrayList;

import Store.StoreItems;
import Store.hpBooster;
import Store.hyperHPBooster;
import Store.superHPBooster;
import exceptions.NotEnoughMoneyException;
import exceptions.NotFoundException;
import gameplay.TimeObserver;
import move.Move;

/**
 * Simple Factory to build the Pokemon and their basic methods.
 * @author Justin Study Group 6
 */
public abstract class Pokemon implements TimeObserver
{
	//descriptor and values for pokemon for battling
	protected int round;
	protected String pokeName;
	protected String nickName;
	protected String type;
	protected int hp;
	protected int maxHP;
	protected int atk;
	protected int level;
	protected int defense;

	//instance variables for move
	protected ArrayList<Move> moves;
	protected int baseExp;
	protected int move1PP;
	protected int move2PP;
	protected int move3PP;
	protected int move4PP;
	protected int currentAmountOfPP;

	protected Move moveBehavior;
	protected Move move;
	protected int Coins;
	protected String spritePath1;
	protected String spritePath2;
	protected ArrayList<StoreItems> bookbag;

	/**
	 * Constructor used for testing to ensure the methods work
	 */
	public Pokemon(int health, String newType, String newName,int attack, int newLevel, int defense, String sp1, String sp2)
	{
		hp = health;
		type = newType;
		pokeName = newName;
		nickName = newName;
		atk = attack;
		level = newLevel;
		maxHP = hp;
		this.defense = defense;
		spritePath1 = sp1;
		spritePath2 = sp2;
		Coins = 100;
		bookbag = new ArrayList<StoreItems>();
	}
	
	public String getSpritePathFront()
	{
		return spritePath1;
	}

	public String getSpritePathBack()
	{
		return spritePath2;
	}


	/**
	 * Sets a move behavior
	 */
	public void setMove(ArrayList<Move> m)
	{
		moves = m;
	}

	/**
	 * replaces a current move with a new move
	 * @return
	 */
	public boolean replaceMove()
	{
		//not done
		return true;
	}

	/**
	 * Pokemon gains health back
	 * @param amount
	 * @return
	 */
	public void heal(int amount)
	{
		if(hp > 0)
		{
			hp = hp + amount;

			//make sure pokemon doesn't overheal
			if(hp > maxHP)
			{
				hp = maxHP;
			}
		}
	}

	public void setNickName(String name)
	{
		nickName = name;
	}

	public int getAttack()
	{
		return atk;
	}

	/**
	 * Next methods return basic pokemon info
	 * @return type, hp, atk, name
	 */
	public String getType()
	{
		return type;
	}

	public int getHealth()
	{
		return hp;
	}
	public boolean getImage()
	{
		//not done
		return true;
	}

	public String getName()
	{
		return pokeName;
	}

	public String getNickName()
	{
		return nickName;
	}

	public int getLevel()
	{
		return level;
	}

	/**
	 * Pokemon takes damage from opponent
	 * @return
	 */
	public void takeDamage(int damage)
	{
		if(hp > 0)
		{
			hp = hp - damage;

			if(hp < 0)
			{
				hp = 0;
			}
		}
	}

	public void attack(Move m, Pokemon target)
	{
		target.takeDamage(m.getPower()*getLevel());
	}

	public void updateTime(int time)
	{
		round++;
	}
	/**
	 *
	 * @return round
	 */
	public int getRound()
	{
		return round;
	}

	public int getDefense()
	{
		return defense;
	}

	public ArrayList<Move> getMoveList()
	{
		return moves;
	}

	public int getMaxHealth()
	{
		return maxHP;
	}
	public int getAmountOfCoins()
	{
		return Coins;
	}

	public void buyItems(StoreItems item, int amount) throws NotEnoughMoneyException 
	{
		int i = 0;
		if(Coins > item.getCost())
		{
			Coins -= item.getCost()*amount;
			while(i<amount)
			{
				bookbag.add(item);
				i++;
			}
		}
		else
			throw new NotEnoughMoneyException("You do not have enough to get "+ getName());
	}
	/**
	 * uses the item in the backpack
	 * @param item the item that is in the backpack
	 * @throws NotFoundException if the item is not in the back then it can't be used
	 */

	public void useItem(StoreItems item) throws NotFoundException 
	{
		StoreItems hpBooster = new hpBooster();
		StoreItems sHPBooster = new superHPBooster();
		StoreItems hHPBooster = new hyperHPBooster();
		if(bookbag.contains(item))
		{
			if(item.getName().contains(hpBooster.getName())||item.getName().contains(sHPBooster.getName())
					||(item.getName().contains(hHPBooster.getName()))||item.getName().contains(hHPBooster.getName()))
			hp = item.calculateRecovery(hp, maxHP);
			
		}
		
		else
			throw new NotFoundException("This item is not in your bookbag");
		
	}
	
	














}
