package model;

import static java.util.Objects.requireNonNull;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * {@link GameOfLife} instances run <i>The Game of Life</i>.
 */
public class GameOfLife {

    private final Random random = new Random();
    private static final int PERIOD_IN_MILLISECONDS = 100;

    private final Grid grid;
    private final ReadOnlyLongWrapper generationNumber = new ReadOnlyLongWrapper();
    private Timeline timeline;

    /**
     * Creates a new {@code GameOfLife} instance given the underlying {@link Grid}.
     *
     * @param grid the underlying {@link Grid}
     * @throws NullPointerException if {@code grid} is {@code null}
     */
    public GameOfLife(Grid grid) {
        this.grid = requireNonNull(grid, "grid is null");
        updateTimeline();
        grid.randomGeneration(random);
    }

    private void updateTimeline() {
        Duration duration = new Duration(PERIOD_IN_MILLISECONDS);
        EventHandler<ActionEvent> eventHandler = event -> next();
        KeyFrame keyFrame = new KeyFrame(duration, eventHandler);
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Transitions into the next generationNumber.
     */
    private void next() {
        grid.updateToNextGeneration();
        generationNumber.set(getGenerationNumber() + 1);
    }


    /**
     * Returns the current generationNumber.
     *
     * @return the current generationNumber
     */
    private long getGenerationNumber() {
        return generationNumber.get();
    }

    /**
     * Returns the generationNumber {@link ReadOnlyLongProperty}.
     *
     * @return the generationNumber {@link ReadOnlyLongProperty}
     */
    public ReadOnlyLongProperty generationNumberProperty() {
        return generationNumber.getReadOnlyProperty();
    }

    /**
     * Returns the {@link Grid}.
     *
     * @return the {@link Grid}
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Plays the game.
     */
    public void play() {
        timeline.play();
    }

    /**
     * Pauses the game.
     */
    public void pause() {
        timeline.pause();
    }

    /**
     * Clears the current game.
     */
    public void clear() {
        pause();
        grid.clear();
        generationNumber.set(0);
    }

    /**
     * Clears the current game and randomly generates a new one.
     */
    public void reset() {
        clear();
        grid.randomGeneration(random);
    }

}
