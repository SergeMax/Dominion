package models.cartes.types.action;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Laboratoire extends Carte {
    /*
        Donne 2 Cartes et 1 Action
        Coût: 5 pièces
        Action
     */

    public Laboratoire() {
        setCout(5);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(2);
                joueur.action += 1;
            }
        }
    }
}
