package models.cartes.types.action;

import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Presage extends Carte {
    /*
        Donne 1 Carte et 1 Action
        Effet: Consultez votre défausse. Vous pouvez placer une carte de votre défausse sur votre pioche.
        Coût: 3 pièces
        Action
     */

    public Presage() {
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
