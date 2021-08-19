import java.util.Objects;

public class Ville {

/*
    public Ville(String nom,String pays, int habitants){
        System.out.println("Création d'une ville !");
        nomVille = nom;
        nomPays = pays;
        nbreHabitants =habitants;
        System.out.println("ville: ".concat(this.nomVille).concat(" pays: ").concat(this.nomPays).concat(" de: ")+ this.nbreHabitants+ " habitants");
    }
*/

    //Constructeur par défaut
    public Ville(){
    System.out.println("Création d'une ville !");
    nomVille = "Inconnu";
    nomPays = "Inconnu";
    nbreHabitants = 0;
    System.out.println("ville: ".concat(this.nomVille).concat(" pays: ").concat(this.nomPays).concat(" de: ")+ this.nbreHabitants+ " habitants");
    //On incrémente nos variables à chaque appel aux constructeurs
    nbreInstances++;
    nbreInstancesBis++;
    //Le reste ne change pas


    }

    public Ville(String nom, int habitants,String pays){
        System.out.println("Création d'une ville !");
        nomVille = nom;
        nomPays = pays;
        nbreHabitants =habitants;
        System.out.println("ville: ".concat(this.nomVille).concat(" de: ")+ this.nbreHabitants+" habitants".concat(" pays: ").concat(this.nomPays));
        this.setCategorie();
        //On incrémente nos variables à chaque appel aux constructeurs
        nbreInstances++;
        nbreInstancesBis++;
        //Le reste ne change pas
    }


    //************* ACCESSEURS *************
    //Retourne le nom de la ville
    public String getNom(){
        return nomVille;
    }

    public String getPays(){
        return nomPays;
    }

    public int getnbreHabitants(){
        return nbreHabitants;
    }

    //************* MUTATEURS *************
    //Définit le nom de la ville
    public void setNom(String Nom){
    nomVille = Nom;
    }

    public void setPays(String Pays){
        nomPays = Pays;
    }

    public void setnbreHabitants(int Habitants){
        nbreHabitants = Habitants;
        this.setCategorie();
    }
    //Retourne la catégorie de la ville
    public char getCategorie(){
        return categorie;}

    //Définit la catégorie de la ville
    private void setCategorie() {
        int bornesSuperieures[] = {0, 1000, 10000, 100000, 500000,
        1000000, 5000000, 10000000};
        char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G','H'};
        int i = 0;
        while (i < bornesSuperieures.length && this.nbreHabitants > bornesSuperieures[i]){
        i++;}
        this.categorie = categories[i];
    } 


    //Retourne la description de la ville
    public String decrisToi(){
        return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ",elle comporte : "+this.nbreHabitants+" habitant(s) => elle est donc de catégorie : "+this.categorie;
    }

    //Retourne une chaîne de caractères selon le résultat de la comparaison
    public String comparer (Ville v1){
        String str = new String();
        if (v1.getnbreHabitants() > this.nbreHabitants){
        str = v1.getNom()+" est une ville plus peuplée que"+this.nomVille;}
        else{
        str = this.nomVille+" est une ville plus peuplée que"+v1.getNom();}

        return str;
    }
    public static int getNombreInstancesBis(){
    return nbreInstancesBis;
    }
    public boolean equals(Object obj) {
        //On vérifie si les références d'objets sont identiques
        if (this == obj)
            return true;
        //On s'assure que les objets sont du même type, ici de type Ville
        if (getClass() != obj.getClass())
            return false;
        //Maintenant, on compare les attributs de nos objets
        Ville other = (Ville) obj;
        return Objects.equals(other.getCategorie(), this.getCategorie()) && Objects.equals(other.getNom(), this.getNom()) && Objects.equals(other.getnbreHabitants(),this.getnbreHabitants()) &&Objects.equals(other.getPays(), this.getPays());
    }
    public int hashCode(){
        return Objects.hash(categorie, nbreHabitants, nomPays, nomVille);
    }



    //Variables publiques qui comptent les instances
    public static int nbreInstances = 0;
    //Variable privée qui comptera aussi les instances
    private static int nbreInstancesBis = 0;

    protected String nomVille;//pour pouvoir proteger nos attributs on les mais en private
    protected String nomPays;
    protected int nbreHabitants;
    protected char categorie;
    
}