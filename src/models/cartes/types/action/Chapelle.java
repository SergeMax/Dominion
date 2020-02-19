package models.cartes.types.action;
import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;


public class Chapelle extends Carte {
    /*
        Effet: Écartez jusqu'à 4 cartes de votre main.
        Coût: 2 pièces
        Action
     */

    public Chapelle() {
        setCout(2);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            if (joueur.isDoitDefausser()){

            }
        }
    }

    /*
        Faire défausser jusqu'à 4 cartes
     */
}
