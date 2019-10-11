package model;

import java.util.Iterator;

/**
 * {@link GridIterator} instances are used to iterate over the cells of a grid.
 */
public class GridIterator implements Iterator<Cell> {
    private int rowIndex;
    private int columnIndex;
    private Grid grid;

    GridIterator(Grid grid) {
        this.rowIndex = 0;
        this.columnIndex = 0;
        this.grid = grid;
    }

    @Override
    public boolean hasNext() {
        return columnIndex < grid.getNumberOfColumns() && rowIndex < grid.getNumberOfRows();
    }

    @Override
    public Cell next() {
        final Cell result = grid.getCell(rowIndex, columnIndex);
        columnIndex = (columnIndex +1) % grid.getNumberOfColumns();
        if(columnIndex == 0){
            rowIndex++;
        }
        return result;
    }
}
