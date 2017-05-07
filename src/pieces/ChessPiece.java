package pieces;

/**
 * Chess Piece class that all pieces will extend.
 */

public class ChessPiece {
    private int myColor; //-1 is black, 1 is white
    private String myPieceType; //always lower case

    public ChessPiece() {
        myColor = -1;
        myPieceType = "n/a";
    }

    public ChessPiece(int color) {
        myColor = color;
        myPieceType = "n/a";
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

    public void move() {
        // TODO
    }

    public void processActors() {
        // TODO, change method signature
        /**
         * processActors remains same across all pieces:
         * every piece will capture pieces in the same way
         */
    }

    public void getMoveLocations() {
        // TODO, change method signature
        /**
         * getMoveLocation from piece to piece:
         * every piece has a different movement pattern
         */
    }

}
