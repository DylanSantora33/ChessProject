package location;

import pieces.*;
import location.Location;

import java.util.ArrayList;

public class ChessBoard {
    private int numRows;
    private int numCols;
    private Location[][] myBoard;
    private Location from;
    private Boolean moveStage;
    private Boolean turn;
    // false = black, true = white

    public ChessBoard() {
        setNumRows(8);
        setNumCols(8);
        myBoard = new Location[8][8];
        from = null;
        moveStage = false;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                myBoard[r][c] = new Location();
            }
        }
        turn = true;
    }

    public Boolean getTurn() {
        return turn;
    }

    public void setMove(Location to) {
        from = to;
        moveStage = true;
        System.out.println(from.getRow() + " " + from.getCol());
    }

    public Location getMove() {
        return from;
    }

    public void setStage(Boolean stage) {
        moveStage = stage;
    }

    public Boolean getStage() {
        return moveStage;
    }

    public ChessPiece getPiece(Location loc) {
        if (myBoard[loc.getRow()][loc.getCol()].getChessPiece() != null) {
            return myBoard[loc.getRow()][loc.getCol()].getChessPiece();
        }

        else {
            return new Pawn(0);
        }
    }

    public void update(Location to) {

        myBoard[to.getRow()][to.getCol()].setChessPiece(myBoard[from.getRow()][from.getCol()].getChessPiece());
        myBoard[from.getRow()][from.getCol()].setChessPiece(null);
        moveStage = false;
        turn = !turn;
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
                if ((r > 2) && (r < 6)) {
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
        if (loc.isInGrid()) {
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
        int r = loc.getRow();
        int c = loc.getCol();
        /*if (loc.getChessPiece().getMyPieceType() == "bishop") {
            return bishopMove(loc);
        }*/
        if (myBoard[r][c].getChessPiece().getMyPieceType() == "pawn") {
            return pawnMove(loc);
        }
        /*if (loc.getChessPiece().getMyPieceType() == "knight") {
            return knightMove(loc);
        }*/

        return null;

        /**
         * TODO: for reference https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
         *  Without offering a deep code review (as I don't have a lot of specific Java knowledge), let's look at what a full "move" entails in chess:
         *      -Player chooses piece to move.
         *      -Piece makes legal move according to its own move rules.
         *      -In addition to purely move-based rules, there's also capture logic, so a bishop cannot move from a1-h8 if there's a piece sitting on c3.
         *      -If the player was previous under check and the move does not remove the check, it must be undone.
         *      -If the move exposes check, it must be undone / disallowed.
         *      -If player captures a piece, remove the piece (including en passant!)
         *      -If the piece is a pawn reaching the back rank, promote it.
         *      -If the move is a castling, set the new position of the rook accordingly. But a king and rook can only castle if they haven't moved, so you need to keep track of that. And if the king moves through a check to castle, that's disallowed, too.
         *      -If the move results in a stalemate or checkmate, the game is over.
         */
    }

    public ArrayList<Location> bishopMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        Location locTracker = loc;
        ChessPiece bishop = loc.getChessPiece();

        locTracker.setCol(loc.getCol() + 1);
        locTracker.setRow(loc.getRow() + 1);
        while (locTracker.isInGrid()) {
            if (locTracker == null) {
                moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() + 1);
                locTracker.setRow(loc.getRow() + 1);
            }
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor()) {
                    moveLocs.add(locTracker);
                }
            }
        }

        locTracker.setCol(loc.getCol() - 1);
        locTracker.setRow(loc.getRow() - 1);
        while (locTracker.isInGrid()) {
            if (locTracker == null) {
                moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() - 1);
                locTracker.setRow(loc.getRow() - 1);
            }
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor()) {
                    moveLocs.add(locTracker);
                }
            }
        }

        locTracker.setCol(loc.getCol() + 1);
        locTracker.setRow(loc.getRow() - 1);
        while (locTracker.isInGrid()) {
            if (locTracker == null) {
                moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() + 1);
                locTracker.setRow(loc.getRow() - 1);
            }
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor()) {
                    moveLocs.add(locTracker);
                }
            }
        }

        locTracker.setCol(loc.getCol() - 1);
        locTracker.setRow(loc.getRow() + 1);
        while (locTracker.isInGrid()) {
            if (locTracker == null) {
                moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() - 1);
                locTracker.setRow(loc.getRow() + 1);
            }
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor()) {
                    moveLocs.add(locTracker);
                }
            }
        }
        return moveLocs;
    }

    public ArrayList<Location> pawnMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();

        if (myBoard[r][c].getChessPiece().getMyColor() == (-1)) {
            if (myBoard[r + 1][c].getChessPiece().getMyColor() == (0)) {
                moveLocs.add(new Location(r + 1, c));
            }
            if (r == 1 && myBoard[r + 1][c].getChessPiece().getMyColor() == (0)) {
                moveLocs.add(new Location(r + 2, c));
            }
            if (myBoard[r + 1][c - 1].getChessPiece().getMyColor() == (1)) {
                moveLocs.add(new Location(r + 1, c - 1));
            }
            if (myBoard[r + 1][c + 1].getChessPiece().getMyColor() == (1)) {
                moveLocs.add(new Location(r + 1, c + 1));
            }

        }
        if (myBoard[r][c].getChessPiece().getMyColor() == (1)) {

            if (myBoard[r - 1][c].getChessPiece().getMyColor() == (0)) {
                moveLocs.add(new Location(r - 1, c));
            }
            if (r == 6 && myBoard[r - 1][c].getChessPiece().getMyColor() == (0)) {
                moveLocs.add(new Location(r - 2, c));
            }
            if (myBoard[r - 1][c - 1].getChessPiece().getMyColor() == (-1)) {
                moveLocs.add(new Location(r - 1, c - 1));
            }
            if (myBoard[r - 1][c + 1].getChessPiece().getMyColor() == (-1)) {
                moveLocs.add(new Location(r - 1, c + 1));
            }
        }
        return moveLocs;

    }

    public ArrayList<Location> knightMove(Location loc) {
        return null;
    }

    public ArrayList<Location> queenMove(Location loc) {
        //TODO: modify this bishop code to fit queen move pattern

        ArrayList<Location> moveLocs = new ArrayList<Location>();
        Location locTracker = loc;
        ChessPiece bishop = loc.getChessPiece();

        locTracker.setCol(loc.getCol() + 1);
        locTracker.setRow(loc.getRow() + 1);
        while (locTracker.isInGrid()) {
            if (locTracker == null) {
                moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() + 1);
                locTracker.setRow(loc.getRow() + 1);
            }
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor()) {
                    moveLocs.add(locTracker);
                }
            }
        }

        locTracker.setCol(loc.getCol() - 1);
        locTracker.setRow(loc.getRow() - 1);
        while (locTracker.isInGrid()) {
            if (locTracker == null) {
                moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() - 1);
                locTracker.setRow(loc.getRow() - 1);
            }
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor()) {
                    moveLocs.add(locTracker);
                }
            }
        }

        locTracker.setCol(loc.getCol() + 1);
        locTracker.setRow(loc.getRow() - 1);
        while (locTracker.isInGrid()) {
            if (locTracker == null) {
                moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() + 1);
                locTracker.setRow(loc.getRow() - 1);
            }
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor()) {
                    moveLocs.add(locTracker);
                }
            }
        }

        locTracker.setCol(loc.getCol() - 1);
        locTracker.setRow(loc.getRow() + 1);
        while (locTracker.isInGrid()) {
            if (locTracker == null) {
                moveLocs.add(locTracker);
                locTracker.setCol(loc.getCol() - 1);
                locTracker.setRow(loc.getRow() + 1);
            }
            else {
                if (bishop.getMyColor() != locTracker.getChessPiece().getMyColor()) {
                    moveLocs.add(locTracker);
                }
            }
        }

        return moveLocs;
    }

    public ArrayList<Location> kingMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        Location locTracker = loc;

        locTracker.setRow(loc.getRow() - 1);
        if (locTracker.isInGrid() && loc.getChessPiece().getMyColor() != locTracker.getChessPiece().getMyColor()) {
            moveLocs.add(locTracker);
        }

        locTracker.setRow(loc.getRow() + 1);
        if (locTracker.isInGrid() && loc.getChessPiece().getMyColor() != locTracker.getChessPiece().getMyColor()) {
            moveLocs.add(locTracker);
        }

        locTracker.setRow(loc.getCol() - 1);
        if (locTracker.isInGrid() && loc.getChessPiece().getMyColor() != locTracker.getChessPiece().getMyColor()) {
            moveLocs.add(locTracker);
        }

        locTracker.setRow(loc.getCol() + 1);
        if (locTracker.isInGrid() && loc.getChessPiece().getMyColor() != locTracker.getChessPiece().getMyColor()) {
            moveLocs.add(locTracker);
        }

        //TODO: capture pieces at diagonals (think im done)
        locTracker.setRow(loc.getRow() - 1);
        locTracker.setCol(loc.getCol() - 1);
        if (locTracker.isInGrid() && loc.getChessPiece().getMyColor() != locTracker.getChessPiece().getMyColor()) {
            moveLocs.add(locTracker);
        }

        locTracker.setRow(loc.getRow() - 1);
        locTracker.setCol(loc.getCol() + 1);
        if (locTracker.isInGrid() && loc.getChessPiece().getMyColor() != locTracker.getChessPiece().getMyColor()) {
            moveLocs.add(locTracker);
        }
        return moveLocs;
    }


}
