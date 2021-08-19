public class Test {
    public static void main(String[] args) {
    TestThread t = new TestThread("A");

    TestThread t2 = new TestThread(" B", t);
    try {
        Thread.sleep(1000);
    } 
    catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("statut du thread " + t.getName() + " = "  + t.getState());
    System.out.println("statut du thread " + t2.getName() + " = " +t2.getState());
    }
}