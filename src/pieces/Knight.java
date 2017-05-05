package pieces;

public class Knight extends ChessPiece {
	
	private int myColor;
	private String myPieceType;
	
	public Knight(int color, String type)
	{
		super();
		setMyColor(color);
		setMyPieceType(type);
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
		this.myPieceType = pieceType;
	}

}
