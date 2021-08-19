import javax.swing.JOptionPane;
public class Test {
    public static void main(String[] args) {
        String[] sexe = {"masculin", "féminin", "indéterminé"};
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String nom = (String)jop.showInputDialog(null,
        "Veuillez indiquer votre sexe !",
        "Gendarmerie nationale !",
        JOptionPane.QUESTION_MESSAGE,
        null,
        sexe,
        sexe[2]);
        jop2.showMessageDialog(null, "Votre sexe est " + nom,
        "Etat civil", JOptionPane.INFORMATION_MESSAGE);
    }
}
/*

Voici un petit détail des paramètres utilisés dans cette méthode :
les quatre premiers, vous connaissez ;
le deuxième null correspond à l'icône que vous souhaitez passer ;
ensuite, vous devez passer un tableau de String afin de remplir la combo (l'objet JComboBox) de la boîte ;
le dernier paramètre correspond à la valeur par défaut de la liste déroulante.

Cette méthode retourne un objet de type Object, comme si vous récupériez la valeur directement dans la combo ! Du
coup, n'oubliez pas de faire un cast.

*/