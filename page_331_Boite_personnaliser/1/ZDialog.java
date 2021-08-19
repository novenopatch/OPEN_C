import javax.swing.JDialog;
import javax.swing.JFrame;
public class ZDialog extends JDialog {
    public ZDialog(JFrame parent, String title, boolean modal){
        //On appelle le construteur de JDialog correspondant
        super(parent, title, modal);
        //On spécifie une taille
        this.setSize(200, 80);
        //La position
        this.setLocationRelativeTo(null);
        //La boîte ne devra pas être redimensionnable
        this.setResizable(false);
        //Enfin on l'affiche
        this.setVisible(true);
        //Tout ceci ressemble à ce que nous faisons depuis le début avec notre JFrame.
    }
}