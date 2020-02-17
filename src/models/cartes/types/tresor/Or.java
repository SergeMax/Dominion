package models.cartes.types.tresor;

import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Or extends Carte {
    /*
        Donne 3 pièces
        Coût: 6 pièces
     */

    public Or() {
        setCout(6);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if(joueur.isEntrainDeJouer()){
                joueur.monnaie += 3;
            }
        }
    }
}
