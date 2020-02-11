package models.cartes.types.action;

import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Forgeron extends Carte {
    /*
        Donne 3 Cartes
        Coût: 4 pièces
        Action
     */

    public Forgeron() {
        setCout(4);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(3);
            }
        }
    }
}
