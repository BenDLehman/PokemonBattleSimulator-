package animation;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * @author Benjamin Hurston
 * Scale is an animation class designed to handle scaling transformations on any node the caller chooses.
 * Scale allows the caller to instantiate the Scale object with a set of parameters to determine the exact
 * effect of the scale along with setters to reuse the same Scale object over different nodes, or simply
 * changing the behavior the currently designated node has. Uses the JavaFX default scaling methods but
 * packages them into a more convenient way to use to reduce code weight in the GUI classes.
 */

public class Scale
{
	/**
	 * Variables which determine the scale behavior a node has.
	 */
	private Node node;
	private char axis;
	private float duration;
	private float byX;
	private float fromX;
	private float toX;

	/**
	 * Constructor of the scale object
	 * @param node	the node to scale
	 * @param axis	the axis to scale with respect to
	 * @param duration	the duration it takes to complete the animation, in milliseconds
	 * @param byX	the pixel increments the scale should occur over
	 * @param fromX	the starting scale multiplier
	 * @param toX	the ending scale multiplier
	 */
	public Scale(Node node, char axis, float duration, float byX, float fromX, float toX)
	{
		this.node = node;
		this.axis = axis;
		this.duration = duration;
		this.byX = byX;
		this.fromX = fromX;
		this.toX = toX;
	}

	/**
	 * Scales the node using the constructor specifications.
	 */
	public void scale()
	{
		 ScaleTransition scale = new ScaleTransition(Duration.millis(duration), node);
		 if(axis == 'x' || axis == 'X')
		 {
			 scale.setToX(toX);
			 scale.setByX(byX);
			 scale.setFromX(fromX);
			 scale.byXProperty();
			 scale.toXProperty();
			 scale.fromXProperty();
		}
		 if(axis == 'y' || axis == 'Y')
		 {
			 scale.setToY(toX);
			 scale.setByY(byX);
			 scale.setFromY(fromX);
			 scale.byYProperty();
			 scale.toYProperty();
			 scale.fromYProperty();
		 }
	     scale.play();
	}

	/**
	 * Designate a new node to scale.
	 * @param node	-The new node to scale.
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
	 * Designate a new pixel increment amount
	 * @param byX
	 */
	public void setByX(float byX)
	{
		this.byX= byX;
	}

	/**
	 * Designate a new duration for the effect to occur over.
	 * @param milliseconds	-The duration of the scale effect in milliseconds.
	 */
	public void setDuration(float milliseconds)
	{
		this.duration = milliseconds;
	}

	/**
	 * Designate a new starting scale multiplier
	 * @param fromX
	 */
	public void setFromX(float fromX)
	{
		this.fromX = fromX;
	}

	/**
	 * Designate a new ending scale multiplier
	 * @param toX
	 */
	public void setToX(float toX)
	{
		this.toX = toX;
	}
}
