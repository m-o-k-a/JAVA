package fr.univamu.asteroid.view;

import fr.univamu.asteroid.game.Asteroid;
import fr.univamu.asteroid.game.Spaceship;
import fr.univamu.asteroid.inspectionView.Inspection;
import fr.univamu.asteroid.tools.Vector;
import fr.univamu.asteroid.viewModel.ViewModel;

import java.util.function.Function;

import static fr.univamu.asteroid.inspectionView.InspectionBuilders.*;

/**
 * This class is used to show the state of the fr.univamu.asteroid.game with a textual
 * representation using a tree structure. One can modify the method
 * <em>modelInspection</em> to insert new values to inspect in the
 * fr.univamu.asteroid.view.
 */public class GameInspectionView {


  public static Inspection modelInspection(ViewModel viewModel) {
    return properties("Modèle",
      labelledProperty(ViewModel::getScore, "Score"),
      property(ViewModel::getSpaceship,
        properties("Vaisseau",
          formattedProperty(
            Spaceship::getPosition,
            vectorFormatter("position")
          ),
                labelledProperty(
                        Spaceship::isMainEngineOn,
                        "isMainEngineOn"
                ),
          formattedProperty(
            Spaceship::drawVelocity,
            vectorFormatter("velocity")
          ),
                formattedProperty(
                        Spaceship::getAcceleration,
                        vectorFormatter("acceleration")
                ),
          labelledProperty(
            Spaceship::getDirection,
            "directionAngle"
          )
        )),
      property(ViewModel::getAsteroids,
        list("Asteroïdes",
          properties(
            "Astéroïde",
            formattedProperty(
              Asteroid::getPosition,
              vectorFormatter("position")
            ),
            formattedProperty(
              Asteroid::getVelocity,
              vectorFormatter("vélocité")
            ),
            labelledProperty(
              Asteroid::getSize,
              "taille"
            )
          )
        )
      )
    ).apply(viewModel);
  }

  private static Function<Vector,String> vectorFormatter(String label) {
    return point ->
      String.format("%s : (%.1f,%.1f)", label, point.getX(), point.getY());
  }


}
