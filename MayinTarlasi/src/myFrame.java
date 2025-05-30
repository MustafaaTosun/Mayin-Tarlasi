import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class myFrame implements ActionListener {
    List<JButton> buttons;
    JLabel l1 = new JLabel();

    JButton button1 = new JButton();
    static JButton button;
    JFrame frame;
    JFrame frame2 = new JFrame();
    static Border border = BorderFactory.createLineBorder(Color.gray, 5);

    static JLabel label1;
    JPanel panel;
    static JLabel labels[];

    myFrame() {

        buttons = new ArrayList<>();

        frame = new JFrame();


        labels = createLabel();
        for (int i = 0; i < 100; i++) {

            button = new JButton();
            button.setSize(50, 50);
            labels[i].add(button);
            //labels[i].setLayout(new GridLayout());
            button.addActionListener(this);
            buttons.add(button);


        }


        for (int i = 0; i < 100; i++) {
            frame.add(labels[i]);

        }
        button1.setSize(50, 50);
        button1.setBounds(275, 255, 100, 40);
        button1.setText("Try again");
        button1.setFont(new Font("Calibri",1,15));
        button1.setBorder(border);
        button1.setBackground(Color.cyan);


        l1.add(button1);
        button1.addActionListener(this);

        frame.setSize(518, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new GridLayout(10, 10));
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 100; i++) {
            if (e.getSource() == buttons.get(i)) {
                buttons.get(i).setVisible(false);
                if (labels[i].getText().equals("-1")) {

                    frame2.setSize(640, 360);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    ImageIcon a = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\MayinTarlasi\\src\\gameover.jpg");
                    l1.setOpaque(true);
                    l1.setBackground(Color.DARK_GRAY);
                    l1.setBounds(250, 250, 640, 360);

                    l1.setHorizontalAlignment(JLabel.CENTER);
                    l1.setVerticalAlignment(JLabel.CENTER);
                    l1.setIcon(a);
                    l1.setVisible(true);


                    frame2.add(l1);
                    frame.setVisible(false);
                    frame2.setVisible(true);

                }


                if (labels[i].getText().equals("0") && !(i % 10 == 0)) {
                    if (i + 10 < 100) {
                        buttons.get(i + 9).setVisible(false);
                    }
                    if (i > 10) {
                        buttons.get(i - 11).setVisible(false);
                    }

                    buttons.get(i - 1).setVisible(false);
                }
                if (labels[i].getText().equals("0") && !(i % 10 == 9)) {
                    if (i + 10 < 100) {
                        buttons.get(i + 11).setVisible(false);
                    }
                    if (!(i - 10 <= 0)) {
                        buttons.get(i - 9).setVisible(false);
                    }

                    buttons.get(i + 1).setVisible(false);

                }
                if ((labels[i].getText().equals("0") && (i + 10 < 100))) {
                    buttons.get(i + 10).setVisible(false);
                }

                if (labels[i].getText().equals("0") && !(i - 10 < 0)) {

                    buttons.get(i - 10).setVisible(false);

                }
            }
        }
        if (e.getSource() == button1) {
            new myFrame();
            frame2.setVisible(false);
        }


    }

    public static JLabel[] createLabel() {
        labels = new JLabel[100];
        int[] a = mayinTarlasi.game(mayinTarlasi.board());
        for (int i = 0; i < 100; i++) {
            label1 = new JLabel();
            label1.setBackground(Color.DARK_GRAY);
            label1.setBorder(border);
            label1.setLayout(new GridLayout());

            label1.setText(a[i] + "");
            label1.setHorizontalAlignment(JLabel.CENTER);
            label1.setVerticalAlignment(JLabel.CENTER);
            labels[i] = label1;
        }

        return labels;
    }


}