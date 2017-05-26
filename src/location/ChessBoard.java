package location;

import pieces.*;
import location.Location;

import java.util.ArrayList;

public class ChessBoard {
    private int numRows;
    private int numCols;
    private Location[][] myBoard;
    private Location from;
    private Boolean moveStage;
    private Boolean turn;
    // false = black, true = white
    private Boolean whiteKingHasMoved;
    private Boolean blackKingHasMoved;
    private Boolean whiteLeftRookHasMoved;
    private Boolean whiteRightRookHasMoved;
    private Boolean whiteInCheck;
    private Boolean blackInCheck;

    public Boolean isWhiteInCheck(Location loc) {
    	ArrayList<Location> possibleLocsDiag = new ArrayList<Location>();
    	ArrayList<Location> possibleLocsStraight = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        ArrayList<Location> moveLocs90 = rookMove90(loc);
        ArrayList<Location> moveLocs180 = rookMove180(loc);
        ArrayList<Location> moveLocs270 = rookMove270(loc);
        ArrayList<Location> moveLocs360 = rookMove360(loc);
        ArrayList<Location> moveLocs45 = bishopMove45(loc);
        ArrayList<Location> moveLocs135 = bishopMove135(loc);
        ArrayList<Location> moveLocs225 = bishopMove225(loc);
        ArrayList<Location> moveLocs315 = bishopMove315(loc);

        if (!moveLocs90.isEmpty())
        {
        	System.out.println("90");
        	possibleLocsStraight.add(moveLocs90.get(moveLocs90.size() - 1));
        }
        if (!moveLocs180.isEmpty())
        {
        	System.out.println("180");
        	possibleLocsStraight.add(moveLocs180.get(moveLocs180.size() - 1));
        }
        if (!moveLocs270.isEmpty())
        {
        	System.out.println("270");
        	possibleLocsStraight.add(moveLocs270.get(moveLocs270.size() - 1));
        }
        if (!moveLocs360.isEmpty())
        {
        	System.out.println("360");
        	possibleLocsStraight.add(moveLocs360.get(moveLocs360.size() - 1));
        }
        if (!moveLocs45.isEmpty())
        {
        	System.out.println("45");
        	possibleLocsDiag.add(moveLocs45.get(moveLocs45.size() - 1));
        }
        if (!moveLocs135.isEmpty())
        {
        	System.out.println("135");
        	possibleLocsDiag.add(moveLocs135.get(moveLocs135.size() - 1));
        }
        if (!moveLocs225.isEmpty())
        {
        	System.out.println("225");
        	possibleLocsDiag.add(moveLocs225.get(moveLocs225.size() - 1));
        }
        if (!moveLocs315.isEmpty())
        {
        	System.out.println("315");
        	possibleLocsDiag.add(moveLocs315.get(moveLocs315.size() - 1));
        }
        
        if (!possibleLocsStraight.isEmpty())
	        for (Location possibleLoc : possibleLocsStraight)
	        {
	        	int possibleR = possibleLoc.getRow();
	        	int possibleC = possibleLoc.getCol();
	        	if (myBoard[possibleR][possibleC].getChessPiece().getMyColor()==(-1))
	        	{
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="rook")
	        		{
	                	System.out.println("rook checking");
	        			return true;
	        		}
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="queen")
	        		{
	                	System.out.println("queen checking");
	        			return true;
	        		}
	        	}
	        }
        if (!possibleLocsDiag.isEmpty())
	        for (Location possibleLoc : possibleLocsDiag)
	        {
	        	int possibleR = possibleLoc.getRow();
	        	int possibleC = possibleLoc.getCol();
	        	if (myBoard[possibleR][possibleC].getChessPiece().getMyColor()==(-1))
	        	{
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="pawn")
	        		{
	        			if ((possibleR + 1)==loc.getRow() && (possibleC + 1)==loc.getCol())
	        			{
		                	System.out.println("pawn checking");
		        			return true;
	        			}
	        			if ((possibleR + 1)==loc.getRow() && (possibleC - 1)==loc.getCol())
	        			{
		                	System.out.println("pawn checking");
		        			return true;
	        			}
	        		}
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="bishop")
	        		{
	                	System.out.println("bishop checking");
	        			return true;
	        		}
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="queen")
	        		{
	        			System.out.println("queen checking");
	        			return true;
	        		}
	        	}
	        }
			return false;    	
    }
    
    public Boolean isBlackInCheck(Location loc) {
    	ArrayList<Location> possibleLocsDiag = new ArrayList<Location>();
    	ArrayList<Location> possibleLocsStraight = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        ArrayList<Location> moveLocs90 = rookMove90(loc);
        ArrayList<Location> moveLocs180 = rookMove180(loc);
        ArrayList<Location> moveLocs270 = rookMove270(loc);
        ArrayList<Location> moveLocs360 = rookMove360(loc);
        ArrayList<Location> moveLocs45 = bishopMove45(loc);
        ArrayList<Location> moveLocs135 = bishopMove135(loc);
        ArrayList<Location> moveLocs225 = bishopMove225(loc);
        ArrayList<Location> moveLocs315 = bishopMove315(loc);

        if (!moveLocs90.isEmpty())
        {
        	System.out.println("90");
        	possibleLocsStraight.add(moveLocs90.get(moveLocs90.size() - 1));
        }
        if (!moveLocs180.isEmpty())
        {
        	System.out.println("180");
        	possibleLocsStraight.add(moveLocs180.get(moveLocs180.size() - 1));
        }
        if (!moveLocs270.isEmpty())
        {
        	System.out.println("270");
        	possibleLocsStraight.add(moveLocs270.get(moveLocs270.size() - 1));
        }
        if (!moveLocs360.isEmpty())
        {
        	System.out.println("360");
        	possibleLocsStraight.add(moveLocs360.get(moveLocs360.size() - 1));
        }
        if (!moveLocs45.isEmpty())
        {
        	System.out.println("45");
        	possibleLocsDiag.add(moveLocs45.get(moveLocs45.size() - 1));
        }
        if (!moveLocs135.isEmpty())
        {
        	System.out.println("135");
        	possibleLocsDiag.add(moveLocs135.get(moveLocs135.size() - 1));
        }
        if (!moveLocs225.isEmpty())
        {
        	System.out.println("225");
        	possibleLocsDiag.add(moveLocs225.get(moveLocs225.size() - 1));
        }
        if (!moveLocs315.isEmpty())
        {
        	System.out.println("315");
        	possibleLocsDiag.add(moveLocs315.get(moveLocs315.size() - 1));
        }
        
        if (!possibleLocsStraight.isEmpty())
	        for (Location possibleLoc : possibleLocsStraight)
	        {
	        	int possibleR = possibleLoc.getRow();
	        	int possibleC = possibleLoc.getCol();
	        	if (myBoard[possibleR][possibleC].getChessPiece().getMyColor()==(1))
	        	{
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="rook")
	        		{
	                	System.out.println("rook checking");
	        			return true;
	        		}
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="queen")
	        		{
	                	System.out.println("queen checking");
	        			return true;
	        		}
	        	}
	        }
        if (!possibleLocsDiag.isEmpty())
	        for (Location possibleLoc : possibleLocsDiag)
	        {
	        	int possibleR = possibleLoc.getRow();
	        	int possibleC = possibleLoc.getCol();
	        	if (myBoard[possibleR][possibleC].getChessPiece().getMyColor()==(1))
	        	{
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="pawn")
	        		{
	        			if ((possibleR - 1)==loc.getRow() && (possibleC + 1)==loc.getCol())
	        			{
		                	System.out.println("pawn checking");
		        			return true;
	        			}
	        			if ((possibleR - 1)==loc.getRow() && (possibleC - 1)==loc.getCol())
	        			{
		                	System.out.println("pawn checking");
		        			return true;
	        			}
	        		}
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="bishop")
	        		{
	                	System.out.println("bishop checking");
	        			return true;
	        		}
	        		if (myBoard[possibleR][possibleC].getChessPiece().getMyPieceType()=="queen")
	        		{
	        			System.out.println("queen checking");
	        			return true;
	        		}
	        	}
	        }
			return false;
    }
    
    

    public ChessBoard() {
        setNumRows(8);
        setNumCols(8);
        myBoard = new Location[8][8];
        from = null;
        moveStage = false;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                myBoard[r][c] = new Location();
            }
        }
        turn = true;
        whiteKingHasMoved = false;
        blackKingHasMoved = false;
        whiteLeftRookHasMoved = false;
        whiteRightRookHasMoved = false;
    }

    public Boolean getTurn() {
        return turn;
    }
    
    public boolean getWKHM() {
    	return whiteKingHasMoved;
    }

    public void setWKHM() {
        whiteKingHasMoved = true;
    }

    public void setBKHM() {
        blackKingHasMoved = true;
    }

    public void setWLRHM() {
        whiteLeftRookHasMoved = true;
    }
    
    public boolean getWLRHM() {
    	return whiteLeftRookHasMoved;
    }

    public void setWRRHM() {
        whiteRightRookHasMoved = true;
    }

    public void setMove(Location to) {
        from = to;
        moveStage = true;
        System.out.println(from.getRow() + " " + from.getCol());
    }

    public Location getMove() {
        return from;
    }

    public void setStage(Boolean stage) {
        moveStage = stage;
    }

    public Boolean getStage() {
        return moveStage;
    }

    public ChessPiece getPiece(Location loc) {
        if (myBoard[loc.getRow()][loc.getCol()].getChessPiece() != null) {
            return myBoard[loc.getRow()][loc.getCol()].getChessPiece();
        }

        else {
            return null;
        }
    }

    public void update(Location to) {
        ChessPiece fromPiece = myBoard[from.getRow()][from.getCol()].getChessPiece();
        ChessPiece toPiece = myBoard[to.getRow()][to.getCol()].getChessPiece();
        myBoard[to.getRow()][to.getCol()].setChessPiece(fromPiece);
        myBoard[from.getRow()][from.getCol()].setChessPiece(toPiece);
        moveStage = false;
        turn = !turn;
        System.out.println("from: " + from.getRow() + " " + from.getCol());
    }

    public void populate() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                myBoard[r][c].setRow(r);
                myBoard[r][c].setCol(c);
                if (r == 1) {
                    myBoard[r][c].setChessPiece(new Pawn(-1));
                }
                if (r == 6) {
                    myBoard[r][c].setChessPiece(new Pawn(1));
                }
                if ((r == 0) && ((c == 0) || (c == 7))) {
                    myBoard[r][c].setChessPiece(new Rook(-1));
                }
                if ((r == 0) && ((c == 1) || (c == 6))) {
                    myBoard[r][c].setChessPiece(new Knight(-1));
                }
                if ((r == 0) && ((c == 2) || (c == 5))) {
                    myBoard[r][c].setChessPiece(new Bishop(-1));
                }
                if ((r == 0) && (c == 3)) {
                    myBoard[r][c].setChessPiece(new Queen(-1));
                }
                if ((r == 0) && (c == 4)) {
                    myBoard[r][c].setChessPiece(new King(-1));
                }
                if ((r == 7) && ((c == 0) || (c == 7))) {
                    myBoard[r][c].setChessPiece(new Rook(1));
                }
                if ((r == 7) && ((c == 1) || (c == 6))) {
                    myBoard[r][c].setChessPiece(new Knight(1));
                }
                if ((r == 7) && ((c == 2) || (c == 5))) {
                    myBoard[r][c].setChessPiece(new Bishop(1));
                }
                if ((r == 7) && (c == 3)) {
                    myBoard[r][c].setChessPiece(new Queen(1));
                }
                if ((r == 7) && (c == 4)) {
                    myBoard[r][c].setChessPiece(new King(1));
                }
                if ((r >= 2) && (r <= 5)) {
                    myBoard[r][c].setChessPiece(new ChessPiece(0));
                }
            }
        }
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int cols) {
        numCols = cols;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int rows) {
        numRows = rows;
    }

    public boolean isValid(Location loc) {
        if ((loc.getRow() >= 0) && (loc.getRow() < numRows)) {
            if ((loc.getCol() >= 0) && (loc.getCol() < numCols)) {
                return true;
            }
        }
        return false;
    }

    public Location[][] getMyBoard() {
        return myBoard;
    }

    public void put(Location loc, ChessPiece piece) {
        if (loc.isInGrid()) {
            if (loc.getChessPiece() != null) {
                loc.setChessPiece(null);
            }
            int row = loc.getRow();
            int col = loc.getCol();
            myBoard[row][col].setChessPiece(piece);
        }
    }

    public Location promotion() {
        for (int c = 0; c < 8; c++) {
            if (myBoard[0][c].getChessPiece().getMyPieceType() == ("pawn") && myBoard[0][c].getChessPiece().getMyColor() == 1) {
                myBoard[0][c].setChessPiece(new Queen(1));
                Location promLoc = new Location(0, c);
                return promLoc;
            }
            if (myBoard[7][c].getChessPiece().getMyPieceType() == ("pawn") && myBoard[7][c].getChessPiece().getMyColor() == -1) {
                myBoard[7][c].setChessPiece(new Queen(-1));
                Location promLoc = new Location(7, c);
                return promLoc;
            }
        }
        return new Location(4, 4);
    }

    public ArrayList<Location> getValidMoveLocations(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        if (myBoard[r][c].getChessPiece().getMyPieceType() == "bishop") {
            return bishopMove(loc);
        }
        if (myBoard[r][c].getChessPiece().getMyPieceType() == "pawn") {
            return pawnMove(loc);
        }
        if (myBoard[r][c].getChessPiece().getMyPieceType() == "rook") {
            return rookMove(loc);
        }
        if (myBoard[r][c].getChessPiece().getMyPieceType() == "queen") {
            return queenMove(loc);
        }
        if (myBoard[r][c].getChessPiece().getMyPieceType() == "king") {
            return kingMove(loc);
        }
        if (myBoard[r][c].getChessPiece().getMyPieceType() == "knight") {
            return knightMove(loc);
        }
        return null;
    }

    public ArrayList<Location> bishopMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        Location locTracker = loc;
        ChessPiece bishop = loc.getChessPiece();
        int r = loc.getRow();
        int c = loc.getCol();

        ArrayList<Location> moveLocs45 = bishopMove45(loc);
        ArrayList<Location> moveLocs135 = bishopMove135(loc);
        ArrayList<Location> moveLocs225 = bishopMove225(loc);
        ArrayList<Location> moveLocs315 = bishopMove315(loc);

        for (Location loc45 : moveLocs45) {
            moveLocs.add(loc45);
        }
        for (Location loc135 : moveLocs135) {
            moveLocs.add(loc135);
        }
        for (Location loc225 : moveLocs225) {
            moveLocs.add(loc225);
        }
        for (Location loc315 : moveLocs315) {
            moveLocs.add(loc315);
        }
        return moveLocs;
    }

    public ArrayList<Location> bishopMove45(Location loc) {
        ArrayList<Location> moveLocs45 = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int tempR = r - 1;
        int tempC = c + 1;
        int bishopColor = myBoard[r][c].getChessPiece().getMyColor();
        System.out.println(bishopColor);
        Boolean blocked45 = false;
        while (blocked45 == false) {
            if ((tempR < 8) && (tempR > -1)) {
                if ((tempC < 8) && (tempC > -1)) {
                    if ((myBoard[tempR][tempC].getChessPiece().getMyColor() == bishopColor) && (!blocked45)) {
                        System.out.println("same color");
                        blocked45 = true;
                        break;
                    }
                    else if ((myBoard[tempR][tempC].getChessPiece().getMyColor() == (0)) && (!blocked45)) {
                        System.out.println("color is 0");
                        moveLocs45.add(new Location(tempR, tempC));
                        System.out
                                .println("tempR:" + tempR + " tempC:" + tempC);
                    }

                    else if ((myBoard[tempR][tempC].getChessPiece().getMyColor() - bishopColor) == -2
                            || (myBoard[tempR][tempC].getChessPiece().getMyColor() - bishopColor) == 2
                            && (!blocked45)) {
                        System.out.println("-2 || +2");
                        blocked45 = true;
                        moveLocs45.add(new Location(tempR, tempC));
                        System.out.println("tempR: " + tempR + "tempC: " + tempC);
                    }
                }
            }
            if (!blocked45) {
                tempR--;
                tempC++;
            }

            if (blocked45) {
                break;
            }

            if (!((tempR < 8) && (tempR > -1)) || !(tempC < 8) && (tempC > -1)) {
                blocked45 = true;
            }
        }
        return moveLocs45;
    }

    public ArrayList<Location> bishopMove135(Location loc) {
        ArrayList<Location> moveLocs135 = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int tempR = r + 1;
        int tempC = c + 1;
        int bishopColor = myBoard[r][c].getChessPiece().getMyColor();
        System.out.println(bishopColor);
        Boolean blocked135 = false;
        while (blocked135 == false) {
            if ((tempR < 8) && (tempR > -1)) {
                if ((tempC < 8) && (tempC > -1)) {
                    if ((myBoard[tempR][tempC].getChessPiece().getMyColor() == bishopColor) && (!blocked135)) {
                        System.out.println("same color");
                        blocked135 = true;
                        break;
                    }
                    else if ((myBoard[tempR][tempC].getChessPiece()
                            .getMyColor() == (0)) && (!blocked135)) {
                        System.out.println("color is 0");
                        moveLocs135.add(new Location(tempR, tempC));
                        System.out
                                .println("tempR:" + tempR + " tempC:" + tempC);
                    }

                    else if ((myBoard[tempR][tempC].getChessPiece()
                            .getMyColor() - bishopColor) == -2
                            || (myBoard[tempR][tempC].getChessPiece()
                            .getMyColor() - bishopColor) == 2
                            && (!blocked135)) {
                        System.out.println("-2 || +2");
                        blocked135 = true;
                        moveLocs135.add(new Location(tempR, tempC));
                        System.out.println("tempR: " + tempR + "tempC: "
                                + tempC);
                    }
                }
            }
            if (!blocked135) {
                tempR++;
                tempC++;
            }

            if (blocked135) {
                break;
            }

            if (!((tempR < 8) && (tempR > -1)) || !(tempC < 8) && (tempC > -1)) {
                blocked135 = true;
            }

        }
        return moveLocs135;
    }

    public ArrayList<Location> bishopMove225(Location loc) {
        ArrayList<Location> moveLocs225 = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int tempR = r + 1;
        int tempC = c - 1;
        int bishopColor = myBoard[r][c].getChessPiece().getMyColor();
        System.out.println(bishopColor);
        Boolean blocked225 = false;
        while (blocked225 == false) {
            if ((tempR < 8) && (tempR > -1)) {
                if ((tempC < 8) && (tempC > -1)) {
                    if ((myBoard[tempR][tempC].getChessPiece().getMyColor() == bishopColor) && (!blocked225)) {
                        System.out.println("same color");
                        blocked225 = true;
                        break;
                    }
                    else if ((myBoard[tempR][tempC].getChessPiece().getMyColor() == (0)) && (!blocked225)) {
                        System.out.println("color is 0");
                        moveLocs225.add(new Location(tempR, tempC));
                        System.out
                                .println("tempR:" + tempR + " tempC:" + tempC);
                    }

                    else if ((myBoard[tempR][tempC].getChessPiece().getMyColor() - bishopColor) == -2
                            || (myBoard[tempR][tempC].getChessPiece().getMyColor() - bishopColor) == 2
                            && (!blocked225)) {
                        System.out.println("-2 || +2");
                        blocked225 = true;
                        moveLocs225.add(new Location(tempR, tempC));
                        System.out.println("tempR: " + tempR + "tempC: "
                                + tempC);
                    }
                }
            }
            if (!blocked225) {
                tempR++;
                tempC--;
            }

            if (blocked225) {
                break;
            }

            if (!((tempR < 8) && (tempR > -1)) || !(tempC < 8) && (tempC > -1)) {
                blocked225 = true;
            }

        }
        return moveLocs225;
    }

    public ArrayList<Location> bishopMove315(Location loc) {
        ArrayList<Location> moveLocs315 = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int tempR = r - 1;
        int tempC = c - 1;
        int bishopColor = myBoard[r][c].getChessPiece().getMyColor();
        System.out.println(bishopColor);
        Boolean blocked315 = false;
        while (blocked315 == false) {
            if ((tempR < 8) && (tempR > -1)) {
                if ((tempC < 8) && (tempC > -1)) {
                    if ((myBoard[tempR][tempC].getChessPiece().getMyColor() == bishopColor) && (!blocked315)) {
                        System.out.println("same color");
                        blocked315 = true;
                        break;
                    }
                    else if ((myBoard[tempR][tempC].getChessPiece()
                            .getMyColor() == (0)) && (!blocked315)) {
                        System.out.println("color is 0");
                        moveLocs315.add(new Location(tempR, tempC));
                        System.out
                                .println("tempR:" + tempR + " tempC:" + tempC);
                    }

                    else if ((myBoard[tempR][tempC].getChessPiece()
                            .getMyColor() - bishopColor) == -2
                            || (myBoard[tempR][tempC].getChessPiece()
                            .getMyColor() - bishopColor) == 2
                            && (!blocked315)) {
                        System.out.println("-2 || +2");
                        blocked315 = true;
                        moveLocs315.add(new Location(tempR, tempC));
                        System.out.println("tempR: " + tempR + "tempC: "
                                + tempC);
                    }
                }
            }
            if (!blocked315) {
                tempR--;
                tempC--;
            }

            if (blocked315) {
                break;
            }

            if (!((tempR < 8) && (tempR > -1)) || !(tempC < 8) && (tempC > -1)) {
                blocked315 = true;
            }

        }
        return moveLocs315;
    }

    public ArrayList<Location> pawnMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        System.out.println("in pawnMove");

        if (myBoard[r][c].getChessPiece().getMyColor() == -1) {
            if (myBoard[r + 1][c].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r + 1, c));
            }
            if (r == 1 && myBoard[r + 1][c].getChessPiece().getMyColor() == 0) {
                if (myBoard[r + 2][c].getChessPiece().getMyColor() == 0) {
                    moveLocs.add(new Location(r + 2, c));
                }
            }
            if (r < 8 && c > 0) {
                if (myBoard[r + 1][c - 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 1, c - 1));
                }
            }
            if (r < 8 && c < 7) {
                if (myBoard[r + 1][c + 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 1, c + 1));
                }
            }
        }
        if (myBoard[r][c].getChessPiece().getMyColor() == (1)) {
            System.out.println("color 1");

            if (myBoard[r - 1][c].getChessPiece().getMyColor() == (0)) {
                moveLocs.add(new Location(r - 1, c));
            }
            if (r == 6 && myBoard[r - 1][c].getChessPiece().getMyColor() == (0)) {
                if (myBoard[r - 2][c].getChessPiece().getMyColor() == 0) {
                    moveLocs.add(new Location(r - 2, c));
                }
            }
            if (r > 0 && c > 0) {
                if (myBoard[r - 1][c - 1].getChessPiece().getMyColor() == (-1)) {
                    moveLocs.add(new Location(r - 1, c - 1));
                }
            }
            if (r > 0 && c < 7) {
                if (myBoard[r - 1][c + 1].getChessPiece().getMyColor() == (-1)) {
                    moveLocs.add(new Location(r - 1, c + 1));
                }
            }
        }
        return moveLocs;

    }

    public ArrayList<Location> knightMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int knightColor = myBoard[r][c].getChessPiece().getMyColor();
        if (r < 6 && c < 7) {
            if (myBoard[r + 2][c + 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r + 2, c + 1));
            }
            if (knightColor == 1) {
                if (myBoard[r + 2][c + 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r + 2, c + 1));
                }
            }
            if (knightColor == -1) {
                if (myBoard[r + 2][c + 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 2, c + 1));
                }
            }
        }
        if (r < 6 && c > 0) {
            if (myBoard[r + 2][c - 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r + 2, c - 1));
            }
            if (knightColor == 1) {
                if (myBoard[r + 2][c - 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r + 2, c - 1));
                }
            }
            if (knightColor == -1) {
                if (myBoard[r + 2][c - 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 2, c - 1));
                }
            }
        }
        if (r > 1 & c > 0) {
            if (myBoard[r - 2][c - 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r - 2, c - 1));
            }
            if (knightColor == 1) {
                if (myBoard[r - 2][c - 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r - 2, c - 1));
                }
            }
            if (knightColor == -1) {
                if (myBoard[r - 2][c - 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r - 2, c - 1));
                }
            }
        }
        if (r > 1 & c < 7) {
            if (myBoard[r - 2][c + 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r - 2, c + 1));
            }
            if (knightColor == 1) {
                if (myBoard[r - 2][c + 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r - 2, c + 1));
                }
            }
            if (knightColor == -1) {
                if (myBoard[r - 2][c + 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r - 2, c + 1));
                }
            }
        }
        if (r < 7 && c < 6) {
            if (myBoard[r + 1][c + 2].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r + 1, c + 2));
            }
            if (knightColor == 1) {
                if (myBoard[r + 1][c + 2].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r + 1, c + 2));
                }
            }
            if (knightColor == -1) {
                if (myBoard[r + 1][c + 2].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 1, c + 2));
                }
            }
        }
        if (r < 7 && c > 1) {
            if (myBoard[r + 1][c - 2].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r + 1, c - 2));
            }
            if (knightColor == 1) {
                if (myBoard[r + 1][c - 2].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r + 1, c - 2));
                }
            }
            if (knightColor == -1) {
                if (myBoard[r + 1][c - 2].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 1, c - 2));
                }
            }
        }
        if (r > 0 && c < 6) {
            if (myBoard[r - 1][c + 2].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r - 1, c + 2));
            }
            if (knightColor == 1) {
                if (myBoard[r - 1][c + 2].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r - 1, c + 2));
                }
            }
            if (knightColor == -1) {
                if (myBoard[r - 1][c + 2].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r - 1, c + 2));
                }
            }
        }
        if (r > 0 && c > 1) {
            if (myBoard[r - 1][c - 2].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r - 1, c - 2));
            }
            if (knightColor == 1) {
                if (myBoard[r - 1][c - 2].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r - 1, c - 2));
                }
            }
            if (knightColor == -1) {
                if (myBoard[r - 1][c - 2].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r - 1, c - 2));
                }
            }
        }
        return moveLocs;
    }

    public ArrayList<Location> rookMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        ArrayList<Location> moveLocs90 = rookMove90(loc);
        ArrayList<Location> moveLocs180 = rookMove180(loc);
        ArrayList<Location> moveLocs270 = rookMove270(loc);
        ArrayList<Location> moveLocs360 = rookMove360(loc);

        for (Location loc90 : moveLocs90) {
            moveLocs.add(loc90);
        }
        for (Location loc180 : moveLocs180) {
            moveLocs.add(loc180);
        }
        for (Location loc270 : moveLocs270) {
            moveLocs.add(loc270);
        }
        for (Location loc360 : moveLocs360) {
            moveLocs.add(loc360);
        }
        return moveLocs;
    }

    public ArrayList<Location> rookMove90(Location loc) {
        ArrayList<Location> moveLocs90 = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int tempC = c + 1;
        int rookColor = myBoard[r][c].getChessPiece().getMyColor();
        System.out.println(rookColor);
        Boolean blocked90 = false;
        while (blocked90 == false) {
            if ((tempC < 8) && (tempC > -1)) {
                if ((myBoard[r][tempC].getChessPiece().getMyColor() == rookColor)
                        && (!blocked90)) {
                    System.out.println("same color");
                    blocked90 = true;
                    break;
                }
                else if ((myBoard[r][tempC].getChessPiece().getMyColor() == (0))
                        && (!blocked90)) {
                    System.out.println("color is 0");
                    moveLocs90.add(new Location(r, tempC));
                    System.out.println("tempR:" + r + " tempC:" + tempC);
                }

                else if ((myBoard[r][tempC].getChessPiece().getMyColor() - rookColor) == -2
                        || (myBoard[r][tempC].getChessPiece().getMyColor() - rookColor) == 2
                        && (!blocked90)) {
                    System.out.println("-2 || +2");
                    blocked90 = true;
                    moveLocs90.add(new Location(r, tempC));
                    System.out.println("tempR: " + r + "tempC: " + tempC);
                }
            }

            if (!blocked90) {
                tempC++;
            }

            if (blocked90) {
                break;
            }

            if (!((tempC < 8) && (tempC > -1))) {
                blocked90 = true;
            }
        }
        return moveLocs90;
    }

    public ArrayList<Location> rookMove180(Location loc) {
        ArrayList<Location> moveLocs180 = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int tempR = r + 1;
        int rookColor = myBoard[r][c].getChessPiece().getMyColor();
        System.out.println("rook Color: " + rookColor);
        Boolean blocked180 = false;
        while (blocked180 == false) {
            if ((tempR < 8) && (tempR > -1)) {
                if ((myBoard[tempR][c].getChessPiece().getMyColor() == rookColor)
                        && (!blocked180)) {
                    System.out.println("same color");
                    blocked180 = true;
                    break;
                }
                else if ((myBoard[tempR][c].getChessPiece().getMyColor() == (0))
                        && (!blocked180)) {
                    System.out.println("color is 0");
                    moveLocs180.add(new Location(tempR, c));
                    System.out.println("tempR:" + tempR + " tempC:" + c);
                }

                else if ((myBoard[tempR][c].getChessPiece().getMyColor() - rookColor) == -2
                        || (myBoard[tempR][c].getChessPiece().getMyColor() - rookColor) == 2
                        && (!blocked180)) {
                    System.out.println("-2 || +2");
                    blocked180 = true;
                    moveLocs180.add(new Location(tempR, c));
                    System.out.println("tempR: " + tempR + "tempC: " + c);
                }
            }

            if (!blocked180) {
                tempR++;
            }

            if (blocked180) {
                break;
            }

            if (!((tempR < 8) && (tempR > -1))) {
                blocked180 = true;
            }
        }
        return moveLocs180;
    }

    public ArrayList<Location> rookMove270(Location loc) {
        ArrayList<Location> moveLocs270 = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int tempC = c - 1;
        int rookColor = myBoard[r][c].getChessPiece().getMyColor();
        System.out.println(rookColor);
        Boolean blocked270 = false;
        while (blocked270 == false) {
            if ((tempC < 8) && (tempC > -1)) {
                if ((myBoard[r][tempC].getChessPiece().getMyColor() == rookColor)
                        && (!blocked270)) {
                    System.out.println("same color");
                    blocked270 = true;
                    break;
                }
                else if ((myBoard[r][tempC].getChessPiece().getMyColor() == (0))
                        && (!blocked270)) {
                    System.out.println("color is 0");
                    moveLocs270.add(new Location(r, tempC));
                    System.out.println("tempR:" + r + " tempC:" + tempC);
                }

                else if ((myBoard[r][tempC].getChessPiece().getMyColor() - rookColor) == -2
                        || (myBoard[r][tempC].getChessPiece().getMyColor() - rookColor) == 2
                        && (!blocked270)) {
                    System.out.println("-2 || +2");
                    blocked270 = true;
                    moveLocs270.add(new Location(r, tempC));
                    System.out.println("tempR: " + r + "tempC: " + tempC);
                }
            }

            if (!blocked270) {
                tempC--;
            }

            if (blocked270) {
                break;
            }

            if (!((tempC < 8) && (tempC > -1))) {
                blocked270 = true;
            }
        }
        return moveLocs270;
    }

    public ArrayList<Location> rookMove360(Location loc) {
        ArrayList<Location> moveLocs360 = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int tempR = r - 1;
        int rookColor = myBoard[r][c].getChessPiece().getMyColor();
        System.out.println("rook Color: " + rookColor);
        Boolean blocked360 = false;
        while (blocked360 == false) {
            if ((tempR < 8) && (tempR > -1)) {
                if ((myBoard[tempR][c].getChessPiece().getMyColor() == rookColor)
                        && (!blocked360)) {
                    System.out.println("same color");
                    blocked360 = true;
                    break;
                }
                else if ((myBoard[tempR][c].getChessPiece().getMyColor() == (0))
                        && (!blocked360)) {
                    System.out.println("color is 0");
                    moveLocs360.add(new Location(tempR, c));
                    System.out.println("tempR:" + tempR + " tempC:" + c);
                }

                else if ((myBoard[tempR][c].getChessPiece().getMyColor() - rookColor) == -2
                        || (myBoard[tempR][c].getChessPiece().getMyColor() - rookColor) == 2
                        && (!blocked360)) {
                    System.out.println("-2 || +2");
                    blocked360 = true;
                    moveLocs360.add(new Location(tempR, c));
                    System.out.println("tempR: " + tempR + "tempC: " + c);
                }
            }

            if (!blocked360) {
                tempR--;
            }

            if (blocked360) {
                break;
            }

            if (!((tempR < 8) && (tempR > -1))) {
                blocked360 = true;
            }
        }
        return moveLocs360;
    }

    public ArrayList<Location> queenMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        ArrayList<Location> moveLocs90 = rookMove90(loc);
        ArrayList<Location> moveLocs180 = rookMove180(loc);
        ArrayList<Location> moveLocs270 = rookMove270(loc);
        ArrayList<Location> moveLocs360 = rookMove360(loc);

        for (Location loc90 : moveLocs90) {
            moveLocs.add(loc90);
        }
        for (Location loc180 : moveLocs180) {
            moveLocs.add(loc180);
        }
        for (Location loc270 : moveLocs270) {
            moveLocs.add(loc270);
        }
        for (Location loc360 : moveLocs360) {
            moveLocs.add(loc360);
        }

        ArrayList<Location> moveLocs45 = bishopMove45(loc);
        ArrayList<Location> moveLocs135 = bishopMove135(loc);
        ArrayList<Location> moveLocs225 = bishopMove225(loc);
        ArrayList<Location> moveLocs315 = bishopMove315(loc);

        for (Location loc45 : moveLocs45) {
            moveLocs.add(loc45);
        }
        for (Location loc135 : moveLocs135) {
            moveLocs.add(loc135);
        }
        for (Location loc225 : moveLocs225) {
            moveLocs.add(loc225);
        }
        for (Location loc315 : moveLocs315) {
            moveLocs.add(loc315);
        }

        return moveLocs;
    }

    public ArrayList<Location> kingMove(Location loc) {
        ArrayList<Location> moveLocs = new ArrayList<Location>();
        int r = loc.getRow();
        int c = loc.getCol();
        int kingColor = myBoard[r][c].getChessPiece().getMyColor();

        if (kingColor == 1) {
            if (canCastleWhiteRight()) {
                moveLocs.add(new Location(7, 6));
            }
            setWKHM();
        }

        if (r > 0) {
            if (myBoard[r - 1][c].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r - 1, c));
            }
            if (kingColor == 1) {
                if (myBoard[r - 1][c].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r - 1, c));
                }
            }
            if (kingColor == -1) {
                if (myBoard[r - 1][c].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r - 1, c));
                }
            }
        }
        if (r < 7) {
            if (myBoard[r + 1][c].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r + 1, c));
            }
            if (kingColor == 1) {
                if (myBoard[r + 1][c].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r + 1, c));
                }
            }
            if (kingColor == -1) {
                if (myBoard[r + 1][c].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 1, c));
                }
            }
        }
        if (c < 7) {
            if (myBoard[r][c + 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r, c + 1));
            }
            if (kingColor == 1) {
                if (myBoard[r][c + 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r, c + 1));
                }
            }
            if (kingColor == -1) {
                if (myBoard[r][c + 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r, c + 1));
                }
            }
        }
        if (c > 0) {
            if (myBoard[r][c - 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r, c - 1));
            }
            if (kingColor == 1) {
                if (myBoard[r][c - 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r, c - 1));
                }
            }
            if (kingColor == -1) {
                if (myBoard[r][c - 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r, c - 1));
                }
            }
        }
        if (c > 0 && r > 0) {
            if (myBoard[r - 1][c - 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r - 1, c - 1));
            }
            if (kingColor == 1) {
                if (myBoard[r - 1][c - 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r - 1, c - 1));
                }
            }
            if (kingColor == -1) {
                if (myBoard[r - 1][c - 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r - 1, c - 1));
                }
            }
        }
        if (c > 0 && r < 7) {
            if (myBoard[r + 1][c - 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r + 1, c - 1));
            }
            if (kingColor == 1) {
                if (myBoard[r + 1][c - 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r + 1, c - 1));
                }
            }
            if (kingColor == -1) {
                if (myBoard[r + 1][c - 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 1, c - 1));
                }
            }
        }
        if (c < 7 && r < 7) {
            if (myBoard[r + 1][c + 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r + 1, c + 1));
            }
            if (kingColor == 1) {
                if (myBoard[r + 1][c + 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r + 1, c + 1));
                }
            }
            if (kingColor == -1) {
                if (myBoard[r + 1][c + 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r + 1, c + 1));
                }
            }
        }
        if (c < 7 && r > 0) {
            if (myBoard[r - 1][c + 1].getChessPiece().getMyColor() == 0) {
                moveLocs.add(new Location(r - 1, c + 1));
            }
            if (kingColor == 1) {
                if (myBoard[r - 1][c + 1].getChessPiece().getMyColor() == -1) {
                    moveLocs.add(new Location(r - 1, c + 1));
                }
            }
            if (kingColor == -1) {
                if (myBoard[r - 1][c + 1].getChessPiece().getMyColor() == 1) {
                    moveLocs.add(new Location(r - 1, c + 1));
                }
            }
        }
        return moveLocs;
    }

    public Boolean canCastleWhiteRight() {
        if (!whiteKingHasMoved) {
            if (myBoard[7][6].getChessPiece().getMyColor() == 0
                    && myBoard[7][5].getChessPiece().getMyColor() == 0) {
                if (!whiteLeftRookHasMoved) {
                    return true;
                }
            }
        }
        return false;
    }

    public void castleWhiteRight() {
        myBoard[7][6].setChessPiece(myBoard[7][4].getChessPiece());
        myBoard[7][4].setChessPiece(new ChessPiece(0));
        myBoard[7][5].setChessPiece(new Rook(1));
    }

}

