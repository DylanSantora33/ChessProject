package location;

import javax.sound.sampled.FloatControl;
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
    private JLabel labelCredit1;
    private JLabel labelCredit2;
    private JLabel labelCredit3;
    private JLabel labelInstructions;
    private JLabel labelInstructions1;
    private JLabel labelInstructions2;
    private JLabel labelInstructions3;
    private JLabel labelSelectedPiece;
    private Box containerBox;
    private Box horizontalBox;
    private JButton[][] buttonArray;
    final static int NUM_ROWS = 8;
    final static int NUM_COLS = 8;
    private ImageIcon knight1;
    private ImageIcon knight0;
    private ImageIcon pawn1;
    private ImageIcon pawn0;
    private ImageIcon bishop1;
    private ImageIcon bishop0;
    private ImageIcon king1;
    private ImageIcon king0;
    private ImageIcon queen1;
    private ImageIcon queen0;
    private ImageIcon rook1;
    private ImageIcon rook0;
    private static ChessBoard myBoard;
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
    private int whiteKingPrime = 0;
    private int blackKingPrime = 0;
    private Sound pieceEffect;
    //private Sound maskoff;
    private Sound win;
    private Sound bgm;

    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem1, menuItem2;

    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    public GUI() {
        super("Chess");

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
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

        pieceEffect = new Sound(cldr.getResource("pieceEffect.wav"));
        bgm = new Sound(cldr.getResource("satie.wav"));
        win = new Sound(cldr.getResource("win.wav"));
        pieceEffect.setVolume(6);
        bgm.setVolume(-10);
        win.setVolume(6);

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

        containerBox = Box.createVerticalBox();
        horizontalBox = Box.createHorizontalBox();

        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(8, 1));

        label1 = new JLabel("White's turn", SwingConstants.CENTER);
        labelSelectedPiece = new JLabel("No piece selected");
        panel2.add(label1);
        panel2.add(labelSelectedPiece);

        labelInstructions = new JLabel("Instructions:", SwingConstants.CENTER);
        labelInstructions1 = new JLabel("Click on a piece, and select one of the highlighted locations to move it.", SwingConstants.CENTER);
        labelInstructions2 = new JLabel("Click on a piece again to cancel and choose another piece.", SwingConstants.CENTER);
        labelInstructions3 = new JLabel("Use the options menu in the top left corner to start a new game.", SwingConstants.CENTER);
        labelCredit = new JLabel("Icons from: https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces", SwingConstants.CENTER);
        labelCredit1 = new JLabel("Music from: https://youtu.be/S-Xm7s9eGxU", SwingConstants.CENTER);
        labelCredit2 = new JLabel("Chesspiece sound effect from: https://youtu.be/Tppf_Dt4A4o", SwingConstants.CENTER);
        labelCredit3 = new JLabel("Winning sound effect from: http://soundbible.com/1003-Ta-Da.html", SwingConstants.CENTER);

        panel3.add(labelInstructions);
        panel3.add(labelInstructions1);
        panel3.add(labelInstructions2);
        panel3.add(labelInstructions3);
        panel3.add(labelCredit);
        panel3.add(labelCredit1);
        panel3.add(labelCredit2);
        panel3.add(labelCredit3);

        horizontalBox.add(panel1);
        horizontalBox.add(Box.createRigidArea(new Dimension(20, 0)));
        horizontalBox.add(panel2);

        containerBox.add(horizontalBox);
        containerBox.add(panel3);
        container.add(containerBox);

        bgm.loop();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

        setSize(600, 600);
        setVisible(true);
    }

    public class Menu implements ActionListener, ItemListener {
        public Menu() {
            menuItem1.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            bgm.stop();
            GUI app = new GUI();
            myBoard = new ChessBoard();
            myBoard.populate();
            setVisible(false); //you can't see me!
            dispose(); //Destroy the JFrame object
        }

        public void itemStateChanged(ItemEvent e) {

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
                        if (!gameOver) {

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
                                    if (myBoard.getMyBoard()[r][c].getChessPiece().getMyColor() == (1) && myBoard.getMyBoard()[r][c].getChessPiece().getMyPieceType() == "king") {
                                        if (whiteKingPrime == 0) {
                                            whiteKingPrime = 1;
                                        }
                                    }
                                    if (myBoard.getMyBoard()[r][c].getChessPiece().getMyColor() == (-1) && myBoard.getMyBoard()[r][c].getChessPiece().getMyPieceType() == "king") {
                                        if (blackKingPrime == 0) {
                                            blackKingPrime = 1;
                                        }
                                    }
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
                                for (int x = 0; x < 8; x++) {
                                    for (int y = 0; y < 8; y++) {
                                        if (myBoard.getMyBoard()[x][y].getChessPiece().getMyColor() == (1)) {
                                            if (myBoard.getMyBoard()[x][y].getChessPiece().getMyPieceType() == ("king")) {
                                                Location whiteKingLoc = myBoard.getMyBoard()[x][y];
                                                Boolean whiteKingChecked = myBoard.isWhiteInCheck(whiteKingLoc);
                                                if (whiteKingChecked) {
                                                    buttonArray[x][y].setBackground(Color.pink);
                                                }
                                            }
                                        }
                                        for (x = 0; x < 8; x++) {
                                            for (y = 0; y < 8; y++) {
                                                if (myBoard.getMyBoard()[x][y].getChessPiece().getMyColor() == (1)) {
                                                    if (myBoard.getMyBoard()[x][y].getChessPiece().getMyPieceType() == ("king")) {
                                                        Location whiteKingLoc = myBoard.getMyBoard()[x][y];
                                                        Boolean whiteKingChecked = myBoard.isWhiteInCheck(whiteKingLoc);
                                                        if (whiteKingChecked) {
                                                            buttonArray[x][y].setBackground(Color.pink);
                                                        }
                                                    }
                                                }
                                                else {
                                                    for (Location l : moveLocs) {
                                                        if (l.getRow() == r && l.getCol() == c) {
                                                            valid = true;
                                                        }
                                                        if (valid) {
                                                            toPiece = myBoard.getMyBoard()[r][c].getChessPiece();
                                                            for (int a = 0; a < 8; a++) {
                                                                for (int b = 0; b < 8; b++) {
                                                                    if ((b + a) % 2 != 0) {
                                                                        buttonArray[a][b].setBackground(Color.darkGray);
                                                                    }
                                                                    else {
                                                                        buttonArray[a][b].setBackground(Color.white);
                                                                    }
                                                                }
                                                            }

                                                            if (whiteKingPrime == 1) {
                                                                if (r == 7 && c == 6) {
                                                                    myBoard.getMyBoard()[7][5].setChessPiece(new Rook(1));
                                                                    myBoard.getMyBoard()[7][7].getChessPiece().setMyColor(0);
                                                                    buttonArray[7][5].setIcon(rook1);
                                                                    buttonArray[7][7].setIcon(null);
                                                                    whiteKingPrime = 2;
                                                                }
                                                                if (r == 7 && c == 2) {
                                                                    myBoard.getMyBoard()[7][3].setChessPiece(new Rook(1));
                                                                    myBoard.getMyBoard()[7][0].getChessPiece().setMyColor(0);
                                                                    buttonArray[7][3].setIcon(rook1);
                                                                    buttonArray[7][0].setIcon(null);
                                                                    whiteKingPrime = 2;
                                                                }
                                                            }
                                                            if (blackKingPrime == 1) {
                                                                if (r == 0 && c == 6) {
                                                                    myBoard.getMyBoard()[0][5].setChessPiece(new Rook(-1));
                                                                    myBoard.getMyBoard()[0][7].getChessPiece().setMyColor(0);
                                                                    buttonArray[0][5].setIcon(rook0);
                                                                    buttonArray[0][7].setIcon(null);
                                                                    blackKingPrime = 2;
                                                                }
                                                                if (r == 0 && c == 2) {
                                                                    myBoard.getMyBoard()[0][3].setChessPiece(new Rook(-1));
                                                                    myBoard.getMyBoard()[0][0].getChessPiece().setMyColor(0);
                                                                    buttonArray[0][3].setIcon(rook0);
                                                                    buttonArray[0][0].setIcon(null);
                                                                    blackKingPrime = 2;
                                                                }
                                                            }

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

                                                            pieceEffect.play();

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

                                                for (x = 0; x < 8; x++) {
                                                    for (y = 0; y < 8; y++) {
                                                        if (myBoard.getPiece(new Location(x, y)).getMyPieceType().equals("king")) {
                                                            if (myBoard.getPiece(new Location(x, y)).getMyColor() == -1) {
                                                                blackKing = true;
                                                            }
                                                            if (myBoard.getPiece(new Location(x, y)).getMyColor() == 1) {
                                                                whiteKing = true;
                                                            }
                                                        }
                                                    }
                                                }

                                                if (!whiteKing) {
                                                    label1.setText("Black wins");
                                                    labelSelectedPiece.setText("Game over");
                                                    bgm.stop();
                                                    win.play();
                                                    gameOver = true;
                                                }
                                                if (!blackKing) {
                                                    label1.setText("White wins");
                                                    labelSelectedPiece.setText("Game over");
                                                    bgm.stop();
                                                    win.play();
                                                    gameOver = true;
                                                }

                                                whiteKing = blackKing = false;

                                                for (x = 0; x < 8; x++) {
                                                    for (y = 0; y < 8; y++) {
                                                        if (myBoard.getMyBoard()[x][y].getChessPiece().getMyColor() == (1)) {
                                                            if (myBoard.getMyBoard()[x][y].getChessPiece().getMyPieceType() == ("king")) {
                                                                Location whiteKingLoc = myBoard.getMyBoard()[x][y];
                                                                Boolean whiteKingChecked = myBoard.isWhiteInCheck(whiteKingLoc);
                                                                if (whiteKingChecked) {
                                                                    buttonArray[x][y].setBackground(Color.pink);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                for (x = 0; x < 8; x++) {
                                                    for (y = 0; y < 8; y++) {
                                                        if (myBoard.getMyBoard()[x][y].getChessPiece().getMyColor() == (-1)) {
                                                            if (myBoard.getMyBoard()[x][y].getChessPiece().getMyPieceType() == ("king")) {
                                                                Location blackKingLoc = myBoard.getMyBoard()[x][y];
                                                                Boolean blackKingChecked = myBoard.isBlackInCheck(blackKingLoc);
                                                                if (blackKingChecked) {
                                                                    buttonArray[x][y].setBackground(Color.pink);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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
}
