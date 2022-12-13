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
    JPanel pnl4;

    public FrameForRadioButton() {
        setLocation(500, 300);
        createGUI();
        setResizable(true);
        pack();
        setSize(200, 200);
    }

    private void createGUI() {
        pnl4 = new JPanel();
        pnl4.setLayout(new FlowLayout());
        pnl2 = new JPanel();
        pnl2.setLayout(new FlowLayout());
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

        listenerBackground = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (rdColorBackground.isSelected()) {
                    pnl1.setBackground(Color.red);
                    pnl2.setBackground(Color.red);
                    blColorLabel.setBackground(Color.red);
                    ylColorLabel.setBackground(Color.red);
                    rdColorBackground.setBackground(Color.red);
                    grColorBackground.setBackground(Color.red);
                } else if (grColorBackground.isSelected()) {
                    pnl1.setBackground(Color.green);
                    pnl2.setBackground(Color.green);
                    blColorLabel.setBackground(Color.green);
                    ylColorLabel.setBackground(Color.green);
                    grColorBackground.setBackground(Color.green);
                    rdColorBackground.setBackground(Color.green);
                }
            }
        };
        grColorBackground.addActionListener(listenerBackground);
        rdColorBackground.addActionListener(listenerBackground);

        listenerLabel = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (ylColorLabel.isSelected()) {
                    pnl4.setBackground(Color.yellow);
                } else if (grColorBackground.isSelected()) {
                    pnl4.setBackground(Color.gray);
                }
            }
        };
        ylColorLabel.addActionListener(listenerLabel);
        blColorLabel.addActionListener(listenerLabel);
        label = new JLabel("Управление цветом");
        label.setFont(new Font("Serif", Font.PLAIN, 12));

        pnl4.add(new JLabel("Управление цветом"));
        pnl1.add(rdColorBackground);
        pnl1.add(grColorBackground);
        pnl2.add(ylColorLabel);
        pnl2.add(blColorLabel);

        setLayout(new GridLayout(3, 1));
        getContentPane().add(pnl4);
        getContentPane().add(pnl2);
        getContentPane().add(pnl1);
    }

    public static void main(String[] args) {
        FrameForRadioButton frm = new FrameForRadioButton();
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}