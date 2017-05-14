package state;

/**
 * Credits.java - Placeholder for the credits state display to be used if time remains.
 * @author Benjamin Hurston
 */
public class Credits extends GUIState
{

	public Credits(AI ai)
	{
		super(ai);
	}

	public void execute()
	{
		ai.setCurrentState(ai.getCreditsState());
		handleScene();
	}

	public void handleScene()
	{

	}

	public void goBack()
	{

	}

}
