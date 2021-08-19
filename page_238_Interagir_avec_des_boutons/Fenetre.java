import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener{

    private Panneau pan = new Panneau();

    

    //comptenue de mon probleme d'affichage j'ai preferer embandonner le bouton personnalise de la classe bouton au profit du par defaut de jbouton
    private JButton bouton = new JButton("bouton 1");
    private JButton bouton2 = new JButton("bouton 2");

    private JPanel container = new JPanel();
    

    private JLabel label = new JLabel("Le JLabel");

    private JLabel labelCompteur = new JLabel("C");

    //Compteur de clics
    private int compteur = 0;
    private int compteur1 = 0;
    private int compteur2 = 0;
    

    public Fenetre(){
        
        this.setTitle("Animation");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        //defini le type d'object de psitionement a utiliser
        container.setLayout(new BorderLayout());
        //1 pour le pan centrer
        container.add(pan, BorderLayout.CENTER);


        
        /*
        //Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
        bouton.addActionListener(this);
        //page 250
        bouton2.addActionListener(this);
        // 
        apres l'ajout de la classe interne
        */
        //Ce sont maintenant nos classes internes qui écoutent nos boutons
        bouton.addActionListener(new BoutonListener());
        bouton2.addActionListener(new Bouton2Listener());

        JPanel south = new JPanel();
        south.add(bouton);
        south.add(bouton2);
        //2 bouton placer au sud
        container.add(south, BorderLayout.SOUTH);

        //mes ajouts
        JPanel North = new JPanel();
        North.add(label, BorderLayout.WEST);
        North.add(labelCompteur,BorderLayout.EAST);

        container.add(North, BorderLayout.NORTH);

        //Définition d'une police d'écriture
        Font police = new Font("Tahoma", Font.BOLD, 16);
        //On l'applique au JLabel
        label.setFont(police);
        //
        //Changement de la couleur du texte
        label.setForeground(Color.blue);
        //On modifie l'alignement du texte grâce aux attributs statiques de la classe JLabel
        //label.setHorizontalAlignment(JLabel.CENTER);
        //label.setVerticalAlignment(JLabel.);

        //
       // container.add(label, BorderLayout.NORTH);
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
            if(x < 1){
                backX = false;
            }
            //Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
            if(x > pan.getWidth()-50){
                backX = true;
            }
            //Idem pour l'axe y
            if(y < 1){
                backY = false;
            }
            if(y > pan.getHeight()-50){
                backY = true;
            }
            //Si on avance, on incrémente la coordonnée
            //backX est un booléen, donc !backX revient à écrire
            //if (backX == false)
            if(!backX){
                pan.setPosX(++x);
            }
            //Sinon, on décrémente
            else{
                    pan.setPosX(--x);
            }
            //Idem pour l'axe Y
            if(!backY){
                pan.setPosY(++y);
            }
            else{
                pan.setPosY(--y);
            }
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

        /*
	//Méthode qui sera appelée lors d'un clic sur le bouton
	public void actionPerformed(ActionEvent arg0) {

        
        //Lorsque l'on clique sur le bouton, on met à jour le JLabel
        this.compteur++;
        label.setText("Vous avez cliqué " + this.compteur + " fois");
        //suite permet de faire une action selon le clique du bouton genre action different selon chaque bouton 
        
           
        if(arg0.getSource() == bouton){
            this.compteur1++;
            this.compteur++;
            label.setText("Vous avez cliqué sur le bouton 1( " + this.compteur1 + "fois)");
        }
        if(arg0.getSource() == bouton2){
            this.compteur2++;
            this.compteur++;
            label.setText("Vous avez cliqué sur le bouton 2( " + this.compteur2 + " fois)");
            
        }
        labelCompteur.setText("clique:("+ this.compteur + "fois)" );
    }
        */
    }
     //Classe écoutant notre premier bouton
    class BoutonListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            //label.setText("Vous avez cliqué sur le bouton 1");
            compteur1++;
            compteur++;
            label.setText("Vous avez cliqué sur le bouton 1( " + compteur1 + "fois)");
            labelCompteur.setText("clique:("+ compteur + "fois)" );
        }
    }
    //Classe écoutant notre second bouton
    class Bouton2Listener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            label.setText("Vous avez cliqué sur le bouton 2");
            compteur2++;
            compteur++;
            label.setText("Vous avez cliqué sur le bouton 2( " + compteur2 + " fois)");
            labelCompteur.setText("clique:("+ compteur + "fois)" );
        }
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

    
        
		
	
    
   
        
}
//sensen ft hiro