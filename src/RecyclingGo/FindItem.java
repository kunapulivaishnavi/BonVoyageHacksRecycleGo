package RecyclingGo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindItem {
    
    private JFrame frame;
    private JPanel panel;
    private JLabel welcomeTitle;
    private JButton find;
    private JPanel panel2;
    private JTextField text;
    private JPanel panel3;
    private JButton back;
    
    public FindItem() throws Exception {
        
        URL url  = getClass().getResource("/RecycleGoImagesAndSounds/Compostable");
        File file = new File(url.getPath());
       // apple = ImageIO.read(new File("C:/Users/vaish/eclipse-workspace/RecycleGoCopy/src/RecycleGoImagesAndSounds/appleCore.png"));
        //apple = ImageIO.read(file);
       
        BufferedReader f = new BufferedReader(
                new FileReader(file));
        String line;
        final String[] compostItems = new String[30];String buffer = "";
        int i = 0;
        while ((line = f.readLine()) != null) {
            compostItems[i++] = line;
        }
         url  = getClass().getResource("/RecycleGoImagesAndSounds/Recyclable");
         file = new File(url.getPath());
       // apple = ImageIO.read(new File("C:/Users/vaish/eclipse-workspace/RecycleGoCopy/src/RecycleGoImagesAndSounds/appleCore.png"));
        //apple = ImageIO.read(file);
        f = new BufferedReader(
                new FileReader(file)); 

        String line2;
        final String[] recyclableItems = new String[35];
        i = 0;
        while ((line2 = f.readLine()) != null) {
            recyclableItems[i++] = line2;
        }
       
        String line3;
        final String[] trashableItems = new String[30];
        i = 0;
        url  = getClass().getResource("/RecycleGoImagesAndSounds/Trashable");
        file = new File(url.getPath());
       // apple = ImageIO.read(new File("C:/Users/vaish/eclipse-workspace/RecycleGoCopy/src/RecycleGoImagesAndSounds/appleCore.png"));
        //apple = ImageIO.read(file);
        f = new BufferedReader(
                new FileReader(file));
        while ((line3 = f.readLine()) != null) {
           trashableItems[i++] = line3;
        }
       
        quickSort(compostItems, 0, compostItems.length - 1);
        quickSort(recyclableItems, 0, recyclableItems.length - 1);
        quickSort(trashableItems, 0, trashableItems.length - 1);
        
        
        
        frame = new JFrame("Find an Item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(new GridLayout(0,1));
        panel2 = new JPanel();
        panel2.setBackground(Color.YELLOW);
        //panel2.setLayout(new GridLayout(0,1));
        panel3 = new JPanel();
        panel3.setBackground(Color.YELLOW);
        text = new JTextField("");
        text.setPreferredSize( new Dimension( 200, 24 ) );
        welcomeTitle = new JLabel("       Find an Item");
        welcomeTitle.setFont(new Font("Courier New", Font.PLAIN, 30));
        find = new JButton("Find");
        back = new JButton("Back");
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setForeground(Color.BLUE);
        find.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (find.isEnabled()) {
                    String s = text.getText(); 
                    if(binarySearch(compostItems, s) == -1) {
                        if(binarySearch(recyclableItems, s) == -1) {
                            if(binarySearch(trashableItems, s) == -1) {
                                text.setText("Item not found");
                                text.setForeground(Color.RED);
                            }
                            else {
                                text.setText("Trash");
                                text.setForeground(Color.GREEN);
                            }
                        }
                        else {
                            text.setText("Recycle");
                            text.setForeground(Color.GREEN);
                        }
                    }
                    else {
                        text.setText("Compost");
                        text.setForeground(Color.GREEN);
                    }
                    
                }
            }
        });
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (back.isEnabled()) {
                    frame.setVisible(false);
                    frame.dispose();
                    HomeScreen hs = new HomeScreen();
                    
                }
            }
        });
        
        
        panel.add(welcomeTitle);
        panel2.add(find);
        panel2.add(text);
        panel3.add(back);
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocation(400,100);
        frame.setVisible(true);
    }
    
    private static void quickSort(String[] a, int start, int end) {

        int i = start;
        int j = end;
        if (j - i >= 1) {
            String pivot = a[i];
            while (j > i) {
                while (a[i].compareTo(pivot) <= 0 && i < end && j > i) {
                    i++;
                }
                while (a[j].compareTo(pivot) >= 0 && j > start && j >= i) {
                    j--;
                }
                if (j > i)
                    swap(a, i, j);
            }
            swap(a, start, j);
            quickSort(a, start, j - 1);
            quickSort(a, j + 1, end);
        }
    }

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int binarySearch(String[] arr, String x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = x.compareTo(arr[m]);
            if (res == 0)
                return m;
            if (res > 0)
                l = m + 1;
            else
                r = m - 1;
        }

        return -1;
    }

}
