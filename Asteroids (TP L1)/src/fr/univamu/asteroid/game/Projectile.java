package fr.univamu.asteroid.game;

import fr.univamu.asteroid.tools.Vector;

public class Projectile {

    private Vector position;
    private Vector velocity;
    private double lifeSpan = 3*60;

    public Projectile(Vector position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public Vector getPosition() { return position; }

    public boolean isAlive() {
        if (lifeSpan <= 0) {
            return true;
        }
        return false;
    }
    public boolean hasCollision() {
        for(Asteroid asteroid : Space.asteroids) {
            if (asteroid.contains(this.position)) {
                return true;
            }
        }
        return false;
    }
    public void update(double dt) {
        //position = position.add(velocity);
        position = position.add(velocity.multiply(dt));
        lifeSpan--;
        position = Space.toricRemap(position);
        //System.out.println(position.getX() + " " + position.getY() + " || " + velocity.getX() + " " + velocity.getY());

    }
}
/**
 public static void addProjectile(Projectile projectile) {
 Space.getProjectiles().add(projectile);
 }
 **/