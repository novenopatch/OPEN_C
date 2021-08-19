
public class StringMeno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chaine = new String();
		String chaine2 = new String(); 
		chaine = "Coucou TOUT LE MONDE !";
		chaine2 = chaine.toLowerCase();//Donne "coucou tout le monde !"
		
		//<>.toLowerCase()
		//<>.toUpperCase()
		//chaine.length() -> revoie la taille de la chaine
		
		//inegalite sur les chaine
		
		if(!chaine.equals(chaine2)) {
			System.out.println("Les deux chaines sont differentes !");
			
		}
		else {
			System.out.println("Les deux chaines sont identiques");
		}
		/*
		 * Ce genre de condition fonctionne de la même façon pour les boucles. Dans l'absolu, cette fonction retourne un booléen, c'est
			pour cette raison que nous pouvons y recourir dans les tests de condition.
			Le résultat de la méthode charAt() sera un caractère : il s'agit d'une méthode d'extraction de caractère. Elle ne peut s'opérer
			que sur des String ! Par ailleurs, elle présente la même particularité que les tableaux, c'est-à-dire que, pour cette méthode, le
			premier caractère sera le numéro 0. Cette méthode prend un entier comme argument.
		 */
		String nbre = new String("1234567");
		char carac = nbre.charAt(4);
		//Renverra ici le caractère 5
		
		/*
		 * La méthode substring() extrait une partie d'une chaîne de caractères. Elle prend deux entiers en arguments : le premier
			définit le premier caractère (inclus) de la sous-chaîne à extraire, le second correspond au dernier caractère (exclu) à extraire. Là
			encore, le premier caractère porte le numéro 0.
		 */
		String chaine3 = new String("la paix niche"), chaine4 = new String();
		chaine4 = chaine3.substring(3,13);
		//Permet d'extraire "paix niche"
		
		/*
		 * La méthode indexOf() explore une chaîne de caractères à la recherche d'une suite donnée de caractères, et renvoie la position
			(ou l'index) de la sous-chaîne passée en argument. la méthode indexOf() explore à partir du début de la chaîne,
			lastIndexOf() explore en partant de la fin, mais renvoie l'index à partir du début de la chaîne. Ces deux méthodes prennent
			un caractère ou une chaîne de caractères comme argument, et renvoient un int. Tout comme charAt() et substring(), le
			premier caractère porte le numéro 0. Je crois qu'ici, un exemple s'impose, plus encore que pour les autres fonctions :
		 */
		String mot = new String("anticonstitutionnellement");
		int n = 0;
		n = mot.indexOf('t');//n vaut e
		n = mot.lastIndexOf('t');//n vaut 24
		n = mot.indexOf("ti");//n vaut 2
		n = mot.lastIndexOf("ti");//n vaut 12
		n = mot.indexOf('x');//n vaut -1
		/*
		 * Les méthodes que nous allons voir nécessitent la classe Math, présente dans java.lang. Elle fait donc partie des
		   fondements du langage. Par conséquent, aucun import particulier n'est nécessaire pour utiliser la classe Math qui regorge de
           méthodes utiles :
		 */
		double X = 0.0;
		X = Math.random();
		//Retourne un nombre aléatoire
		//compris entre 0 et 1, comme 0.0001385746329371058
		double sin = Math.sin(120);
		//La fonction sinus
		double cos = Math.cos(120);
		//La fonction cosinus
		double tan = Math.tan(120);
		//La fonction tangente
		double abs = Math.abs(-120.25); //La fonction valeur absolue(retourne le nombre sans le signe)
		double d = 2;
		double exp = Math.pow(d, 2);
		//La fonction exposant
		//Ici, on initialise la variable exp avec la valeur de d élevée au carré
		//La méthode pow() prend donc une valeur en premier paramètre, et un exposant en second
		String[] tab = {"toto", "tata", "titi", "tete"};
		parcourirTableau(tab);
		System.out.println(toString(tab));
		
		
		
	}
	static void parcourirTableau(String[] tabBis)
	{
		for(String str : tabBis)
		System.out.println(str);
	}
	static String toString(String[] tab)
	{
		System.out.println("Méthode toString() !\n----------");
		String retour = "";
		for(String str : tab)
		retour += str + "\n";
		return retour;
	}//Vous voyez que la deuxième méthode retourne
}
