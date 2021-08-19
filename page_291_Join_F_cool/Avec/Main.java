import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
public class Main {
    public static void main(String[] args) {
        Path chemin = Paths.get("E:\\Mes Documents");
        String filtre = "*.psd";
        //Création de notre tâche principale qui se charge de découper  son travail en sous-tâches
        FolderScanner fs = new FolderScanner(chemin, filtre);
        //Nous récupérons le nombre de processeurs disponibles
        int processeurs = Runtime.getRuntime().availableProcessors();
        //Nous créons notre pool de thread pour nos tâches de fond
        ForkJoinPool pool = new ForkJoinPool(processeurs);
        Long start = System.currentTimeMillis();
       
        //Nous lançons le traitement de notre tâche principale via le  pool
        pool.invoke(fs);
        Long end = System.currentTimeMillis();
        System.out.println("Il y a " + fs.getResultat() + " fichier(s) portant l'extension " + filtre);
        System.out.println("Temps de traitement : " + (end - start));
    }
}
/*
    Vous constaterez que l'utilisation de ce mode est très gourmand en ressource processeurs. Il est donc à utiliser avec parcimonie.
Dans cet exemple nous avons créé dynamiquement autant de threads que nécessaires pour traiter nos tâches. Vous n'aurez peut-
être pas besoin de faire ceci pour des problèmes où seulement 2 ou 3 sous-tâches suffisent, surtout si vous le savez à l'avance.
L'idée maîtresse revient à définir un seuil au delà duquel le traitement se fera en mode Fork/join, sinon, il se fera dans un seul
thread (je vous rappelle qu'il se peut que ce mode de fonctionnement soit plus lent et consommateur qu'en mode normal). Voici
comment procéder dans ce genre de cas :
*/

/*
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CalculSuite extends RecursiveTask<Long> {
    private long debut = 0, fin = 0, resultat;
    private int SEUIL = 1_000;
    public CalculSuite(long debut, long fin){
        this.debut = debut;
        this.fin = fin;
    }
    protected Long compute() {
        long nombreDeChoseAFaire = fin - debut;
        if(nombreDeChoseAFaire < SEUIL){
            System.out.println("Passage en mode MonoThread ou le découpage
            calcul le résultat");
            resultat = calculer();
        }
        else{
            System.out.println("Passage en mode Fork/Join");
            //On découpe la tâche en deux
            long milieu = nombreDeChoseAFaire/2;
            CalculSuite calcul1 = new CalculSuite(debut,
            (debut+milieu)-1);
            calcul1.fork();
            CalculSuite calcul2 = new CalculSuite(debut + milieu, fin);
            resultat = calcul2.compute() + calcul1.join();
        }
    return resultat;
    }
    public long calculer(){

        for(long i = debut; i <= fin; i++){
            System.out.println(resultat + " + " + i);
            resultat += i;
        }
        return resultat;
    }
    public long getResultat(){
        return resultat;
    }
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        CalculSuite calcul = new CalculSuite(0, 100_000);
        pool.invoke(calcul);
        System.out.println("Résultat du calcul : " +
        calcul.getResultat());
    }
}




*/
/*
        Vous pouvez voir que ce code fonctionne très bien même si son intérêt n'est que pédagogique.
    Un nouveau thread permet de créer une nouvelle pile d'exécution.
    La classe Thread et l'interface Runnable se trouvent dans le package java.lang, aucun import spécifique n'est
    donc nécessaire pour leur utilisation.
    Un thread se lance lorsqu'on invoque la méthode start().
    Cette dernière invoque automatiquement la méthode run().
    Les opérations que vous souhaitez effectuer dans une autre pile d'exécution sont à placer dans la méthode run(), qu'il
    s'agisse d'une classe héritant de Thread ou d'une implémentation de Runnable.
    Pour protéger l'intégrité des données accessibles à plusieurs threads, utilisez le mot clé synchronized dans la
    déclaration de vos méthodes.
    Un thread est déclaré mort lorsqu'il a dépilé la méthode run() de sa pile d'exécution.
    Les threads peuvent présenter plusieurs états : NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING et
    TERMINATED.

*/