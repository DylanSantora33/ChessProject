/*
 * GuiTest2.java
 *
 * Created on April 19, 2004, 6:03 PM
 *
 * Creates a 2D grid of buttons; when a button is pressed, Console
 * window states which button (row/col pair) was pressed.
 *
 * @author  T. Neuhaus
 */


import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and JComponents
import java.awt.Color;

public class GUI extends JFrame {
    
    // component(s) in window \
	private JPanel panel1;
    private JLabel label1;
    private JButton[][] buttonArray;
    final static int NUM_ROWS = 8;
    final static int NUM_COLS = 8;
    
    /** Creates a new instance of GuiTest2 */
    public GUI() {
        // STEP 1: must call super() first
        super("Button Grid Demo");
        
        // STEP 2: get content pane and set its layout
        Container container = getContentPane();
        container.setLayout( new GridLayout(NUM_ROWS, NUM_COLS) );
                    // set GridLayout; optionally, if you want spacing
                    // between each component on the grid, you can supply
                    // 2 more arguments, e.g.:
                    // new GridLayout(NUM_ROWS, NUM_COLS, 5, 5)
        
        // STEP 3 and 4 and 5: construct components, add to Container, and
        // register event handlers ... all done in one place here so that
        // only one set of nested 'for' loops needed to set up the 2D array
        // of JButtons
        
        panel1 = new JPanel(new BorderLayout());
        buttonArray = new JButton[8][8];    // instantiate buttonArray
        ButtonHandler buttonHandler = new ButtonHandler();
                    // instantiate event handler for buttonArray;
                    // the handler is defined below as a private inner class
        for (int r = 0; r < NUM_ROWS; r++)
            for (int c = 0; c < NUM_COLS; c++) {
                buttonArray[r][c] = new JButton();
                        // instantiate each JButton with a row/col label
                if ((c+r) % 2 != 0)
                buttonArray[r][c].setBackground(Color.black);
                container.add(buttonArray[r][c]);
                        // add the JButton to the Container
                buttonArray[r][c].addActionListener(buttonHandler);
                        // register the JButton with the event handler
            }
        

        // DON'T FORGET TO INCLUDE THIS CODE - otherwise you will not
        // be able to close your application!!!
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        
       // label1 = new JLabel("Click on any button");
       // container.add(label1);
        
        // STEP 6: set window size and show window
        setSize( 900, 900);     // width=500, height=400
        setVisible(true);
        
    }   // end GuiTest2() constructor
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI application = new GUI();
    }
    
    /******** PRIVATE INNER CLASSES FOR EVENT HANDLING ***************/
    /*
     * - Provide ActionListener event handlers for JTextField, JButton
     * - Provide ItemListener event handlers for JCheckBox, JComboBox events
     * - Provide MouseListener event handlers for mouse events
     * - Provide KeyListener event handlers for key events
     *
     * - if there is more than one component associated with a
     *  particular event handler, you can test which component caused
     *  the event using the method event.getSource()
     */
    private class ButtonHandler implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            // replace with appropriate reaction to button press
            
            // sample code to show that button pressed
            for (int r = 0; r < NUM_ROWS; r++)
                for (int c = 0; c < NUM_COLS; c++) {
                    if (event.getSource() == buttonArray[r][c]) {
                        System.out.println("Button at row " + r + ",col " + c + " pressed");
                    }
                }
            }
        }   // end ButtonHandler
    
    }   // end GuiTest2 class