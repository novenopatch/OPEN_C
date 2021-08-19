import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Les autres imports
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    //private JComboBox combo = new JComboBox();
    private JLabel label = new JLabel("Une ComboBox");
    //Les variables d'instance restent inchangées
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.WHITE);
        container.setLayout(new BorderLayout());

        
        //Le début ne change pas
        //Ici, nous changeons juste la façon d'initialiser la JComboBox
        String[] tab = {"Option 1", "Option 2", "Option 3", "Option 4"};
        JComboBox combo = new JComboBox(tab);
        //Ajout du listener
        combo.addItemListener(new ItemState());
        combo.setPreferredSize(new Dimension(100, 20));
        combo.setForeground(Color.blue);

        JPanel top = new JPanel();
        top.add(label);
        top.add(combo);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }
    //La fin reste inchangée
    //Classe interne implémentant l'interface ItemListener
    class ItemState implements ItemListener{
        public void itemStateChanged(ItemEvent e) {
            System.out.println("événement déclenché sur : " + e.getItem());
        }
    }
}

/*

Vous voyez que lorsque nous cliquons sur une autre option, notre objet commence par modifier l'état de l'option précédente
(l'état passe en DESELECTED) avant de changer celui de l'option choisie (celle-ci passe à l'état SELECTED). Nous pouvons
donc suivre très facilement l'état de nos éléments grâce à cette interface ; cependant, pour plus de simplicité, nous utiliserons
l'interface ActionListener afin de récupérer l'option sélectionnée.
Voici un code implémentant cette interface :

//Les autres imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Fenetre extends JFrame {
//Les variables d'instance restent inchangées
    public Fenetre(){
        //Le début ne change pas
        String[] tab = {"Option 1", "Option 2", "Option 3", "Option 4"};
        combo = new JComboBox(tab);
        //Ajout du listener
        combo.addItemListener(new ItemState());
        combo.addActionListener(new ItemAction());
        combo.setPreferredSize(new Dimension(100, 20));
        combo.setForeground(Color.blue);
        //La fin reste inchangée
    }
//La classe interne ItemState reste inchangée
    class ItemAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionListener : action sur " + combo.getSelectedItem());
        }
    }
}


*/
/*

Vous constatez qu'en utilisant cette méthode, nous pouvons récupérer l'option sur laquelle l'action a été effectuée. L'appel de la
méthode getSelectedItem() retourne la valeur de l'option sélectionnée ; une fois récupérée, nous pouvons travailler avec
notre liste !
Maintenant que nous savons comment récupérer les informations dans une liste, je vous invite à continuer notre animation.

*/