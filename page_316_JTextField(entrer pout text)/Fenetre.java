
import java.awt.BorderLayout;
import java.awt.Font;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JTextField jtf = new JTextField("Valeur par défaut");
    private JLabel label = new JLabel("Un JTextField");
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        Font police = new Font("Arial", Font.BOLD, 14);
        jtf.setFont(police);
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        top.add(label);
        top.add(jtf);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }
}

/*

    Nous pouvons initialiser le contenu avec la méthode setText(String str) ou le récupérer grâce à la méthode
getText().
Il existe un objet très ressemblant à celui-ci, en un peu plus étoffé. En fait, cet objet permet de créer un JTextField formaté
pour recevoir un certain type de données saisies (date, pourcentage etc.). Voyons cela tout de suite.

*/