
public class Duo<T, S> {

        //Variable d'instance de type T
        private T valeur1;
        //Variable d'instance de type S
        private S valeur2;
        //Constructeur par défaut
        public Duo()
        {
        this.valeur1 = null;
        this.valeur2 = null;
        }
        //Constructeur avec paramètres
        public Duo(T val1, S val2)
        {
        this.valeur1 = val1;
        this.valeur2 = val2;
        }
        //Méthodes d'initialisation des deux valeurs
        public void setValeur(T val1, S val2)
        {
        this.valeur1 = val1;
        this.valeur2 = val2;
        }
        
        //Définit la valeur T
        public void setValeur1(T valeur1) 
        {
        this.valeur1 = valeur1;
        }
        //Retourne la valeur S
        public S getValeur2() 
        {
        return valeur2;
        }
    
        //Définit la valeur S
        public void setValeur2(S valeur2) 
        {
        this.valeur2 = valeur2;
        }
}