/**
 * Holds the character a movebehavior must have inorder to be called a move behavior
 * Group 6
 * @author nahesha paulection
 */
package move;

import java.util.ArrayList;

public interface MoveBehavior
{
	/**
	 * Inorder to learn certain moves a pokemon must be a specific level
	 * @param level
	 */
	public void learnMove();

	public ArrayList<Move> getMoveList();


}
