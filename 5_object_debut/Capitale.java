class Capitale extends Ville {
    public Capitale(){
        //Ce mot clé appelle le constructeur de la classe mère
        super();
        monument = "aucun";
    }
    //Constructeur d'initialisation de capitale
    public Capitale(String nom, int hab, String pays, String monument){
        super(nom, hab, pays);
        this.monument = monument;
    }
    /*
    Dans le constructeur d'initialisation de notre Capitale, vous remarquez la présence de super(nom, hab, pays);. Cette
    ligne de code joue le même rôle que celui que nous avons précédemment vu avec le constructeur par défaut. Sauf qu'ici, le
    constructeur auquel super fait référence prend trois paramètres : ainsi, super doit prendre ces paramètres. Si vous ne lui
    mettez aucun paramètre, super() renverra le constructeur par défaut de la classe Ville.
    */
/**
* Description d'une capitale
* @return String retourne la description de l'objet
*/
    public String decrisToi(){
        String str = super.decrisToi() + "\n \t ==>>" + this.monument +"en est un monument";
        return str;
    }
    /** 
   * @return le nom du monument
   */
    public String getMonument() {
        return monument;
        }
        
        //Définit le nom du monument
    public void setMonument(String monument) {
        this.monument = monument;
        }
    private String monument;
}