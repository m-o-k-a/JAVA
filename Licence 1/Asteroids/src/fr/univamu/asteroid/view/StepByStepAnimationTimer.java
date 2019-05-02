package fr.univamu.asteroid.view;

import javafx.animation.AnimationTimer;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public class StepByStepAnimationTimer extends AnimationTimer {

  private final View view;
  private final double dt;
  private long lastTick = -1;

  public StepByStepAnimationTimer(View view, double dt) {
    this.view = view;
    this.dt = dt;
  }

  @Override
  public void handle(long now) {
    if (lastTick < 0 || ((double) now - lastTick) * 1e-9 > dt) {
      view.tick(dt);
      lastTick = now;
    }
    if (view.isGameOver()) this.stop();
  }
}
