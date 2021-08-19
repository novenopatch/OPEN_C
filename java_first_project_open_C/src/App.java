import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.println("Salut eclipse.");
		String b = "bit c'est la plus petite valeur informatique: soit 0 soit 1";
		String o = "Octet regroupement de 8 bits,par exemple: 01011101";
		String Ko = "Kilo Octet regroupement de 1024 octets";
		String Mo = "Mega Octet regroupement de 1024 ko";
		String Go = "Giga Octet regroupement de 1024 Mo";
		String To = "Tera Octet regroupement de 1024 Go";
		byte temperature ;//bon c'est a cause du cours d'open_c sinon apres l'instaciation je fais l'affectation d'une valeur part defaut sur la meme ligne
		temperature = 64;// pour le byte-128 et +127
		short vitesseMax = 32000;//2octets
		int temperatureSoleil = 15600000;//4 octect pour le type long c'est 8 octet en ajoutant un L a la fin du nombre
		float pi = 3.15f;
		char charatere = 'A';
		*/
		/*
		double nbre1 = 10, nbre2 = 3;
		int resultat = (int)(nbre1 / nbre2);//ici on a fait un cast nous avons conversti le resultat en int puis stocke dans un int c'est normal que l'on perde la partie decimale
		System.out.println("Le résultat est = " + resultat);
		double resultat2 = nbre1 / nbre2;
		System.out.println("Le résultat est = " + resultat2);///cela donne le resultat attendue 3.33333333
		
		int i = 12;
		String j = new String();
		j = j.valueOf(i) + "grrrr";
		System.out.println(j);
		
		int x = 12;
		String z = new String();
		z = z.valueOf(x);//conversion de x en string
		int k = Integer.valueOf(z).intValue();//conversion de z en int
		System.out.println(k);
		*/
		/*
		 * Suite lire les donnees au clavier.
		 */
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("Veillez saisir votre nom:");
		String userName = sc.nextLine();
		System.out.println("Vous avez saisie :".concat(userName));
		
		System.out.print("Veillez saisir a present votre niveau:");
		int userLevel = sc.nextInt();
		System.out.println("Vous avez saisie :" + userLevel);
		*/
		/*
		 *  Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			double d = sc.nextDouble();
			long l = sc.nextLong();
			byte b = sc.nextByte();
			//Etc.
			 
			System.out.println("Saisissez une lettre :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			System.out.println("Vous avez saisi le caractère : " + carac);
			
			Une précision s'impose, toutefois : la méthode nextLine() récupère le contenu de toute la ligne saisie et replace la « tête de
			lecture » au début d'une autre ligne. Par contre, si vous avez invoqué une méthode comme nextInt(), nextDouble() et
			que vous invoquez directement après la méthode nextLine(), celle-ci ne vous invitera pas à saisir une chaîne de caractères :
			elle videra la ligne commencée par les autres instructions. En effet, celles-ci ne repositionnent pas la tête de lecture, l'instruction
			nextLine() le fait à leur place. Pour faire simple, ceci :
		 */
		
	/*
		System.out.println("Saisissez un entier : ");
		int ty = sc.nextInt();//complication a cause de la methode fake la
		System.out.println("Saisissez une chaîne : ");
		//On vide la ligne avant d'en lire une autre
		sc.nextLine();
		String str = sc.nextLine();
		System.out.println("FIN ! ");
		byte note = 10;
		switch(note)
		{
		 	case 0:
		 	{
			 System.out.print("0/20 : tu peux revoir ce chapitre, petit Zéro !");
			 break;
		 	}
		 	case 10:
		 	{
		 		System.out.print("10/20 : je crois que tu as compris l'essentiel ! Viens relire ce chapitre à l'occasion.");
		 		break;
		 	}
		 	case 20:
		 	{
		 		System.out.print("20/20 : bravo !");
		 		break;
		 	}
		 	default :
		 	{
		 		System.out.print("c'est impossible!");
		 	}
		*/ 		
		 
		 
		//}
		/*
		 * La condition ternaire
		Les conditions ternaires sont assez complexes et relativement peu utilisées. Je vous les présente ici à titre indicatif. La
		particularité de ces conditions réside dans le fait que trois opérandes (c'est-à-dire des variables ou des constantes) sont mis en
		jeu, mais aussi que ces conditions sont employées pour affecter des données à une variable. Voici à quoi ressemble la structure
		de ce type de condition :
		Code : Java
		
		
		
		 * 
		 */
		int x2 = 10, y2 = 20;
		int max = (x2 < y2) ? y2 : x2 ; //Maintenant, max vaut 20
		/*
		 * Décortiquons ce qu'il se passe :
		Nous cherchons à affecter une valeur à notre variable max, mais de l'autre côté de l'opérateur d'affectation se trouve une
		condition ternaire...
		Ce qui se trouve entre les parenthèses est évalué : x est-il plus petit que y ? Donc, deux cas de figure se profilent à
		l'horizon :
		si la condition renvoie true (vrai), qu'elle est vérifiée, la valeur qui se trouve après le ? sera affectée ;
		sinon, la valeur se trouvant après le symbole: sera affectée.
		L'affectation est effective : vous pouvez utiliser votre variable max.
		Vous pouvez également faire des calculs (par exemple) avant d'affecter les valeurs :
		Code : Java
		 
		int t = 10, j1 = 20;
		int max1 = (t < j1) ? t * 2 : j1 * 2 ; //Ici, max vaut 2 * 20 donc 40
		
		N'oubliez pas que la valeur que vous allez affecter à votre variable doit être du même type que votre variable. Sachez aussi que
		rien ne vous empêche d'insérer une condition ternaire dans une autre condition ternaire :
		Code : Java
		int x = 10, y = 20;
		int max = (x < y) ? (y < 10) ? y % 10 : y * 2 : x ; //Max vaut 40
		//Pas très facile à lire...
		//Vous pouvez entourer votre deuxième instruction ternaire par des
		parenthèses pour mieux voir :
		max = (x < y) ? ((y < 10) ? y % 10 : y * 2) : x ; //Max vaut 40
		
		
		
		Les conditions vous permettent de n'exécuter que certains morceaux de code.
		Il existe plusieurs sortes de structures conditionnelles :
		la structure if... elseif... else ;
		la structure switch... case... default ;
		la structure ? :.
		Si un bloc d'instructions contient plus d'une ligne, vous devez l'entourer d'accolades afin de bien en délimiter le début et
		la fin.
		Pour pouvoir mettre une condition en place, vous devez comparer des variables à l'aide d'opérateurs logiques.
		Vous pouvez mettre autant de comparaisons renvoyant un boolean que vous le souhaitez dans une condition.
		Pour la structure switch, pensez à mettre les instructions break; si vous ne souhaitez exécuter qu'un seul bloc case.
		*/
		
		/*
		//Les Boucles
		//Une variable vide
		String prenom;
		//On initialise celle-ci à O pour oui
		char reponse = 'O';
		//Notre objet Scanner, n'oubliez pas l'import de java.util.Scanner !
		Scanner sc_t = new Scanner(System.in);
		//Tant que la réponse donnée est égale à oui...
		while (reponse == 'O')
		{
			//On affiche une instruction
			System.out.println("Donnez un prénom : ");
			//On récupère le prénom saisi
			prenom = sc_t.nextLine();
			//On affiche notre phrase avec le prénom
			System.out.println("Bonjour " +prenom+ ", comment vas-tu ?");
			//On demande si la personne veut faire un autre essai
			System.out.println("Voulez-vous réessayer ? (O/N)");
			//On récupère la réponse de l'utilisateur
			reponse = sc_t.nextLine().charAt(0);
		}
		System.out.println("Au revoir...");
		//Fin de la boucle
		 * 
		 * évalue la condition qui nous dit : tant que la variable reponse contient « O », on exécute la boucle. Celle-ci contient bien le
		caractère « O », donc nous entrons dans la boucle. Puis l'exécution des instructions suivant l'ordre dans lequel elles
		apparaissent dans la boucle a lieu. À la fin, c'est-à-dire à l'accolade fermante de la boucle, le compilateur nous ramène au début
		de la boucle.
		Cette boucle n'est exécutée que lorsque la condition est remplie : ici, nous avons initialisé la variable reponse à « O »
		pour que la boucle s'exécute. Si nous ne l'avions pas fait, nous n'y serions jamais entrés. Normal, puisque nous testons
		la condition avant d'entrer dans la boucle !
		Voilà. C'est pas mal, mais il faudrait forcer l'utilisateur à ne taper que « O » ou « N ». Comment faire ? C'est très simple : avec une
		boucle ! Il suffit de forcer l'utilisateur à entrer soit « N » soit « O » avec un while ! Attention, il nous faudra réinitialiser la
		variable reponse à « ' ' » (caractère vide). Il faudra donc répéter la phase « Voulez-vous réessayer ? » tant que la réponse
		donnée n'est pas « O » ou « N ».
		Voici notre programme dans son intégralité :
		
		String prenom;
		char reponse = 'O';
		Scanner sc = new Scanner(System.in);
		while (reponse == 'O')
		{
		System.out.println("Donnez un prénom : ");
		prenom = sc.nextLine();
		System.out.println("Bonjour " +prenom+ ", comment vas-tu ?");
		//Sans ça, nous n'entrerions pas dans la deuxième boucle
		reponse = ' ';
		//Tant que la réponse n'est pas O ou N, on repose la question
		while(reponse != 'O' && reponse != 'N')
		{
		//On demande si la personne veut faire un autre essai
		System.out.println("Voulez-vous réessayer ? (O/N)");
		reponse = sc.nextLine().charAt(0);
		}
		}
		System.out.println("Au revoir...");
		
		
		
		int a = 1, b = 15;
		while (a++ < b)
		System.out.println("coucou " +a+ " fois !!");
		
		Souvenez-vous de ce dont je vous parlais au chapitre précédent sur la priorité des opérateurs. Ici, l'opérateur « < » a la priorité
		sur l'opérateur d'incrémentation « ++ ». Pour faire court, la boucle while teste la condition et ensuite incrémente la variable a.
		Par contre, essayez ce code :
		int a = 1, b = 15;
		while (++a < b)
		System.out.println("coucou " +a+ " fois !!");
		Vous devez remarquer qu'il y a un tour de boucle en moins ! Eh bien avec cette syntaxe, l'opérateur d'incrémentation est
		prioritaire sur l'opérateur d'inégalité (ou d'égalité), c'est-à-dire que la boucle incrémente la variable a, et ce n'est qu'après l'avoir
		fait qu'elle teste la condition !
						
	*/	
		for(int i = 0, j = 2; (i < 10 && j < 6); i++, j+=2){
			System.out.println("i = " + i + ", j = " + j);
			}
	}
	

}
