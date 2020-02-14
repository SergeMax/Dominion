package models.cartes;

import models.Joueur;
import models.cartes.types.action.Artisan;
import models.cartes.types.action.Marchand;
import tools.Paths;

import java.util.ArrayList;

public abstract class Carte {
    private int cout;
    private TypeDeCarte type;
    private LocalisationDesCartes Localisation;

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public TypeDeCarte getType() {
        return type;
    }

    public void setType(TypeDeCarte type) {
        this.type = type;
    }

    public LocalisationDesCartes getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(LocalisationDesCartes localisation) {
        Localisation = localisation;
    }

    public String getUrlImgCarte(){
        return Paths.urlImgCarte + this.getClass().getSimpleName().toLowerCase() + ".png";
    }

    public void effet(ArrayList<Joueur> joueurs){

    }


    public static void main(String[] args) {
        Carte carteArtisant = new Artisan();
        Carte carteMarchand = new Marchand();

        System.out.println(carteArtisant.getUrlImgCarte());
        System.out.println(carteMarchand.getUrlImgCarte());
    }
}
