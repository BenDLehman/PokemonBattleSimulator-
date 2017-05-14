package gameplay;

/**
 * 
 * @author Ben Lehman
 *
 */
/**
 * addTimeObserver simply adds the observer to the Array List
 * removeTimeObserver simply removes the specified observer from the Array List
 * timeChanged increments the round and updates all the observers with that round number
 */
public interface Timer 
{
	public void addTimeObserver(TimeObserver observer);		
	public void removeTimeObserver(TimeObserver observer);	
	public void timeChanged();								
}
