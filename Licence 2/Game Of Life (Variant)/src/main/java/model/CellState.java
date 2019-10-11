package model;

import javafx.scene.paint.Color;

/**
 * {@link CellState} instances represent the possible states of a {@link CellState}.
 */
public enum CellState {
    BLUE(true, Color.BLUE), RED(true, Color.RED), DEAD(false, Color.WHITE);

    public final boolean isAlive;
    public final Color color;

    CellState(boolean isAlive, Color color) {
        this.isAlive = isAlive;
        this.color = color;
    }
}
