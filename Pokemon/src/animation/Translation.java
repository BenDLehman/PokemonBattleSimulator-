package animation;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * @author Benjamin Hurston
 * Translation is an animation class designed to handle translation transformations on any node the caller chooses.
 * Translation allows the caller to instantiate the Translation object with a set of parameters to determine the exact
 * effect of the translate along with setters to reuse the same Translation object over different nodes, or simply
 * changing the behavior the currently designated node has. Uses the JavaFX default translation methods but
 * packages them into a more convenient way to use to reduce code weight in the GUI classes.
 */

public class Translation
{
	/**
	 * Variables which determine the fade behavior a node has.
	 */
	private Node node;
	private char axis;
	private float shift;
	private float duration;
	private int cycles;
	private boolean autoReverse;

	/**
	 * Constructor of the Translation object
	 * @param node	the node to translate
	 * @param axis	the axis to translate it on
	 * @param shift	the translation axis location
	 * @param duration	the duration of the translation to occur over, in milliseconds
	 * @param cycles	the amount of the times the translate will occur (repeats)
	 * @param autoReverse	if the translate should return to its starting location upon completing a cycle
	 */
	public Translation(Node node, char axis, float shift, float duration, int cycles, boolean autoReverse)
	{
		this.node = node;
		this.axis = axis;
		this.shift = shift;
		this.duration = duration;
		this.cycles = cycles;
		this.autoReverse = autoReverse;
	}

	/**
	 * Translates the node using the specified parameters.
	 */
	public void translate()
	{
		 TranslateTransition translate = new TranslateTransition(Duration.millis(duration), node);
		 if(axis == 'x' || axis == 'X')	translate.setToX(shift);
		 if(axis == 'y' || axis == 'Y')	translate.setToY(shift);
	     translate.setDuration(Duration.millis(duration));
	     translate.setCycleCount(cycles);
	     translate.setAutoReverse(autoReverse);
	     translate.play();
	}

	/**
	 * Designate a new node to translate.
	 * @param node	-The new node to translate.
	 */
	public void setNode(Node node)
	{
		this.node = node;
	}

	/**
	 * Designate a new axis to scale with respect to
	 * @param axis	the axis, X, Y, or Z to use.
	 */
	public void setAxis(char axis)
	{
		this.axis = axis;
	}

	/**
	 * Designate a new axis location to translate to
	 * @param shift	the new location along the current axis to translate to
	 */
	public void setShift(float shift)
	{
		this.shift = shift;
	}

	/**
	 * Designate a new duration for the effect to occur over.
	 * @param milliseconds	-The duration of the translate effect in milliseconds.
	 */
	public void setDuration(float milliseconds)
	{
		this.duration = milliseconds;
	}

	/**
	 * Designate a new number of cycles for the translate to occur.
	 * @param cycles	-How many cycles the effect should repeat itself over.
	 */
	public void setCycles(int cycles)
	{
		this.cycles = cycles;
	}

	/**
	 * Designate whether the node should return to its starting position upon a cycle completion.
	 * @param autoReverse	-(true, false), should the node return to its location when a cycle completes?
	 */
	public void setAutoReverse(boolean autoReverse)
	{
		this.autoReverse = autoReverse;
	}
}
