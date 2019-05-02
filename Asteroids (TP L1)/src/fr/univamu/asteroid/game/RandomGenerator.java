package fr.univamu.asteroid.game;


import fr.univamu.asteroid.tools.Polygon;
import fr.univamu.asteroid.tools.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Objects of this class can generate random values (polygons, asteroids,
 * positions,...) with limited parametrization.
 */
public class RandomGenerator {

  private static final Random gen = new Random();

  // Asteroid parameters
  private static final double STANDARD_ANGULAR_VELOCITY = 10;
  private static final double STANDARD_SPEED = 30;
  private static final int MIN_VERTEX_COUNT = 5;
  private static final int MAX_VERTEX_COUNT = 12;

  // Polygon parameters
  private static final double MIN_CENTER_TO_VERTEX_DISTANCE = 10;
  private static final double MAX_CENTER_TO_VERTEX_DISTANCE = 20;


  /**
   * Generates a random asteroid.
   *
   * @param size a size factor (linear in diameter)
   * @return the generated asteroid
   */
  public Asteroid asteroid(double size) {
    return asteroid(position(),size);
  }


  /** Generates a random asteroid at a given position.
   * @param position the center of the asteroid
   * @param size the size of the asteroid (linear in diameter)
   * @return the generated asteroid
   */
  public Asteroid asteroid(Vector position, double size) {
    Polygon shape = polygon(MIN_VERTEX_COUNT, MAX_VERTEX_COUNT, size);
    Vector velocity = velocity();
    double angularVelocity = angularVelocity();
    return new Asteroid(position, shape, velocity, angularVelocity,size);

  }



  /** Generates a random polygon.
   * @param minVertexCount the minimum number of vertices
   * @param maxVertexCount the maximum number of vertices
   * @param size the size of the polygon (linear in diameter)
   * @return the generated polygon
   */
  public Polygon polygon(int minVertexCount, int maxVertexCount, double size) {
    int nbVertex =
      gen.nextInt(maxVertexCount - minVertexCount + 1) + minVertexCount;
    return polygon(nbVertex, size);
  }


  /** Generates a random polygon.
   * @param nbVertices the number of vertices
   * @param size the size of the polygon (linear in diameter)
   * @return the generated polygon
   */
  public Polygon polygon(int nbVertices, double size) {
    List<Vector> vertices = new ArrayList<>(nbVertices);
    for (int i = 0; i < nbVertices; i++) {
      double distance = size * polygonalRadius();
      Vector vertex =
        new Vector(distance, 0).rotate(360. * i / nbVertices);
      vertices.add(vertex);
    }
    return new Polygon(vertices);
  }


  /**
   * @return a random position in space
   */
  private Vector position() {
    Vector center = new Vector(
      gen.nextDouble() * Space.SPACE_WIDTH,
      gen.nextDouble() * Space.SPACE_HEIGHT
    );
    return Space.toricRemap(center);
  }


  /**
   * @return a random angular velocity, with uniform distribution.
   */
  private double angularVelocity() {
    return gen.nextGaussian() * STANDARD_ANGULAR_VELOCITY;
  }


  /**
   * @return a random velocity
   */
  private Vector velocity() {
    return new Vector(
      gen.nextGaussian() * STANDARD_SPEED,
      gen.nextGaussian() * STANDARD_SPEED
    );
  }


  private double polygonalRadius() {
    return gen.nextDouble()
      * (MAX_CENTER_TO_VERTEX_DISTANCE
      - MIN_CENTER_TO_VERTEX_DISTANCE
    )
      + MIN_CENTER_TO_VERTEX_DISTANCE;
  }


}
