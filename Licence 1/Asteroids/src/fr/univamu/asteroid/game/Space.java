package fr.univamu.asteroid.game;


import fr.univamu.asteroid.tools.Vector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Space contains all the information determining the current state of
 * the fr.univamu.asteroid.game, and methods implementing how the fr.univamu.asteroid.game state changes, and how
 * the fr.univamu.asteroid.game ends (basically the rules of the fr.univamu.asteroid.game).
 */
public class Space {

  public static final double SPACE_WIDTH = 800;
  public static final double SPACE_HEIGHT = 800;

  public static final int INITIAL_ASTEROID_COUNT = 10;
  public static final double INITIAL_ASTEROID_SIZE = 2;

  public static final double MINIMAL_SIZE = 0.5;
  public static final int NUMBER_FRAGMENTS = 4;
  public static final double RATIO_FRAGMENTS = 0.5;




  /**
   * We don't want asteroids to spawn on the spaceship. This parameter
   * controls how close an asteroid can be from the spaceship initially,
   * in pixels.
   */
  private static final double STARTING_SECURITY_DISTANCE = 80;

  /**
   * An object able to create random items, like asteroids or positions.
   */
  public static final RandomGenerator generator = new RandomGenerator();

  private Spaceship spaceship;
  public static List<Asteroid> asteroids;
  public static List<Projectile> projectiles;
  public static List<PowerUp> powerup = new ArrayList<>();
  public Score score = new Score();

  public Spaceship getSpaceship() {
    return spaceship;
  }
  public static boolean gameOver = false;

  public List<Asteroid> getAsteroids() {
    return asteroids;
  }
  public List<Projectile> getProjectiles() { return projectiles; }

  public Score getScore() {
    return score;
  }

  public Space() {
    spaceship = new Spaceship();
    asteroids = new ArrayList<>(INITIAL_ASTEROID_COUNT);
    projectiles = new ArrayList<>();
    //Projectile.addProjectile(new Projectile(new Vector(0, 0), new Vector(0, 0)));
    for (int i = 0; i < INITIAL_ASTEROID_COUNT; i++) {
      asteroids.add(generateInitialAsteroid());
    }
  }


  public void update(double dt) {
    Score.update(dt);
    for (Asteroid asteroid : asteroids) {
      asteroid.update(dt);
    }
    for (PowerUp power : powerup) {
      power.update();
    }
    processProjectiles(dt);
    spaceship.update(dt);
    hasCollision();
    removeDeadProjectiles();

    //processProjectiles(dt);


  }


  private void processProjectiles(double dt) { //TODO: CANNOT REFRACTOR THIS
    for (Projectile o : projectiles) {
      o.update(dt);
      if (o.hasCollision()) {
        score.notifyAsteroidHit();
        projectiles.remove(o);
        Set<Projectile> hittedProjectils = new HashSet<>();
        Set<Asteroid> hittedAsteroids = new HashSet<>();
        //TODO: create a set of hitting projectiles
        for (Asteroid a : asteroids) {
          if (a.contains(o.getPosition())) {
            List<Asteroid> newAsteroids = a.fragments();
            //now add all the new asteroids
            for(Asteroid f : newAsteroids) { asteroids.add(f); }
            PowerUp p = new PowerUp(1, a.getPosition());
            asteroids.remove(a);
            powerup.add(p);
            System.out.println("A");

          }
        }
      }
    }
  }



  public void hasCollision() {
        gameOver = Spaceship.collides();
  }
  public boolean isGameOver() {
      return gameOver;
  }

  public void addProjectile(Projectile projectile) {
   projectiles.add(projectile);
  }
  private List<Projectile> getDeadProjectile() {
    List<Projectile> deadProjectiles = new ArrayList<>();
    for (Projectile o : projectiles) {
      if (o.isAlive()){
        deadProjectiles.add(o);
      }
    }
    return deadProjectiles;
  }
  private void removeDeadProjectiles2(){ //TODO NOT ALL DELETE
    List<Projectile> isDeadProjectile = getDeadProjectile();
    for (Projectile isDead : isDeadProjectile) {
      projectiles.remove(isDead);
    }
  }

  private void removeDeadProjectiles(){ //TODO NOT ALL DELETE
  List<Projectile> isDeadProjectile = getDeadProjectile();
  while (isDeadProjectile.size() != 0) {
      Projectile isDead = isDeadProjectile.get(0);
      projectiles.remove(isDead);
      isDeadProjectile.remove(isDead);

    }
}


  /**
   * Generates a random asteroid with standard parameters, whose distance
   * to the spaceship is large enough.
   *
   * @return a random asteroid
   */
  public Asteroid generateInitialAsteroid() {
    Asteroid asteroid = generator.asteroid(INITIAL_ASTEROID_SIZE);
    double distanceFromSpaceship =
      asteroid.getPosition().distanceTo(spaceship.getPosition());
    if (distanceFromSpaceship < STARTING_SECURITY_DISTANCE) {
      return generateInitialAsteroid();
    }
    return asteroid;
  }
/** collision with all, WIP
 * public boolean hasCollision {
 *     for(i = 0, i < liste asteroid, i++) {
 *         spaceship.collides(asteroid[i]);
 *     }
 * }
 */


  /**
   * Because the space is toric (things leaving the window on one side
   * reappear on the other side), we need to compute the positions of items
   * leaving the screen to get them back on the other side. This method takes
   * an arbitrary vector and maps it to valid toric coordinates.
   *
   * @param position any position
   * @return the same position with canonical toric coordinates
   */
  public static Vector toricRemap(Vector position) {
    return new Vector(
      clamp(position.getX(), SPACE_WIDTH),
      clamp(position.getY(), SPACE_HEIGHT)
    );
  }


  /**
   * Used by remapPosition to compute coordinates between 0 and a bound.
   *
   * @param value the coordinate to recompute
   * @param bound the maximum value allowed for this coordinate
   * @return the corrected coordinate
   */
  private static double clamp(double value, double bound) {
    return value - Math.floor( value / bound) * bound;
  }
}
