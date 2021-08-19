class Mainvar
{
    public static void main(String [] args){
        System.out.println("Menos");
        
        byte testbyte;
        testbyte = 67;//-128 a 127

        String testByteString;
        testByteString = String.valueOf(testbyte);

        int i = 12;
        String j = new String();
        j = String.valueOf(i);
        
        System.out.println("\n"+ testByteString);

        int tsoleil;
        tsoleil = 45;//-2*10Xy9 a 2*10Xy9

        short vitessemax;
        vitessemax = 3200;//-32768 a 32767

        long anneLumire;
        anneLumire = 9999999999999999L;//-9*10Xy18 a 9*10Xy18

        float pi;
        pi = 3.14f;

        float nombre;
        nombre = 2.0f;//f permet  jvm de savoir que c'est un float

        double division;
        division = 0.3333333333333d;//double
        

        char caractere;
        caractere = 'A';

        char unecaratere;
        unecaratere ='A';


        String phrase;//string est un object
        phrase = "J'adore python java POURquoi il sait pas que 3.14 est un float ";


        boolean unbolean;
        unbolean = true;


        

    }
}