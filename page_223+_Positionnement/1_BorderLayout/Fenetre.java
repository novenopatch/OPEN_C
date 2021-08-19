import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;

public class Fenetre extends JFrame {
    
    
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
/*
        Le premier objet que nous aborderons est le BorderLayout. Il est très pratique si vous voulez placer vos composants de
        façon simple par rapport à une position cardinale de votre conteneur. Si je parle de positionnement cardinal, c'est parce que vous
        devez utiliser les valeurs NORTH, SOUTH, EAST, WEST ou encore CENTER. Mais puisqu'un aperçu vaut mieux qu'un exposé sur
        le sujet, voici un exemple à la figure suivante mettant en œuvre un BorderLayout.

        */

       //On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());
        //On ajoute le bouton au content pane de la JFrame
        //Au centre
        this.getContentPane().add(new JButton("CENTER"),BorderLayout.CENTER);
        //Au nord
        this.getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
        //Au sud
        this.getContentPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
        //À l'ouest
        this.getContentPane().add(new JButton("WEST"), BorderLayout.WEST);
        //À l'est
        this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);
        this.setVisible(true);
    }
    /*
    Ce n'est pas très difficile à comprendre. Vous définissez le layout à utiliser avec la méthode setLayout() de l'objet JFrame ;
    ensuite, pour chaque composant que vous souhaitez positionner avec add(), vous utilisez en deuxième paramètre un attribut
    static de la classe BorderLayout (dont la liste est citée plus haut).

    Utiliser l'objet BorderLayout soumet vos composants à certaines contraintes. Pour une position NORTH ou SOUTH, la
    hauteur de votre composant sera proportionnelle à la fenêtre, mais il occupera toute la largeur ; tandis qu'avec WEST et EAST, ce
    sera la largeur qui sera proportionnelle alors que toute la hauteur sera occupée ! Et bien entendu, avec CENTER, tout l'espace est
    utilisé.
    Vous devez savoir que CENTER est aussi le layout par défaut du content pane de la fenêtre, d'où la taille du bouton
    lorsque vous l'avez ajouté pour la première fois.

    */

}