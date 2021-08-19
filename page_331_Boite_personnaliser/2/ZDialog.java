import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class ZDialog extends JDialog {
    boolean sendData = false;
    private JTextField jtf = new JTextField("Valeur par défaut");
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
    //Cas où notre ZDialog renverra le contenu
    //D'un JTextField nommé jtf
    public String showZDialog(){
        this.sendData = false;
        //Début du dialogue
        this.setVisible(true);
        //Le dialogue prend fin
        //Si on a cliqué sur OK, on envoie, sinon on envoie une chaîne vide !
        return (this.sendData)? jtf.getText() : "";
    }
    /*

    Il nous reste un dernier point à gérer.
        Comment récupérer les informations saisies dans notre boîte depuis notre fenêtre, vu que nous voulons obtenir
        plusieurs informations ?
    C'est vrai qu'on ne peut retourner qu'une valeur à la fois. Mais il peut y avoir plusieurs solutions à ce problème :
        Dans le cas où nous n'avons qu'un composant, nous pouvons adapter la méthode showZDialog() au type de retour
        du composant utilisé.

        Dans notre cas, nous voulons plusieurs composants, donc plusieurs valeurs. Vous pouvez :
            retourner une collection de valeurs (ArrayList) ;
            faire des accesseurs dans votre ZDialog ;
            créer un objet dont le rôle est de collecter les informations dans votre boîte et de retourner cet objet ;
            etc.
    Nous allons opter pour un objet qui collectera les informations et que nous retournerons à la fin de la méthode
    showZDialog(). Avant de nous lancer dans sa création, nous devons savoir ce que nous allons mettre dans notre boîte...
    J'ai choisi de vous faire programmer une boîte permettant de spécifier les caractéristiques d'un personnage de jeu vidéo :
        son nom (un champ de saisie) ;
        son sexe (une combo) ;
        sa taille (un champ de saisie) ;
        sa couleur de cheveux (une combo) ;
        sa tranche d'âge (des boutons radios).

        Pour ce qui est du placement des composants, l'objet JDialog se comporte exactement comme un objet JFrame
(BorderLayout par défaut, ajout d'un composant au conteneur...).
Nous pouvons donc créer notre objet contenant les informations de notre boîte de dialogue, je l'ai appelé ZDialogInfo.
    */
}