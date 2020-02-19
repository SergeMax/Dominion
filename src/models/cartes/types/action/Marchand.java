package models.cartes.types.action;
import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;


public class Marchand extends Carte {
    /*
        Donne 1 Carte et 1 Action
        Effet: La première fois que vous jouez un Argent ce tour-ci, + 1 pièce.
        Coût: 3 pièces
        Action
     */

    public Marchand() {
        setCout(3);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(1);
                joueur.action =+1;
            }
        }
    }

    /*
        Reçoit une action, tenir compte de l'activation de la première carte argent et ignorer les autres, donner +1 pièce lors que
        ça se produit
     */
}
