package pieces;

import location.Location;

import java.util.ArrayList;

public class Queen extends ChessPiece {
    private int myColor;
    private String myPieceType;

    public Queen(int color) {
        super();
        setMyColor(color);
        myPieceType = "queen";
    }

    public int getMyColor() {
        return myColor;
    }

    public void setMyColor(int color) {
        myColor = color;
    }

    public String getMyPieceType() {
        return myPieceType;
    }

    public void setMyPieceType(String pieceType) {
        myPieceType = pieceType;
    }
}
