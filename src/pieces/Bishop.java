package pieces;

import java.util.ArrayList;

import location.Location;

public class Bishop extends ChessPiece {
    private int myColor;
    private String myPieceType;
    private ArrayList<Location> moveLocations;

    public Bishop(int color) {
        super();
        setMyColor(color);
        myPieceType = "bishop";
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
