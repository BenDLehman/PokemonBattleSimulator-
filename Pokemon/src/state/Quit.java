package state;

/**
 * Quit.java -Placeholder for the quit state to be used if time remains.
 * @author Benjamin Hurston
 */
public class Quit extends GUIState
{

	public Quit(AI ai)
	{
		super(ai);
	}

	public void execute()
	{
		ai.setCurrentState(ai.getQuitState());
		handleScene();
	}

	public void handleScene()
	{
		//1- cleanup memory
		//2- close the program, or perhaps put back at the main menu?
	}
}
