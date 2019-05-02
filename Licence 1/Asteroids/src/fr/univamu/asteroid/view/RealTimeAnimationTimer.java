package fr.univamu.asteroid.view;

import javafx.animation.AnimationTimer;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public class RealTimeAnimationTimer extends AnimationTimer {

  private final View view;
  private long previousTick = -1;

  public RealTimeAnimationTimer(View view) {
    this.view = view;
  }

  @Override
  public void handle(long now) {
    double dt =
      (previousTick == -1) ? 0 : (double) (now - previousTick) * 1e-9;
    previousTick = now;
    view.tick(dt);
    if (view.isGameOver()) stop();
  }

}
