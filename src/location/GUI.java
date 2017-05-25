package location;

import javax.swing.*;       // access to JFrame and JComponents
import java.awt.*;
import java.awt.event.*;
import pieces.*;
import java.util.*;
import java.awt.Color;

public class GUI extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JLabel labelCredit;
    private JLabel labelInstructions;
    private JLabel labelInstructions1;
    private JLabel labelInstructions2;
    private JLabel labelSelectedPiece;
    private JButton[][] buttonArray;
    final static int NUM_ROWS = 8;
    final static int NUM_COLS = 8;
    ImageIcon knight1;
    ImageIcon knight0;
    ImageIcon pawn1;
    ImageIcon pawn0;
    ImageIcon bishop1;
    ImageIcon bishop0;
    ImageIcon king1;
    ImageIcon king0;
    ImageIcon queen1;
    ImageIcon queen0;
    ImageIcon rook1;
    ImageIcon rook0;
    static ChessBoard myBoard;
    private int turnCount; // if turnCount%2 == 0 -> white's turn
    private int rowOfPiece;
    private int colOfPiece;
    private ArrayList<Location> moveLocs;
    private ChessPiece[][] chessBoard;
    private ChessPiece fromPiece;
    private ChessPiece toPiece;
    private int fromR;
    private int fromC;
    private boolean hasValidPiece;
    private boolean valid = false;
    private boolean whiteKing = false;
    private boolean blackKing = false;
    private boolean gameOver = false;
    
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem1, menuItem2;
    
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    public GUI() {
    	super("Chess");
    	
    	menuBar = new JMenuBar();

    	menu = new JMenu("Options");
    	menu.setMnemonic(KeyEvent.VK_A);
    	menu.getAccessibleContext().setAccessibleDescription(
    	        "The only menu in this program that has menu items");
    	menuBar.add(menu);

    	//a group of JMenuItems
    	menuItem1 = new JMenuItem("New Chess Game");
    	menu.add(menuItem1);
    	

    	menuItem2 = new JMenuItem("New 3-Check Game");
    	menu.add(menuItem2);

    	
    	
    	this.setJMenuBar(menuBar);
    	
    	
    	
    	Menu menu5 = new Menu();
    	menu.addActionListener(menu5);
        
        turnCount = 0;

        ClassLoader cldr = this.getClass().getClassLoader();
        // cldr.getResource("smiley.gif")

        
        knight1 = new ImageIcon(cldr.getResource("knight1.png"));
        knight0 = new ImageIcon(cldr.getResource("knight0.png"));
        pawn1 = new ImageIcon(cldr.getResource("pawn1.png"));
        pawn0 = new ImageIcon(cldr.getResource("pawn0.png"));
        bishop1 = new ImageIcon(cldr.getResource("bishop1.png"));
        bishop0 = new ImageIcon(cldr.getResource("bishop0.png"));
        king1 = new ImageIcon(cldr.getResource("king1.png"));
        king0 = new ImageIcon(cldr.getResource("king0.png"));
        queen1 = new ImageIcon(cldr.getResource("queen1.png"));
        queen0 = new ImageIcon(cldr.getResource("queen0.png"));
        rook1 = new ImageIcon(cldr.getResource("rook1.png"));
        rook0 = new ImageIcon(cldr.getResource("rook0.png"));
        
        
       

        panel1 = new JPanel();

        panel1.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        panel1.setPreferredSize(new Dimension(400, 400));

        buttonArray = new JButton[8][8];
        ButtonHandler buttonHandler = new ButtonHandler();

        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLS; c++) {

                buttonArray[r][c] = new JButton();

                if (r == 1) {
                    buttonArray[r][c] = new JButton(pawn0);
                }
                if (r == 6) {
                    buttonArray[r][c] = new JButton(pawn1);
                }
                if ((r == 0) && ((c == 0) || (c == 7))) {
                    buttonArray[r][c] = new JButton(rook0);
                }
                if ((r == 0) && ((c == 1) || (c == 6))) {
                    buttonArray[r][c] = new JButton(knight0);
                }
                if ((r == 0) && ((c == 2) || (c == 5))) {
                    buttonArray[r][c] = new JButton(bishop0);
                }
                if ((r == 0) && (c == 3)) {
                    buttonArray[r][c] = new JButton(queen0);
                }
                if ((r == 0) && (c == 4)) {
                    buttonArray[r][c] = new JButton(king0);
                }
                if ((r == 7) && ((c == 0) || (c == 7))) {
                    buttonArray[r][c] = new JButton(rook1);
                }
                if ((r == 7) && ((c == 1) || (c == 6))) {
                    buttonArray[r][c] = new JButton(knight1);
                }
                if ((r == 7) && ((c == 2) || (c == 5))) {
                    buttonArray[r][c] = new JButton(bishop1);
                }
                if ((r == 7) && (c == 3)) {
                    buttonArray[r][c] = new JButton(queen1);
                }
                if ((r == 7) && (c == 4)) {
                    buttonArray[r][c] = new JButton(king1);
                }
                if ((r >= 2) && (r <= 5)) {
                    buttonArray[r][c] = new JButton();
                }

                if ((c + r) % 2 != 0) {
                    buttonArray[r][c].setBackground(Color.darkGray);
                }
                else {
                    buttonArray[r][c].setBackground(Color.white);
                }
                panel1.add(buttonArray[r][c]);

                buttonArray[r][c].addActionListener(buttonHandler);

            }
        }

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));

        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(4,1));

        label1 = new JLabel("White's turn", SwingConstants.CENTER);
        labelSelectedPiece = new JLabel("No piece selected");
        panel2.add(label1);
        panel2.add(labelSelectedPiece);

        labelInstructions = new JLabel("Instructions:", SwingConstants.CENTER);
        labelInstructions1 = new JLabel("Click on a piece, and select one of the highlighted locations to move it.", SwingConstants.CENTER);
        labelInstructions2 = new JLabel("Click on a piece again to cancel and choose another piece.", SwingConstants.CENTER);
        labelCredit = new JLabel("Icons from: //https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces", SwingConstants.CENTER);
        panel3.add(labelInstructions);
        panel3.add(labelInstructions1);
        panel3.add(labelInstructions2);

        container.add(panel1);
        //container.add(label1);
        container.add(panel2);
        //container.add(labelSelectedPiece);
        //container.add(labelInstructions1);
        //container.add(labelInstructions2);
        container.add(labelCredit);
        container.add(panel3);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

        setSize(600, 600);
        setVisible(true);
    }
    
    public class Menu implements ActionListener, ItemListener
    {
    	public Menu()
    	{
    		menuItem1.addActionListener(this);
    	}
    	
    	public void actionPerformed(ActionEvent e)
    	{
    		System.out.println("hiii");
    		GUI app = new GUI();
    		myBoard = new ChessBoard();
            myBoard.populate();
    		setVisible(false);
    		dispose(); 
    		
    	}
    	
    	public void itemStateChanged(ItemEvent e)
    	{
    		
    	}
    }
    
    
    
    
    
    

    
    public static void main(String[] args) {
        GUI application = new GUI();
        myBoard = new ChessBoard();
        myBoard.populate();
    }

    public void update(Location from, Location to) {
        buttonArray[from.getRow()][from.getCol()].setIcon(null);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            for (int r = 0; r < NUM_ROWS; r++) {
                for (int c = 0; c < NUM_COLS; c++) {
                    if (event.getSource() == buttonArray[r][c]) {
                    	if (gameOver == false)
                    	{

                        if (!myBoard.getStage()) {
                            if (myBoard.getPiece(new Location(r, c)) != null
                                    && ((myBoard.getTurn() == true && myBoard.getPiece(new Location(r, c)).getMyColor() == 1)
                                    || (myBoard.getTurn() == false && myBoard.getPiece(new Location(r, c)).getMyColor() == -1))) {
                                Location moveloc = new Location(r, c);
                                myBoard.setMove(moveloc);
                                System.out.println("stage false");
                                moveLocs = myBoard.getValidMoveLocations(moveloc);
                                fromPiece = myBoard.getMyBoard()[r][c].getChessPiece();
                                fromR = r;
                                fromC = c;
                                for (Location loc : moveLocs) {
                                   // loc.print();
                                    buttonArray[loc.getRow()][loc.getCol()].setBackground(Color.green);
                                    if (myBoard.getPiece(loc).getMyColor() != 0) {
                                        buttonArray[loc.getRow()][loc.getCol()].setBackground(Color.red);
                                    }
                                }
                                pieceSelected(r, c);
                            }
                        }

                        else if (fromR == r && fromC == c) {
                            myBoard.setStage(false);
                            for (Location loc : moveLocs) {
                                if ((loc.getCol() + loc.getRow()) % 2 != 0) {
                                    buttonArray[loc.getRow()][loc.getCol()].setBackground(Color.darkGray);
                                }
                                else {
                                    buttonArray[loc.getRow()][loc.getCol()].setBackground(Color.white);
                                }
                            }
                            labelSelectedPiece.setText("No piece selected");
                        }

                        else {
                            for (Location l : moveLocs) {
                                if (l.getRow() == r && l.getCol() == c) {
                                    valid = true;
                                }
                                if (valid) {
                                    toPiece = myBoard.getMyBoard()[r][c].getChessPiece();
                                    for (Location loc : moveLocs) {
                                        if ((loc.getCol() + loc.getRow()) % 2 != 0) {
                                            buttonArray[loc.getRow()][loc.getCol()].setBackground(Color.darkGray);
                                        }
                                        else {
                                            buttonArray[loc.getRow()][loc.getCol()].setBackground(Color.white);
                                        }
                                    }
                                    System.out.println("hi");
                                    buttonArray[myBoard.getMove().getRow()][myBoard.getMove().getCol()].setIcon(null);
                                    System.out.println(myBoard.getPiece(myBoard.getMove()));
                                    if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("pawn") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
                                        buttonArray[r][c].setIcon(pawn0);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("pawn") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
                                        buttonArray[r][c].setIcon(pawn1);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("king") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
                                        buttonArray[r][c].setIcon(king0);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("king") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
                                        buttonArray[r][c].setIcon(king1);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("queen") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
                                        buttonArray[r][c].setIcon(queen0);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("queen") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
                                        buttonArray[r][c].setIcon(queen1);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("bishop") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
                                        buttonArray[r][c].setIcon(bishop0);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("bishop") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
                                        buttonArray[r][c].setIcon(bishop1);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("knight") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
                                        buttonArray[r][c].setIcon(knight0);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("knight") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
                                        buttonArray[r][c].setIcon(knight1);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("rook") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
                                        buttonArray[r][c].setIcon(rook0);
                                    }
                                    else if (myBoard.getPiece(myBoard.getMove()).getMyPieceType().equals("rook") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
                                        buttonArray[r][c].setIcon(rook1);
                                    }

                                    myBoard.update(myBoard.getMyBoard()[r][c]);
                                    myBoard.getMyBoard()[fromR][fromC].getChessPiece().setMyColor(0);

                                    if (myBoard.getTurn()) {
                                        label1.setText("White's turn");
                                    }
                                    else {
                                        label1.setText("Black's turn");
                                    }

                                    Location promLoc = myBoard.promotion();
                                    if (promLoc.getRow() == 0) {
                                        int promC = promLoc.getCol();
                                        buttonArray[0][promC].setIcon(queen1);
                                    }
                                    if (promLoc.getRow() == 7) {
                                        int promC = promLoc.getCol();
                                        buttonArray[7][promC].setIcon(queen0);
                                    }
                                    valid = false;
                                    labelSelectedPiece.setText("No piece selected");
                                    System.out.println("///////////////new move/////////////////");
                                }
                            }
                        }
                        
                        for (int x = 0; x < 8; x++)
                        	for (int y  = 0; y < 8; y++)
                        	{
                        		if (myBoard.getPiece(new Location(x,y)).getMyPieceType().equals("king"))
                        		{
                        			if (myBoard.getPiece(new Location(x,y)).getMyColor() == -1)
                        			blackKing = true;
                        			if (myBoard.getPiece(new Location(x,y)).getMyColor() == 1)
                        			whiteKing = true;
                        			
                        		}
                        		
                        	}
                        		
                        if (!whiteKing)
                        {
                        	label1.setText("blak wins"); 
                        	gameOver = true;
                        }
                        if (!blackKing)
                        {
                        	label1.setText("whaite wins"); 
                        	gameOver = true;
                        }
                        	
                        whiteKing = blackKing = false;
                        
                        
                        
                    	}
                    }
                }
            }
        }
    }

    public void pieceSelected(int r, int c) {
        Location selectedLoc = new Location(r, c);

        if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("pawn") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
            labelSelectedPiece.setText("Pawn (Black) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("pawn") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
            labelSelectedPiece.setText("Pawn (White) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("king") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
            labelSelectedPiece.setText("King (Black) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("king") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
            labelSelectedPiece.setText("King (White) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("queen") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
            labelSelectedPiece.setText("Queen (Black) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("queen") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
            labelSelectedPiece.setText("Queen (White) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("bishop") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
            labelSelectedPiece.setText("Bishop (Black) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("bishop") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
            labelSelectedPiece.setText("Bishop (White) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("knight") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
            labelSelectedPiece.setText("Knight (Black) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("knight") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
            labelSelectedPiece.setText("Knight (White) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("rook") && myBoard.getPiece(myBoard.getMove()).getMyColor() == -1) {
            labelSelectedPiece.setText("Rook (Black) selected");
        }
        else if (myBoard.getPiece(selectedLoc).getMyPieceType().equals("rook") && myBoard.getPiece(myBoard.getMove()).getMyColor() == 1) {
            labelSelectedPiece.setText("Rook (White) selected");
        }
    }
}
