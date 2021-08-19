import java.awt.Color;
import java.sql.JDBCType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

public class Fenetre extends JFrame {

    public Fenetre(){
        this.setTitle("Ma première fenêtre Java");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan = new JPanel();
        //defintion couleur de fond
        pan.setBackground(Color.ORANGE);
        //on previent notre jframe que notre jpanel sera son content pane
        this.setContentPane(pan);
        this.setVisible(true);
    }
}