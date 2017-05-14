package animation;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * @author Benjamin Hurston
 * Fade is an animation class designed to handle fade transitions and effects on any node the caller chooses.
 * Fade allows the caller to instantiate the Fade object with a set of information to determine the fade effect along
 * with setters to reuse the same Fade object over different nodes, or simply changing the behavior the currently designated node
 * has. Uses the JavaFX default scaling methods but packages them into a more convenient way to use to reduce code weight in the GUI classes.
 */

public class Fade
{
	/**
	 * Variables which determine the fade behavior a node has.
	 */
	private Node node;
	private float start;
	private float end;
	private float duration;
	private int cycles;
	private boolean autoReverse;

	/**
	 * Constructor of the Fade object.
	 * @param node	-Which node the caller wishes to affect.
	 * @param start	-Starting alpha value for the node.
	 * @param end	-Ending alpha value for the node.
	 * @param duration	-The duration the transition from start to end takes, in milliseconds.
	 * @param cycles	-The number of cycles the fade effect should have.
	 * @param autoReverse	-Should a cycle revert back to the starting alpha value after reaching the end?
	 */
	public Fade(Node node, float start, float end, float duration, int cycles, boolean autoReverse)
	{
		this.node = node;
		this.start = start;
		this.end = end;
		this.duration = duration;
		this.cycles = cycles;
		this.autoReverse = autoReverse;
	}

	/**
	 * Fades the node using the assigned variables from start to end.
	 */
	public void fadeIn()
	{
		 FadeTransition fade = new FadeTransition(Duration.millis(duration), node);
	     fade.setFromValue(start);
	     fade.setToValue(end);
	     fade.setCycleCount(cycles);
	     fade.setAutoReverse(autoReverse);
	     fade.play();
	}

	/**
	 * Fades the object using variables assigned according to fadeIn. Thus, fades the node from
	 * end to start.
	 */
	public void fadeOut()
	{
		 FadeTransition fade = new FadeTransition(Duration.millis(duration), node);
	     fade.setFromValue(end);
	     fade.setToValue(start);
	     fade.setCycleCount(cycles);
	     fade.setAutoReverse(autoReverse);
	     fade.play();
	}

	/**
	 * Designate a new node to fade.
	 * @param node	-The new node to fade.
	 */
	public void setNode(Node node)
	{
		this.node = node;
	}

	/**
	 * Designate a new starting alpha value.
	 * @param start	-The starting alpha value of the effect.
	 */
	public void setStart(float start)
	{
		this.start = start;
	}

	/**
	 * Designate a new ending alpha value.
	 * @param end	-The ending alpha value of the effect.
	 */
	public void setEnd(float end)
	{
		this.end = end;
	}

	/**
	 * Designate a new duration for the effect to occur over.
	 * @param milliseconds	-The duration of the fade effect in milliseconds.
	 */
	public void setDuration(float milliseconds)
	{
		this.duration = milliseconds;
	}

	/**
	 * Designate a new number of cycles for the fade to occur.
	 * @param cycles	-How many cycles the effect should repeat itself over.
	 */
	public void setCycles(int cycles)
	{
		this.cycles = cycles;
	}

	/**
	 * Designate whether the node should return to its starting alpha value after the fade completes.
	 * @param autoReverse	-(true, false), should the node return to its starting alpha value when faded?
	 */
	public void setAutoReverse(boolean autoReverse)
	{
		this.autoReverse = autoReverse;
	}
}
