package controller;

import javafx.collections.ListChangeListener.Change;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * An extension of {@link ToggleGroup} that ensures that a {@link Toggle} in a group must always be
 * selected.
 *
 */
class PersistentToggleGroup extends ToggleGroup {

  /**
   * Creates a new {@code PersistentToggleGroup}.
   */
  PersistentToggleGroup() {
    getToggles().addListener((Change<? extends Toggle> change) -> {
      while (change.next()) {
        for (Toggle toggle : change.getAddedSubList()) {
          ToggleButton toggleButton = (ToggleButton) toggle;
          toggleButton.addEventFilter(MouseEvent.MOUSE_RELEASED, mouseEvent -> {
            if (toggleButton.equals(getSelectedToggle())) {
              mouseEvent.consume();
            }
          });
        }
      }
    });
  }

}
