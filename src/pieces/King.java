package pieces;

import location.Location;

import java.util.ArrayList;

public class King extends ChessPiece {
    private int myColor;
    private String myPieceType;
    private ArrayList<Location> moveLocations;
    private Location loc;

    public King(int color) {
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

    public ArrayList<Location> getMoveLocations() {
        int r = loc.getRow();
        int c = loc.getCol();

        Location temp = new Location();

        for (int x = r - 1; x <= r + 1; x++) {
            for (int y = c - 1; y <= y + 1; y++) {

                temp.setRow(x);
                temp.setCol(y);
                if (loc != temp && temp.isValid()) {
                    moveLocations.add(temp);


                }
            }
        }

        return moveLocations;

    }


}
    
    
    
    }
    
    
    

