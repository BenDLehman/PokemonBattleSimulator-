package state;
import javafx.scene.layout.AnchorPane;

/**
 * Selection.java -Placeholder for the selection state display to be used if time remains.
 * @author Benjamin Hurston
 */

public class Selection extends GUIState
{

	public Selection(AI ai)
	{
		super(ai);
	}

	public void execute(AnchorPane root)
	{
		ai.setCurrentState(ai.getSelectionState());
		handleScene();
	}

	public void handleScene()
	{

	}

	public void goBack()
	{

	}

	public void lockIn()
	{

	}

	public void startBattle()
	{

	}

}
