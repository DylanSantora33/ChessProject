package pieces;

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
