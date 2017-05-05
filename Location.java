package board;

public class Location {
	private int myRow;
	private int myCol;
	
	public Location() {
		setRow(0);
		setCol(0);
	}
	
	public Location(int row, int col) {
		setRow(row);
		setCol(col);
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
}
