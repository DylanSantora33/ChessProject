package pieces;

import location.Location;

import java.util.ArrayList;

public class Rook extends ChessPiece {
    private int myColor;
    private String myPieceType;
    private ArrayList<Location> moveLocations;

    public Rook(int color) {
        super();
        setMyColor(color);
        myPieceType = "rook";
    }

    public void getMoveLocations() {
        //TODO
        moveLocations = new ArrayList<Location>();
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
