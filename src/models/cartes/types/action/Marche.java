package models.cartes.types.action;
import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Marche extends Carte {
    /*
        Donne 1 Carte, 1 Action, 1 Achat et 1 pièce
        Coût: 5 pièces
        Action
     */

    public Marche() {
        setCout(5);
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
