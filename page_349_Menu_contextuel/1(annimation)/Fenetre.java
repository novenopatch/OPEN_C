import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame{

    private    Panneau pan = new Panneau();
    private JPanel container = new JPanel();
    private int compteur = 0;
    private boolean animated = true;
    private boolean backX, backY;
    private int x,y ;
    private Thread t;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu animation = new JMenu("Animation"),
    forme = new JMenu("Forme"),
    typeForme = new JMenu("Type de forme"),
    aPropos = new JMenu("À propos");
    private JMenuItem lancer = new JMenuItem("Lancer l'animation"),arreter = new JMenuItem("Arrêter l'animation"),quitter = new JMenuItem("Quitter"),aProposItem = new JMenuItem("?");
    private JCheckBoxMenuItem morph = new JCheckBoxMenuItem("Morphing");
    private JRadioButtonMenuItem carre = new JRadioButtonMenuItem("Carré"),
    rond = new JRadioButtonMenuItem("Rond"),
    triangle = new JRadioButtonMenuItem("Triangle"),
    etoile = new JRadioButtonMenuItem("Etoile");
    private ButtonGroup bg = new ButtonGroup();

    //La déclaration pour le menu contextuel
    private JPopupMenu jpm = new JPopupMenu();
    private JMenu background = new JMenu("Couleur de fond");
    private JMenu couleur = new JMenu("Couleur de la forme");
    private JMenuItem launch = new JMenuItem("Lancer l'animation");
    private JMenuItem stop = new JMenuItem("Arrêter l'animation");
    private JMenuItem rouge = new JMenuItem("Rouge"),
    bleu = new JMenuItem("Bleu"),
    vert = new JMenuItem("Vert"),
    rougeBack = new JMenuItem("Rouge"),
    bleuBack = new JMenuItem("Bleu"),
    vertBack = new JMenuItem("Vert");
    //On crée des listeners globaux
    private StopAnimationListener stopAnimation=new StopAnimationListener();
    private StartAnimationListener startAnimation=new StartAnimationListener();
  //Avec des listeners pour les couleurs
    private CouleurFondListener bgColor = new CouleurFondListener();
    private CouleurFormeListener frmColor = new CouleurFormeListener();

   
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        
        //On initialise le menu stop
        stop.setEnabled(false);
        //On affecte les écouteurs
        stop.addActionListener(stopAnimation);
        launch.addActionListener(startAnimation);
        //On affecte les �couteurs aux points de menu
        rouge.addActionListener(frmColor);
        bleu.addActionListener(frmColor);
        vert.addActionListener(frmColor);
        //blanc.addActionListener(frmColor);
        rougeBack.addActionListener(bgColor);
        bleuBack.addActionListener(bgColor);
        vertBack.addActionListener(bgColor);
        //blancBack.addActionListener(bgColor);
        //On cr�e et on passe l'�couteur pour afficher le menu contextuel
        //Cr�ation d'une impl�mentation de MouseAdapter
        //avec red�finition de la m�thode ad�quate
        
        pan.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent event){
                //Seulement s'il s'agit d'un clic droit
                //if(event.getButton() == MouseEvent.BUTTON3)
                if(event.isPopupTrigger()){
                    background.add(rougeBack);
                    background.add(bleuBack);
                    background.add(vertBack);
                    couleur.add(rouge);
                    couleur.add(bleu);
                    couleur.add(vert);
                    jpm.add(launch);
                    jpm.add(stop);
                    jpm.add(couleur);
                    jpm.add(background);
                    
                    //La méthode qui va afficher le menu
                    jpm.show(pan, event.getX(), event.getY());
                }

            }
        
        });
        container.add(pan, BorderLayout.CENTER);
        this.setContentPane(container);
        this.initMenu();
        this.setVisible(true);
    }
    private void initMenu(){
        //Ajout du listener pour lancer l'animation
        //ATTENTION, LE LISTENER EST GLOBAL !!!
        lancer.addActionListener(startAnimation);
        //On attribue l'accélerateur c
        lancer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
        animation.add(lancer);
        //Ajout du listener pour arrêter l'animation
        //LISTENER A CHANGER ICI AUSSI
        arreter.addActionListener(stopAnimation);
        arreter.setEnabled(false);
        arreter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        animation.add(arreter);
        //Le reste est inchangé
        //Cette instruction ajoute l'accélérateur 'c' à notre objet
        lancer.setAccelerator(KeyStroke.getKeyStroke('c'));
        //Menu animation
        //Ajout du listener pour lancer l'animation
        lancer.addActionListener(new StartAnimationListener());
        animation.add(lancer);

        //Ajout du listener pour arrêter l'animation
        arreter.addActionListener(new StopAnimationListener());
        arreter.setEnabled(false);
        animation.add(arreter);

        animation.addSeparator();
        //Pour quitter l'application
        quitter.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        System.exit(0);
        }
        });
        animation.add(quitter);
        //Menu forme
        bg.add(carre);
        bg.add(triangle);
        bg.add(rond);
        bg.add(etoile);

        //On crée un nouvel écouteur, inutile de créer 4 instances différentes
        FormeListener fl = new FormeListener();
        carre.addActionListener(fl);
        rond.addActionListener(fl);
        triangle.addActionListener(fl);
        etoile.addActionListener(fl);


        typeForme.add(rond);
        typeForme.add(carre);
        typeForme.add(triangle);
        typeForme.add(etoile);

        rond.setSelected(true);

        forme.add(typeForme);

        //Ajout du listener pour le morphing
        morph.addActionListener(new MorphListener());
        forme.add(morph);

        //Menu À propos

        //Ajout de ce que doit faire le "?"
        aProposItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane();
                ImageIcon img = new ImageIcon("imge.png");
                String mess = "Merci ! \n J'espère que vous vous amusez bien !\n";
                mess += "Je crois qu'il est temps d'ajouter des accélérateurs et des "+" mnémoniques dans tout ça...\n";
                mess += "\n Allez, GO les ZérOs !";
                jop.showMessageDialog(null, mess, "À propos",
                JOptionPane.INFORMATION_MESSAGE, img);
            }
        });

        aPropos.add(aProposItem);


        //Ajout des menus dans la barre de menus
        menuBar.add(animation);
        menuBar.add(forme);
        menuBar.add(aPropos);
        
        
        
        //Ajout des menus dans la barre de menus et ajout de mnémoniques
        animation.setMnemonic('A');
        menuBar.add(animation);
        forme.setMnemonic('F');
        menuBar.add(forme);

        aPropos.setMnemonic('P');
        menuBar.add(aPropos);
        //Ajout de la barre de menus sur la fenêtre
        this.setJMenuBar(menuBar);
    }
    private void go(){
        x = pan.getPosX();
        y = pan.getPosY();
        while(this.animated){
            //Si le mode morphing est activé, on utilise la taille actuelle de la forme
            if(pan.isMorph()){
            if(x < 1)backX = false;
            if(x > pan.getWidth() - pan.getDrawSize()) backX = true;
            if(y < 1)backY = false;
            if(y > pan.getHeight() - pan.getDrawSize()) backY = true;
            }
            //Sinon, on fait comme d'habitude
            else{
            if(x < 1)backX = false;
            if(x > pan.getWidth()-50) 
                backX = true;
            if(y < 1)
                backY = false;
            if(y > pan.getHeight()-50) 
                backY = true;
            }
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
	  //Les classes internes :
	 // -> StartAnimationListener
	 // -> StopAnimationListener
	 // -> PlayAnimation
	 // -> FormeListener
	 // -> MorphListener
	 //sont inchang�es !
	 //�coute le changement de couleur du fond
    class CouleurFondListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
			 if(e.getSource() == vertBack)
				 pan.setCouleurFond(Color.green);
			 else if (e.getSource() == bleuBack)
				 pan.setCouleurFond(Color.blue);
			 else if(e.getSource() == rougeBack)
				 pan.setCouleurFond(Color.red);
			 else
			 	pan.setCouleurFond(Color.white);
    	}
    }
    class CouleurFormeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource() == vert)
                pan.setCouleurForme(Color.green);
            else if (e.getSource() == bleu)
                pan.setCouleurForme(Color.blue);
            else if(e.getSource() == rouge)
                pan.setCouleurForme(Color.red);
            else
                pan.setCouleurForme(Color.white);
    	}
    }
    	
    public class StartAnimationListener implements ActionListener{
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane();
                int option = jop.showConfirmDialog(null,
                "Voulez-vous lancer l'animation ?",
                "Lancement de l'animation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.OK_OPTION){
                    lancer.setEnabled(false);
                    arreter.setEnabled(true);
                    //On ajoute l'instruction pour le menu contextuel
                    launch.setEnabled(false);
                    stop.setEnabled(true);
                    animated = true;
                    t = new Thread(new PlayAnimation());
                    t.start();
                }
            }
        }
    
        /**
        * Écouteur du menu Quitter
        * @author CHerby
        */
    class StopAnimationListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            int option = jop.showConfirmDialog(null,
            "Voulez-vous arrêter l'animation ?",
            "Arrêt de l'animation",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if(option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION){
                animated = false;
                //On remplace nos boutons par nos JMenuItem
                lancer.setEnabled(true);
                arreter.setEnabled(false);
                //On ajoute l'instruction pour le menu contextuel
                launch.setEnabled(true);
                stop.setEnabled(false);
            }
        }
    }

    class PlayAnimation implements Runnable{
        public void run() {
                go();
        }
    }
    class FormeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
                pan.setForme(((JRadioButtonMenuItem)e.getSource()).getText());
        }
    }
    
   
        
     class MorphListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //Si la case est cochée, activation du mode morphing
            //Si la case est cochée, activation du mode morphing
            if(morph.isSelected()) 
                pan.setMorph(true);
            //Sinon rien !
            else pan.setMorph
                (false);
            
        }
    }
   
    /*
    class Bouton2Listener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
               
            }
    }
    */
   

}

//Storn Shadow

