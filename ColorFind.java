package braingames;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.Date;

public class ColorFind {

    private static int score = 0, highScore = 0;
    private static String[] colours = {"Blue", "Green", "Yellow", "Red", "Orange", "Black"};
    private static long startTime = System.currentTimeMillis();
    private static long elapsedTime = 0L;
    private static long totalTime = 5 * 1000;

    private static void incrementScore() {
        score = score + 50;
    }

    private static void decrementScore() {
        score = score - 100;
    }

    public static void createQuestion() {
        if (checkElapsedTime(elapsedTime, totalTime) == true) {
            //creates 4 random numbers from 0 to 5 and one answer from those 4 random numbers
            Random rand = new Random();
            int randomNum1 = rand.nextInt((5 - 0) + 1) + 0;
            int randomNum2 = rand.nextInt((5 - 0) + 1) + 0;
            while (randomNum2 == randomNum1) {
                randomNum2 = rand.nextInt((5 - 0) + 1) + 0;
            }
            int randomNum3 = rand.nextInt((5 - 0) + 1) + 0;
            while (randomNum3 == randomNum1 || randomNum3 == randomNum2) {
                randomNum3 = rand.nextInt((5 - 0) + 1) + 0;
            }
            int randomNum4 = rand.nextInt((5 - 0) + 1) + 0;
            while (randomNum4 == randomNum1 || randomNum4 == randomNum2 || randomNum4 == randomNum3) {
                randomNum4 = rand.nextInt((5 - 0) + 1) + 0;
            }
            int answer = rand.nextInt((5 - 0) + 1) + 0;
            while (answer != randomNum1 && answer != randomNum2 && answer != randomNum3 && answer != randomNum4) {
                answer = rand.nextInt((5 - 0) + 1) + 0;
            }
            displayQuestion(randomNum1, randomNum2, randomNum3, randomNum4, answer);
            return;
        } else {
            // returns to this condition after time elapsed 
            JFrame f = new JFrame();

            // added later to beautify  - begin
            JPanel pLab = new JPanel();
            JPanel container = new JPanel();
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            // added later to beautify  - end

            f.setVisible(true);
            f.setSize(400, 400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel p = new JPanel();
            JLabel lab = new JLabel();
            lab.setText("Your score is " + score);
            
            // added later to beautify  - begin
            //p.add(lab);
            pLab.add(lab);
            container.add(pLab);
            container.add(p);
            // added later to beautify  - end
            
            JButton b11 = new JButton("Play again");
            JButton b12 = new JButton("Main menu");
            p.add(b11);
            p.add(b12);

            // added later to beautify  - begin
            //f.add(p);
            f.add(container);
            // added later to beautify  - end
            
            b11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    startTime = System.currentTimeMillis();
                    elapsedTime = 0L;
                    score = 0;
                    f.dispose();
                    createQuestion();
                }
            });
            b12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Main m = new Main();
                    f.dispose();
                    startTime = System.currentTimeMillis();
                    elapsedTime = 0L;
                    score = 0;
                    m.displayMainFrame();
                }
            });
            return;
        }
    }

    public static void displayQuestion(int randomNum1, int randomNum2, int randomNum3, int randomNum4, int answer) {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(800, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();

        // added later to beautify  - begin
        JPanel container = new JPanel();
        JPanel pHeading = new JPanel();
        JPanel pLab = new JPanel();
        JPanel pLabInstructions = new JPanel();
        JPanel pLabInstructions1 = new JPanel();
        JLabel labHeading = new JLabel();
        JLabel labInstructions = new JLabel();
        JLabel labInstructions1 = new JLabel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        labHeading.setText("Color Find");
        labHeading.setFont(new Font("Serif", Font.PLAIN, 24));
        labInstructions.setText("Click on the color asked. Maximize your score in " + totalTime / 1000 + " seconds!");
        labInstructions.setFont(new Font("Serif", Font.PLAIN, 14));
        labInstructions1.setText("You'll get 50 for correct answer and lose 100 for wrong answer");
        labInstructions1.setFont(new Font("Serif", Font.PLAIN, 14));
        pHeading.add(labHeading);
        pLabInstructions.add(labInstructions);
        pLabInstructions1.add(labInstructions1);
        container.add(pHeading);
        container.add(p);
        container.add(pLab);
        container.add(pLabInstructions);
        container.add(pLabInstructions1);
        // added later to beautify  - end

        // creates 4 different coloured buttons
        JButton b1 = new JButton();
        if (colours[randomNum1] == "Yellow") {
            b1.setBackground(Color.YELLOW);
        } else if (colours[randomNum1] == "Blue") {
            b1.setBackground(Color.BLUE);
        } else if (colours[randomNum1] == "Green") {
            b1.setBackground(Color.GREEN);
        } else if (colours[randomNum1] == "Black") {
            b1.setBackground(Color.BLACK);
        } else if (colours[randomNum1] == "Red") {
            b1.setBackground(Color.RED);
        } else if (colours[randomNum1] == "Orange") {
            b1.setBackground(Color.ORANGE);
        }
        b1.setPreferredSize(new Dimension(150, 150));
        p.add(b1);

        JButton b2 = new JButton();
        if (colours[randomNum2] == "Yellow") {
            b2.setBackground(Color.YELLOW);
        } else if (colours[randomNum2] == "Blue") {
            b2.setBackground(Color.BLUE);
        } else if (colours[randomNum2] == "Green") {
            b2.setBackground(Color.GREEN);
        } else if (colours[randomNum2] == "Black") {
            b2.setBackground(Color.BLACK);
        } else if (colours[randomNum2] == "Red") {
            b2.setBackground(Color.RED);
        } else if (colours[randomNum2] == "Orange") {
            b2.setBackground(Color.ORANGE);
        }
        b2.setPreferredSize(new Dimension(150, 150));
        p.add(b2);

        JButton b3 = new JButton();
        if (colours[randomNum3] == "Yellow") {
            b3.setBackground(Color.YELLOW);
        } else if (colours[randomNum3] == "Blue") {
            b3.setBackground(Color.BLUE);
        } else if (colours[randomNum3] == "Green") {
            b3.setBackground(Color.GREEN);
        } else if (colours[randomNum3] == "Black") {
            b3.setBackground(Color.BLACK);
        } else if (colours[randomNum3] == "Red") {
            b3.setBackground(Color.RED);
        } else if (colours[randomNum3] == "Orange") {
            b3.setBackground(Color.ORANGE);
        }
        b3.setPreferredSize(new Dimension(150, 150));
        p.add(b3);

        JButton b4 = new JButton();
        if (colours[randomNum4] == "Yellow") {
            b4.setBackground(Color.YELLOW);
        } else if (colours[randomNum4] == "Blue") {
            b4.setBackground(Color.BLUE);
        } else if (colours[randomNum4] == "Green") {
            b4.setBackground(Color.GREEN);
        } else if (colours[randomNum4] == "Black") {
            b4.setBackground(Color.BLACK);
        } else if (colours[randomNum4] == "Red") {
            b4.setBackground(Color.RED);
        } else if (colours[randomNum4] == "Orange") {
            b4.setBackground(Color.ORANGE);
        }
        b4.setPreferredSize(new Dimension(150, 150));
        p.add(b4);

        JLabel lab = new JLabel();
        if (answer == 0) {
            lab.setText(colours[0]);
            if ((randomNum1 == 1 || randomNum2 == 1 || randomNum3 == 1 || randomNum4 == 1)) {
                lab.setForeground(Color.green);
                lab.setOpaque(true);
            } else if ((randomNum1 == 2 || randomNum2 == 2 || randomNum3 == 2 || randomNum4 == 2)) {
                lab.setForeground(Color.yellow);
                lab.setOpaque(true);
            } else if ((randomNum1 == 3 || randomNum2 == 3 || randomNum3 == 3 || randomNum4 == 3)) {
                lab.setForeground(Color.red);
                lab.setOpaque(true);
            } else if ((randomNum1 == 4 || randomNum2 == 4 || randomNum3 == 4 || randomNum4 == 4)) {
                lab.setForeground(Color.orange);
                lab.setOpaque(true);
            }

        } else if (answer == 1) {
            lab.setText(colours[1]);
            if ((randomNum1 == 0 || randomNum2 == 0 || randomNum3 == 0 || randomNum4 == 0)) {
                lab.setForeground(Color.blue);
                lab.setOpaque(true);
            } else if ((randomNum1 == 2 || randomNum2 == 2 || randomNum3 == 2 || randomNum4 == 2)) {
                lab.setForeground(Color.yellow);
                lab.setOpaque(true);
            } else if ((randomNum1 == 3 || randomNum2 == 3 || randomNum3 == 3 || randomNum4 == 3)) {
                lab.setForeground(Color.red);
                lab.setOpaque(true);
            } else if ((randomNum1 == 4 || randomNum2 == 4 || randomNum3 == 4 || randomNum4 == 4)) {
                lab.setForeground(Color.orange);
                lab.setOpaque(true);
            }
        } else if (answer == 2) {
            lab.setText(colours[2]);
            if ((randomNum1 == 0 || randomNum2 == 0 || randomNum3 == 0 || randomNum4 == 0)) {
                lab.setForeground(Color.blue);
                lab.setOpaque(true);
            } else if ((randomNum1 == 1 || randomNum2 == 1 || randomNum3 == 1 || randomNum4 == 1)) {
                lab.setForeground(Color.green);
                lab.setOpaque(true);
            } else if ((randomNum1 == 3 || randomNum2 == 3 || randomNum3 == 3 || randomNum4 == 3)) {
                lab.setForeground(Color.red);
                lab.setOpaque(true);
            } else if ((randomNum1 == 4 || randomNum2 == 4 || randomNum3 == 4 || randomNum4 == 4)) {
                lab.setForeground(Color.orange);
                lab.setOpaque(true);
            }
        } else if (answer == 3) {
            lab.setText(colours[3]);
            if ((randomNum1 == 0 || randomNum2 == 0 || randomNum3 == 0 || randomNum4 == 0)) {
                lab.setForeground(Color.blue);
                lab.setOpaque(true);
            } else if ((randomNum1 == 1 || randomNum2 == 1 || randomNum3 == 1 || randomNum4 == 1)) {
                lab.setForeground(Color.green);
                lab.setOpaque(true);
            } else if ((randomNum1 == 2 || randomNum2 == 2 || randomNum3 == 2 || randomNum4 == 2)) {
                lab.setForeground(Color.yellow);
                lab.setOpaque(true);
            } else if ((randomNum1 == 4 || randomNum2 == 4 || randomNum3 == 4 || randomNum4 == 4)) {
                lab.setForeground(Color.orange);
                lab.setOpaque(true);
            }
        } else if (answer == 4) {
            lab.setText(colours[4]);
            if ((randomNum1 == 0 || randomNum2 == 0 || randomNum3 == 0 || randomNum4 == 0)) {
                lab.setForeground(Color.blue);
                lab.setOpaque(true);
            } else if ((randomNum1 == 1 || randomNum2 == 1 || randomNum3 == 1 || randomNum4 == 1)) {
                lab.setForeground(Color.green);
                lab.setOpaque(true);
            } else if ((randomNum1 == 2 || randomNum2 == 2 || randomNum3 == 2 || randomNum4 == 2)) {
                lab.setForeground(Color.yellow);
                lab.setOpaque(true);
            } else if ((randomNum1 == 3 || randomNum2 == 3 || randomNum3 == 3 || randomNum4 == 3)) {
                lab.setForeground(Color.red);
                lab.setOpaque(true);
            }
        } else if (answer == 5) {
            lab.setText(colours[5]);
            if ((randomNum1 == 0 || randomNum2 == 0 || randomNum3 == 0 || randomNum4 == 0)) {
                lab.setForeground(Color.blue);
                lab.setOpaque(true);
            } else if ((randomNum1 == 1 || randomNum2 == 1 || randomNum3 == 1 || randomNum4 == 1)) {
                lab.setForeground(Color.green);
                lab.setOpaque(true);
            } else if ((randomNum1 == 2 || randomNum2 == 2 || randomNum3 == 2 || randomNum4 == 2)) {
                lab.setForeground(Color.yellow);
                lab.setOpaque(true);
            } else if ((randomNum1 == 3 || randomNum2 == 3 || randomNum3 == 3 || randomNum4 == 3)) {
                lab.setForeground(Color.red);
                lab.setOpaque(true);
            }
        }
        
        // added later to beautify  - begin
        //p.add(lab);        
        pLab.add(lab);
        // added later to beautify  - end
        
        JLabel score_lab = new JLabel();
        p.add(score_lab);
        
        // added later to beautify  - begin
        //f.add(p);
        f.add(container);
        // added later to beautify  - end

        // performs all the functions on clicking those buttons
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (answer == randomNum1) {
                    incrementScore();
                    f.dispose();
                    createQuestion();
                } else {
                    decrementScore();
                    f.dispose();
                    createQuestion();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (answer == randomNum2) {
                    incrementScore();
                    f.dispose();
                    createQuestion();
                } else {
                    decrementScore();
                    f.dispose();
                    createQuestion();
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (answer == randomNum3) {
                    incrementScore();
                    f.dispose();
                    createQuestion();
                } else {
                    decrementScore();
                    f.dispose();
                    createQuestion();
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (answer == randomNum4) {
                    incrementScore();
                    f.dispose();
                    createQuestion();
                } else {
                    decrementScore();
                    f.dispose();
                    createQuestion();
                }
            }
        });
        return;
    }

    public static boolean checkElapsedTime(long elapTime, long totalTime) {
        // this function compares the time
        elapTime = (new Date()).getTime() - startTime;
        if (elapTime < totalTime) {
            return true;
        } else {
            return false;
        }
    }
}
