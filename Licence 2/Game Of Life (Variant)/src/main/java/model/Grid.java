package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


/**
 * {@link Grid} instances represent the grid in <i>The Game of Life</i>.
 */
public class Grid implements Iterable<Cell> {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final Cell[][] cells;

    /**
     * Creates a new {@code Grid} instance given the number of rows and columns.
     *
     * @param numberOfRows    the number of rows
     * @param numberOfColumns the number of columns
     * @throws IllegalArgumentException if {@code numberOfRows} or {@code numberOfColumns} are
     *                                  less than or equal to 0
     */
    public Grid(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.cells = createCells();
    }

    /**
     * Returns an iterator over the cells in this {@code Grid}.
     *
     * @return an iterator over the cells in this {@code Grid}
     */

    @Override
    public Iterator<Cell> iterator() {
        return new GridIterator(this);
    }

    private Cell[][] createCells() {
        Cell[][] cells = new Cell[getNumberOfRows()][getNumberOfColumns()];
        for (int rowIndex = 0; rowIndex < getNumberOfRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < getNumberOfColumns(); columnIndex++) {
                cells[rowIndex][columnIndex] = new Cell();
            }
        }
        return cells;
    }

    /**
     * Returns the {@link Cell} at the given index.
     *
     * <p>Note that the index is wrapped around so that a {@link Cell} is always returned.
     *
     * @param rowIndex    the row index of the {@link Cell}
     * @param columnIndex the column index of the {@link Cell}
     * @return the {@link Cell} at the given row and column index
     */
    public Cell getCell(int rowIndex, int columnIndex) {
        return cells[getWrappedRowIndex(rowIndex)][getWrappedColumnIndex(columnIndex)];
    }

    private int getWrappedRowIndex(int rowIndex) {
        return (rowIndex + getNumberOfRows()) % getNumberOfRows();
    }

    private int getWrappedColumnIndex(int columnIndex) {
        return (columnIndex + getNumberOfColumns()) % getNumberOfColumns();
    }

    /**
     * Returns the number of rows in this {@code Grid}.
     *
     * @return the number of rows in this {@code Grid}
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * Returns the number of columns in this {@code Grid}.
     *
     * @return the number of columns in this {@code Grid}
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }


    private List<Cell> getNeighbours(int rowIndex, int columnIndex) {
        List<Cell> neigh = new ArrayList<>();
        for (int row = rowIndex-1; row<=rowIndex+1; row++) {
            for (int col = columnIndex-1; col<=columnIndex+1; col++) {
                if (!(row == rowIndex && col == columnIndex)) {
                    Cell cell = getCell(row, col);
                    neigh.add(cell);
                }
            }
        }
        return neigh;
    }

    private int countAliveNeighbours(int rowIndex, int columnIndex) {
        int alive = 0;
        List<Cell> neigh = getNeighbours(rowIndex, columnIndex);
        for(int i = 0; i<neigh.size(); i++) {
            if (neigh.get(i).isAlive()) { alive++; }
        }
        return alive;
    }

    private CellState calculateNextState(int rowIndex, int columnIndex) {
        CellState nextstate;
        int alive = countAliveNeighbours(rowIndex,columnIndex);
        if (getCell(rowIndex, columnIndex).isAlive()) {
            if (alive == 2 || alive == 3) {
                nextstate = getCell(rowIndex, columnIndex).getState();
            } else {
                nextstate = CellState.DEAD;
            }
        }
        else {
            if (alive == 3) {
                if (countBlueNeighbours(rowIndex, columnIndex) >= countRedNeighbours(rowIndex, columnIndex)) {
                    nextstate = CellState.BLUE;
                } else {
                    nextstate = CellState.RED;
                }
            } else {
                nextstate = CellState.DEAD;
            }
        }
        return nextstate;
    }

    private int countRedNeighbours(int rowIndex, int columnIndex) {
        int count = 0;
        List<Cell> neigh = getNeighbours(rowIndex, columnIndex);
        for (Cell cell : neigh) {
            if (cell.getState() == CellState.RED)  { count++; }
        }
        return count;
    }

    private int countBlueNeighbours(int rowIndex, int columnIndex) {
        int count = 0;
        List<Cell> neigh = getNeighbours(rowIndex, columnIndex);
        for (Cell cell : neigh) {
            if (cell.getState() == CellState.BLUE)  { count++; }
        }
        return count;
    }

    private CellState[][] calculateNextStates() {
        CellState[][] nextCellState = new CellState[getNumberOfRows()][getNumberOfColumns()];
        for (int row = 0; row < getNumberOfRows();row++){
            for (int col =0; col < getNumberOfColumns(); col++){
                nextCellState[row][col] = calculateNextState(row, col);
            }
        }
        return nextCellState;
    }

    private void updateStates(CellState[][] nextState) {
        for (int row = 0; row < getNumberOfRows(); row++) {
            for (int col = 0; col < getNumberOfColumns(); col++) {
                cells[row][col].setState(nextState[row][col]);
            }
        }
    }

    /**
     * Transitions all {@link Cell}s in this {@code Grid} to the next generation.
     *
     * <p>The following rules are applied:
     * <ul>
     * <li>Any live {@link Cell} with fewer than two live neighbours dies, i.e. underpopulation.</li>
     * <li>Any live {@link Cell} with two or three live neighbours lives on to the next
     * generation.</li>
     * <li>Any live {@link Cell} with more than three live neighbours dies, i.e. overpopulation.</li>
     * <li>Any dead {@link Cell} with exactly three live neighbours becomes a live cell, i.e.
     * reproduction.</li>
     * </ul>
     */

    void updateToNextGeneration() {
        updateStates(calculateNextStates());
    }

    /**
     * Sets all {@link Cell}s in this {@code Grid} as dead.
     */
    void clear() {
        for (int row = 0; row < getNumberOfRows();row++) {
            for (int col = 0; col < getNumberOfColumns(); col++) {
                getCell(row, col).setState(CellState.DEAD);
            }
        }
    }

    /**
     * Goes through each {@link Cell} in this {@code Grid} and randomly sets its state as ALIVE or DEAD.
     *
     * @param random {@link Random} instance used to decide if each {@link Cell} is ALIVE or DEAD.
     * @throws NullPointerException if {@code random} is {@code null}.
     */
    void randomGeneration(Random random) {
        for (int row = 0; row < getNumberOfRows();row++) {
            for (int col = 0; col < getNumberOfColumns(); col++) {
                int rand = random.nextInt(4);
                if(rand == 0) { getCell(row, col).setState(CellState.DEAD); }
                else if(rand == 1) { getCell(row, col).setState(CellState.RED); }
                else if(rand == 2) { getCell(row, col).setState(CellState.DEAD); }
                if(rand == 3) { getCell(row, col).setState(CellState.BLUE); }
            }
        }
    }
}
