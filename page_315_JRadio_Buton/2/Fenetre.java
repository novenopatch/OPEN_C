import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.ButtonGroup;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JRadioButton jr1 = new JRadioButton("Radio 1");
    private JRadioButton jr2 = new JRadioButton("Radio 2");

    //Les autres variables
    private ButtonGroup bg = new ButtonGroup();
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        //Les autres instructions
        jr1.setSelected(true);
        jr1.addActionListener(new StateListener());
        jr2.addActionListener(new StateListener());
        //On ajoute les boutons au groupe
        bg.add(jr1);
        bg.add(jr2);
        top.add(jr1);
        top.add(jr2);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }
    class StateListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("source : " + jr1.getText() + " - état : " + jr1.isSelected());
            System.out.println("source : " + jr2.getText() + " - état : " + jr2.isSelected());
        }
    }
}