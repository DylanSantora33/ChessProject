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
}
