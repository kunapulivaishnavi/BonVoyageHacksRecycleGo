package RecyclingGo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Buttons {
    JFrame frame;
    private JPanel panel;
    JButton recycle;
    JButton compost;
    JButton trash;
    static int points;
    static JButton back;
    
    public Buttons() {
        frame = new JFrame("Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.add(panel);
        
        //frame.add(panel2);
        frame.pack();
        JLabel score = new JLabel("Score: " + points);
        
        recycle = new JButton("Recycle");
        compost = new JButton("Compost");
        trash = new JButton("Trash");
        back = new JButton("                                                                  Back");
        
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setForeground(Color.BLUE);
        panel.add(recycle);
        panel.add(compost);
        panel.add(trash);
        panel.add(score);
        panel.add(Box.createVerticalStrut(200)); 
        panel.add(back);
        frame.pack();
        frame.setLocation(800,0);
        frame.setSize(300,300);
        frame.setVisible(true);
      
       // points = 0;
        
    }
    
}
