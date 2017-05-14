package state;
import javafx.stage.Stage;

/**
 * AI.java -Create the AI to handle graphical output dependent on the GUI state.
 * @author Benjamin Hurston
 */
public class AI
{
	protected GUIState introState;
	protected GUIState creditsState;
	protected GUIState selectionState;
	protected GUIState quitState;
	protected GUIState currentState;
	protected GUIState menuState;
	protected GUIState battleState;
	protected Stage stage;

	/**
	 * Construct the possible scene states
	 * @param stage	the stage the scenes will be set on.
	 */
	public AI(Stage stage)
	{
		this.stage = stage;
		introState = new Intro(this);
		creditsState = new Credits(this);
		selectionState = new Selection(this);
		quitState = new Quit(this);
		menuState = new Menu(this);
		battleState = new Battle(this);
		currentState = introState;
	}

	/**
	 * Call the current state to execute.
	 */
	public void executeTasks()
	{
		currentState.execute();
	}

	/**
	 * Retrieve the current state
	 * @return	the current state
	 */
	public GUIState getCurrentState()
	{
		return currentState;
	}

	/**
	 * Set the new current state
	 * @param state	the state to set
	 */
	public void setCurrentState(GUIState state)
	{
		currentState = state;
	}

	/**
	 * Set the current state to the introState and return the state.
	 * @return	the introState
	 */
	public GUIState getIntroState()
	{
		currentState = introState;
		return currentState;
	}

	/**
	 * Set the current state to the creditsState and return the state.
	 * @return	the getCreditsState
	 */
	public GUIState getCreditsState()
	{
		currentState = creditsState;
		return currentState;
	}

	/**
	 * Set the current state to the selectionState and return the state.
	 * @return	the getSelectionState
	 */
	public GUIState getSelectionState()
	{
		currentState = selectionState;
		return currentState;
	}

	/**
	 * Set the current state to the quitState and return the state.
	 * @return	the quitState
	 */
	public GUIState getQuitState()
	{
		currentState = quitState;
		return quitState;
	}

	/**
	 * Set the current state to the menuState and return the state.
	 * @return	the menuState
	 */
	public GUIState getMenuState()
	{
		currentState = menuState;
		return currentState;
	}

	/**
	 * Set the current state to the battleState and return the state.
	 * @return	the battleState
	 */
	public GUIState getBattleState()
	{
		currentState = battleState;
		return currentState;
	}

	/**
	 * Execute the current state.
	 */
	public void execute()
	{
		if(currentState == introState)		currentState.execute();
		if(currentState == creditsState)	currentState.execute();
		if(currentState == selectionState)	currentState.execute();
		if(currentState == quitState)		currentState.execute();
		if(currentState == menuState)		currentState.execute();
		if(currentState == battleState)		currentState.execute();
	}
}
