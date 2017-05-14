package gui;
import battlehandler.trainer.trainer;
import move.Move;
import pokemon.Pokemon;

/**
 * MoveOne.java -Flexible command that is compatible for future customization which will perform
 * the move within the Pokemon's first moveslot.
 * @author Benjamin Hurston
 */
public class MoveOne implements Command
{
	trainer trainer1;
	trainer trainer2;
	trainer active;
	trainer inactive;

	Move move;
	Pokemon user;
	Pokemon target;
	String effectiveness;

	public MoveOne(trainer trainer1, trainer trainer2)
	{
		this.trainer1 = trainer1;
		this.trainer2 = trainer2;
	}

	/**
	 * Execute the first move of the attacking Pokemon. Damage is calculated as the following algorithm:
	 * (((2 * Pokemon Level + 10)/250) * (Attacker Attack/Target Defense) * Move Base Power + 2) * Effectiveness Modifier * 1.5)
	 * This is a close, just slightly modified version of the official Pokemon damage algorithm which allows lower-tier Pokemon
	 * to stand a chance based on type advantage against the higher-tier Pokemon.
	 */
	public void execute()
	{
		int damage;
		if(trainer1.isActive() == true)
		{
			inactive = trainer2;
			active = trainer1;
		}
		else
		{
			inactive = trainer1;
			active = trainer2;
		}
		user = active.getPokemon(0);
		target = inactive.getPokemon(0);
		move = active.getPokemon(0).getMoveList().get(0);

		damage = (int) ((float) (0.44 * (float) (user.getAttack()/(float) target.getDefense()) * move.getPower() + 2) * (getEffectiveness(target, user)));

		target.takeDamage(damage);

		active.getPokemon(0).getMoveList().get(0).usePP();

	}

	/**
	 * Get the type advantage multiplier for the attacking Pokemon based on the target's own type.
	 * @param target the Pokemon being attacked
	 * @param user	the Pokemon who is attacking
	 * @return	the type advantage modifier
	 */
	private double getEffectiveness(Pokemon target, Pokemon user)
	{
		if((target.getType().contains("fire") || target.getType().contains("Fire")) && (user.getType().contains("water") || user.getType().contains("Water")))
		{
			return 2.0 * 1.5;
		}
		else if((target.getType().contains("fire") || target.getType().contains("Fire")) && (user.getType().contains("grass") || user.getType().contains("Grass")))
		{
			return 0.5 * 1.5;
		}
		else if((target.getType().contains("fire") || target.getType().contains("Fire")) && (user.getType().contains("fire") || user.getType().contains("Fire")))
		{
			return 0.5 * 1.5;
		}
		else if((target.getType().contains("grass") || target.getType().contains("Grass")) && (user.getType().contains("water") || user.getType().contains("Water")))
		{
			return 0.5 * 1.5;
		}
		else if((target.getType().contains("grass") || target.getType().contains("Grass")) && (user.getType().contains("grass") || user.getType().contains("Grass")))
		{
			return 0.5 * 1.5;
		}
		else if((target.getType().contains("grass") || target.getType().contains("Grass")) && (user.getType().contains("fire") || user.getType().contains("Fire")))
		{
			return 2.0 * 1.5;
		}
		else if((target.getType().contains("water") || target.getType().contains("Water")) && (user.getType().contains("water") || user.getType().contains("Water")))
		{
			return 0.5 * 1.5;
		}
		else if((target.getType().contains("water") || target.getType().contains("Water")) && (user.getType().contains("grass") || user.getType().contains("Grass")))
		{
			return 2.0 * 1.5;
		}
		else if((target.getType().contains("water") || target.getType().contains("Water")) && (user.getType().contains("fire") || user.getType().contains("Fire")))
		{
			return 0.5 * 1.5;
		}
		else
		{
			return 1.0 * 1.5;
		}
	}
}
