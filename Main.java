package braingames;
// VENKATA K C RITVIK GOPARAJU
// DHARMIK GOGINENI
// BALANAGU SREERAMAN 

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    Main() {
        displayMainFrame();
    }

    public static void displayMainFrame() {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();

        // added later to beautify  - begin
        JPanel container = new JPanel();
        JPanel pHeading = new JPanel();
        JPanel pLab = new JPanel();
        JLabel labHeading = new JLabel();
        JLabel lab = new JLabel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        labHeading.setText("Brain Games for Kids (BRAIGS4KIDS)");
        labHeading.setFont(new Font("Serif", Font.PLAIN, 24));
        lab.setText("Click on a game to play!");
        lab.setFont(new Font("Serif", Font.PLAIN, 14));
        pHeading.add(labHeading);
        pHeading.add(labHeading);
        pLab.add(lab);
        container.add(pHeading);
        container.add(p);
        container.add(pLab);
        // added later to beautify  - end
        
        JButton b1 = new JButton("Color Find Game");
        b1.setPreferredSize(new Dimension(150, 100));
        JButton b2 = new JButton("Secret Code Game");
        b2.setPreferredSize(new Dimension(150, 100));
        p.add(b1);
        p.add(b2);
        
        // added later to beautify  - begin
        //f.add(p);
        f.add(container);
        // added later to beautify  - end
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ColorFind cF = new ColorFind();
                f.dispose();
                cF.createQuestion();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //secretcode sec=new secretcode();
                f.dispose();
            }
        });
    }

    public static void main(String args[]) {
        displayMainFrame();
    }
}
