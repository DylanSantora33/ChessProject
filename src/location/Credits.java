package location;

import com.intellij.openapi.ui.popup.JBPopupAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by kevin on 6/2/2017.
 */
public class Credits extends JFrame {
    private JLabel label;
    private JLabel labelCredit;
    private JLabel labelCredit1;
    private JLabel labelCredit2;
    private JLabel labelCredit3;
    private JLabel labelCredit4;

    public Credits() {
        Container container = getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        label = new JLabel("CREDITS", SwingConstants.CENTER);
        labelCredit = new JLabel("Icons from: https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces", SwingConstants.CENTER);
        labelCredit1 = new JLabel("Music from: https://youtu.be/S-Xm7s9eGxU", SwingConstants.CENTER);
        labelCredit2 = new JLabel("Chesspiece sound effect from: https://youtu.be/Tppf_Dt4A4o", SwingConstants.CENTER);
        labelCredit3 = new JLabel("Winning sound effect from: http://soundbible.com/1003-Ta-Da.html", SwingConstants.CENTER);
        labelCredit4 = new JLabel("Sound code adapted from: http://www.dreamincode.net/forums/topic/343804-how-to-add-background-music-to-my-2d-platformer-game/page__p__1992601&#entry1992601", SwingConstants.CENTER);

        panel.add(label);
        panel.add(labelCredit);
        panel.add(labelCredit1);
        panel.add(labelCredit2);
        panel.add(labelCredit3);
        panel.add(labelCredit4);

        container.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(900, 500);
        setVisible(true);
    }

}
