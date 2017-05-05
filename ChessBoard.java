package board;

public class ChessBoard {
	private int numRows;
	private int numCols;
	
	public ChessBoard() {
		setNumRows(0);
		setNumCols(0);
	}
	
	public ChessBoard(int rows, int cols) {
		setNumRows(rows);
		setNumCols(cols);
	}

	public int getNumCols() {
		return numCols;
	}

	public void setNumCols(int cols) {
		numCols = cols;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int rows) {
		numRows = rows;
	}	
}
