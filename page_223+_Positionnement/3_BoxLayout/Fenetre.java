/*  
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
*/

/*      
    L'objet BoxLayout
    Grâce à lui, vous pourrez ranger vos composants à la suite soit sur une ligne, soit sur une colonne. Le mieux, c'est encore un
    exemple de rendu (voir figure suivante) avec un code
    

*/
/* 
public class Fenetre extends JFrame {
    public Fenetre(){
        this.setTitle("Box Layout");
        this.setSize(300, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel b1 = new JPanel();
        //On définit le layout en lui indiquant qu'il travaillera en ligne
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(new JButton("Bouton 1"));
        JPanel b2 = new JPanel();
        //Idem pour cette ligne
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
        b2.add(new JButton("Bouton 2"));
        b2.add(new JButton("Bouton 3"));
        JPanel b3 = new JPanel();
        //Idem pour cette ligne
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(new JButton("Bouton 4"));
        b3.add(new JButton("Bouton 5"));
        b3.add(new JButton("Bouton 6"));
        JPanel b4 = new JPanel();
        //On positionne maintenant ces trois lignes en colonne
        b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);
        this.getContentPane().add(b4);
        this.setVisible(true);
    }
   
}
*/

 /*
    Ce code est simple : on crée trois JPanel contenant chacun un certain nombre de JButton rangés en ligne grâce à l'attribut
    LINE_AXIS. Ces trois conteneurs créés, nous les rangeons dans un quatrième où, cette fois, nous les agençons dans une
    colonne grâce à l'attribut PAGE_AXIS. Rien de compliqué, vous en conviendrez, mais vous devez savoir qu'il existe un moyen
    encore plus simple d'utiliser ce layout : via l'objet Box. Ce dernier n'est rien d'autre qu'un conteneur paramétré avec un
    BoxLayout. 
    Voici un code affichant la même chose que le précédent :
*/
    import javax.swing.Box;
    import javax.swing.JButton;
    import javax.swing.JFrame;

        public class Fenetre extends JFrame{
            public Fenetre(){
            this.setTitle("Box Layout");
            this.setSize(300, 120);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            //On crée un conteneur avec gestion horizontale
            Box b1 = Box.createHorizontalBox();
            b1.add(new JButton("Bouton 1"));
            //Idem
            Box b2 = Box.createHorizontalBox();
            b2.add(new JButton("Bouton 2"));
            b2.add(new JButton("Bouton 3"));
            //Idem
            Box b3 = Box.createHorizontalBox();
            b3.add(new JButton("Bouton 4"));
            b3.add(new JButton("Bouton 5"));
            b3.add(new JButton("Bouton 6"));
            //On crée un conteneur avec gestion verticale
            Box b4 = Box.createVerticalBox();
            b4.add(b1);
            b4.add(b2);
            b4.add(b3);
            this.getContentPane().add(b4);
            this.setVisible(true);
        }
    }
