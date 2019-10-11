package model;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

/**
 * {@link Cell} instances represent the cells of <i>The Game of Life</i>.
 */

public class Cell {
    private final Property<CellState> stateProperty = new SimpleObjectProperty<>(CellState.DEAD);

    /**
     * Determines whether this {@link Cell} is alive or not.
     *
     * @return {@code true} if this {@link Cell} is alive and {@code false} otherwise
     */

    public boolean isAlive() {
        return getState().isAlive;
    }

    /**
     * Sets the state of this {@link Cell}.
     *
     * @param cellState the new state of this {@link Cell}
     */

    public void setState(CellState cellState) {
        getStateProperty().setValue(cellState);
    }

    /**
     * Returns the current state of this {@link Cell}.
     *
     * @return the current state of this {@link Cell}
     */

    public CellState getState(){
        return getStateProperty().getValue();
    }

    /**
     * Change the state of this {@link Cell} from ALIVE to DEAD or from DEAD to ALIVE.
     */

    public void toggleState() {
        CellState[] possibleStates = CellState.values();
        int stateOrdinal = getState().ordinal();
        int numberOfPossibleStates = possibleStates.length;
        setState(possibleStates[(stateOrdinal+1)%numberOfPossibleStates]);
    }

    /**
     * Returns this {@link Cell}'s state property.
     *
     * @return this {@link Cell}'s state property.
     */
    public Property<CellState> getStateProperty() {
        return stateProperty;
    }

}
