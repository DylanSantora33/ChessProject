


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
        panel1 = new JPanel();
        
        panel1.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));

        Container container = getContentPane();
        container.setLayout( new FlowLayout() );
        panel1.setPreferredSize(new Dimension(900,900));
        buttonArray = new JButton[8][8];
        ButtonHandler buttonHandler = new ButtonHandler();
        
        for (int r = 0; r < NUM_ROWS; r++)
            for (int c = 0; c < NUM_COLS; c++) {
                buttonArray[r][c] = new JButton();

                if ((c+r) % 2 != 0)
                buttonArray[r][c].setBackground(Color.black);
                panel1.add(buttonArray[r][c]);

                buttonArray[r][c].addActionListener(buttonHandler);

            }
        
        label1 = new JLabel("fatty's turn",SwingConstants.CENTER);
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