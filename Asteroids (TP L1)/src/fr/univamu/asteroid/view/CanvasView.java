package fr.univamu.asteroid.view;

import fr.univamu.asteroid.game.Asteroid;
import fr.univamu.asteroid.game.Projectile;
import fr.univamu.asteroid.game.Score;
import fr.univamu.asteroid.game.Spaceship;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import fr.univamu.asteroid.tools.Polygon;
import fr.univamu.asteroid.tools.Vector;
import fr.univamu.asteroid.viewModel.ViewModel;


/**
 * An object of this class is responsible for drawing the current state
 * of the fr.univamu.asteroid.game over a JavaFX canvas, and handling GUi events.
 */
public class CanvasView {

  private final Canvas canvas;
  private final ViewModel viewModel;
  private GraphicsContext context;

  /**
   * @param canvas the canvas on which to draw the fr.univamu.asteroid.game
   * @param viewModel the fr.univamu.asteroid.viewModel to display and interact with
   */
  public CanvasView(Canvas canvas, ViewModel viewModel) {
    this.canvas = canvas;
    this.viewModel = viewModel;
    context = canvas.getGraphicsContext2D();
  }

   /**
   * Refresh the canvas, using the current state of the fr.univamu.asteroid.game.
   */
   public void render() {
    clear();
    renderBackground();
    for (Asteroid asteroid : viewModel.getAsteroids()) {
      renderAsteroid(asteroid);
    }
    for (Projectile projectile : viewModel.getProjectiles()) {
       renderProjectile(projectile);
    }
    renderSpaceship(viewModel.getSpaceship());
    renderScore(viewModel.getScore());
  }

  /**
   * the font used to render the score.
   */
  private static final Font font = Font.font("DejaVu Sans", FontWeight.BOLD,48);
  private static final Font font2 = Font.font("DejaVu Sans", FontWeight.EXTRA_LIGHT,12);

  /**
   * @param score the score to render
   */
  private void renderScore(Score score) {
    context.setFill(Color.GREEN);
    context.setFont(font);
    String text = String.format("Score: %d", Math.round(score.getScore()));
    context.fillText(text, 5,50);
    context.setFill(Color.LIME);
    context.setFont(font2);
    String text2 = String.format("x%d", Math.round(score.getmultiplier()));
    context.fillText(text2, 170,58);
  }


  /**
   * Remove the current drawing from the canvas.
   */
  public void clear() {
    context.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
  }

  /**
   * Set the background image of the fr.univamu.asteroid.game.
   */
  public void renderBackground() {
    context.setFill(Color.BLACK);
    context.fillRect(0,0, Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
  }


  /**
   * @param asteroid an asteroid to display
   */
  public void renderAsteroid(Asteroid asteroid) {
    context.setFill(Color.GRAY);
    renderPolygon(asteroid.getShape());
  }


  /**
   * @param shape a polygon to display
   */
  private void renderPolygon(Polygon shape) {
    int nbPoints = shape.getVertices().size();
    double[] xs = new double[nbPoints];
    double[] ys = new double[nbPoints];
    int i = 0;
    for (Vector vertex : shape.getVertices()) {
      xs[i] = vertex.getX();
      ys[i] = vertex.getY();
      i++;
    }
    context.fillPolygon(xs, ys, nbPoints);
  }

  public void renderProjectile(Projectile projectile) {
    context.setFill(Color.RED);
    context.fillOval(projectile.getPosition().getX(), projectile.getPosition().getY(), 3, 3);

  }

  /**
   * @param spaceship a spaceship to display
   */
  public void renderSpaceship(Spaceship spaceship) {
    context.save();
    Vector position = spaceship.getPosition();
    context.translate(position.getX(), position.getY());
    context.rotate(spaceship.getDirection());
    renderSpaceShipImage(context, spaceshipImage);
    context.restore();
  }


  /** renders an image of the spaceship. The context must be put in position
   * before calling this method, by rotation and translation, in such a
   * way that the spaceship would be in position (0,0) facing right.
   * @param context the drawing context rotated and translated
   * @param img the image to draw
   */
  private void renderSpaceShipImage(GraphicsContext context, Image img) {
    context.drawImage(
      img,
      - (double) PIXEL_SHIP_WIDTH / 2,
      - (double) PIXEL_SHIP_HEIGHT / 2,
      PIXEL_SHIP_WIDTH,
      PIXEL_SHIP_HEIGHT);
  }

  private static final int PIXEL_SHIP_WIDTH = 57;
  private static final int PIXEL_SHIP_HEIGHT = 47;


  private final Image spaceshipImage =
    loadImage("/fr/univamu/asteroid/resources/spaceship.png");


  /** Load an image from the fr.univamu.asteroid.resources package.
   * @param filePath relative path for the image.
   * @return a representation of the image.
   */
  private Image loadImage(String filePath) {
    return new Image(getClass().getResource(filePath).toString());
  }


}
