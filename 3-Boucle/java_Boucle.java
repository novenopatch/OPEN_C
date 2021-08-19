/*
*/

public class java_Boucle
{
    public static void main(String[] args)
    {
        int i = 0;
        int f = 0;
        while(i != 10)//boucle affichant i
        {
            System.out.println(i);
            i++;

            if(i ==7)
            {
                break;//continue permet de revenir au debut de la  boucle donc une itération
            }
        }
        //on peut faire la boucle à l'envers avec do while,láventage c'est que si est dans le do s'execute au moins une fois
        do
        {
            i++;

            if(i ==7)
            {
                break;//continue permet de revenir au debut de la  boucle donc une itération
            }
        }
        while( i !=10);
        //boucle for
        for(f =0; f != 20; f++)// avant la première c'est l'initialisation apres la condition,puis l'incrémentation.
        {
            System.out.println("f");
        }
    }
}