package state;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import animation.Fade;
import animation.Scale;
import animation.Translation;
import battlehandler.trainer.firstPlayer;
import battlehandler.trainer.secondPlayer;
import battlehandler.trainer.trainer;
import gui.Invoker;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pokemon.Pokemon;

/**
 * Battle.java - The class holding the execution information for when the ai is in the battle state. Specifically, this class controls and updates
 * what the user sees when battling Pokemon as well as allowing them to interact with the interface to control the progression of the game.
 * @author Benjamin Hurston
 */
public class Battle extends GUIState
{
	private ImageView trainerBack = new ImageView();
	private ImageView pokemonFront = new ImageView();
	private ImageView pokemonBack =  new ImageView();
	private ImageView pokeballBack =  new ImageView();

	private Pokemon player1Active, player2Active;

	private trainer trainer1, trainer2;
	private  trainer activePlayer, inactivePlayer;

	private String effectiveness = "";

	private Text info, poke1info, poke2info;

	private Button
		move1, move2, move3, move4,
		poke1, poke2, cancel,
		runButton, itemsButton, switchButton, fightButton;

	StackPane stack;

	GridPane moves = new GridPane();
	GridPane switchPokemon = new GridPane();
	GridPane grid = new GridPane();

	Rectangle poke2Hp = new Rectangle();
	Rectangle poke1Hp = new Rectangle();
	Rectangle poke2HpBack = new Rectangle();
	Rectangle poke1HpBack = new Rectangle();

	Circle c;

	Scene menuScene;

	Boolean stopTimeLine = false;

	float lastScale1 = 1.0f;
	float lastScale2 = 1.0f;


	/**
	 * Battle scene constructor, state pattern.
	 */
	public Battle(AI ai)
	{
		super(ai);
	}

	/**
	 * Execute when the ai's state is the battle state. Execute handles some inital setup before calling
	 * handleScene which deals with scene updating and interaction.
	 */
	public void execute()
	{
		trainer1 = firstPlayer.getFirstPlayerInstance();
		trainer2 = secondPlayer.getSecondPlayerInstance();
		activePlayer = trainer1;
		trainer1.setActive(true);
		inactivePlayer = trainer2;
		trainer2.setActive(false);
		currentPane = new BorderPane();
		currentPane.getStylesheets().addAll(GUIState.class.getResource("/gui/application.css").toExternalForm());
		ai.setCurrentState(ai.getBattleState());
        styleContent();
		handleScene();
	}

	/**
	 * Handles interactions with and updates of the scene.
	 */
	public void handleScene()
	{
		//Event handler when the cancel button in the switch menu is pressed.
		cancel.addEventFilter(
		        MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	overlayPlay("/resources/sound/selectoption.wav");
		            	stack.getChildren().remove(switchPokemon);
		            	stack.getChildren().add(grid);
		            	info.setText("What will " + activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " do?");
		            }
		        });

		//Event handler when the switch pokemon button is pressed.
		switchButton.addEventFilter(
		        MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	overlayPlay("/resources/sound/selectoption.wav");
		            	stack.getChildren().remove(moves);

		        		switchPokemon.setPrefWidth(250);
		        		switchPokemon.setPrefHeight(25);

		        		switchPokemon.setTranslateX(125);
		        		switchPokemon.translateXProperty();
		        		switchPokemon.setTranslateY(675);
		        		switchPokemon.translateYProperty();

		        		poke1.setText(activePlayer.getPokemon(1).getName() + "(" + activePlayer.getPokemon(1).getHealth() + "/" + activePlayer.getPokemon(1).getMaxHealth() + ")");
		        		poke2.setText(activePlayer.getPokemon(2).getName() + "(" + activePlayer.getPokemon(2).getHealth() + "/" + activePlayer.getPokemon(2).getMaxHealth() + ")");
		        		poke1.setId("battlebuttons");
		        		poke1.setMinWidth(moves.getPrefWidth());
		        		poke1.setMinHeight(moves.getPrefHeight());
		        		poke2.setId("battlebuttons");
		        		poke2.setMinWidth(moves.getPrefWidth());
		        		poke2.setMinHeight(moves.getPrefHeight());
		        		cancel.setId("battlebuttons");
		        		cancel.setMinWidth(moves.getPrefWidth());
		        		cancel.setMinHeight(moves.getPrefHeight());

		            	stack.getChildren().remove(grid);
		            	stack.getChildren().add(switchPokemon);

		            	info.setText("Which Pokemon would you like to use?");
		            	//A button with the specified text caption.
		            }
		        });

		//Translate animation objects
		Translation trainerBackTranslate = new Translation(trainerBack, 'X', -300, 2000.0f, 1, false);
		Translation pokemonBackTranslate = new Translation(pokemonBack, 'X', -300, 0000.0f, 1, false);
		Translation pokemonFrontTranslate = new Translation(pokemonFront, 'X', -300, 0000.0f, 1, false);
		Translation pokeballBackTranslateX = new Translation(pokeballBack, 'X', -260, 1000.0f, 1, false);
		Translation pokeballBackTranslateY = new Translation(pokeballBack, 'Y', -10, 1000.0f, 1, false);

		//Fade animation objects
		Fade fadeable = new Fade(currentPane, 0.0f, 1.0f, 3000.0f, 1, true);
		Fade dialogueBox = new Fade(c, 0.0f, 0.5f, 5000.0f, 1, false);
		Fade dialogue = new Fade(info, 0.0f, 1.0f, 5000.0f, 1, false);
		Fade buttonGrid = new Fade(grid, 0.0f, 1.0f, 5000.0f, 1, false);
		Fade poke1hpfx = new Fade(poke1Hp, 0.0f, 1.0f, 5000.0f, 1, false);
		Fade poke2hpfx = new Fade(poke2Hp, 0.0f, 1.0f, 5000.0f, 1, false);
		Fade poke1infofx = new Fade(poke1info, 0.0f, 1.0f, 5000.0f, 1, false);
		Fade poke2infofx = new Fade(poke2info, 0.0f, 1.0f, 5000.0f, 1, false);

		fadeable.fadeIn();

		//TimeLine to handle the initial scene setup--trainer throwing pokeball, etc.
		Timeline battleIntro = new Timeline(
				new KeyFrame(Duration.ZERO, event -> currentPane.setCenter(stack)),
				new KeyFrame(Duration.millis(2000), event -> trainerBackTranslate.translate()),
				new KeyFrame(Duration.millis(5000), event -> {trainerBack.setImage(new WritableImage(image.getPixelReader(), 105, 0, 100, 130));}),
				new KeyFrame(Duration.millis(5050), event -> {trainerBack.setImage(new WritableImage(image.getPixelReader(), 229, 0, 100, 130));}),
				new KeyFrame(Duration.millis(5050), event -> {trainerBack.setTranslateX(-315);
				trainerBack.translateXProperty();}),
				new KeyFrame(Duration.millis(7000), event -> {trainerBack.setImage(new WritableImage(image.getPixelReader(), 350, 0, 100, 130));}),
				new KeyFrame(Duration.millis(7050), event -> {trainerBack.setImage(new WritableImage(image.getPixelReader(), 540, 0, 100, 130));}),

				//Pokeball throw sequence, trainer back
				new KeyFrame(Duration.millis(7055), event -> { image = new Image("/resources/sprites/pokeballthrow.png");
				pokeballBack.setImage(new WritableImage(image.getPixelReader(), 0, 0, 15, 25));
				pokeballBack.setTranslateX(-255);
				trainerBack.translateXProperty();
				try {
			        AudioInputStream inputStream = AudioSystem
			                .getAudioInputStream(getClass().getResource("/resources/sound/throwpokeball.wav"));
			        Clip audio = AudioSystem.getClip();
			        audio.open(inputStream);
			        FloatControl gainControl = (FloatControl) audio.getControl(FloatControl.Type.MASTER_GAIN);
			        gainControl.setValue(-20.0f);
			        audio.start();
			    } catch (Exception e) {
			        stopPlay();
			        System.err.println(e.getMessage());
			    };}),
				new KeyFrame(Duration.millis(7070), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 16, 0, 15, 25));
				pokeballBackTranslateX.setShift(-250);
				pokeballBackTranslateX.translate();
				pokeballBackTranslateY.setShift(-50);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(7170), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 32, 0, 15, 25));
				pokeballBackTranslateX.setShift(-245);
				pokeballBackTranslateX.translate();
				pokeballBackTranslateY.setShift(-20);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(7270), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 48, 0, 15, 25));
				pokeballBackTranslateX.setShift(-240);
				pokeballBackTranslateX.translate();
				pokeballBackTranslateY.setShift(0);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(7370), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 64, 0, 15, 25));
				pokeballBackTranslateX.setShift(-235);
				pokeballBackTranslateX.translate();
				pokeballBackTranslateY.setShift(20);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(7470), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 80, 0, 15, 25));
				pokeballBackTranslateX.setShift(-230);
				pokeballBackTranslateX.translate();
				pokeballBackTranslateY.setShift(40);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(7570), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 96, 0, 15, 25));
				pokeballBackTranslateX.setShift(-225);
				pokeballBackTranslateX.translate();
				pokeballBackTranslateY.setShift(60);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(7670), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 112, 0, 15, 25));
				pokeballBackTranslateX.setShift(-220);
				pokeballBackTranslateX.translate();
				pokeballBackTranslateY.setShift(80);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(7770), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 127, 0, 17, 25));
				pokeballBackTranslateX.setShift(-215);
				pokeballBackTranslateX.translate();
				pokeballBackTranslateY.setShift(100);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(7870), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 145, 0, 15, 25));
				pokeballBackTranslateY.setShift(120);
				pokeballBackTranslateY.translate();}),
				new KeyFrame(Duration.millis(8570), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 145, 0, 15, 25));
				pokeballBackTranslateY.setShift(100);
				pokeballBackTranslateY.translate();
				overlayPlay("/resources/sound/pokeballopen.wav");
				menuScene.setFill(Color.WHITE);
				fadeable.fadeIn();}),
				new KeyFrame(Duration.millis(9070), event -> {pokeballBack.setImage(new WritableImage(image.getPixelReader(), 112, 0, 15, 25));}),
				new KeyFrame(Duration.millis(8770), event -> {stack.getChildren().add(pokemonBack);}),
				new KeyFrame(Duration.millis(9170), event -> {stack.getChildren().remove(pokeballBack);}),
				//End back trainer pokeball sequence

				new KeyFrame(Duration.millis(7000), event -> pokemonBackTranslate.translate()),
				new KeyFrame(Duration.millis(7000), event -> pokemonFrontTranslate.translate()),
				new KeyFrame(Duration.millis(7200), event -> {trainerBackTranslate.setShift(-625.0f);
				trainerBackTranslate.translate();}),
				new KeyFrame(Duration.millis(11000), event -> {dialogue.fadeIn();
				dialogueBox.fadeIn();
				buttonGrid.fadeIn();
				poke1infofx.fadeIn();
				poke2infofx.fadeIn();
				poke1hpfx.fadeIn();
				poke2hpfx.fadeIn();}),
				new KeyFrame(Duration.millis(12000), event -> {stack.getChildren().add(c);
				stack.getChildren().add(info);
				stack.getChildren().add(grid);
				stack.getChildren().add(poke1info);
				stack.getChildren().add(poke2info);
				stack.getChildren().add(poke1HpBack);
				stack.getChildren().add(poke2HpBack);
				stack.getChildren().add(poke1Hp);
				stack.getChildren().add(poke2Hp);})
				);

		battleIntro.setCycleCount(1);
		battleIntro.play();

		//Event handler when the fightButton is pressed, display all available moves along with their Power Points for the current active Pokemon.
		fightButton.addEventFilter(
		        MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	overlayPlay("/resources/sound/selectoption.wav");
		        		moves.setPrefWidth(250);
		        		moves.setPrefHeight(25);
		        		moves.setTranslateX(10);
		        		moves.translateXProperty();
		        		moves.setTranslateY(675);
		        		moves.translateYProperty();

		            	stack.getChildren().remove(grid);
		            	stack.getChildren().add(moves);

		        		move1 = new Button(activePlayer.getPokemon(0).getMoveList().get(0).getName() + "(" + activePlayer.getPokemon(0).getMoveList().get(0).getCurrentPP() + "/" + activePlayer.getPokemon(0).getMoveList().get(0).getPP() + ")");
		        		move2 = new Button(activePlayer.getPokemon(0).getMoveList().get(1).getName() + "(" + activePlayer.getPokemon(0).getMoveList().get(1).getCurrentPP() + "/" + activePlayer.getPokemon(0).getMoveList().get(1).getPP() + ")");
		        		move3 = new Button(activePlayer.getPokemon(0).getMoveList().get(2).getName() + "(" + activePlayer.getPokemon(0).getMoveList().get(2).getCurrentPP() + "/" + activePlayer.getPokemon(0).getMoveList().get(2).getPP() + ")");
		        		move4 = new Button(activePlayer.getPokemon(0).getMoveList().get(3).getName() + "(" + activePlayer.getPokemon(0).getMoveList().get(3).getCurrentPP() + "/" + activePlayer.getPokemon(0).getMoveList().get(3).getPP() + ")");

		            	move1.setId("battlebuttons");
		            	move2.setId("battlebuttons");
		            	move3.setId("battlebuttons");
		            	move4.setId("battlebuttons");

		            	move1.setMinWidth(moves.getPrefWidth());
		            	move2.setMinWidth(moves.getPrefWidth());
		            	move3.setMinWidth(moves.getPrefWidth());
		            	move4.setMinWidth(moves.getPrefWidth());

		            	move1.setMinHeight(moves.getPrefHeight());
		            	move2.setMinHeight(moves.getPrefHeight());
		            	move3.setMinHeight(moves.getPrefHeight());
		            	move4.setMinHeight(moves.getPrefHeight());

		        		moves.add(move1, 0, 0);
		        		moves.add(move2, 1, 0);
		        		moves.add(move3, 2, 0);
		        		moves.add(move4, 3, 0);

		        		//Event handler when the first move is selected.
		                move1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
		                {
		        			public void handle(final MouseEvent mouseEvent)
		        			{
		        				Invoker.pushButton(0);
		        		    	stack.getChildren().remove(moves);
		        				moveSetup(0);
		        			}
		                });

		                //Event handler when the second move is selected.
		                move2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
		                {
		        			public void handle(final MouseEvent mouseEvent)
		        			{
		        				Invoker.pushButton(1);
		        		    	stack.getChildren().remove(moves);
		        				moveSetup(1);
		        			}
		                });

		                //Event handler when the third move is selected.
		                move3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
		                {
		        			public void handle(final MouseEvent mouseEvent)
		        			{
		        				Invoker.pushButton(2);
		        		    	stack.getChildren().remove(moves);
		        				moveSetup(2);
		        			}
		                });

		                //Event handler when the fourth move is selected.
		                move4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
		                {
		        			public void handle(final MouseEvent mouseEvent)
		        			{
		        				Invoker.pushButton(3);
		        		    	stack.getChildren().remove(moves);
		        				moveSetup(3);
		        			}
		                });
		            }
		        });

		//Event handler when the run button is selected.
		runButton.addEventFilter(
		        MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	overlayPlay("/resources/sound/selectoption.wav");
		            	Timeline noRun = new Timeline(
		        				new KeyFrame(Duration.ZERO, event -> info.setText("There is no running from a trainer battle!")),
		        				new KeyFrame(Duration.millis(3000), event -> info.setText("What will " + activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " do?"))
		        				);
		            	noRun.play();
		            }
		        });

		//Event handler when the items button is selected.
		itemsButton.addEventFilter(
		        MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	overlayPlay("/resources/sound/selectoption.wav");
		            	Timeline noItems = new Timeline(
		        				new KeyFrame(Duration.ZERO, event -> info.setText("You have no items!")),
		        				new KeyFrame(Duration.millis(3000), event -> info.setText("What will " + activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " do?"))
		        				);

		            	noItems.play();

		            }
		        });
	}

	/**
	 * Refresh the shared ImageView with the new filepath.
	 * @param filePath the filepath to the image requested.
	 */
	public void updateImage(String filePath)
	{
		image = new Image(filePath);
		view.setImage(image);
	}

	/**
	 * Verify that health bars are dynamically updating both Pokemon's HP bar through the use of scaling and translations animation classes.
	 * updateHealth is also responsible for updating the color of each Pokemon's HP bar based on their health percentage and changing
	 * the displayed text above healthbars when a Pokemon changes.
	 */
	public void updateHealth()
	{
		poke1info.setText(trainer1.getPokemon(0).getName() +  "(" + trainer1.getName() + ") " + "LV. 50");
		poke2info.setText(trainer2.getPokemon(0).getName() +  "(" + trainer2.getName() + ") " + "LV. 50");

		if(inactivePlayer == trainer1)
		{
			Scale healthDecrease1 = new Scale(poke1Hp, 'X', 1000, 1.0f, lastScale1, (trainer1.getPokemon(0).getHealth()/(float) trainer1.getPokemon(0).getMaxHealth()));
			healthDecrease1.scale();
			lastScale1 = (trainer1.getPokemon(0).getHealth()/(float) trainer1.getPokemon(0).getMaxHealth());
			Translation healthFix = new Translation(poke1Hp, 'x', (float) (-325 - (300 - (300.0 * (trainer1.getPokemon(0).getHealth()/(double) trainer1.getPokemon(0).getMaxHealth())))/2), 1000, 1, false);
			healthFix.translate();
			if(trainer1.getPokemon(0).getHealth() > trainer1.getPokemon(0).getMaxHealth() * .75)	poke1Hp.setFill(Color.GREEN);
			else if(trainer1.getPokemon(0).getHealth() > trainer1.getPokemon(0).getMaxHealth() * .33)	poke1Hp.setFill(Color.YELLOW);
			else	poke1Hp.setFill(Color.RED);
		}
		else if(inactivePlayer == trainer2)
		{

			Scale healthDecrease2 = new Scale(poke2Hp, 'X', 1000, 1.0f, lastScale2, (trainer2.getPokemon(0).getHealth()/(float) trainer2.getPokemon(0).getMaxHealth()));
			healthDecrease2.scale();
			lastScale2 = (trainer2.getPokemon(0).getHealth()/(float) trainer2.getPokemon(0).getMaxHealth());
			Translation healthFix = new Translation(poke2Hp, 'x', (float) (325 - (300 - (300.0 * (trainer2.getPokemon(0).getHealth()/(double) trainer2.getPokemon(0).getMaxHealth())))/2), 1000, 1, false);
			healthFix.translate();
			if(trainer2.getPokemon(0).getHealth() > trainer2.getPokemon(0).getMaxHealth() * .75)	poke2Hp.setFill(Color.GREEN);
			else if(trainer2.getPokemon(0).getHealth() > trainer2.getPokemon(0).getMaxHealth() * .33)	poke2Hp.setFill(Color.YELLOW);
			else	poke2Hp.setFill(Color.RED);
		}

		if(activePlayer == trainer1)
		{
			Scale healthDecrease1 = new Scale(poke1Hp, 'X', 1000, 1.0f, lastScale1, (trainer1.getPokemon(0).getHealth()/(float) trainer1.getPokemon(0).getMaxHealth()));
			healthDecrease1.scale();
			lastScale1 = (trainer1.getPokemon(0).getHealth()/(float) trainer1.getPokemon(0).getMaxHealth());
			Translation healthFix = new Translation(poke1Hp, 'x', (float) (-325 - (300 - (300.0 * (trainer1.getPokemon(0).getHealth()/(double) trainer1.getPokemon(0).getMaxHealth())))/2), 1000, 1, false);
			healthFix.translate();
			if(trainer1.getPokemon(0).getHealth() > trainer1.getPokemon(0).getMaxHealth() * .75)	poke1Hp.setFill(Color.GREEN);
			else if(trainer1.getPokemon(0).getHealth() > trainer1.getPokemon(0).getMaxHealth() * .33)	poke1Hp.setFill(Color.YELLOW);
			else	poke1Hp.setFill(Color.RED);
		}
		else if(activePlayer == trainer2)
		{

			Scale healthDecrease2 = new Scale(poke2Hp, 'X', 1000, 1.0f, lastScale2, (trainer2.getPokemon(0).getHealth()/(float) trainer2.getPokemon(0).getMaxHealth()));
			healthDecrease2.scale();
			lastScale2 = (trainer2.getPokemon(0).getHealth()/(float) trainer2.getPokemon(0).getMaxHealth());
			Translation healthFix = new Translation(poke2Hp, 'x', (float) (325 - (300 - (300.0 * (trainer2.getPokemon(0).getHealth()/(double) trainer2.getPokemon(0).getMaxHealth())))/2), 1000, 1, false);
			healthFix.translate();
			if(trainer2.getPokemon(0).getHealth() > trainer2.getPokemon(0).getMaxHealth() * .75)	poke2Hp.setFill(Color.GREEN);
			else if(trainer2.getPokemon(0).getHealth() > trainer2.getPokemon(0).getMaxHealth() * .33)	poke2Hp.setFill(Color.YELLOW);
			else	poke2Hp.setFill(Color.RED);
		}
	}

	/**
	 * Play a sound effect and display a visual cue that a certain type of move has been used.
	 * @param user the Pokemon using the move.
	 */
	public void damageEffects(Pokemon user)
	{
		Fade typeEffect = new Fade(currentPane, 1.0f, 0.0f, 250.0f, 2, true);

		if(user.getType().contains("ire"))
		{
			overlayPlay("/resources/sound/firedamage.wav");
			menuScene.setFill(Color.RED);
		}
		else if(user.getType().contains("ater"))
		{
			overlayPlay("/resources/sound/waterdamage.wav");
			menuScene.setFill(Color.BLUE);
		}
		else if(user.getType().contains("rass"))
		{
			overlayPlay("/resources/sound/grassdamage.wav");
			menuScene.setFill(Color.GREEN);
		}
		else
		{
			overlayPlay("/resources/sound/damage.wav");
			menuScene.setFill(Color.BLACK);
		}
		typeEffect.fadeIn();
	}

	/**
	 * Get the current active trainer.
	 * @return the current active trainer.
	 */
	public trainer getActive()
	{
		return activePlayer;
	}

	/**
	 * Get the current inactive trainer.
	 * @return the current inactive trainer.
	 */
	public trainer getInactive()
	{
		return inactivePlayer;
	}

	/**
	 * Handles the internal change and display change of a switch being used.
	 * @param i the pokemon slot being switched.
	 * @param i the switch Button used in the display
	 */
	public void pokeSwitchSetup(int i, Button poke)
	{
	       //Handle first pokemon switch button
			poke.addEventFilter(
			        MouseEvent.MOUSE_PRESSED,
			        new EventHandler<MouseEvent>() {
			            public void handle(final MouseEvent mouseEvent)
			            {
			            	updateHealth();
			            	Fade fadeBack = new Fade(pokemonBack, 1.0f, 0.0f, 2000.0f, 1, true);
			            	Fade fadeFront = new Fade(pokemonFront, 1.0f, 0.0f, 2000.0f, 1, true);
			            	Fade flash = new Fade(currentPane, 0.0f, 1.0f, 3000.0f, 1, true);

			            	overlayPlay("/resources/sound/selectoption.wav");
			            	stack.getChildren().remove(switchPokemon);
			            	if(activePlayer.getPokemon(0).getHealth() > 0 && activePlayer.getPokemon(i).getHealth() > 0)
			            	{
			            		Timeline noRun = new Timeline(
				        				new KeyFrame(Duration.ZERO, event -> {info.setTranslateY(275);
				        				info.translateYProperty();
				        				info.setText(activePlayer.getPokemon(0).getName() + " return!");
				        				overlayPlay("/resources/sound/pokeballreturn.wav");
					        			if(activePlayer == trainer1)	fadeBack.fadeIn();
					        			if(activePlayer == trainer2)	fadeFront.fadeIn();
				        				}),

				        				new KeyFrame(Duration.millis(3000), event -> {info.setTranslateY(275);
				        				info.translateYProperty();
				        				info.setText(activePlayer.getPokemon(0).getName() + " return!");
					        			if(activePlayer == trainer1)	stack.getChildren().remove(pokemonBack);
					        			if(activePlayer == trainer2)	stack.getChildren().remove(pokemonFront);
					        			activePlayer.switchPokemon(activePlayer.getPokemon(0), activePlayer.getPokemon(i));
					        			info.setText(activePlayer.getPokemon(0).getName() + ", go!");}),

				        				new KeyFrame(Duration.millis(5000), event -> {
				        				overlayPlay("/resources/sound/pokeballopen.wav");
				        				poke2Hp.setTranslateX(325 - (300 - (int) (300.0 * (trainer2.getPokemon(0).getHealth()/(double) trainer2.getPokemon(0).getMaxHealth())))/2);
				        				poke2Hp.translateXProperty();
				        				poke1Hp.setTranslateX(-325 - (300 - (int) (300.0 * (trainer1.getPokemon(0).getHealth()/(double) trainer1.getPokemon(0).getMaxHealth())))/2);
				        				poke1Hp.translateXProperty();
				        				menuScene.setFill(Color.WHITE);
				        				flash.fadeIn();
				        				}),
				        				new KeyFrame(Duration.millis(5100), event -> {
					        			if(activePlayer == trainer1)
					        			{
					        				player1Active = activePlayer.getPokemon(0);
					        				image = new Image(activePlayer.getPokemon(0).getSpritePathBack());
					        				pokemonBack.setImage(image);
					        				updateImages();
					        				stack.getChildren().add(2, pokemonBack);
					        				fadeBack.setDuration(1000);
					        				fadeBack.fadeOut();
					        				activePlayer = trainer2;
					        				trainer2.setActive(true);
					        				inactivePlayer = trainer1;
					        				trainer1.setActive(false);
					        				updateHealth();
					        			}
					        			else if(activePlayer == trainer2)
					        			{
					        				player2Active = activePlayer.getPokemon(0);
					        				image = new Image(activePlayer.getPokemon(0).getSpritePathFront());
					        				pokemonFront.setImage(image);
					        				updateImages();
					        				stack.getChildren().add(2, pokemonFront);
					        				fadeFront.setDuration(1000);
					        				fadeFront.fadeOut();
					        				activePlayer = trainer1;
					        				trainer1.setActive(true);
					        				inactivePlayer = trainer2;
					        				trainer2.setActive(false);
					        				updateHealth();
					        			}
					        			stack.getChildren().add(grid);
					        			info.setText("What will " + activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " do?");
		    		        			info.setTranslateY(250);
		    		        			info.translateYProperty();
				        				})
		        				);
				            	noRun.play();
			            	}
			            	//if the current Pokemon is fainted and the selection is able to fight
			            	else if(activePlayer.getPokemon(0).getHealth() <= 0 && activePlayer.getPokemon(i).getHealth() > 0)
			            	{
			            		Timeline noRun = new Timeline(
				        				new KeyFrame(Duration.ZERO, event -> {
				        				}),

				        				new KeyFrame(Duration.millis(2000), event -> {
					        			activePlayer.switchPokemon(activePlayer.getPokemon(0), activePlayer.getPokemon(i));
					        			info.setText(activePlayer.getPokemon(0).getName() + ", go!");
			    		        		info.setTranslateY(275);
			    		        		info.translateYProperty();}),

				        				new KeyFrame(Duration.millis(4000), event -> {
						        		info.setText("What will " + activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " do?");
			    		        		info.setTranslateY(250);
			    		        		info.translateYProperty();
				        				overlayPlay("/resources/sound/pokeballopen.wav");
				        				poke2Hp.setTranslateX(325 - (300 - (int) (300.0 * (trainer2.getPokemon(0).getHealth()/(double) trainer2.getPokemon(0).getMaxHealth())))/2);
				        				poke2Hp.translateXProperty();
				        				poke1Hp.setTranslateX(-325 - (300 - (int) (300.0 * (trainer1.getPokemon(0).getHealth()/(double) trainer1.getPokemon(0).getMaxHealth())))/2);
				        				poke1Hp.translateXProperty();
				        				menuScene.setFill(Color.WHITE);
				        				flash.fadeIn();
				        				if(activePlayer == trainer1)
					        			{
				        					stack.getChildren().remove(pokemonBack);
					        				player1Active = activePlayer.getPokemon(0);
					        				image = new Image(activePlayer.getPokemon(0).getSpritePathBack());
					        				pokemonBack.setImage(image);
					        				updateImages();
					        				stack.getChildren().add(2, pokemonBack);
					        				fadeBack.setDuration(1000);
					        				fadeBack.fadeOut();
					        				updateHealth();
					        			}
					        			else if(activePlayer == trainer2)
					        			{
					        				stack.getChildren().remove(pokemonFront);
					        				player2Active = activePlayer.getPokemon(0);
					        				image = new Image(activePlayer.getPokemon(0).getSpritePathFront());
					        				pokemonFront.setImage(image);
					        				updateImages();
					        				stack.getChildren().add(2, pokemonFront);
					        				fadeFront.setDuration(1000);
					        				fadeFront.fadeOut();
					        				updateHealth();
					        			}
				        				switchPokemon.getChildren().add(cancel);
				        				setupSwitch();
				        				stack.getChildren().add(grid);
				        				})
		        				);
				            	noRun.play();
			            	}
			            	//if the Pokemon is unable to fight
			            	else
			            	{
			            		Timeline noRun = new Timeline(
				        				new KeyFrame(Duration.ZERO, event -> {
					        			info.setText("That Pokemon is unable to fight!");
			    		        		info.setTranslateY(275);
			    		        		info.translateYProperty();}),
				        				new KeyFrame(Duration.millis(2000), event -> {
					        			info.setText("Which Pokemon would you like to use?");
			    		        		info.setTranslateY(250);
			    		        		info.translateYProperty();
			    		        		stack.getChildren().add(switchPokemon);
				        				})
		        				);
				            	noRun.play();
			            	}

			            }
			        });
	}

	/**
	 * Goes through the GUI checks and responsibilities of displaying the act of, and the result of a move being used.
	 * @param i the move slot being displayed.
	 */
	public void moveSetup(int i)
	{
		//Play a ping when the i'th move is selected.
		overlayPlay("/resources/sound/selectoption.wav");

		//Animation settings for front and back sprite fading.
		Fade fadeBack = new Fade(pokemonBack, 1.0f, 0.0f, 1000.0f, 1, false);
    	Fade fadeFront = new Fade(pokemonFront, 1.0f, 0.0f, 1000.0f, 1, false);

    	//The selected move must have Power Points left in order to use it.
    	if(activePlayer.getPokemon(0).getMoveList().get(i).getCurrentPP() > 0)
    	{
    		Timeline noRun = new Timeline(
    				//Text update of the move used.
    				new KeyFrame(Duration.ZERO, event ->
    				{
    					info.setTranslateY(275);
    					info.translateYProperty();
    					info.setText(activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " used " + activePlayer.getPokemon(0).getMoveList().get(i).getName() + "!");
    				}),
    				//Visual effects of a move being used, health bar corrections, and text update for type effectiveness.
    				new KeyFrame(Duration.millis(1000), event ->
    				{
    					damageEffects(activePlayer.getPokemon(0));
    					updateHealth();
    					getEffectiveness(inactivePlayer.getPokemon(0), activePlayer.getPokemon(0));
    					if(effectiveness != "")	info.setText(effectiveness);
    				}),
    				//Text update when a Pokemon runs out of HP and faints. The Pokemon fades out using the Fade animation class. Give an audio cue.
    				new KeyFrame(Duration.millis(2000), event ->
    				{
    					if(inactivePlayer.getPokemon(0).getHealth() == 0)
    					{
    						info.setText(inactivePlayer.getName() + "'s " + inactivePlayer.getPokemon(0).getName() + " fainted!");
    						if(inactivePlayer == trainer1)	fadeBack.fadeIn();
    						if(inactivePlayer == trainer2)	fadeFront.fadeIn();
    						overlayPlay("/resources/sound/faint.wav");
    					}
    				}),
    				//Switch the active Trainer to rotate turns.
    				new KeyFrame(Duration.millis(2500), event ->
    				{
    					updateTrainers();
    				}),
    				//Determine the path the program takes depending on the new activePlayer's Pokemon's ability to still fight.
    				new KeyFrame(Duration.millis(3000), event ->
    				{
    					//If the Pokemon can still fight.
    					if(activePlayer.getPokemon(0).getHealth() > 0)
    					{
    						info.setText("What will " + activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " do?");
    						stack.getChildren().add(grid);
    						info.setTranslateY(250);
    						info.translateYProperty();
    					}
    					//If the Pokemon fainted. The user cannot cancel swapping from a dead Pokemon, they must choose. Adjust the switchPokemon grid to compensate for only 2 buttons. Prompt the user.
    					else
    					{
    						setupSwitch();
    						stack.getChildren().remove(grid);
    						switchPokemon.getChildren().remove(cancel);
			            	stack.getChildren().add(switchPokemon);
			            	switchPokemon.setTranslateX(250);
			            	switchPokemon.translateXProperty();
		            		info.setText("Which Pokemon would you like to use?");
    						info.setTranslateY(250);
    						info.translateYProperty();
		            		//Check if the current active player is defeated, all Pokemon have fainted. If so, stop the battle music, cue the ending music, stop game.
		            		if(activePlayer.getPokemon(0).getHealth() == 0 && activePlayer.getPokemon(1).getHealth() == 0 && activePlayer.getPokemon(2).getHealth() == 0)
		            		{
		            			ai.getMenuState().mainClip.stop();
		            			doPlay("/resources/sound/battlecomplete.wav");
		            			info.setText("Congratulations! " + inactivePlayer.getName() + " wins!");
		            			info.setTranslateY(275);
		            			info.translateYProperty();
		            			switchPokemon.getChildren().removeAll(poke1, poke2, cancel);
		            		}
    					}
    				})
    			);
        	noRun.play();
    	}
    	//If the move selected has no Power Points left, it cannot be used.
    	else
    	{
    		Timeline noRun = new Timeline(
    				new KeyFrame(Duration.ZERO, event ->
    				{
    					info.setText("Not enough Power Points to use that move!");
    				}),
    				new KeyFrame(Duration.millis(1000), event ->
    				{
    					info.setText("What will " + activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " do?");
    					stack.getChildren().add(grid);
        				info.setTranslateY(250);
        				info.translateYProperty();
    				})
    			);
        	noRun.play();
    	}
    }

	/**
	 * Verify the style attributes of the switchPokemon GridPane.
	 */
	public void setupSwitch()
	{
		switchPokemon.setPrefWidth(250);
		switchPokemon.setPrefHeight(25);
		switchPokemon.setTranslateX(125);
		switchPokemon.translateXProperty();
		switchPokemon.setTranslateY(675);
		switchPokemon.translateYProperty();

		poke1.setId("battlebuttons");
		poke1.setMinWidth(moves.getPrefWidth());
		poke1.setMinHeight(moves.getPrefHeight());
		poke2.setId("battlebuttons");
		poke2.setMinWidth(moves.getPrefWidth());
		poke2.setMinHeight(moves.getPrefHeight());

		cancel.setId("battlebuttons");
		cancel.setMinWidth(moves.getPrefWidth());
		cancel.setMinHeight(moves.getPrefHeight());

		poke1.setText(activePlayer.getPokemon(1).getName() + "(" + activePlayer.getPokemon(1).getHealth() + "/" + activePlayer.getPokemon(1).getMaxHealth() + ")");
		poke2.setText(activePlayer.getPokemon(2).getName() + "(" + activePlayer.getPokemon(2).getHealth() + "/" + activePlayer.getPokemon(2).getMaxHealth() + ")");
	}

	/**
	 * Rotate the active trainer.
	 */
	private void updateTrainers()
	{
		if(activePlayer == trainer1)
		{
			activePlayer = trainer2;
			trainer2.setActive(true);
			inactivePlayer = trainer1;
			trainer1.setActive(false);
		}
		else if(activePlayer == trainer2)
		{
			activePlayer = trainer1;
			trainer1.setActive(true);
			inactivePlayer = trainer2;
			trainer2.setActive(false);
		}
	}

	/**
	 * Sets a String value used in the GUI to determine whether to display type effectiveness or not when a move is used.
	 * @param target the Pokemon being attacked
	 * @param user the Pokemon who is the attacker
	 */
	private void getEffectiveness(Pokemon target, Pokemon user)
	{
		if((target.getType().contains("fire") || target.getType().contains("Fire")) && (user.getType().contains("water") || user.getType().contains("Water")))	effectiveness = "It's super effective!";
		else if((target.getType().contains("fire") || target.getType().contains("Fire")) && (user.getType().contains("grass") || user.getType().contains("Grass")))	effectiveness = "It's not very effective...";
		else if((target.getType().contains("fire") || target.getType().contains("Fire")) && (user.getType().contains("fire") || user.getType().contains("Fire")))	effectiveness = "It's not very effective...";
		else if((target.getType().contains("grass") || target.getType().contains("Grass")) && (user.getType().contains("water") || user.getType().contains("Water")))	effectiveness = "It's not very effective.";
		else if((target.getType().contains("grass") || target.getType().contains("Grass")) && (user.getType().contains("grass") || user.getType().contains("Grass")))	effectiveness = "It's not very effective...";
		else if((target.getType().contains("grass") || target.getType().contains("Grass")) && (user.getType().contains("fire") || user.getType().contains("Fire")))	effectiveness = "It's super effective!";
		else if((target.getType().contains("water") || target.getType().contains("Water")) && (user.getType().contains("water") || user.getType().contains("Water")))	effectiveness = "It's not very effective...";
		else if((target.getType().contains("water") || target.getType().contains("Water")) && (user.getType().contains("grass") || user.getType().contains("Grass")))	effectiveness = "It's super effective!";
		else if((target.getType().contains("water") || target.getType().contains("Water")) && (user.getType().contains("fire") || user.getType().contains("Fire")))	effectiveness = "It's not very effective...";
		else	effectiveness = "";
	}

	/**
	 * Fix scaling and translations of Sprites to make sure their size and perspective is correct.
	 */
	private void updateImages()
	{
		image = new Image(player2Active.getSpritePathFront());
		String pokeName2 = player2Active.getName();
		pokemonFront.setImage(image);
        switch (pokeName2) {
        case "Ivysaur":
			pokemonFront.setFitHeight(250.0);
			pokemonFront.setFitWidth(250.0);
	        pokemonFront.setTranslateY(-75);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Bulbasaur":
			pokemonFront.setFitHeight(250.0);
			pokemonFront.setFitWidth(250.0);
	        pokemonFront.setTranslateY(-75);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Venusaur":
			pokemonFront.setFitHeight(200.0);
			pokemonFront.setFitWidth(200.0);
	        pokemonFront.setTranslateY(-100);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Charmander":
			pokemonFront.setFitHeight(300.0);
			pokemonFront.setFitWidth(300.0);
	        pokemonFront.setTranslateY(-100);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Charmeleon":
			pokemonFront.setFitHeight(300.0);
			pokemonFront.setFitWidth(300.0);
	        pokemonFront.setTranslateY(-100);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Charizard":
			pokemonFront.setFitHeight(350.0);
			pokemonFront.setFitWidth(350.0);
	        pokemonFront.setTranslateY(-100);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Squirtle":
			pokemonFront.setFitHeight(250.0);
			pokemonFront.setFitWidth(250.0);
	        pokemonFront.setTranslateY(-75);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Wartortle":
			pokemonFront.setFitHeight(250.0);
			pokemonFront.setFitWidth(250.0);
	        pokemonFront.setTranslateY(-75);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Blastoise":
			pokemonFront.setFitHeight(325.0);
			pokemonFront.setFitWidth(325.0);
	        pokemonFront.setTranslateY(-100);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Eevee":
			pokemonFront.setFitHeight(250.0);
			pokemonFront.setFitWidth(250.0);
	        pokemonFront.setTranslateY(-75);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Flareon":
			pokemonFront.setFitHeight(250.0);
			pokemonFront.setFitWidth(250.0);
	        pokemonFront.setTranslateY(-75);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Poliwag":
			pokemonFront.setFitHeight(75.0);
			pokemonFront.setFitWidth(75.0);
	        pokemonFront.setTranslateY(-30);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "Poliwhirl":
			pokemonFront.setFitHeight(125.0);
			pokemonFront.setFitWidth(125.0);
	        pokemonFront.setTranslateY(-50);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
				break;
        case "Vulpix":
			pokemonFront.setFitHeight(100.0);
			pokemonFront.setFitWidth(100.0);
	        pokemonFront.setTranslateY(-50);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(290);
	        pokemonFront.translateXProperty();
                 break;
        case "NineTails":
			pokemonFront.setFitHeight(350.0);
			pokemonFront.setFitWidth(350.0);
	        pokemonFront.setTranslateY(-100);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(280);
	        pokemonFront.translateXProperty();
                 break;
        case "Oddish":
			pokemonFront.setFitHeight(100.0);
			pokemonFront.setFitWidth(100.0);
	        pokemonFront.setTranslateY(-50);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(280);
	        pokemonFront.translateXProperty();
				break;
        case "Gloom":
			pokemonFront.setFitHeight(100.0);
			pokemonFront.setFitWidth(100.0);
	        pokemonFront.setTranslateY(-50);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(280);
	        pokemonFront.translateXProperty();
				break;
        case "Vileplume":
			pokemonFront.setFitHeight(150.0);
			pokemonFront.setFitWidth(150.0);
	        pokemonFront.setTranslateY(-75);
	        pokemonFront.translateYProperty();
	        pokemonFront.setTranslateX(280);
	        pokemonFront.translateXProperty();
				break;
        default:
    		pokemonFront.setFitHeight(180.0);
    		pokemonFront.setFitWidth(180.0);
            pokemonFront.setTranslateY(0);
            pokemonFront.translateYProperty();
            pokemonFront.setTranslateX(-200);
            pokemonFront.translateXProperty();
                 break;
    }

		image = new Image(player1Active.getSpritePathBack());
		pokemonBack.setImage(image);
        String pokemonName1 = player1Active.getName();
        switch (pokemonName1) {
            case "Ivysaur":
            	pokemonBack.setFitHeight(180.0);
            	pokemonBack.setFitWidth(180.0);
            	pokemonBack.setTranslateY(150);
            	pokemonBack.translateYProperty();
            	pokemonBack.setTranslateX(-250);
            	pokemonBack.translateXProperty();
                     break;
            case "Bulbasaur":
        		pokemonBack.setFitHeight(180.0);
        		pokemonBack.setFitWidth(180.0);
        		pokemonBack.setTranslateY(150);
        		pokemonBack.translateYProperty();
        		pokemonBack.setTranslateX(-250);
        		pokemonBack.translateXProperty();
                     break;
            case "Venusaur":
    			pokemonBack.setFitHeight(300.0);
    			pokemonBack.setFitWidth(300.0);
    			pokemonBack.setTranslateY(150);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
                     break;
            case "Charmander":
    			pokemonBack.setFitHeight(180.0);
    			pokemonBack.setFitWidth(180.0);
    			pokemonBack.setTranslateY(150);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
                     break;
            case "Charmeleon":
    			pokemonBack.setFitHeight(250.0);
    			pokemonBack.setFitWidth(250.0);
    			pokemonBack.setTranslateY(150);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-275);
    			pokemonBack.translateXProperty();
                     break;
            case "Charizard":
            	pokemonBack.setFitHeight(500.0);
            	pokemonBack.setFitWidth(500.0);
            	pokemonBack.setTranslateY(50);
            	pokemonBack.translateYProperty();
            	pokemonBack.setTranslateX(-250);
            	pokemonBack.translateXProperty();
                     break;
            case "Squirtle":
        		pokemonBack.setFitHeight(150.0);
        		pokemonBack.setFitWidth(150.0);
        		pokemonBack.setTranslateY(175);
        		pokemonBack.translateYProperty();
        		pokemonBack.setTranslateX(-250);
        		pokemonBack.translateXProperty();
                     break;
            case "Wartortle":
    			pokemonBack.setFitHeight(200.0);
    			pokemonBack.setFitWidth(200.0);
    			pokemonBack.setTranslateY(150);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
                     break;
            case "Blastoise":
    			pokemonBack.setFitHeight(300.0);
    			pokemonBack.setFitWidth(300.0);
    			pokemonBack.setTranslateY(100);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
                     break;
            case "Eevee":
    			pokemonBack.setFitHeight(150.0);
    			pokemonBack.setFitWidth(150.0);
    			pokemonBack.setTranslateY(175);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
                     break;
            case "Flareon":
    			pokemonBack.setFitHeight(200.0);
    			pokemonBack.setFitWidth(200.0);
    			pokemonBack.setTranslateY(150);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
                     break;
            case "Poliwag":
    			pokemonBack.setFitHeight(100.0);
    			pokemonBack.setFitWidth(100.0);
    			pokemonBack.setTranslateY(200);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
                     break;
            case "Poliwhirl":
    			pokemonBack.setFitHeight(200.0);
    			pokemonBack.setFitWidth(200.0);
    			pokemonBack.setTranslateY(150);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
    				break;
            case "Vulpix":
    			pokemonBack.setFitHeight(150.0);
    			pokemonBack.setFitWidth(150.0);
    			pokemonBack.setTranslateY(175);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-250);
    			pokemonBack.translateXProperty();
                     break;
            case "NineTails":
    			pokemonBack.setFitHeight(250.0);
    			pokemonBack.setFitWidth(250.0);
    			pokemonBack.setTranslateY(125);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-260);
    			pokemonBack.translateXProperty();
                     break;
            case "Oddish":
    			pokemonBack.setFitHeight(100.0);
    			pokemonBack.setFitWidth(100.0);
    			pokemonBack.setTranslateY(175);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-275);
    			pokemonBack.translateXProperty();
    				break;
            case "Gloom":
    			pokemonBack.setFitHeight(180.0);
    			pokemonBack.setFitWidth(180.0);
    			pokemonBack.setTranslateY(150);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-275);
    			pokemonBack.translateXProperty();
    				break;
            case "Vileplume":
    			pokemonBack.setFitHeight(200.0);
    			pokemonBack.setFitWidth(200.0);
    			pokemonBack.setTranslateY(150);
    			pokemonBack.translateYProperty();
    			pokemonBack.setTranslateX(-275);
    			pokemonBack.translateXProperty();
    				break;
            default:
        		pokemonBack.setFitHeight(180.0);
        		pokemonBack.setFitWidth(180.0);
                pokemonBack.setTranslateY(0);
                pokemonBack.translateYProperty();
                pokemonBack.setTranslateX(-200);
                pokemonBack.translateXProperty();
                     break;
        }
	}

    private void styleContent()
    {
		menuScene = new Scene(currentPane, 1024, 768);
		menuScene.setFill(Color.BLACK);
		player1Active = trainer1.getPokemon(0);
		player2Active = trainer2.getPokemon(0);
        stack = new StackPane();

		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/pokemon.ttf"), 14);
		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Pokemon Hollow.ttf"), 14);
		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Pokemon Solid.ttf"), 14);
		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/texgyreadventor-regular.otf"), 14);

		filePath = "/resources/images/battlebase.png";
		image = new Image(filePath);
		view.setImage(image);
		view.setFitHeight(768.0);
		view.setFitWidth(1024.0);
        view.setSmooth(true);
        view.setCache(true);

		c = new Circle();
		c.setRadius(110);
		c.setOpacity(0.5);
		c.setTranslateY(300);
		c.translateYProperty();
		c.setScaleX(7.0);
		c.scaleXProperty();

    	image = new Image("/resources/images/trainermalefront.png");
		WritableImage croppedImage = new WritableImage(image.getPixelReader(), 0, 0, 100, 130);
		trainerBack.setImage(croppedImage);
		trainerBack.setFitHeight(400.0);
		trainerBack.setFitWidth(250.0);
		trainerBack.setSmooth(true);
		trainerBack.setCache(true);

		updateImages();
		pokemonBack.setSmooth(true);
		pokemonBack.setCache(true);

		stack.getChildren().add(view);
		stack.getChildren().add(pokemonFront);

		stack.getChildren().add(trainerBack);
		stack.getChildren().add(pokeballBack);

		pokeballBack.setFitHeight(50.0);
		pokeballBack.setFitWidth(30.0);
		pokeballBack.setSmooth(true);
		pokeballBack.setCache(true);

		//Fix initial component positions
        trainerBack.setTranslateY(160);
        trainerBack.translateYProperty();
        trainerBack.setTranslateX(-600);
        trainerBack.translateXProperty();

        poke1info = new Text(0, 0, trainer1.getPokemon(0).getName() +  "(" + trainer1.getName() + ") " + "LV. 50");
		poke1info.setId("pokebattleinfo");
		poke1info.setTranslateY(-370);
		poke1info.translateYProperty();
		poke1info.setTranslateX(-325);
		poke1info.translateYProperty();

		poke2info = new Text(0, 0, trainer2.getPokemon(0).getName() +  "(" + trainer2.getName() + ") " + "LV. 50");
		poke2info.setId("pokebattleinfo");
		poke2info.setTranslateY(-370);
		poke2info.translateYProperty();
		poke2info.setTranslateX(325);
		poke2info.translateYProperty();

		poke2Hp.setWidth(300.0 * (trainer2.getPokemon(0).getHealth()/(double) trainer2.getPokemon(0).getMaxHealth()));
		poke2Hp.setTranslateX(325 - (300 - (int) (300.0 * (trainer2.getPokemon(0).getHealth()/(double) trainer2.getPokemon(0).getMaxHealth())))/2);
		poke2Hp.translateXProperty();
		poke1Hp.setWidth(300.0 * (trainer1.getPokemon(0).getHealth()/(double) trainer1.getPokemon(0).getMaxHealth()));
		poke1Hp.setTranslateX(-325 - (300 - (int) (300.0 * (trainer1.getPokemon(0).getHealth()/(double) trainer1.getPokemon(0).getMaxHealth())))/2);
		poke1Hp.translateXProperty();

		poke1Hp.setHeight(30);
		poke1Hp.setOpacity(1.0);
		poke1Hp.setTranslateY(-340);
		poke1Hp.translateYProperty();
		poke1Hp.setTranslateX(-325);
		poke1Hp.translateXProperty();
		poke1Hp.setArcHeight(10);
		poke1Hp.setArcWidth(10);
		if(trainer1.getPokemon(0).getHealth() > trainer1.getPokemon(0).getMaxHealth() * .75)	poke1Hp.setFill(Color.GREEN);
		else if(trainer1.getPokemon(0).getHealth() > trainer1.getPokemon(0).getMaxHealth() * .33)	poke1Hp.setFill(Color.YELLOW);
		else	poke1Hp.setFill(Color.RED);

		poke2Hp.setWidth(300 * (trainer2.getPokemon(0).getHealth()/trainer2.getPokemon(0).getMaxHealth()));
		poke2Hp.setHeight(30);
		poke2Hp.setOpacity(1.0);
		poke2Hp.setTranslateY(-340);
		poke2Hp.translateYProperty();
		poke2Hp.setTranslateX(325);
		poke2Hp.translateXProperty();
		poke2Hp.setArcHeight(10);
		poke2Hp.setArcWidth(10);
		if(trainer2.getPokemon(0).getHealth() > trainer2.getPokemon(0).getMaxHealth() * .75)	poke2Hp.setFill(Color.GREEN);
		else if(trainer2.getPokemon(0).getHealth() > trainer2.getPokemon(0).getMaxHealth() * .33)	poke2Hp.setFill(Color.YELLOW);
		else	poke2Hp.setFill(Color.RED);


		poke2HpBack.setWidth(300.0);
		poke2HpBack.setTranslateX(325);
		poke2HpBack.translateXProperty();
		poke1HpBack.setWidth(300.0);
		poke1HpBack.setTranslateX(-325);
		poke1HpBack.translateXProperty();

		poke1HpBack.setHeight(30);
		poke1HpBack.setOpacity(0.5);
		poke1HpBack.setTranslateY(-340);
		poke1HpBack.translateYProperty();
		poke1HpBack.setTranslateX(-325);
		poke1HpBack.translateXProperty();
		poke1HpBack.setArcHeight(10);
		poke1HpBack.setArcWidth(10);
		poke1HpBack.setFill(Color.BLACK);
		poke1HpBack.setId("pokehealthbackbar");

		poke2HpBack.setWidth(300);
		poke2HpBack.setHeight(30);
		poke2HpBack.setOpacity(0.5);
		poke2HpBack.setTranslateY(-340);
		poke2HpBack.translateYProperty();
		poke2HpBack.setTranslateX(325);
		poke2HpBack.translateXProperty();
		poke2HpBack.setArcHeight(10);
		poke2HpBack.setArcWidth(10);
		poke2HpBack.setFill(Color.BLACK);
		poke2HpBack.setId("pokehealthbackbar");

		info = new Text(0, 0, "What will " + activePlayer.getName() + "'s " + activePlayer.getPokemon(0).getName() + " do?");
		info.setId("battledialogue");
		info.setTranslateY(250);
		info.translateYProperty();
		info.setTranslateX(0);
		info.translateYProperty();

		poke1 = new Button(activePlayer.getPokemon(1).getName() + "(" + activePlayer.getPokemon(1).getHealth() + "/" + activePlayer.getPokemon(1).getMaxHealth() + ")");
		poke2 = new Button(activePlayer.getPokemon(2).getName() + "(" + activePlayer.getPokemon(2).getHealth() + "/" + activePlayer.getPokemon(2).getMaxHealth() + ")");
		cancel = new Button("Cancel");
		switchPokemon.add(poke1, 0, 0);
		switchPokemon.add(poke2, 1, 0);
		switchPokemon.add(cancel, 2, 0);

		updateHealth();

		grid = new GridPane();
		grid.setPrefWidth(250);
		grid.setPrefHeight(25);

		grid.setTranslateX(10);
		grid.translateXProperty();
		grid.setTranslateY(675);
		grid.translateYProperty();

		//moves
		//A button with the specified text caption.
		moves.setPrefWidth(250);
		moves.setPrefHeight(25);

		moves.setTranslateX(10);
		moves.translateXProperty();
		moves.setTranslateY(675);
		moves.translateYProperty();

        image = new Image("/resources/images/trainermalefront.png");

      //A button with the specified text caption.
      	itemsButton = new Button("Items");
      	grid.add(itemsButton, 2, 0);
      	itemsButton.setId("battlebuttons");
      	itemsButton.setMinWidth(grid.getPrefWidth());
      	itemsButton.setMinHeight(grid.getPrefHeight());

      	//A button with the specified text caption.
      	runButton = new Button("Run");
      	grid.add(runButton, 3, 0);
      	runButton.setId("battlebuttons");
      	runButton.setMinWidth(grid.getPrefWidth());
      	runButton.setMinHeight(grid.getPrefHeight());

    	//Press to show moves
    	fightButton = new Button("Fight");
    	grid.add(fightButton, 0, 0);
    	fightButton.setId("battlebuttons");
    	fightButton.setMinWidth(grid.getPrefWidth());
    	fightButton.setMinHeight(grid.getPrefHeight());

    	//Press to show Pokemon which can be swapped to.
    	switchButton = new Button("Switch Pokemon");
    	grid.add(switchButton, 1, 0);
    	switchButton.setId("battlebuttons");
    	switchButton.setMinWidth(grid.getPrefWidth());
    	switchButton.setMinHeight(grid.getPrefHeight());

    	pokeSwitchSetup(1, poke1);
    	pokeSwitchSetup(2, poke2);
    	stage.setScene(menuScene);
    }
}
