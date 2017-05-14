package gui;
import state.Simulator;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * UserInterface.java -Keeps the main method organized from the rest of the program so its location is easily known.
 * Sets the stage to be used to display scenes and builds the Simulator which will handle
 * initialization processes of the program.
 * @author Benjamin Hurston
 */
public class UserInterface extends Application
{
	protected Stage stage;
    protected Simulator simulator;

    /**
     * Initialize the stage to be used in the remainder of the program, create and call this Simulator.
     */
    public void start(Stage stage)
    {
    	this.stage = stage;
        simulator = new Simulator(this.stage);
        simulator.update();
    }

    /**
     * The main method to be run
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}