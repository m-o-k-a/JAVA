package fr.univamu.asteroid.game;

import fr.univamu.asteroid.tools.Polygon;
import fr.univamu.asteroid.tools.Vector;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidTest {
    private final double angularVelocity = 3/2;
    private double angle = 0;
    @Test
    void contains() {
        Polygon shape = new Polygon(List.of(new Vector(-5, 5), new Vector(5, 5), new Vector(4, 2), new Vector(-6, 4)));
        Asteroid asteroid = new Asteroid(new Vector (40, 15), shape, new Vector (0, 0), angularVelocity, 1.0);
        //void update(double dt) {
        angle = angle + angularVelocity;
        //}

        assertTrue(asteroid.contains(new Vector(40, 15)));
        assertFalse(asteroid.contains(new Vector(20, 45)));
    }
}