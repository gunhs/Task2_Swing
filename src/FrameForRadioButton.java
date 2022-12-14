import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameForRadioButton extends JFrame {
    JLabel label;
    ButtonGroup grpBackground;
    JRadioButton rdColorBackground;
    JRadioButton grColorBackground;
    ButtonGroup grpLabel;
    JRadioButton ylColorLabel;
    JRadioButton blColorLabel;
    ActionListener listenerBackground;
    ActionListener listenerLabel;
    JPanel pnl1;
    JPanel pnl2;
    JPanel pnl3;
    JPanel pnl4;
    JPanel pnl5;

    public FrameForRadioButton() {
        setLocation(500, 300);
        createGUI();
        setResizable(true);
        pack();
        setSize(250, 200);
    }

    private void createGUI() {
        pnl4 = new JPanel();
        pnl4.setLayout(new FlowLayout());
        pnl3 = new JPanel();
        pnl3.setLayout(new FlowLayout());
        pnl2 = new JPanel();
        pnl2.setLayout(new FlowLayout());
        pnl5 = new JPanel();
        pnl5.setLayout(new FlowLayout());
        pnl1 = new JPanel();
        pnl1.setLayout(new FlowLayout());
        grpBackground = new ButtonGroup();
        rdColorBackground = new JRadioButton("Красный", false);
        grpBackground.add(rdColorBackground);
        grColorBackground = new JRadioButton("Зелёный", true);
        grpBackground.add(grColorBackground);
        grpLabel = new ButtonGroup();
        ylColorLabel = new JRadioButton("Жёлтый", false);
        grpLabel.add(ylColorLabel);
        blColorLabel = new JRadioButton("Серый", true);
        grpLabel.add(blColorLabel);
        label = new JLabel("Управление цветом");
        label.setFont(new Font("Serif", Font.BOLD, 16));

        listenerBackground = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (rdColorBackground.isSelected()) {
                    pnl1.setBackground(Color.red);
                    pnl2.setBackground(Color.red);
                    blColorLabel.setBackground(Color.red);
                    ylColorLabel.setBackground(Color.red);
                    rdColorBackground.setBackground(Color.red);
                    grColorBackground.setBackground(Color.red);
                    pnl3.setBackground(Color.red);
                    pnl5.setBackground(Color.red);
                    getContentPane().setBackground(Color.red);
                } else if (grColorBackground.isSelected()) {
                    pnl1.setBackground(Color.green);
                    pnl2.setBackground(Color.green);
                    blColorLabel.setBackground(Color.green);
                    ylColorLabel.setBackground(Color.green);
                    grColorBackground.setBackground(Color.green);
                    rdColorBackground.setBackground(Color.green);
                    pnl3.setBackground(Color.green);
                    pnl5.setBackground(Color.green);
                    getContentPane().setBackground(Color.green);
                }
            }
        };
        grColorBackground.addActionListener(listenerBackground);
        rdColorBackground.addActionListener(listenerBackground);

        listenerLabel = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (ylColorLabel.isSelected()) {
                    pnl4.setBackground(Color.yellow);
                    label.setBackground(Color.yellow);
                } else if (grColorBackground.isSelected()) {
                    label.setBackground(Color.gray);
                    pnl4.setBackground(Color.gray);
                }
                revalidate();
                repaint();
            }
        };
        ylColorLabel.addActionListener(listenerLabel);
        blColorLabel.addActionListener(listenerLabel);

        pnl4.add(label);
        pnl3.add(new JLabel("Управление цветом фона"));
        pnl1.add(rdColorBackground);
        pnl1.add(grColorBackground);
        pnl5.add(new JLabel("Управление цветом фона метки"));
        pnl2.add(ylColorLabel);
        pnl2.add(blColorLabel);

        setLayout(new GridLayout(5, 1));
        getContentPane().add(pnl4);
        getContentPane().add(pnl3);
        getContentPane().add(pnl2);
        getContentPane().add(pnl5);
        getContentPane().add(pnl1);
    }

    public static void main(String[] args) {
        FrameForRadioButton frm = new FrameForRadioButton();
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}