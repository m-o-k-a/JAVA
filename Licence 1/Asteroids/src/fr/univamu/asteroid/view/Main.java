package fr.univamu.asteroid.view;

import fr.univamu.asteroid.game.Space;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fr.univamu.asteroid.viewModel.ViewModel;

import java.net.URL;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public class Main extends Application {


  public final static int CANVAS_WIDTH = (int) Space.SPACE_WIDTH;
  public final static int CANVAS_HEIGHT = (int) Space.SPACE_HEIGHT;
  public final static int WINDOW_WIDTH = 1200;

  private AnimationTimer timer;
  private View view;

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader();
    URL fxmlLocation = getClass().getResource("window.fxml");
    fxmlLoader.setLocation(fxmlLocation);
    fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
    Parent root = fxmlLoader.load(fxmlLocation.openStream());
    primaryStage.setTitle("Asteroids");
    Scene scene = new Scene(root, WINDOW_WIDTH, CANVAS_HEIGHT);
    primaryStage.setScene(scene);
    view = fxmlLoader.getController();
    ViewModel viewModel = new ViewModel(new Space(),view);
    view.initialize(viewModel);
    view.setEventHandler(scene);
    timer = isInDebugMode() ? new StepByStepAnimationTimer(view,0.2)
                            : new RealTimeAnimationTimer(view);
    primaryStage.show();
    timer.start();

  }


  public static void main(String[] args) {
    launch(args);
  }


  public static boolean isInDebugMode() {
    // Hack: this will check if the Java Debug Wire Protocol agent is used.
    return java.lang.management.ManagementFactory.
      getRuntimeMXBean().
      getInputArguments().toString().contains("jdwp");
  }
}
