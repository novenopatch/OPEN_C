import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
/*      
    L'objet GridLayout
    Celui-ci permet d'ajouter des composants suivant une grille définie par un nombre de lignes et de colonnes. Les éléments sont
    disposés à partir de la case située en haut à gauche. Dès qu'une ligne est remplie, on passe à la suivante. Si nous définissons
    une grille de trois lignes et de deux colonnes, nous obtenons le résultat visible sur la figure suivante.



*/

public class Fenetre extends JFrame {
   
    
    public Fenetre(){
        this.setTitle("GridLayout");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On définit le layout à utiliser sur le content pane
        //Trois lignes sur deux colonnes
        //this.setLayout(new GridLayout(3, 2));//avec cette ligne on ne peut pas rajouter les espace entre les bouton
        GridLayout gl = new GridLayout(3, 2);
        gl.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        gl.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        this.setLayout(gl);
        //On ajoute le bouton au content pane de la JFrame
        this.getContentPane().add(new JButton("1"));
        this.getContentPane().add(new JButton("2"));
        this.getContentPane().add(new JButton("3"));
        this.getContentPane().add(new JButton("4"));
        this.getContentPane().add(new JButton("5"));
        this.setVisible(true);
        /*
        Ce code n'est pas bien différent du précédent : nous utilisons simplement un autre layout manager et n'avons pas besoin de
        définir le positionnement lors de l'ajout du composant avec la méthode add().
        Sachez également que vous pouvez définir le nombre de lignes et de colonnes en utilisant ces méthodes :

            Code : Java
                GridLayout gl = new GridLayout();
                gl.setColumns(2);
                gl.setRows(3);
                this.setLayout(gl);
        Vous pouvez aussi ajouter de l'espace entre les colonnes et les lignes.
            Code : Java
                GridLayout gl = new GridLayout(3, 2);
                gl.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
                gl.setVgap(5); //Cinq pixels d'espace entre les lignes (V commeVertical)
                //Ou en abrégé : GridLayout gl = new GridLayout(3, 2, 5, 5);
        */
        
    }

}