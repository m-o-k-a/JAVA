package fr.univamu.asteroid.tools;

/**
 * 2-dimensional vectors. Instances of this class are immutable: a vector,
 * once defined, cannot be modified. Operations on vectors produce new
 * vectors as results.
 */
public class Vector {

  public static final Vector ZERO = new Vector(0, 0);

  public final double x;
  public final double y;


  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  /** Vector addition.
   * @param vec vector to add
   * @return the vector this + vec
   */
  public Vector add(Vector vec) {
    return new Vector(this.getX() + vec.getX(), this.getY() + vec.getY());
  }

  /** Vector negation
   * @return the vector -this
   */
  public Vector negate() {
    return new Vector(-this.getX(), -this.getY());
  }

  /** Vector subtraction
   * @param removed vector to subtract
   * @return the vector this - removed
   */
  public Vector subtract(Vector removed) {
    return this.add(removed.negate());
  }

  /** Scalar multiplication of vectors
   * @param scalar a scalar
   * @return the vector scalar * this
   */
  public Vector multiply(double scalar) {
    return new Vector(scalar * this.getX(), scalar * this.getY());
  }

  /** Dotproduct of vectors
   * @param vec a vector
   * @return the product this . vec
   */
  public double dotProduct(Vector vec) {
    return this.getX() * vec.getX() + this.getY() * vec.getY();
  }


  /**
   * @return the square of the norm of this
   */
  public double norm2() {
    return this.dotProduct(this);
  }

  /**
   * @return the norm of this
   */
  public double norm() {
    return Math.sqrt(this.norm2());
  }

  /** Rotating a vector around (0,0)
   * @param degree degree of counterclockwise rotation
   * @return the rotated vector
   */
  public Vector rotate(double degree) {
    double rad = Math.toRadians(degree);
    double sine = Math.sin(rad);
    double cosine = Math.cos(rad);
    return new Vector(
      cosine * this.getX() + sine * this.getY(),
      -sine * this.getX() + cosine * this.getY()
    );
  }


  /** Translating a point (considering this as a point)
   * @param displacement a vector of displacement
   * @return The point (as a vector) this + displacement
   */
  public Vector translate(Vector displacement) {
    return this.add(displacement);
  }

  /** Distance between two points
   * @param point a point (as a vector)
   * @return distance between this and point
   */
  public double distanceTo(Vector point) {
    return this.subtract(point).norm();
  }

  /**
   * @return a vector collinear with this, with norm 1 and same direction
   */
  public Vector normalize() {
    double norm = this.norm();
    if (norm < 1e-9)
      throw new IllegalArgumentException("normalize null vector");
    return this.multiply(1 / norm);
  }


  /** Angle formed by two vectors
   * @param vec
   * @return signed angle from this to vec, between -pi and pi (positive for counterclockwise)
   */
  public double angleWith(Vector vec) {
    Vector vec1 = this.normalize();
    Vector vec2 = vec.normalize();
    double cos = vec1.dotProduct(vec2);
    double theta = Math.acos(Math.min(1,Math.max(-1,cos)));
    return
      (new Vector(-vec1.getY(), vec1.getX()).dotProduct(vec2) > 0) ? theta : -theta;
  }

  /** Angle from horizontal
   * @return signed angle from the horizontal to this, between -pi and pi (positive for counterclockwise)
   */
  public double angle() {
    return new Vector(1, 0).angleWith(this);
  }

  @Override
  public String toString() {
    return "(" + getX() + ", " + getY() + ")";
  }

}
