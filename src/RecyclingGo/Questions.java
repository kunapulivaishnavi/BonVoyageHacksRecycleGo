package RecyclingGo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class Questions {
    
    private JFrame frame;
    private JPanel panel;
    private JButton back;
    private JPanel panel2;

    Questions() {
        frame = new JFrame("Questions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        URL url  = getClass().getResource("/RecycleGoImagesAndSounds/questions.jpg");
        File file = new File(url.getPath());
        ImageIcon image = new ImageIcon(url.getPath());
        JLabel label = new JLabel(image, JLabel.CENTER);
        panel = new JPanel(new GridLayout(0,1));
        panel.add(label);
        panel2 = new JPanel();
        panel.add(panel2);
        back = new JButton("Back");
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setForeground(Color.BLUE);
        back.setPreferredSize(new Dimension(1000, 100));
        back.setFont(new Font("Arial", Font.PLAIN, 50));
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (back.isEnabled()) {
                    frame.setVisible(false);
                    frame.dispose();
                    HomeScreen hs = new HomeScreen();
                    
                }
            }
        });
        panel2.add(back);
        JScrollPane scroll = new JScrollPane(panel);
        frame.add(scroll, BorderLayout.CENTER);
       // frame.pack();
        frame.setSize(700, 700);
        frame.setLocation(300,10);
        frame.setVisible(true);
    }
}
