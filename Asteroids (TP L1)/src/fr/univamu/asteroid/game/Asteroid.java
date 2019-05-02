package fr.univamu.asteroid.game;

import fr.univamu.asteroid.tools.Polygon;
import fr.univamu.asteroid.tools.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Models an asteroid. An asteroid is a polygonal shape with velocity
 * and angular velocity. They have currently no acceleration so they travel
 * in straight lines. Their positions must be updated frequently using
 * the <em>update</em> method.
 */
public class Asteroid {

  /**
   * The position of the center of the asteroid.
   */
  private Vector position;

  /**
   * The velocity of the center of the asteroid.
   */
  private Vector velocity;

  /**
   * A measure of the rotation of the asteroid since its creation.
   */
  private double angle;

  /**
   * The angle in degree by which the asteroid rotates each second.
   */
  private double angularVelocity;

  /**
   * The shape of the asteroid, the center of the asteroid is the
   * center of its shape.
   */
  private final Polygon shape;

  /**
   * The size of the asteroid (in an arbitrary but fixed unit)
   */
  private final double size;

  /**
   * @return the position of the center of the asteroid.
   */
  public Vector getPosition() {
    return position;
  }

  /**
   * @return the velocity of the center of the asteroid.
   */
  public Vector getVelocity() {
    return velocity;
  }

  /**
   * @return the angular velocity of the asteroid around its angle.
   */
  public double getAngularVelocity() {
    return angularVelocity;
  }

  /**
   * @return a factor of size of the asteroid.
   */
  public double getSize() {
    return size;
  }

  /**
   * @return the shape of the asteroid, with same center as the asteroid.
   */
  public Polygon getShape() {
    return shape.rotate(angle).translate(position);
  }
/** TO CHECK - CONTAINS
  public boolean contains(Vector point) { //TODO Q1.6 to 1.12 (imcomprehensible)
    point = new Vector(0, 0); //pour la position 0, 0
    if (shape.getVertices().contains(point)) {
      return true;
      //pour remettre l'angle à zero: angle = 0;
      //le translate agit avec le vecteur position, angle avec angle;
      //donc il faudrait aussi appliquer sur le vecteur point
      //appliquer les meme rotations et meme translation.
      //MAIS CEST UN VECTEUR DONC IDK
    }
    else{
      return false;
    }
  } */
  public boolean contains(Vector point) {
    return getShape().contains(point);
  }


  /**
   * @param center          the center of the asteroid
   * @param shape           the shape with center (0,0) of the asteroid
   * @param velocity        the velocity (in pixel per second) of the asteroid
   * @param angularVelocity the angular velocity (in degree per second) of the asteroid
   * @param size            the relative size of the asteroid.
   */
  public Asteroid(Vector center,
                  Polygon shape,
                  Vector velocity,
                  double angularVelocity,
                  double size) {
    this.position = center;
    this.shape = shape;
    this.angle = 0;
    this.velocity = velocity;
    this.angularVelocity = angularVelocity;
    this.size = size;
  }

  public List<Asteroid> fragments() {
    List<Asteroid> fragmentedAsteroid = new ArrayList<>();
    if (getSize() >= Space.MINIMAL_SIZE) {
      for (int i = 0; i < Space.NUMBER_FRAGMENTS; i++) {
        Asteroid a = Space.generator.asteroid(getSize() * Space.RATIO_FRAGMENTS);
        a.position = this.getPosition();
        //faster the angular velocity of asteroid
        a.angularVelocity = getAngularVelocity();
        a.angularVelocity += -360 + (new Random().nextInt(721));
        fragmentedAsteroid.add(a);
      }
    }
    return fragmentedAsteroid;
  }

  /**
   * Asteroids move over time. To simulate the movement, their positions
   * and other physical properties must be updated regularly. This method
   * simulates the effect of a small time delay <em>dt</em> upon the asteroid.
   *
   * @param dt the time delay to simulate.
   */
  public void update(double dt) {
    position = position.add(velocity.multiply(dt));
    position = Space.toricRemap(position);
    angle = angle + angularVelocity * dt;
    //Spaceship.collides(this);
  }


}
