import javax.swing.JOptionPane;
public class Test {
    public static void main(String[] args) {
        String[] sexe = {"masculin", "féminin", "indéterminé"};
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        int rang = jop.showOptionDialog(null,
        "Veuillez indiquer votre sexe !",
        "Gendarmerie nationale !",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        sexe,
        sexe[2]);
        jop2.showMessageDialog(null, "Votre sexe est " + sexe[rang],
        "Etat civil", JOptionPane.INFORMATION_MESSAGE);
    }
}