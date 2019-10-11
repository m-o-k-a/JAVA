package controller;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import model.GameOfLife;
import model.Grid;
import view.MatrixPane;

/**
 * Controller for <i>The Game of Life</i> application.
 */
public class Controller {

    @FXML
    private ToggleButton playToggleButton;
    @FXML
    private ToggleButton pauseToggleButton;
    @FXML
    private Label generationNumberLabel;
    @FXML
    private MatrixPane matrixPane;

    private GameOfLife gameOfLife;

    @FXML
    private void initialize() {
        initializePlayAndPauseToggleButtons();
    }

    private void initializePlayAndPauseToggleButtons() {
        ToggleGroup toggleGroup = new PersistentToggleGroup();
        toggleGroup.getToggles().addAll(playToggleButton, pauseToggleButton);
        pauseToggleButton.setSelected(true);
    }


    /**
     * Sets {@link GameOfLife} instance.
     *
     * @param gameOfLife {@link GameOfLife} instance
     * @throws NullPointerException if {@code gameOfLife} is {@code null}
     */

    public void setGameOfLife(GameOfLife gameOfLife) {
        this.gameOfLife = requireNonNull(gameOfLife, "game of life is null");
        setGenerationNumberLabelTextProperty();
        initializeMatrixPane();
    }

    private void setGenerationNumberLabelTextProperty() {
        generationNumberLabel.textProperty().bind(gameOfLife.generationNumberProperty().asString());
    }

    private void initializeMatrixPane() {
        Grid grid = gameOfLife.getGrid();
        matrixPane.initialize(grid);
    }

    @FXML
    private void playToggleButtonAction() {
        gameOfLife.play();
    }

    @FXML
    private void pauseToggleButtonAction() {
        gameOfLife.pause();
    }

    @FXML
    private void resetButtonAction() {
        gameOfLife.reset();
        pauseToggleButton.setSelected(true);
    }

    @FXML
    private void clearButtonAction() {
        gameOfLife.clear();
        pauseToggleButton.setSelected(true);
    }
}
