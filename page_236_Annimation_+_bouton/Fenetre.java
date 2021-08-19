
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Fenetre extends JFrame{
    private Panneau pan = new Panneau();
    private JButton bouton = new JButton("mon bouton");
    private JPanel container = new JPanel();
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);

        container.setLayout(new BorderLayout());
        
        container.add(pan, BorderLayout.CENTER);
        container.add(bouton, BorderLayout.SOUTH);
        this.setContentPane(container);
        this.setVisible(true);
        go();
        }
        private void go(){
            //Les coordonnées de départ de notre rond
            int x = pan.getPosX(), y = pan.getPosY();
            //Le booléen pour savoir si l'on recule ou non sur l'axe x
            boolean backX = false;
            //Le booléen pour savoir si l'on recule ou non sur l'axe y
            boolean backY = false;
            //Dans cet exemple, j'utilise une boucle while
            //Vous verrez qu'elle fonctionne très bien
            while(true){
                //Si la coordonnée x est inférieure à 1, on avance
                if(x < 1)
                    backX = false;
                //Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
                if(x > pan.getWidth()-50)
                    backX = true;
                //Idem pour l'axe y
                if(y < 1)
                    backY = false;
                if(y > pan.getHeight()-50)
                    backY = true;
                //Si on avance, on incrémente la coordonnée
                if(!backX)
                    pan.setPosX(++x);
                //Sinon, on décrémente
                else
                    pan.setPosX(--x);
                //Idem pour l'axe Y
                if(!backY)
                    pan.setPosY(++y);
                else
                    pan.setPosY(--y);
                //On redessine notre Panneau
                pan.repaint();
                //Comme on dit : la pause s'impose ! Ici, trois millièmes de seconde
                try {
                    Thread.sleep(3);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}
/*
Un bouton s'utilise avec la classe JButton présente dans le package javax.swing.
Pour ajouter un bouton dans une fenêtre, vous devez utiliser la méthode add() de son content pane.
Il existe des objets permettant de positionner les composants sur un content pane ou un conteneur : les layout managers.
Les layout managers se trouvent dans le package java.awt.
Le layout manager par défaut du content pane d'un objet JFrame est le BorderLayout.
Le layout manager par défaut d'un objet JPanel est le FlowLayout.
Outre le FlowLayout et le BorderLayout, il existe le GridLayout, le CardLayout, le BoxLayout et le
GridBagLayout. La liste n'est pas exhaustive.
On définit un layout sur un conteneur grâce à la méthode setLayout().

*/
