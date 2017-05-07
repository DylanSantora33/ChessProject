package pieces;

public class King extends ChessPiece {
    private int myColor;
    private String myPieceType;

    public King(int color) {
        super();
        setMyColor(color);
        myPieceType = "queen";
    }

    public void getMoveLocations() {
        //TODO
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
