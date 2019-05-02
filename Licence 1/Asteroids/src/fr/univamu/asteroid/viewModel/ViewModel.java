package fr.univamu.asteroid.viewModel;

import fr.univamu.asteroid.game.*;
import fr.univamu.asteroid.view.View;

import java.util.List;

public class ViewModel {

  private Space gameState;
  private View view;

  public ViewModel(Space space, View view) {
    this.gameState = space;
    this.view = view;
  }


  public void tick(double dt) {
    gameState.update(dt);
    view.render();

  }

  public void startSpaceshipMainEngine() {
    gameState.getSpaceship().startMainEngine();
  }
  public void stopSpaceshipMainEngine() {
    gameState.getSpaceship().stopMainEngine();
  }
  public void startSpaceshipLeftEngine() {
    gameState.getSpaceship().startLeftEngine();
  }
  public void stopSpaceshipLeftEngine() {
    gameState.getSpaceship().stopLeftEngine();
  }
  public void startSpaceshipRightEngine() {
    gameState.getSpaceship().startRightEngine();
  }
  public void stopSpaceshipRightEngine() {
    gameState.getSpaceship().stopRightEngine();
  }
  public void startSpaceshipBackEngine() { gameState.getSpaceship().startBackEngine(); }
  public void stopSpaceshipBackEngine() {
    gameState.getSpaceship().stopBackEngine();
  }



  public boolean isGameOver() {
    return gameState.isGameOver();
  }


  public List<Asteroid> getAsteroids() {
    return gameState.getAsteroids();
  }
  public List<Projectile> getProjectiles() {
    return gameState.getProjectiles();
  }

  public void fireSpaceshipGun() { gameState.projectiles.add(gameState.getSpaceship().fire());}


  public Spaceship getSpaceship() {
    return gameState.getSpaceship();
  }


  public Score getScore() {
    return gameState.score;
  }
}
