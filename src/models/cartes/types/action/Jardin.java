package models.cartes.types.action;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Jardin extends Carte {
    /*
        Effet: Vaut 1 point de victoire pour chaque 10 cartes que vous avez (arrondi à l'unité inférieure).
        Coût: 4 pièces
        Action - Victoire
     */

    public Jardin() {
        setCout(4);
        setType(TypeDeCarte.victoire_action);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for (Joueur joueur : partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){

            }
        }
    }

    /*
        Compter le nombre de carte type victoire en main+deck+defausse, donner 1 points de victoire pour chacune des cartes
     */
}
