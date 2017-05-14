package state;
import animation.Fade;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Intro.java -Initial state to be triggered at the start of the game. Executes an intro short to introduce the
 * group, display necessary copyright information, and play the intro clip.
 * @author Benjamin Hurston
 */
public class Intro extends GUIState
{
	public Intro(AI ai)
	{
		super(ai);
	}

	/**
	 * Ensure the introState is set, load the css for this root Pane.
	 */
	public void execute()
	{
		currentPane = new BorderPane();
		currentPane.getStylesheets().addAll(GUIState.class.getResource("/gui/application.css").toExternalForm());;
		ai.setCurrentState(ai.getIntroState());
		handleScene();
	}


	/**
	 * Display copyright info, show group number, play the Pokemon short.
	 */
	public void handleScene()
	{
		music = "/resources/sound/introscreen.wav";
		filePath = "/resources/images/charmander.gif";
		image = new Image(filePath);
		view.setImage(image);
		view.setFitHeight(768.0);
		view.setFitWidth(1024.0);
        view.setSmooth(true);
        view.setCache(true);
        StackPane stack = new StackPane();

		Fade fadeable = new Fade(stack, 0.0f, 1.0f, 5000.0f, 1, false);
		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/pokemon.ttf"), 14);
		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Pokemon Hollow.ttf"), 14);
		Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Pokemon Solid.ttf"), 14);
		Text text = new Text(0, 0, "Pokemon:\n\n c 2016 Pokemon, Nintendo");
		text.setId("introtext");

		fadeable.fadeIn();
		stack.getChildren().add(text);

		Timeline copyrightInfo = new Timeline(
				new KeyFrame(Duration.millis(2500), event -> doPlay(music)),
				new KeyFrame(Duration.millis(4000), event -> fadeable.fadeOut()),
				new KeyFrame(Duration.millis(8000), event ->  text.setText("Presented by group 6")),
				new KeyFrame(Duration.millis(8000), event ->  fadeable.fadeIn()),
				new KeyFrame(Duration.millis(12000), event ->  fadeable.fadeOut()),
				new KeyFrame(Duration.millis(16000), event -> stack.getChildren().remove(text)),
				new KeyFrame(Duration.millis(17000), event -> stack.getChildren().add(view)),
				new KeyFrame(Duration.millis(18000), event -> {fadeable.setDuration(1000.0f);
															   fadeable.fadeIn();}),
				new KeyFrame(Duration.millis(19000), event -> updateImage("/resources/images/charmeleon.gif")),
				new KeyFrame(Duration.millis(20500), event -> updateImage("/resources/images/charizard.gif")),
				new KeyFrame(Duration.millis(22000), event -> updateImage("/resources/images/squirtle.gif")),
				new KeyFrame(Duration.millis(23000), event -> updateImage("/resources/images/wartortle.gif")),
				new KeyFrame(Duration.millis(24500), event -> updateImage("/resources/images/blastoise.gif")),
				new KeyFrame(Duration.millis(26000), event -> updateImage("/resources/images/bulbasaur.gif")),
				new KeyFrame(Duration.millis(27500), event -> updateImage("/resources/images/ivysaur.gif")),
				new KeyFrame(Duration.millis(29000), event -> updateImage("/resources/images/venasaur.gif")),
				new KeyFrame(Duration.millis(30500), event -> {fadeable.fadeOut();
				 												ai.setCurrentState(ai.getMenuState());
				 												ai.executeTasks();})
				);
		copyrightInfo.setCycleCount(1);
		copyrightInfo.play();

		currentPane.setCenter(stack);
		Scene introScene = new Scene(currentPane, 1024, 768);
		introScene.setFill(Color.BLACK);
		stage.setScene(introScene);
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
