public class Test {
    public static void main(String[] args) {
        CompteEnBanque cb = new CompteEnBanque();
        Thread t = new Thread(new RunImpl(cb));
        t.start();
    }
}