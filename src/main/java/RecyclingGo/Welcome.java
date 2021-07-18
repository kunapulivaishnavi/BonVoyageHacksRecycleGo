package RecyclingGo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome {
    private JFrame frame;
    private JPanel panel;
    private JLabel gameTitle;
    private JLabel welcomeTitle;
    private JButton nextButton;
    private JPanel panel2;
    
    public Welcome() {
        String space = "          ";
        String space2 = "          ";
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(new GridLayout(0,1));
        panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);
        gameTitle = new JLabel(space + "RecycleGo");
        gameTitle.setForeground(Color.BLUE);
        gameTitle.setFont(new Font("Serif", Font.BOLD, 50));
        welcomeTitle = new JLabel(space2 + "Welcome!");
        welcomeTitle.setFont(new Font("Courier New", Font.PLAIN, 30));
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nextButton.isEnabled()) {
                    frame.setVisible(false);
                    frame.dispose();
                    HomeScreen hs = new HomeScreen();
                    
                    
                }
            }
        });
        panel.add(gameTitle);
        panel.add(welcomeTitle);
        panel2.add(nextButton);
        frame.add(panel);
        frame.add(panel2);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocation(400,100);
        frame.setVisible(true);
        
    }
    
}
