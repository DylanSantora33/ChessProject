package board;

import pieces.*;

public class ChessBoard {
    private int numRows;
    private int numCols;
    private Location[][] myBoard = new Location[8][8];

    public ChessBoard() {
        setNumRows(8);
        setNumCols(8);
    }

    public void populate() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                myBoard[r][c].setRow(r);
                myBoard[r][c].setCol(c);
                if (r == 1) {
                    myBoard[r][c].setChessPiece(new Pawn(-1));
                }
                if (r == 6) {
                    myBoard[r][c].setChessPiece(new Pawn(1));
                }
                if ((r == 0) && ((c == 0) || (c == 7))) {
                    myBoard[r][c].setChessPiece(new Rook(-1));
                }
                if ((r == 0) && ((c == 1) || (c == 6))) {
                    myBoard[r][c].setChessPiece(new Knight(-1));
                }
                if ((r == 0) && ((c == 2) || (c == 5))) {
                    myBoard[r][c].setChessPiece(new Bishop(-1));
                }
                if ((r == 0) && (c == 3)) {
                    myBoard[r][c].setChessPiece(new Queen(-1));
                }
                if ((r == 0) && (c == 4)) {
                    myBoard[r][c].setChessPiece(new King(-1));
                }
                if ((r == 7) && ((c == 0) || (c == 7))) {
                    myBoard[r][c].setChessPiece(new Rook(1));
                }
                if ((r == 7) && ((c == 1) || (c == 6))) {
                    myBoard[r][c].setChessPiece(new Knight(1));
                }
                if ((r == 7) && ((c == 2) || (c == 5))) {
                    myBoard[r][c].setChessPiece(new Bishop(1));
                }
                if ((r == 7) && (c == 3)) {
                    myBoard[r][c].setChessPiece(new Queen(1));
                }
                if ((r == 7) && (c == 4)) {
                    myBoard[r][c].setChessPiece(new King(1));
                }
                if ((r >= 2) && (r <= 6)) {
                    myBoard[r][c].setChessPiece(null);
                }
            }
        }
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
        if ((loc.getRow() >= 0) && (loc.getRow() < numRows)) {
            if ((loc.getCol() >= 0) && (loc.getCol() < numCols)) {
                return true;
            }
        }
        return false;
    }

    public void put(Location loc, ChessPiece piece) {
        if (loc.isValid()) {
        	if (loc.getChessPiece()!=null)
        	{
        		loc.setChessPiece(null);
        	}
            int row = loc.getRow();
            int col = loc.getCol();
            myBoard[row][col].setChessPiece(piece);
        }
    }
}
