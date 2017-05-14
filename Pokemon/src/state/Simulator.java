package state;
import battlehandler.trainer.firstPlayer;
import battlehandler.trainer.secondPlayer;
import battlehandler.trainer.trainer;
import gui.InvokerBuilder;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import move.MoveFactory;
import pokemon.Pokemon;
import species.fire.Charizard;
import species.fire.Charmander;
import species.fire.Charmeleon;
import species.fire.Eevee;
import species.fire.Flareon;
import species.fire.NineTails;
import species.fire.Vulpix;
import species.grass.Bulbasaur;
import species.grass.Gloom;
import species.grass.Ivysaur;
import species.grass.Oddish;
import species.grass.Venusaur;
import species.grass.Vileplume;
import species.water.Blastoise;
import species.water.Poliwag;
import species.water.Poliwhirl;
import species.water.Squirtle;
import species.water.Wartortle;

/**
 * Simulator.java -Initializer for the program. Constructs any necessary components to be used, sets stage properties, builds commands, Pokemon,
 * and trainers to be used as well as keeps track of the different root panes used in the different states.
 * @author Benjamin Hurston
 */
public class Simulator
{
	protected BorderPane currentState;
	protected BorderPane introPane;
	protected BorderPane creditsPane;
	protected BorderPane selectionPane;
	protected BorderPane quitPane;
	protected BorderPane menuPane;
	protected BorderPane battlePane;
	protected AI display;
	protected trainer trainer1;
	protected trainer trainer2;

	public Simulator(Stage stage)
	{
		new InvokerBuilder();
		trainer1 = firstPlayer.getFirstPlayerInstance();
		trainer2 = secondPlayer.getSecondPlayerInstance();
		generatePokemon(trainer1, 3);
		generatePokemon(trainer2, 3);
		display = new AI(stage);
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setTitle("Pokemon Battle Simulator");
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/resources/images/pokeballicon.png")));

	}

	/**
	 * Calls the AI to execute tasks determined by the state the program is in.
	 */
	public void update()
	{
		display.executeTasks();
	}

	/**
	 * Generate a random number
	 */
	private int ranNum(double d, double max)
	{
		return (int) (d + (int)(Math.random() * ((max - 0) + 1)));
	}

	/**
	 * Generate Pokemon for a trainer
	 * @param trainer1	the trainer to receive the Pokemon
	 * @param i	the amount of unique Pokemon to get
	 */
	private void generatePokemon(trainer trainer1, int i)
	{
		Pokemon charmander = new Charmander();
		MoveFactory makeMoves = new MoveFactory();
		makeMoves.createMoveList(charmander);
		Pokemon charmeleon = new Charmeleon();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(charmeleon);
		Pokemon charizard = new Charizard();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(charizard);
		Pokemon bulbasaur = new Bulbasaur();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(bulbasaur);
		Pokemon ivysaur = new Ivysaur();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(ivysaur);
		Pokemon venusaur = new Venusaur();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(venusaur);
		Pokemon squirtle = new Squirtle();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(squirtle);
		Pokemon wartortle = new Wartortle();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(wartortle);
		Pokemon blastoise = new Blastoise();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(blastoise);
		Pokemon eevee = new Eevee();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(eevee);
		Pokemon flareon = new Flareon();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(flareon);
		Pokemon ninetails = new NineTails();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(ninetails);
		Pokemon vulpix = new Vulpix();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(vulpix);
		Pokemon poliwag = new Poliwag();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(poliwag);
		Pokemon poliwhirl = new Poliwhirl();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(poliwhirl);
		Pokemon oddish = new Oddish();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(oddish);
		Pokemon gloom = new Gloom();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(gloom);
		Pokemon vileplume = new Vileplume();
		makeMoves = new MoveFactory();
		makeMoves.createMoveList(vileplume);

		Pokemon[] pokemon = new Pokemon[18];
		pokemon[0] = charmander;
		pokemon[1] = charmeleon;
		pokemon[2] = charizard;
		pokemon[3] = squirtle;
		pokemon[4] = wartortle;
		pokemon[5] = blastoise;
		pokemon[6] = bulbasaur;
		pokemon[7] = ivysaur;
		pokemon[8] = venusaur;
		pokemon[9] = eevee;
		pokemon[10] = flareon;
		pokemon[11] = ninetails;
		pokemon[12] = vulpix;
		pokemon[13] = poliwag;
		pokemon[14] = poliwhirl;
		pokemon[15] = oddish;
		pokemon[16] = gloom;
		pokemon[17] = vileplume;
		int dexId = ranNum(0, 17);
		int k;
		for(k=0;k<i;k++)
		{
			while(trainer1.findInPokemonList(pokemon[dexId]) == true)
			{
				dexId = ranNum(0, 17);
			}
			trainer1.addPokemon(pokemon[dexId]);
		}
	}
}
