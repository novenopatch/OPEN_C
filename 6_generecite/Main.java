class Main{
    public static void main(String[] args) {
    Solo<Integer> val = new Solo<Integer>(12);
    int nbre = val.getValeur();
    System.out.println(nbre);
    //Solo<Integer> val1 = new Solo<Integer>(12);
    //val1.setValeur(12.2f);
    //Ici, on essaie de mettre un nombre à virgule flottante à la place d'un entier
    Solo<String> valS = new Solo<String>("TOTOTOTO");
    Solo<Float> valF = new Solo<Float>(12.2f);
    Solo<Double> valD = new Solo<Double>(12.202568);
    
    int i = new Integer(12);
    //Est équivalent à int i = 12
    double d = new Double(123.0995); //Est équivalent à double d =12.2586
    Double d = 12.0;
    Character c = 'C';
    al = new ArrayList();
    //Avant Java 5 il fallait faire al.add(new Integer(12))
    //Depuis Java 5 il suffit de faire
    al.add(12);
    //...
    }
}