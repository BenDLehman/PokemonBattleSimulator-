package battlehandler.trainer;

/**
 * The methods that a trainer must have inorder to considered a player
 * @author naheha
 *
 */
public class firstPlayer extends trainer {
	/**
	 * initiates the first player to level one
	 * and initiares the name and
	 * @param name name of the trainer
	 * @param lifepoints the lifepoint of the second player
	 */
	private volatile static trainer firstTrainerInstance;
	public firstPlayer(String name)
	{
		super(name);
		level = 1;
	}
	/**
	 * only creates a new first player if there was no player put in place
	 * @param name the name of the first player
	 * @param npc ???
	 */
	public static trainer getFirstPlayerInstance(String name)
	{
		if(firstTrainerInstance == null)
		{
			synchronized(firstPlayer.class)
			{
				if(firstTrainerInstance == null)
				{
					firstTrainerInstance = new firstPlayer(name);
				}
			}
		}
		return firstTrainerInstance;
	}

	/**
	 * returns true if the first player spot is filled
	 * @return
	 */
	public static trainer getFirstPlayerInstance()
	{
		if(firstTrainerInstance == null)
		{
			firstTrainerInstance = new firstPlayer("PlayerOne");
		}
		return firstTrainerInstance;
	}



}
