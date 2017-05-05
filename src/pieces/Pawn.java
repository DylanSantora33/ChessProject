package pieces;

/**
 * Pawn piece that extends ChessPiece.
 */
public class Pawn extends ChessPiece {
    private int myColor;
    private String myPieceType;


    public Pawn() {
        super();
    }

    public Pawn(int color) {
        super();
        myColor = color;
        myPieceType = "pawn";
    }

    public void getMoveLocations() {

    }

    public String getMyPieceType() {
        return myPieceType;
    }

    public void setMyPieceType(String pieceType) {
        myPieceType = pieceType;
    }
}
