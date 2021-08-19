import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Les imports restent inchangés
public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    String[] tab = {"Option 1", "Option 2", "Option 3", "Option 4"};
    private JComboBox combo = new JComboBox(tab);
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

        combo.setPreferredSize(new Dimension(100, 20));//car par defaut il est trop petit
        //...
        //combo.addItem("Option 1");
        //combo.addItem("Option 2");
        //combo.addItem("Option 3");
        //combo.addItem("Option 4");
        

        
    
        JPanel top = new JPanel();
        top.add(label);
        top.add(combo);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
       
    }
}
//...