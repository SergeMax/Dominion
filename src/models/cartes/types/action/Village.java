package models.cartes.types.action;

import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Village extends Carte {
    /*
        Donne 1 carte et 2 Actions
        Coût: 3 pièces
        Action
     */

    public Village() {
        setCout(3);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(1);
            }
        }
    }
}
