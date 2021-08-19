import javax.swing.JOptionPane;
public class Test {
    public static void main(String[] args) {
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String nom = jop.showInputDialog(null, 
        "Veuillez décliner votre identité !", 
        "Gendarmerie nationale !",
        JOptionPane.QUESTION_MESSAGE);
        
        jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité",
        JOptionPane.INFORMATION_MESSAGE);
}
}