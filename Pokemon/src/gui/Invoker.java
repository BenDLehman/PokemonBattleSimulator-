package gui;

/**
 * Invoker.java -Invoker class acting like "remote" of the system for the useable commands.
 * Invoker usage modeled after Justin Study's implementation in the
 * Command Pattern lab.
 * @author Benjamin Hurston
 */

public class Invoker
{
	//array of commands, these have a pre-specified location within the array.
	//***INVOKER STILL BUILT TO BE LEFT ALONE WITHOUT BEING TOUCHED IF FUTURE COMMANDS ARE ADDED/CHANGED***
	//0- MoveOne
	//1- MoveTwo
	//2- MoveThree
	//3- MoveFour
	private static Command[] commandArray = new Command[4];


	/**
	 * Used by the InvokerBuilder to store the Commands when initially.
	 * constructed.
	 * @param i	the position within the commandArray to store the command.
	 * @param c	the command to be stored.
	 */
	public static void setCommandArray(int s, Command c)
	{
		commandArray[s] = c;
	}

	/**
	 * Calls execute to a given Command within the commandArray.
	 * @param i the Command in the commandArray to be executed.
	 */
	public static void pushButton(int i)
	{
		commandArray[i].execute();
	}
}
