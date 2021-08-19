import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean reponse = true;
		short choix;
		double temperature;
		double result1;
		double result2;
		char reponseR;
		
		System.out.println("CONVERTISSEUR DEGRES CELSIUS ET DEGRES FAHRENHEINT");
		System.out.println("--------------------------------------------------");
		
		
		do {
		choix = menu();
		
		if((choix==1 || choix==2) && reponse)
			{
			temperature = temp();
			if (choix==1) {
				result1 = celcuisFa(temperature);
				result2 = arrondi(result1,2);
				System.out.println(temperature + "°C".concat(" = ")+ result2+" °F");
				}
			else {
				result1 = faCelcuis(temperature);
				result2 = arrondi(result1,2);
				System.out.println(temperature + "°F ".concat(" = ")+ result2+" °C");
				}
			
			do{
				System.out.print("Voulez-vous réessayer ? (O/N):");
				reponseR = sc.nextLine().charAt(0);
				}while(reponseR != 'O' && reponseR != 'N');
			if(reponseR=='O') {
				//continue;//inutile puisque la boucle fini et se redemare conme la condition est toujours valide
			}
			else if(reponseR=='N') {
				System.out.println("Au revoir,Merci d'avoir utiliser mon programme.");
				reponse = false;
				break;
				
				
			}
			
			}
		else {
			System.out.println("Choix invalide! Mode inconnu, veuillez réitérer votre choix.\n");
			//choix = menu();//inutile
			
		}
	
		}while(reponse == true);
		
		
		

	}
	public static byte menu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Choisisez le mode de conversion:\n1- Convertisseur Celsuis -> Fahrenheit\n2- Convesrtiseur Fahrenheit -> Celsuis\n:");
		byte choice = sc.nextByte();
		
		return choice;
		
	}
	
	public static double temp() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Temperature a convertir :");
		double temp = sc.nextDouble();
		return temp;
		
	}
	public static double celcuisFa(double cel ) {
		
		double result;
		result = ((9.0/5.0)* cel) +32.0;
		return result;
		
	}
	public static double faCelcuis(double fah ) {
		double resultCel = ((fah - 32)* 5 )/ 9;
		
		return resultCel;
	}
	
	public static double arrondi(double A, int B) {
		return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10,
		B);
		}
	
}
