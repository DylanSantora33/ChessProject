package pieces;

/**
 *  Chess Piece class that all pieces will extend.
 */

public class ChessPiece {
    private int myColor;
    private String myPieceType;

    public ChessPiece() {
        myColor = -1;
        myPieceType = "n/a";
    }

    public ChessPiece(int color, String pieceType) {
        myColor = color;
        myPieceType = pieceType;
    }

}
