package RecyclingGo;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import java.net.URL;

import javax.imageio.*;
import javax.swing.*;

public class AnimatedOrange {
    
//    public static void main(String[] args) {
//        AnimatedOrange orange = new AnimatedOrange();
//    }

    public AnimatedOrange() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                BufferedImage orange = null;
                try {
                    URL url  = getClass().getResource("RecycleGoImagesAndSounds/orangePeel.png");
                    File file = new File(url.getPath());
                   // apple = ImageIO.read(new File("C:/Users/vaish/eclipse-workspace/RecycleGoCopy/src/RecycleGoImagesAndSounds/appleCore.png"));
                    orange = ImageIO.read(file);
                   // orange = ImageIO.read(new File("C:/Users/vaish/eclipse-workspace/RecycleGo/src/RecycleGoImagesAndSounds/orangePeel.png"));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
               
                final JFrame frame = new JFrame("RecycleGo");
                frame.setLayout(new BorderLayout());
                frame.add(new AnimationPane(orange));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(800, 600);
                //panel.setVisible(true);
                frame.setVisible(true);
                final Buttons b = new Buttons();
                b.compost.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (b.compost.isEnabled()) {
                            frame.setVisible(false);
                            frame.dispose();
                            b.frame.setVisible(false);
                            b.frame.dispose();
                            Buttons.points++;
                            AnimatedPot pot = new AnimatedPot();
                            
                            
                            
                        }
                    }
                });
                
                b.recycle.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (b.compost.isEnabled()) {
                            frame.setVisible(false);
                            frame.dispose();
                            b.frame.setVisible(false);
                            b.frame.dispose();
                            GameOver go = new GameOver(); 
                            Buttons.points = 0;
                            
                        }
                    }
                });
                
                b.trash.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (b.trash.isEnabled()) {
                            frame.setVisible(false);
                            frame.dispose();
                            b.frame.setVisible(false);
                            b.frame.dispose();
                            GameOver go = new GameOver(); 
                            Buttons.points = 0;
                            
                        }
                    }
                });
                
                Buttons.back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (Buttons.back.isEnabled()) {
                            b.frame.setVisible(false);
                            b.frame.dispose();
                            frame.setVisible(false);
                            frame.dispose();
                            HomeScreen hs = new HomeScreen();
                            Buttons.points = 0;
                            
                        }
                    }
                });
                
            }

        });
    }

    public class AnimationPane extends JPanel {

        private BufferedImage orange;
        private int xPos = 0;
        private int direction = 1;

        public AnimationPane(BufferedImage image) {
            // apple = ImageIO.read(new File("C:/Users/vaish/eclipse-workspace/RecycleGo/src/RecycleGoImagesAndSounds/appleCore.png"));
            orange = image;   
            Timer timer = new Timer(0, new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        xPos += direction;
                        if (xPos + orange.getWidth() > getWidth()) {
                            xPos = getWidth() - orange.getWidth();
                            direction *= -1;
                            //Buttons.points--;
                        } else if (xPos < 0) {
                            xPos = 0;
                            direction *= -1;
                            //Buttons.points--;
                        }
                        repaint();
                    }

                });
                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();
        }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int y = getHeight() - orange.getHeight();
            g.drawImage(orange, xPos, y, this);

        }

    }   

}