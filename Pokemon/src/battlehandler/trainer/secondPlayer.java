package battlehandler.trainer;

public class secondPlayer extends trainer {
	private volatile static trainer secondTrainerInstance;
	/**
	 * initiates the second player to level one
	 * and initiares the name and
	 * @param name name of the trainer
	 * @param lifepoints the lifepoint of the second player
	 */
	public secondPlayer(String name)
	{
		super(name);
		level = 1;
	}
	/**
	 * only creates a new first player if there was no player put in place
	 * @param name the name of the first player
	 * @param npc ???
	 */
	public static trainer getSecondPlayerInstance(String name)
	{
		if(secondTrainerInstance == null)
		{
			synchronized(secondPlayer.class)
			{
				if(secondTrainerInstance == null)
				{
					secondTrainerInstance = new secondPlayer(name);
				}
			}
		}
		return secondTrainerInstance;

	}
	/**
	 * returns the first player
	 * @return
	 */
	public static trainer getSecondPlayerInstance()
	{
		if(secondTrainerInstance == null)
		{
			secondTrainerInstance = new secondPlayer("PlayerTwo");
		}
		return secondTrainerInstance;
	}


}
