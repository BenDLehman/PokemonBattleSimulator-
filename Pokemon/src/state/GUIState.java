package state;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * GUIState.java -Provides skeleton for methods of implementations of the GUI state.
 * Provides some shared methods of the implementations to use, specifically sound handling.
 * @author Benjamin Hurston
 */
public abstract class GUIState
{
	protected Stage stage;
	protected AI ai;
	protected Clip clip;
	protected Clip mainClip;
	protected Clip overlayClip;
	protected String music;
	protected Image image;
	protected String filePath;
	protected ImageView view = new ImageView();
	protected StackPane stack = new StackPane();
	protected Scene scene;
	protected BorderPane currentPane;

	public GUIState(AI ai)
	{
		this.ai = ai;
		this.stage = ai.stage;
	}

	public void execute()
	{
	}

	public void handleScene()
	{
	}

	/**
	 * Sets a new soundfile to play in the clip line, this usage stops the previous clip in this line before it begins a new one.
	 * @param path the path to the soundfile
	 */
	public void doPlay(final String path)
	{
	    try {
	        stopPlay();
	        AudioInputStream inputStream = AudioSystem
	                .getAudioInputStream(getClass().getResource(path));
	        clip = AudioSystem.getClip();
	        clip.open(inputStream);
	        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(-30.0f);
	        clip.start();
	    } catch (Exception e) {
	        stopPlay();
	        System.err.println(e.getMessage());
	    }
	}

	/**
	 * Sets a new soundfile to play in the overlayClip line, this usage will not stop the previous line from continuing.
	 * @param path the path to the soundfile
	 */
	public void overlayPlay(final String path)
	{
	    try {
	        AudioInputStream inputStream = AudioSystem
	                .getAudioInputStream(getClass().getResource(path));
	        overlayClip = AudioSystem.getClip();
	        overlayClip.open(inputStream);
	        FloatControl gainControl = (FloatControl) overlayClip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(-30.0f);
	        overlayClip.start();
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	    }
	}

	/**
	 * Stops the current line playing.
	 */
	public void stopPlay()
	{
	    if (clip != null)
	    {
	        clip.stop();
	        clip.close();
	        clip.flush();
	    }
	}

	/**
	 * Play the main music to be used in the battle, stores it in a specific Clip so the line may later easily be closed.
	 */
	public void playMainMusic()
	{
		try {
	        stopPlay();
	        AudioInputStream inputStream = AudioSystem
	                .getAudioInputStream(getClass().getResource("/resources/sound/battle.wav"));
	        mainClip = AudioSystem.getClip();
	        mainClip.open(inputStream);
	        FloatControl gainControl = (FloatControl) mainClip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(-30.0f);
	        mainClip.start();
	    } catch (Exception e) {
	        stopPlay();
	        System.err.println(e.getMessage());
	    }
	}

	/**
	 * Cause the current line loaded in to fade out over six seconds--STARTING VOLUME VALUE SPECIFIC TO THIS PROGRAM
	 */
	public void soundFade()
	{
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		Timeline soundFade = new Timeline(
				new KeyFrame(Duration.millis(100), event -> gainControl.setValue(-31.0f)),
				new KeyFrame(Duration.millis(200), event -> gainControl.setValue(-32.0f)),
				new KeyFrame(Duration.millis(300), event -> gainControl.setValue(-33.0f)),
				new KeyFrame(Duration.millis(400), event -> gainControl.setValue(-34.0f)),
				new KeyFrame(Duration.millis(500), event -> gainControl.setValue(-35.0f)),
				new KeyFrame(Duration.millis(600), event -> gainControl.setValue(-36.0f)),
				new KeyFrame(Duration.millis(700), event -> gainControl.setValue(-37.0f)),
				new KeyFrame(Duration.millis(800), event -> gainControl.setValue(-38.0f)),
				new KeyFrame(Duration.millis(900), event -> gainControl.setValue(-39.0f)),
				new KeyFrame(Duration.millis(100), event -> gainControl.setValue(-40.0f)),
				new KeyFrame(Duration.millis(1100), event -> gainControl.setValue(-41.0f)),
				new KeyFrame(Duration.millis(1200), event -> gainControl.setValue(-42.0f)),
				new KeyFrame(Duration.millis(1300), event -> gainControl.setValue(-43.0f)),
				new KeyFrame(Duration.millis(1400), event -> gainControl.setValue(-44.0f)),
				new KeyFrame(Duration.millis(1500), event -> gainControl.setValue(-45.0f)),
				new KeyFrame(Duration.millis(1600), event -> gainControl.setValue(-46.0f)),
				new KeyFrame(Duration.millis(1700), event -> gainControl.setValue(-47.0f)),
				new KeyFrame(Duration.millis(1800), event -> gainControl.setValue(-48.0f)),
				new KeyFrame(Duration.millis(1900), event -> gainControl.setValue(-49.0f)),
				new KeyFrame(Duration.millis(2000), event -> gainControl.setValue(-50.0f)),
				new KeyFrame(Duration.millis(2100), event -> gainControl.setValue(-41.0f)),
				new KeyFrame(Duration.millis(2200), event -> gainControl.setValue(-42.0f)),
				new KeyFrame(Duration.millis(2300), event -> gainControl.setValue(-43.0f)),
				new KeyFrame(Duration.millis(2400), event -> gainControl.setValue(-44.0f)),
				new KeyFrame(Duration.millis(2500), event -> gainControl.setValue(-45.0f)),
				new KeyFrame(Duration.millis(2600), event -> gainControl.setValue(-46.0f)),
				new KeyFrame(Duration.millis(2700), event -> gainControl.setValue(-47.0f)),
				new KeyFrame(Duration.millis(2800), event -> gainControl.setValue(-48.0f)),
				new KeyFrame(Duration.millis(2900), event -> gainControl.setValue(-49.0f)),
				new KeyFrame(Duration.millis(3000), event -> gainControl.setValue(-50.0f)),
				new KeyFrame(Duration.millis(3100), event -> gainControl.setValue(-51.0f)),
				new KeyFrame(Duration.millis(3200), event -> gainControl.setValue(-52.0f)),
				new KeyFrame(Duration.millis(3300), event -> gainControl.setValue(-53.0f)),
				new KeyFrame(Duration.millis(3400), event -> gainControl.setValue(-54.0f)),
				new KeyFrame(Duration.millis(3500), event -> gainControl.setValue(-55.0f)),
				new KeyFrame(Duration.millis(3600), event -> gainControl.setValue(-56.0f)),
				new KeyFrame(Duration.millis(3700), event -> gainControl.setValue(-57.0f)),
				new KeyFrame(Duration.millis(3800), event -> gainControl.setValue(-58.0f)),
				new KeyFrame(Duration.millis(3900), event -> gainControl.setValue(-59.0f)),
				new KeyFrame(Duration.millis(4000), event -> gainControl.setValue(-60.0f)),
				new KeyFrame(Duration.millis(4100), event -> gainControl.setValue(-61.0f)),
				new KeyFrame(Duration.millis(4200), event -> gainControl.setValue(-62.0f)),
				new KeyFrame(Duration.millis(4300), event -> gainControl.setValue(-63.0f)),
				new KeyFrame(Duration.millis(4400), event -> gainControl.setValue(-64.0f)),
				new KeyFrame(Duration.millis(4500), event -> gainControl.setValue(-65.0f)),
				new KeyFrame(Duration.millis(4600), event -> gainControl.setValue(-66.0f)),
				new KeyFrame(Duration.millis(4700), event -> gainControl.setValue(-67.0f)),
				new KeyFrame(Duration.millis(4800), event -> gainControl.setValue(-68.0f)),
				new KeyFrame(Duration.millis(4900), event -> gainControl.setValue(-69.0f)),
				new KeyFrame(Duration.millis(5000), event -> gainControl.setValue(-70.0f)),
				new KeyFrame(Duration.millis(5100), event -> gainControl.setValue(-71.0f)),
				new KeyFrame(Duration.millis(5200), event -> gainControl.setValue(-72.0f)),
				new KeyFrame(Duration.millis(5300), event -> gainControl.setValue(-73.0f)),
				new KeyFrame(Duration.millis(5400), event -> gainControl.setValue(-74.0f)),
				new KeyFrame(Duration.millis(5500), event -> gainControl.setValue(-75.0f)),
				new KeyFrame(Duration.millis(5600), event -> gainControl.setValue(-76.0f)),
				new KeyFrame(Duration.millis(5700), event -> gainControl.setValue(-77.0f)),
				new KeyFrame(Duration.millis(5800), event -> gainControl.setValue(-78.0f)),
				new KeyFrame(Duration.millis(5900), event -> gainControl.setValue(-79.0f)),
				new KeyFrame(Duration.millis(6000), event -> gainControl.setValue(-80.0f))
				);
		soundFade.play();
	}
}
