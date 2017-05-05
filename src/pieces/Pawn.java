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

    public Pawn(int color, String pieceType) {
        super(color, pieceType);
    }

}
