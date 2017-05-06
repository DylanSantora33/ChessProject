package board;

import pieces.ChessPiece;

public class Location {
	private int myRow;
	private int myCol;
	private ChessPiece myChessPiece;
	
	public Location() {
		setRow(0);
		setCol(0);
		setChessPiece(null);
	}
	
	public Location(int row, int col, ChessPiece piece) {
		setRow(row);
		setCol(col);
		setChessPiece(piece);
	}

	public int getCol() {
		return myCol;
	}

	public void setCol(int col) {
		myCol = col;
	}

	public int getRow() {
		return myRow;
	}

	public void setRow(int row) {
		myRow = row;
	}
	
	public boolean equals(Location loc) {
		if((myCol==loc.getCol())&&(myRow==loc.getRow()))
		{
			return true;
		}
		return false;
	}
	
	public ChessPiece getChessPiece() {
		return myChessPiece;
	}
	
	public void setChessPiece(ChessPiece piece) {
		myChessPiece = piece;	
	}
}
