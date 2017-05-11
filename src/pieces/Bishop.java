package pieces;

import java.util.ArrayList;

import location.ChessBoard;
import location.Location;

public class Bishop extends ChessPiece {
    private int myColor;
    private String myPieceType;
    private Location location;

    public Bishop(int color) {
        super();
        setMyColor(color);
        myPieceType = "bishop";
        board = null;
    }

    public void putSelfInBoard(ChessBoard b, Location l) {
        if (board == null) {
            if (l.isValid()) {
                b.put(l, this);
                board = b;
                location = l;
            }
        }
    }
}
