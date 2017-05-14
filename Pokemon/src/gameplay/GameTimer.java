package gameplay;

import java.util.ArrayList;
/**
 *
 * @author Ben Lehman
 *
 */
public class GameTimer implements Timer
{
	protected int round = 0;
	protected ArrayList<TimeObserver> theObservers = new ArrayList<TimeObserver>();
	/**
	 * Adds the specified observer to the list
	 */
	@Override
	public void addTimeObserver(TimeObserver observer)
	{
		theObservers.add(observer);

	}
	/**
	 * Removes the specified observer from the list
	 */
	@Override
	public void removeTimeObserver(TimeObserver observer)
	{
		theObservers.remove(observer);

	}

	/**
	 * Updates the round thus updating the time
	 * Then goes through the array and updates each observers round
	 */
	@Override
	public void timeChanged()
	{
		int x = 0;
		int size;

		round = round +1;
		size = theObservers.size();

		while(x< size)
		{
			theObservers.get(x).updateTime(round);
			x++;
		}
	}

	/**
	 *
	 * @return the Observers Array List
	 */
	public ArrayList<TimeObserver> getTheObservers()
	{
		return theObservers;
	}

}
