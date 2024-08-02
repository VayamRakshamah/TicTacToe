package Models;

public class Cell {

    private Player player;

    private CellState cellState;

    private int row;
    private int column;

    public Cell(int i, int j) {
        this.row = i;
        this.column = j;
        this.cellState = CellState.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
