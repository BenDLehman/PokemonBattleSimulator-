package gui;

import battlehandler.trainer.firstPlayer;
import battlehandler.trainer.secondPlayer;
import battlehandler.trainer.trainer;

/**
 * InvokerBuilder.java -Build and store any Commands to be used. The Invoker may be left untouched while retaining
 * full functionality in the future when other Commands are added or old ones are modified.
 * Modeled after Justin Study's usage of the Invoker in the Command Pattern Lab.
 * @author Benjamin Hurston
 *
 */
public class InvokerBuilder
{
	//Passes through the singleton instances reduce coupling between the commands and the specific implementations of trainers.
	trainer player1 = firstPlayer.getFirstPlayerInstance("Player 1");
	trainer player2 = secondPlayer.getSecondPlayerInstance("Player 2");

	/**
	 * Construct and store the commands to be used.
	 */
	public InvokerBuilder()
	{
		Invoker.setCommandArray(0, new MoveOne(player1, player2));
		Invoker.setCommandArray(1, new MoveTwo(player1, player2));
		Invoker.setCommandArray(2, new MoveThree(player1, player2));
		Invoker.setCommandArray(3, new MoveFour(player1, player2));
	}
}
