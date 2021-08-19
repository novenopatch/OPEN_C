
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
    private Panneau pan = new Panneau();
    private JButton bouton = new JButton("Go");
    private JButton bouton2 = new JButton("Stop");
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Choix de la forme");
    private int compteur = 0;
    private boolean animated = true;
    private boolean backX, backY;
    private int x, y;
    private Thread t;
    private JComboBox combo = new JComboBox();
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);
        bouton.addActionListener(new BoutonListener());
        bouton2.addActionListener(new Bouton2Listener());
        bouton2.setEnabled(false);
        JPanel south = new JPanel();
        south.add(bouton);
        south.add(bouton2);
        container.add(south, BorderLayout.SOUTH);
        combo.addItem("ROND");
        combo.addItem("CARRE");
        combo.addItem("TRIANGLE");
        combo.addItem("ETOILE");
        combo.addActionListener(new FormeListener());

        JPanel top = new JPanel();
        top.add(label);
        top.add(combo);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }
    private void go(){
        x = pan.getPosX();
        y = pan.getPosY();
        while(this.animated){
            if(x < 1) 
                backX = false;
            if(x > pan.getWidth() - 50) 
                backX = true;
            if(y < 1) 
                backY = false;
            if(y > pan.getHeight() - 50) 
                backY = true;
            if(!backX) 
                pan.setPosX(++x);
            else 
                pan.setPosX(--x);
            if(!backY) 
                pan.setPosY(++y);
            else 
                pan.setPosY(--y);
            pan.repaint();
            try {
                Thread.sleep(3);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //Classe écoutant notre bouton
    public class BoutonListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
        animated = true;
        t = new Thread(new PlayAnimation());
        t.start();
        bouton.setEnabled(false);
        bouton2.setEnabled(true);
    }
    }
    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        animated = false;
        bouton.setEnabled(true);
        bouton2.setEnabled(false);
        }
    }
    class PlayAnimation implements Runnable{
        public void run() {
        go();
        }
    }
    class FormeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //La méthode retourne un Object puisque nous passons des Object dans une liste
            //Il faut donc utiliser la méthode toString() pour retourner un String (ou utiliser un cast)
            pan.setForme(combo.getSelectedItem().toString());
        }
    }
}