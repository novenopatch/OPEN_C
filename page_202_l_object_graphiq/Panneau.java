import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;







public class Panneau extends JPanel {
    int n=0;
    
    public void paintComponent(Graphics g){

        //Vous verrez cette phrase chaque fois que la méthode sera invoquée
        System.out.println("Je suis exécutée ! "+ n);
        n++;
        /**g.fillOval(20, 20, 75, 75);
        //g.draw3DRect(50, 50, 75, 75, true);
        int x1 = this.getWidth()/4;
        int y1 = this.getHeight()/4;
        g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
        **/
        /**  //pour le centrage
        int x1 = this.getWidth()/4;
        int y1 = this.getHeight()/4;
        g.drawOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
        */
        /* // pour rectg
        g.drawRect(10, 10, 50, 60);
        g.fillRect(65, 65, 30, 40);
        */ 
        /*
        //x1, y1, width, height, arcWidth, arcHeight
        g.drawRoundRect(10, 10, 30, 50, 10, 10);
        g.fillRoundRect(55, 65, 55, 30, 5, 5);
        */
        /*
        //La méthode drawLine()
        //x1, y1, x2, y2
        g.drawLine(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), 0);
        */

        

        /*
        //drawPolygon(int[] x, int[] y, int nbrePoints);

        int x[] = {20, 30, 50, 60, 60, 50, 30, 20};
        int y[] = {30, 20, 20, 30, 50, 60, 60, 50};
        g.drawPolygon(x, y, 8);

        int x2[] = {50, 60, 80, 90, 90, 80, 60, 50};
        int y2[] = {60, 50, 50, 60, 80, 90, 90, 80};
        g.fillPolygon(x2, y2, 8);
        
        Il existe également une méthode qui prend exactement les mêmes arguments mais qui, elle, trace plusieurs lignes :
            drawPolyline().
            Cette méthode va dessiner les lignes correspondant aux coordonnées définies dans les tableaux, sachant que lorsque son indice
            s'incrémente, la méthode prend automatiquement les valeurs de l'indice précédent comme point d'origine. Cette méthode ne fait
            pas le lien entre la première et la dernière valeur de vos tableaux. Vous pouvez essayer le code précédent en remplaçant
            drawPolygon() par cette méthode.

        */

        /*
        Font font = new Font("Courier", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.MAGENTA);
        g.drawString("Tiens ! Le Site du Zéro !", 10, 20);
        */

        /*
        La méthode drawImage()
        Voici à quoi elle ressemble :
        Code : Java
        drawImage(Image img, int x, int y, Observer obs);
        Vous devez charger votre image grâce à trois objets :
        un objet Image ;
        un objet ImageIO ;
        un objet File.
        Vous allez voir que l'utilisation de ces objets est très simple. Il suffit de déclarer un objet de type Image et de l'initialiser en
        utilisant une méthode statique de l'objet ImageIO qui, elle, prend un objet File en paramètre. Ça peut sembler compliqué, mais
        vous allez voir que ce n'est pas le cas... Notre image sera stockée à la racine de notre projet, mais ce n'est pas une obligation.
        Dans ce cas, faites attention au chemin d'accès de votre image.
        En ce qui concerne le dernier paramètre de la méthode drawImage, il s'agit de l'objet qui est censé observer l'image. Ici, nous
        allons utiliser notre objet Panneau, donc this.
        Cette méthode dessinera l'image avec ses propres dimensions. Si vous voulez qu'elle occupe l'intégralité de votre
        conteneur, utilisez le constructeur suivant : 
        drawImage(Image img, int x, int y, int width, int height, Observer obs).
        
        try {
            Image img = ImageIO.read(new File("image.png"));
            g.drawImage(img, 0, 0, this);
            //Pour une image de fond
            //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
            } 
        catch (IOException e) {
            e.printStackTrace();
            }
        */
        /*
        L'objet Graphics2D
            Ceci est une amélioration de l'objet Graphics, et vous allez vite comprendre pourquoi.
            Pour utiliser cet objet, il nous suffit en effet de caster l'objet Graphics en Graphics2D (Graphics2D g2d =
            (Graphics2D) g), et de ne surtout pas oublier d'importer notre classe qui se trouve dans le package java.awt. L'une des
            possibilités qu'offre cet objet n'est autre que celle de peindre des objets avec des dégradés de couleurs. Cette opération n'est pas
            du tout difficile à réaliser : il suffit d'utiliser un objet GradientPaint et une méthode de l'objet Graphics2D.
            Nous n'allons pas reprendre tous les cas que nous avons vus jusqu'à présent, mais juste deux ou trois afin que vous voyiez bien
            la différence. Commençons par notre objet GradientPaint ; voici comment l'initialiser (vous devez mettre à jour vos imports
            en ajoutant import java.awt.GradientPaint) :

        Code : Java
            GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30, Color.cyan, true);
            Alors, que signifie tout cela ? Voici le détail du constructeur utilisé dans ce code :
            premier paramètre : la coordonnée x où doit commencer la première couleur ;
            deuxième paramètre : la coordonnée y où doit commencer la première couleur ;
            troisième paramètre : la première couleur ;
            quatrième paramètre : la coordonnée x où doit commencer la seconde couleur ;
            cinquième paramètre : la coordonnée y où doit commencer la seconde couleur ;
            sixième paramètre : la seconde couleur ;
            septième paramètre : le booléen indiquant si le dégradé doit se répéter.
        
        
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30,Color.CYAN, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

            Les deux figures suivantes représentent les résultats obtenus, l'un avec le booléen à true, et l'autre à false.
             Votre dégradé est oblique (rien ne m'échappe, à moi :-p). Ce sont les coordonnées choisies qui influent sur la direction du
            dégradé. Dans notre exemple, nous partons du point de coordonnées (0, 0) vers le point de coordonnées (30, 30). Pour obtenir un
            dégradé vertical, il suffit d'indiquer la valeur de la seconde coordonnée x à 0, ce qui correspond à la figure suivante.
        

            Voici un petit cadeau :

                   Graphics2D g2d = (Graphics2D)g;
    GradientPaint gp, gp2, gp3, gp4, gp5, gp6;
    gp = new GradientPaint(0, 0, Color.RED, 20, 0, Color.magenta, true);
    gp2 = new GradientPaint(20, 0, Color.magenta, 40, 0, Color.blue,true);
    gp3 = new GradientPaint(40, 0, Color.blue, 60, 0, Color.green,true);
    gp4 = new GradientPaint(60, 0, Color.green, 80, 0, Color.yellow,true);
    gp5 = new GradientPaint(80, 0, Color.yellow, 100, 0,Color.orange, true);
    gp6 = new GradientPaint(100, 0, Color.orange, 120, 0, Color.red,true);
    g2d.setPaint(gp);
    g2d.fillRect(0, 0, 20, this.getHeight());
    g2d.setPaint(gp2);
    g2d.fillRect(20, 0, 20, this.getHeight());
    g2d.setPaint(gp3);
    g2d.fillRect(40, 0, 20, this.getHeight());
    g2d.setPaint(gp4);
    g2d.fillRect(60, 0, 20, this.getHeight());
    g2d.setPaint(gp5);
    g2d.fillRect(80, 0, 20, this.getHeight());
    g2d.setPaint(gp6);
    g2d.fillRect(100, 0, 40, this.getHeight());
        
        */

 
    }
}