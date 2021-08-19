public class Test {
    public static void main(String[] args) {
        CompteEnBanque cb = new CompteEnBanque();
        CompteEnBanque cb2 = new CompteEnBanque();
        
        Thread t = new Thread(new RunImpl(cb, "Cysboy"));
        Thread t2 = new Thread(new RunImpl(cb2, "Zéro"));
        t.start();
        t2.start();
    }
}

/*
Jusqu'ici, rien de perturbant : nous avons utilisé deux instances distinctes de RunImpl utilisant elles-mêmes deux instances
distinctes de CompteEnBanque. Mais que se passerait-il si nous utilisions la même instance de CompteEnBanque pour
deux threads différents ? Testez plusieurs fois le code que voici :

public class Test {
public static void main(String[] args) {
CompteEnBanque cb = new CompteEnBanque();
}
}
Thread t = new Thread(new RunImpl(cb, "Cysboy"));
Thread t2 = new Thread(new RunImpl(cb, "Zéro"));
t.start();
t2.start();

*/