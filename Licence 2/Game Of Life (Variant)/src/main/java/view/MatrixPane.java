package view;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import model.Cell;
import model.CellState;
import model.Grid;

/**
 * Created by Arnaud Labourel on 22/11/2018.
 */
public class MatrixPane extends GridPane{
    private static final double CELL_SIZE = 14;

    public void initialize(Grid grid) {
        for (int rowIndex = 0; rowIndex < grid.getNumberOfRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid.getNumberOfColumns(); columnIndex++) {
                addCellRectangle(grid.getCell(rowIndex,columnIndex), rowIndex, columnIndex);
            }
        }
    }

    private void addCellRectangle(Cell cell, int rowIndex, int columnIndex) {
        Rectangle rectangleCell = new Rectangle(CELL_SIZE, CELL_SIZE);
        addStatePropertyListener(cell, rectangleCell);
        updateFill(rectangleCell, cell.getState());
        addClickEventHandler(cell, rectangleCell);
        add(rectangleCell, columnIndex, rowIndex);
    }

    private void addStatePropertyListener(Cell cell, Rectangle cellRectangle) {
        cell.getStateProperty().addListener((observable, oldValue, newValue) ->
                updateFill(cellRectangle, newValue));
    }

    private void updateFill(Rectangle cellRectangle, CellState newCellState) {
        cellRectangle.setFill(newCellState.color);
    }

    private void addClickEventHandler(Cell cell, Rectangle cellRectangle) {
        cellRectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> cell.toggleState());
    }
}
