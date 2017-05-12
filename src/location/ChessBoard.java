package location;
import pieces.*;

public class ChessBoard {
    private int numRows;
    private int numCols;
    private Location[][] myBoard;
    private GUI myGUI;
    private location pressedButton;

    public ChessBoard() {
        setNumRows(8);
        setNumCols(8);
        myBoard = new Location[8][8];
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

    public Location[][] getMyBoard() {
        return myBoard;
    }

    public void put(Location loc, ChessPiece piece) {
        if (loc.isValid()) {
            if (loc.getChessPiece() != null) {
                loc.setChessPiece(null);
            }
            int row = loc.getRow();
            int col = loc.getCol();
            myBoard[row][col].setChessPiece(piece);
        }
    }

    public ArrayList<Location> getValidMoveLocations(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        if (loc.getChessPiece().getMyPieceType() == "bishop") {
            return bishopMove(loc);
        }
        if (loc.getChessPiece().getMyPieceType() == "pawn") {
            return pawnMove(loc);
        }
        if (loc.getChessPiece().getMyPieceType() == "knight") {
            return knightMove(loc);
        }
    }


    public ArrayList<Location> bishopMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        Location locTracker = loc;
        ChessPiece bishop = loc.getChessPiece();

        locTracker.setCol(loc.getCol() + 1);
        locTracker.setRow(loc.getRow() + 1);
        while (locTracker.isValid()) {
            if (locTracker == null)
                moveLocs.add(locTracker);
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor())
                    moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() + 1);
                locTracker.setRow(loc.getRow() + 1);
            }
        }

        locTracker.setCol(loc.getCol() - 1);
        locTracker.setRow(loc.getRow() - 1);
        while (locTracker.isValid()) {
            if (locTracker == null)
                moveLocs.add(locTracker);
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor())
                    moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() - 1);
                locTracker.setRow(loc.getRow() - 1);
            }
        }

        locTracker.setCol(loc.getCol() + 1);
        locTracker.setRow(loc.getRow() - 1);
        while (locTracker.isValid()) {
            if (locTracker == null)
                moveLocs.add(locTracker);
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor())
                    moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() + 1);
                locTracker.setRow(loc.getRow() - 1);
            }
        }

        locTracker.setCol(loc.getCol() - 1);
        locTracker.setRow(loc.getRow() + 1);
        while (locTracker.isValid()) {
            if (locTracker == null)
                moveLocs.add(locTracker);
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor())
                    moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() - 1);
                locTracker.setRow(loc.getRow() + 1);
            }
        }
        return null;

    }

    public ArrayList<Location> pawnMove(Location loc) {
        return null;
    }

    public ArrayList<Location> knightMove(Location loc) {
        return null;
    }
    
    public void setPressedButton(Location loc)
    {
        
    }

}
