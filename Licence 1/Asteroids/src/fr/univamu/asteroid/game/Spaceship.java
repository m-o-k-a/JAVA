package fr.univamu.asteroid.game;

import fr.univamu.asteroid.tools.Polygon;
import fr.univamu.asteroid.tools.Vector;

import java.util.List;

/**
 * Models a spaceship controlled by a player.
 */
public class Spaceship {


  /**
   * The position of the center of the spaceship
   */
  private static Vector position;
  private static Vector velocity = new Vector(0, 0);
  private Vector sub = new Vector(1, 1);
  private static final double MAIN_ENGINE_POWER = 50; /** vector F/m, absolute value */
  private static final double ANGULAR_SPEED = 360/60;
  /**
   * The forward direction for the spaceship, encoding the rotation
   * from horizontal of its image and the direction of acceleration.
   */
  private static Vector direction = new Vector(1, 0);

  /**
   * Controls if the main engine, with forward acceleration, is powered on.
   */
  private boolean isMainEngineOn = false;
  private boolean isBackEngineOn = false;
  private boolean isLeftEngineOn = false;
  private boolean isRightEngineOn = false;


  /**
   * @return the position of the spaceship
   */
  public Vector getPosition() {
    return position;
  }

  /**
   * @return the angle of the spaceship in degree, where 0 is facing right.
   */
  public double getDirection() {
    return Math.toDegrees(direction.angle());
  }


  /**
   * @return whether the main engine is on (forward acceleration).
   */
  public boolean isMainEngineOn() {
    return isMainEngineOn;
  }
  public boolean isLeftEngineOn() {
    return isLeftEngineOn;
  }
  public boolean isRightEngineOn() {
    return isRightEngineOn;
  }
  public boolean isBackEngineOn() { return isBackEngineOn;}


  /**
   * Initially the spaceship will be positioned at the center of space.
   */
  public Spaceship() {
    this.position =
      new Vector(
        Space.SPACE_HEIGHT / 2,
        Space.SPACE_WIDTH / 2
      );
  }

  /** collision */


  /** get Acceleration, depending of the mouvement ? */
  public Vector drawVelocity() {
    return velocity;
  }
  public Vector getVelocity(double dt) {
    if (isMainEngineOn()) {
      return velocity.add(getAcceleration().multiply(dt));
    }
    else {
      return velocity.multiply(0.99);
    }
  }
  /** make velocity slow down */
  public Vector reduceVelocity(double red) {
    return velocity.multiply(red);
  }
  public Vector getAcceleration() {
    if (isMainEngineOn()) {
      return direction.multiply(MAIN_ENGINE_POWER);// = position.add(direction.multiply(100 * dt));
    }
    else {
      return Vector.ZERO;
      //return direction.multiply(MAIN_ENGINE_POWER); //TODO SOLVE
      //return direction.multiply(0);
      //return direction = new Vector(0, 0);
    }
    //return new Vector( 0, 0); problème de surcharge mémoire.
  }


  /**
   * The spaceship is a moving object. Every now and then, its position
   * must be updated, as well as other parameters evolving with time. This
   * method simulates the effects of a delay <em>dt</em> over the spaceship.
   * For good accuracy this delay should be kept small.
   *
   * @param dt the time delay to simulate.
   * saved update in answer
   */
  public void update(double dt) {
    collissionPowerup();
    velocity = getVelocity(dt);
    position = position.add(velocity.multiply(dt));
    if (isLeftEngineOn()) {
      //velocity = velocity.add(getAcceleration().multiply(dt));
      //position = position.add(velocity.multiply(dt));
      direction = direction.rotate(ANGULAR_SPEED); //RIP 10 MINUTES A CHERCHER SUR INTERNET
    }
    if (isRightEngineOn()) {
      direction = direction.rotate(-ANGULAR_SPEED);
    }
    //if (isBackEngineOn()) {
      //direction = position.subtract(sub);
    //}
    position = Space.toricRemap(position);
  }


  /**
   * Switches the main engine (powering forward acceleration) on.
   */
  public void startMainEngine() {
    isMainEngineOn = true;
  }
  public void startLeftEngine() {
    isLeftEngineOn = true;
  }
  public void startRightEngine() {
    isRightEngineOn = true;
  }
  public void startBackEngine() {
    isBackEngineOn = true;
  }
  /**
   * Switches the main engine (powering forward acceleration) off.
   */
  public void stopMainEngine() {
    isMainEngineOn = false;
  }
  public void stopLeftEngine() {
    isLeftEngineOn = false;
  }
  public void stopRightEngine() {
    isRightEngineOn = false;
  }
  public void stopBackEngine() {
    isBackEngineOn = false;
  }


  /**
   * A list of points on the boundary of the spaceship, used
   * to detect collision with other objects.
   */
  /**public boolean collides(Asteroid asteroid) { //TODO ERROR
    //pour tous les asteroid, verifier si pour tout vecteur de list.of, le vecteur est contains dans asteroid
     * for(int i = 0, i < size(List.of), i++) {
   *      Vector real = caluler position réelle
     *    if asteroid.contains(real) == true { return true;} (collision existe, on arette)
     *  }
     *  return false;
     * }
   * }
     */

  public Projectile fire() {
    //return new Projectile(Spaceship.position.add(new Vector(30, 30).rotate(ANGULAR_SPEED)), velocity); //TODO prendre en compte la rotation du vaisseau
    Vector p = this.position.add(this.direction.multiply(30));
    Vector v = (this.velocity.add(this.direction.multiply(100)));
    //Vector v = this.velocity.multiply(100);
    return new Projectile(p, v);
  }


  public static boolean collides() {
      for(int i = 0; i < contactPoints.size(); i++) {
        for(int j = 0; j < Space.asteroids.size(); j++)
          //Space.hasCollision(this);
        if((Space.asteroids.get(j)).contains(contactPoints.get(i).rotate(ANGULAR_SPEED).translate(position))) {
          System.out.println("Game Over");
          return true;
        }
    }
    return false;
  }
  public static boolean collissionPowerup() { //TODO ajouter rotate et translate au vecteur du vaisseau
    for(Vector i : contactPoints) {
      for(PowerUp j : Space.powerup)
        if (i.distanceTo(j.getPosition()) <= 100) { //TODO apprendre les maths ;-;
          System.out.println("pen15");
          return true;
        }
    }
    return false;
  }


  private static final List<Vector> contactPoints =
    List.of(
      new Vector(0,0),
      new Vector(27,0),
      new Vector(14.5,1.5),
      new Vector(2,3),
      new Vector(0,18),
      new Vector(-13,18),
      new Vector(-14,2),
      new Vector(-14,-2),
      new Vector(-13,-18),
      new Vector(0,-18),
      new Vector(2,-3),
      new Vector(14.5,-1.5)
    );
}
