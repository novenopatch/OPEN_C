import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

   
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);
        this.setContentPane(container);
        this.initMenu();
        this.setVisible(true);

    }
    private void initMenu(){
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
    public class StartAnimationListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
        //Idem
            JOptionPane jop = new JOptionPane();
            int option = jop.showConfirmDialog(null,
            "Voulez-vous lancer l'animation ?",
            "Lancement de l'animation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

            if(option == JOptionPane.OK_OPTION){
                lancer.setEnabled(false);
                arreter.setEnabled(true);
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

            //Idem
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
                //On commente cette ligne pour l'instant
                //****************************************
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
   
    
    class Bouton2Listener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
               
            }
        }
   

}

//Storn Shadow

