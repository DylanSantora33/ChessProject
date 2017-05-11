
import javax.swing.*;       // access to JFrame and JComponents

import java.net.URL;		// added for JAR file access
import java.io.*;			// for PrintStream to capture error info
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Color;

public class GUI extends JFrame {
    
	private JPanel panel1;
    private JLabel label1;
    private JButton[][] buttonArray;
    final static int NUM_ROWS = 8;
    final static int NUM_COLS = 8;
    
    public GUI() {

        super("Chess");
        
        
        
        Icon knight1 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\knight1.png");
        Icon knight0 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\knight0.png");
        Icon pawn1 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\pawn1.png");
        Icon pawn0 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\pawn0.png");
        Icon bishop0 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\bishop0.png");
        Icon bishop1 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\bishop1.png");
        Icon king0 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\king0.png");
        Icon king1 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\king1.png");
        Icon queen0 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\queen0.png");
        Icon queen1 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\queen1.png");
        Icon rook0 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\rook0.png");
        Icon rook1 = new ImageIcon("H:\\ChessProject\\ChessProj\\src\\rook1.png");
        
        
        panel1 = new JPanel();
        
        panel1.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));

        Container container = getContentPane();
        container.setLayout( new FlowLayout() );
        
        panel1.setPreferredSize(new Dimension(900,900));
        
        buttonArray = new JButton[8][8];
        ButtonHandler buttonHandler = new ButtonHandler();
        
        for (int r = 0; r < NUM_ROWS; r++)
            for (int c = 0; c < NUM_COLS; c++) {
            	
            	//buttonArray[r][c] = new JButton(king1);
            	
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
            	
            	
            	
            	
            	
            	
                

                if ((c+r) % 2 != 0)
                buttonArray[r][c].setBackground(Color.darkGray);
                
                panel1.add(buttonArray[r][c]);

                buttonArray[r][c].addActionListener(buttonHandler);

            }
        
        label1 = new JLabel("fatty's turn", SwingConstants.CENTER);
        container.add(panel1);
        container.add(label1);


        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        

        

        setSize( 900, 1000);
        setVisible(true);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI application = new GUI();
    }
    

    private class ButtonHandler implements ActionListener {
        public void actionPerformed (ActionEvent event) {

            for (int r = 0; r < NUM_ROWS; r++)
                for (int c = 0; c < NUM_COLS; c++) {
                    if (event.getSource() == buttonArray[r][c]) {
                        System.out.println("Button at row " + r + ",col " + c + " pressed");
                    }
                }
            }
        }
    
    }