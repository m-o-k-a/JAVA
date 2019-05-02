package fr.univamu.asteroid.game;

public class Score {
    public static double score = 0;
    public static int multiplier = 1;
    public static int multiplierTimer = 2*60;

    public double getScore() { return score; }
    public double getmultiplier() { return multiplier; }

    public static void update(double dt) {
        if (multiplier <= 1) { multiplier = 1; }
        multiplierTimer--;
        if (multiplierTimer <= 0) { multiplier--; multiplierTimer = 2*60; }
    }

    private void addPoints(double points) {
        score += points*getmultiplier();
    }

    public void notifyAsteroidHit() {
        addPoints(10);
        multiplier++;
    }


}
