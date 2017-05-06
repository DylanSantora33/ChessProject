package board;

import pieces.ChessPiece;
import board.Location;

public class ChessBoard {
	private int numRows;
	private int numCols;
	private Locations[][] myBoard = new Locations[8][8];
	
	public ChessBoard() {
		setNumRows(8);
		setNumCols(8);
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
	
	public boolean isValid(Location loc) {
		if ((loc.getRow()>=0)&&(loc.getRow()<numRows))
		{
			if ((loc.getCol()>=0)&&(loc.getCol()<numCols))
			{
				return true;
			}
		}
	return false;
	}
	
	public ChessPiece put(Location loc, ChessPiece piece) {
		if (loc.isValid())
		{
			int row = loc.getRow();
			int col = loc.getCol();
			Location[row][col].setChessPiece(piece);			
		}
	}
}
