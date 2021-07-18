package RecyclingGo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeScreen {
    private JFrame frame;
    private JPanel panel;
    private JButton welcome;
    private JButton faq;
    private JButton check;
    private JPanel panel2;
    private JPanel panel3;
    
    public HomeScreen() {
        String space = "          ";
        String space2 = "          ";
        frame = new JFrame("Home Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        //panel.setLayout(new GridLayout(0,1));
        panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);
        panel3 = new JPanel();
        panel3.setBackground(Color.CYAN);
        welcome = new JButton("Matching Game");
        welcome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (welcome.isEnabled()) {
                    frame.setVisible(false);
                    frame.dispose();
                    AnimatedApple apple = new AnimatedApple();
                    
                    
                }
            }
        });
        
        
        
        faq = new JButton("Frequently Asked Questions");
        faq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (faq.isEnabled()) {
                    frame.setVisible(false);
                    frame.dispose();
                    Questions q = new Questions();
                    
                    
                }
            }
        });
        
        
        check = new JButton("Check Items");
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (check.isEnabled()) {
                    frame.setVisible(false);
                    frame.dispose();
                    try {
                        FindItem fi = new FindItem();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    
                    
                }
            }
        });
        panel2.add(check);
        panel.add(welcome);
        panel3.add(faq);
        //panel2.add(check);
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocation(400,100);
        frame.setVisible(true);
        
    }
    
}
