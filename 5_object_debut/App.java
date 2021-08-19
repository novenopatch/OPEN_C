
public class App { 
    public  static void main(String[] agrs){
        //Ville ville1 = new Ville();
        //Ville ville2 = new Ville("Paris","France",20000);
        //Ville villeOpenClassroom = new Ville("Marseille", 123456789, "France");

        Ville V = new Ville("Lyon", 654, "France");
        Ville V2 = new Ville("Lille", 123, "France");
        System.out.println(V.comparer(V2));
        System.out.println(V2.decrisToi());
        Capitale cap = new Capitale();
        System.out.println(cap.decrisToi());
        Capitale cap2 = new Capitale("Paris", 654987, "France", "la tourEiffel");
        System.out.println("\n"+cap2.decrisToi());


        //Définition d'un tableau de villes null
        Ville[] tableau = new Ville[6];
        //Définition d'un tableau de noms de villes et un autre de nombresd'habitants
        String[] tab = {"Marseille", "lille", "caen", "lyon", "paris","nantes"};
        int[] tab2 = {123456, 78456, 654987, 75832165, 1594, 213};
        //Les trois premiers éléments du tableau seront des villes,
        //et le reste, des capitales
        for(int i = 0; i < 6; i++)
        {
            if (i <3){
                Ville Vt = new Ville(tab[i], tab2[i], "france");
                tableau[i] = Vt; }
            else{
                Capitale C = new Capitale(tab[i], tab2[i], "france", "la tourEiffel");
                tableau[i] = C; }
        }
        //Il ne nous reste plus qu'à décrire tout notre tableau !
        for(Ville Vt : tableau){
            System.out.println(Vt.decrisToi()+"\n");
        }

    }
    
}