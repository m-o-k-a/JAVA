package fr.univamu.asteroid.view;

import fr.univamu.asteroid.game.Spaceship;
import fr.univamu.asteroid.inspectionView.Inspection;
import fr.univamu.asteroid.inspectionView.InspectionView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyEvent;
import fr.univamu.asteroid.viewModel.ViewModel;

/**
 * The fr.univamu.asteroid.view handles the graphical user interface. It receives and processes
 * the keyboard events, and regularly redraws itself.
 * <p>
 * You should not modify this class, except when invited to,
 */
public class View {

  private ViewModel viewModel;

  /**
   * Handles the event of a key pressed on the keyboard. Each time a key
   * is pressed, this method is activated with as parameter a value containing
   * all necessary information about which key is pressed.
   *
   * @param keyEvent a representation of the keyboard event
   */
  public void handleKeyPressed(KeyEvent keyEvent) {
    switch (keyEvent.getCode()) {
      case UP:
        viewModel.startSpaceshipMainEngine();
        break;
      case LEFT:
        viewModel.startSpaceshipLeftEngine();
        break;
      case RIGHT:
        viewModel.startSpaceshipRightEngine();
        break;
      case DOWN:
        viewModel.startSpaceshipBackEngine();
      case SPACE:
        viewModel.fireSpaceshipGun();
        break;

//      case UP:
//        fr.univamu.asteroid.viewModel.doSomething(); // TODO modify the method called
//        break;
    }
  }

  /**
   * Handles the event of a key released on the keyboard. Each time a key
   * is released, this method is activated with as parameter a value containing
   * all necessary information about which key is released.
   *
   * @param keyEvent a representation of the keyboard event
   */
  public void handleKeyReleased(KeyEvent keyEvent) {
    switch (keyEvent.getCode()) {
      case UP:
        viewModel.stopSpaceshipMainEngine();
        break;
        case LEFT:
        viewModel.stopSpaceshipLeftEngine();
        break;
      case RIGHT:
        viewModel.stopSpaceshipRightEngine();
        break;
      case DOWN:
        viewModel.stopSpaceshipBackEngine();
        break;

    }

  }

  /* Everything below should not be modified! */

  private CanvasView canvasView;
  private InspectionView inspectionView;

  @FXML
  private Canvas canvas;
  @FXML
  private TreeView<String> treeView;


  public void tick(double dt) {
    update(dt);
    render();
  }


  private void update(double dt) {
    viewModel.tick(dt);
  }


  public void render() {
    canvasView.render();
    inspectionView.render();
  }


  public void setEventHandler(Scene scene) {
    scene.addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPressed);
    scene.addEventFilter(KeyEvent.KEY_RELEASED, this::handleKeyReleased);
  }


  public void initialize(ViewModel viewModel) {
    this.viewModel = viewModel;
    canvasView = new CanvasView(canvas, viewModel);
    Inspection inspection =
      GameInspectionView.modelInspection(viewModel);
    inspectionView = new InspectionView(treeView, inspection);
    canvas.setWidth(Main.CANVAS_WIDTH);
    canvas.setHeight(Main.CANVAS_HEIGHT);
    render();
  }


  public boolean isGameOver() {
    return viewModel.isGameOver();
  }
}
