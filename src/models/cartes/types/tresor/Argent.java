package models.cartes.types.tresor;
import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Argent extends Carte {
    /*
        Donne 2 pièces
        Coût: 3 pièces
     */

    public Argent() {
        setCout(3);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if(joueur.isEntrainDeJouer()){
                joueur.monnaie += 2;
            }
        }
    }
}
