package fr.univamu.asteroid.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Simple 2-dimensional polygons, defined by a list of vertices.
 */
public class Polygon {

  private final List<Vector> vertices;

  /**
   * @param vertices vertices in counterclockwise order.
   */
  public Polygon(List<Vector> vertices) {
    this.vertices = vertices;
  }

  /**
   * @return how many vertices define this polygon (there may be degenerate vertices).
   */
  public int nbVertices() {
    return vertices.size();
  }

  /** Checks whether an arbitrary point is inside or outside the polygon.
   * @param point an arbitrary point
   * @return true if the point is inside the polygon
   */
  public boolean contains(Vector point) {
    Vector previous =
      vertices.get(nbVertices() - 1).subtract(point).normalize();
    double angle = 0;
    for (Vector current : vertices) {
      Vector vector = current.subtract(point).normalize();
      double dangle = previous.angleWith(vector);
      angle = angle + dangle;
      previous = vector;
    }
    return Math.abs(angle) > 1e-3;
  }


  /** Applies a transformation to the vertices of the polygon.
   * @param transform the transformation to apply to the vertices
   * @return the polygon with transformed vertices.
   */
  public Polygon transform(Function<Vector,Vector> transform) {
    List<Vector> transformedVertices = new ArrayList<>(nbVertices());
    for (Vector vertex : vertices) {
      transformedVertices.add(transform.apply(vertex));
    }
    return new Polygon(transformedVertices);

  }

  /** Computes the rotation of a polygon around the point (0,0)
   * @param angleInDegree angle of rotation
   * @return the rotated polygon
   */
  public Polygon rotate(double angleInDegree) {
    return transform(vec -> vec.rotate(angleInDegree));
  }

  /** Computes the translation of a polygon.
   * @param vector the vector of translation
   * @return the translated polygon
   */
  public Polygon translate(Vector vector) {
    return transform(vec -> vec.translate(vector));
  }


  /**
   * @return the list of vertices defining the polygon
   */
  public List<Vector> getVertices() {
    return new ArrayList<>(vertices);
  }
}
