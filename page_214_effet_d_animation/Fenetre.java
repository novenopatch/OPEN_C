import java.awt.Dimension;
import javax.swing.JFrame;

public class Fenetre extends JFrame{

    private Panneau pan = new Panneau();

    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);
        this.setVisible(true);
        go();
    }
   /* 
    private void go(){
        //for(int i = -50; i < pan.getWidth(); i++){
        for(;;){//pour rendre l'animawtion sans fin
            int x = pan.getPosX();
            int y = pan.getPosY();
            x++;
            y++;
            pan.setPosX(x);
            pan.setPosY(y);

            pan.repaint();
            try {
                Thread.sleep(10);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Si nos coordonnées arrivent au bord de notre composant
            //On réinitialise
            if(x == pan.getWidth() || y == pan.getHeight()){
                pan.setPosX(-50);
                pan.setPosY(-50);
            }
        }
        
    }
    */
    /*
    Ce code fonctionne parfaitement (en tout cas, comme nous l'avons prévu), mais avant de passer au chapitre suivant, nous
    pouvons encore l'améliorer. Nous allons maintenant rendre notre rond capable de détecter les bords de notre Panneau et de
    ricocher sur ces derniers !
    Jusqu'à présent, nous n'attachions aucune importance au bord que notre rond dépassait. Cela est terminé ! Dorénavant, nous
    séparerons le dépassement des coordonnées posX et posY de notre Panneau.
    Pour les instructions qui vont suivre, gardez en mémoire que les coordonnées du rond correspondent en réalité aux
    coordonnées du coin supérieur gauche du carré entourant le rond.
    Voici la marche à suivre :
    si la valeur de la coordonnée x du rond est inférieure à la largeur du composant et que le rond avance, on continue
    d'avancer ;
    sinon, on recule.
    Nous allons faire de même pour la coordonnée y.
    Comment savoir si l'on doit avancer ou reculer ? Grâce à un booléen, par exemple. Au tout début de notre application, deux
    booléens seront initialisés à false, et si la coordonnée x est supérieure à la largeur du Panneau, on recule ; sinon, on avance.
    Idem pour la coordonnée y.
    Dans ce code, j'utilise deux variables de type int pour éviter de rappeler les méthodes getPosX() et getPosY().

    Voici donc le nouveau code de la méthode go() :
    */
    private void go(){
        //Les coordonnées de départ de notre rond
        int x = pan.getPosX(), y = pan.getPosY();
        //Le booléen pour savoir si l'on recule ou non sur l'axe x
        boolean backX = false;
        //Le booléen pour savoir si l'on recule ou non sur l'axe y
        boolean backY = false;
        //Dans cet exemple, j'utilise une boucle while
        //Vous verrez qu'elle fonctionne très bien
        while(true){
            //Si la coordonnée x est inférieure à 1, on avance
            if(x < 1){
                backX = false;
            }
            //Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
            if(x > pan.getWidth()-50){
                backX = true;
            }
            //Idem pour l'axe y
            if(y < 1){
                backY = false;
            }
            if(y > pan.getHeight()-50){
                backY = true;
            }
            //Si on avance, on incrémente la coordonnée
            //backX est un booléen, donc !backX revient à écrire
            //if (backX == false)
            if(!backX){
                pan.setPosX(++x);
            }
            //Sinon, on décrémente
            else{
                 pan.setPosX(--x);
            }
            //Idem pour l'axe Y
            if(!backY){
                pan.setPosY(++y);
            }
            else{
                pan.setPosY(--y);
            }
             //On redessine notre Panneau
                pan.repaint();
            //Comme on dit : la pause s'impose ! Ici, trois millièmes de seconde
            try {
                Thread.sleep(3);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
   
    





}
