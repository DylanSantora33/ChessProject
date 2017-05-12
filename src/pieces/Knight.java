package pieces;

public class Knight extends ChessPiece {
    private int myColor;
    private String myPieceType;

    public Knight(int color) {
        super();
        setMyColor(color);
        myPieceType = "knight";
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
