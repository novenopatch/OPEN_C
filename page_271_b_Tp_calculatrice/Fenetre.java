import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Fenetre extends JFrame{
    private BorderLayout ecranL = new BorderLayout();
    private JLabel ecran = new JLabel("0");
    private JPanel panEcran = new JPanel();

    private GridLayout gridN = new GridLayout(4, 3);
    private JPanel numContainer = new JPanel();

    private GridLayout gridR = new GridLayout(5,0);
    private JPanel rContainer = new JPanel();

   

    private BorderLayout containerL = new BorderLayout();
    private JPanel container = new JPanel();

    private double chiffre1;
	private boolean clicOperateur = false, update = false;
	private String operateur = "";

    
	String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8","9", "0", ".", "=", "C", "+", "-", "*", "/"};
	//Un bouton par élément à afficher
    JButton[] tab_button = new JButton[tab_string.length];
    
    public Fenetre(){
        this.setSize(240, 260);
		this.setTitle("Calculette");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setResizable(false);

		initComposant();
		//On ajoute le conteneur
		this.setContentPane(container);
		this.setVisible(true);
    }

    private void initComposant(){
        numContainer.setLayout(gridN);
        rContainer.setLayout(gridR);
        
        panEcran.add(ecran);
        panEcran.setBorder(BorderFactory.createLineBorder(Color.black));

        container.setLayout(containerL);
        container.add(numContainer, BorderLayout.CENTER);
        container.add(rContainer, BorderLayout.EAST);
        container.add(panEcran, BorderLayout.NORTH);

        Font police = new Font("Arial", Font.BOLD, 20);
        ecran.setFont(police);
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        ecran.setPreferredSize(new Dimension(220, 20));
        panEcran.setPreferredSize(new Dimension(220, 30));


        for(int i = 0; i < tab_string.length; i++){
            
            tab_button[i] = new JButton(tab_string[i]);
            switch(i){
                case 10:
                    numContainer.add(tab_button[i]);//bouton .
                    break;
                case 11 :
                    tab_button[i].addActionListener(new EgalListener());
                   
                    numContainer.add(tab_button[i]); //bouton egal 
                
                    break;
                case 12 :
                    tab_button[i].setForeground(Color.red);
                    rContainer.add(tab_button[i]);//c
                    tab_button[i].addActionListener(new effacerListener());
               
                    break;
                case 13 :
                    rContainer.add(tab_button[i]);//+
                    tab_button[i].addActionListener(new PlusListener());
               
                    break;
                case 14 :
                    rContainer.add(tab_button[i]);//-
                    tab_button[i].addActionListener(new MoinsListener());
                
                    break;
                case 15 :
                    rContainer.add(tab_button[i]);//*
                    tab_button[i].addActionListener(new MultiListener());
               
                    break;
                case 16 :
                    rContainer.add(tab_button[i]);// (/)
                    tab_button[i].addActionListener(new DivListener());
                    break;
                default :

                   //touche numerique
                    numContainer.add(tab_button[i]);
                    tab_button[i].setForeground(Color.BLUE);
                    tab_button[i].addActionListener(new ChiffreListener());
               
                    break;
            }
            
        }
            
           
    }
    private void calcul(){
        if(operateur.equals("+")){
        chiffre1 = chiffre1 + Double.valueOf(ecran.getText()).doubleValue();
        ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("-")){
        chiffre1 = chiffre1 - Double.valueOf(ecran.getText()).doubleValue();
        ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("*")){
        chiffre1 = chiffre1 * Double.valueOf(ecran.getText()).doubleValue();
        ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(ecran.getText()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            } 
            catch(ArithmeticException e) {
                ecran.setText("0");
            }
       }
    }
    
    class ChiffreListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //On affiche le chiffre additionnel dans le label
            String str = ((JButton)e.getSource()).getText();
            if(update){
                update = false;
            }
            else{
                if(!ecran.getText().equals("0"))
                    str = ecran.getText() + str;
            }
            ecran.setText(str);
        }
    }

    class effacerListener implements ActionListener{
        public void actionPerformed(ActionEvent o){
            clicOperateur = false;
            update = true;
		    chiffre1 = 0;
		    operateur = "";
            ecran.setText("");
            
		;
        }
    }
    //Listener affecté au bouton =
	class EgalListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            calcul();
            update = true;
            clicOperateur = false;
        }
    }
    //Listener affecté au bouton +
    class PlusListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "+";
            update = true;
        }
    }
            //Listener affecté au bouton -
    class MoinsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "-";
            update = true;
        }
    }
            //Listener affecté au bouton *
    class MultiListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
                
            }
            operateur = "*";
            update = true;
        }
    }
            //Listener affecté au bouton /
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "/";
            update = true;
        }
    }

    
}