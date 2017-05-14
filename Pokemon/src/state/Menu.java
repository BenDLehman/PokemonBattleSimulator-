package state;

import animation.Fade;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Menu.java -State to be triggered at the end of the intro. Displays the name of the game and
 * allows user to choose to start the game or play the credits (unimplemented).
 * @author Benjamin Hurston
 */
public class Menu extends GUIState
{
	public Menu(AI ai)
	{
		super(ai);
	}

	/**
	 * Ensure the menuState is set, load the css for this root Pane.
	 */
	public void execute()
	{
		currentPane = new BorderPane();
		currentPane.getStylesheets().addAll(GUIState.class.getResource("/gui/application.css").toExternalForm());;
		ai.setCurrentState(ai.getMenuState());
		handleScene();
	}

	/**
	 * Handles the scene display and user interaction with any available buttons.
	 */
	public void handleScene()
	{
		music = "/resources/sound/menuscreen.wav";
		doPlay(music);
        StackPane stack = new StackPane();
		Fade fadeable = new Fade(currentPane, 0.0f, 1.0f, 5000.0f, 1, false);

		filePath = "/resources/images/titlebackground.png";
		image = new Image(filePath);
		view.setImage(image);
		view.setFitHeight(768.0);
		view.setFitWidth(1024.0);
        view.setSmooth(true);
        view.setCache(true);


		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/pokemon.ttf"), 14);
		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Pokemon Hollow.ttf"), 14);
		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Pokemon Solid.ttf"), 14);

		Text start = new Text(0, 0, "Start");
		start.setId("menustart");
		Text credits = new Text(0, 0, "Credits");
		credits.setId("menucredits");
		Text title = new Text(0, 0, "Battle Simulator");
		title.setId("menutitle");
		Text pokemon = new Text(0, 0, "Pokemon");
		pokemon.setId("menupokemon");

		start.addEventFilter(
		        MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	start.setId("starthover");
		            }
		        });
		start.addEventFilter(
		        MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	start.setId("menustart");
		            }
		        });
		start.addEventFilter(
		        MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	startBattle();
		            }
		        });

		credits.addEventFilter(
		        MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	credits.setId("creditshover");
		            }
		        });
		credits.addEventFilter(
		        MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            	credits.setId("menucredits");
		            }
		        });
		credits.addEventFilter(
		        MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent)
		            {
		            }
		        });

		stack.getChildren().add(view);
        GridPane grid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(80);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(20);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(80);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(20);
        grid.getColumnConstraints().addAll(column1, column2);
        grid.getRowConstraints().addAll(row1, row2);
        grid.setPadding(new Insets(0, 0, 0, 25));
	    HBox hbox = new HBox();
	    hbox.getChildren().addAll(pokemon, title);
        grid.add(start, 0, 1);
        grid.add(credits, 0, 1);
        credits.setTranslateX(750);
        credits.translateXProperty();
        start.setTranslateX(40);
        start.translateXProperty();
        stack.getChildren().add(grid);
        title.setTranslateY(-100);
        title.translateYProperty();
        stack.getChildren().add(title);

		Timeline fadeDelay = new Timeline(
				new KeyFrame(Duration.ZERO, event -> fadeable.fadeIn()),
				new KeyFrame(Duration.millis(500), event -> currentPane.setCenter(stack))
				);
		fadeDelay.setCycleCount(1);
		fadeDelay.play();

		Scene menuScene = new Scene(currentPane, 1024, 768);
		menuScene.setFill(Color.BLACK);
		stage.setScene(menuScene);
	}

	/**
	 * Stops the current sound files, sets up for the battle scene and starts the
	 * transition effect.
	 */
	public void startBattle()
	{
		stopPlay();
		Fade fadeable = new Fade(currentPane, 0.0f, 1.0f, 200.0f, 19, true);
		playMainMusic();
		fadeable.fadeIn();
    	Timeline musicFade = new Timeline(
				new KeyFrame(Duration.millis(3600), event -> {image = new Image("/resources/images/battlebase.png");
															  view.setImage(image);
															  ai.setCurrentState(ai.getBattleState());
            												  ai.executeTasks();})
				);
    	musicFade.setCycleCount(1);
    	musicFade.play();
	}

	/**
	 * Unimplemented
	 */
	public void startCredits()
	{
	}

	/**
	 * Refresh the imageview to display the specified image
	 * @param filePath the filepath to the image
	 */
	public void updateImage(String filePath)
	{
		image = new Image(filePath);
		view.setImage(image);
	}
}
