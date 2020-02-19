package models.cartes.types.victoire;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Malediction extends Carte {
    /*
        Enlève 1 point de victoire
        Coût: 0 pièce
     */

    public Malediction() {
        setCout(0);
        setType(TypeDeCarte.victoire);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for (Joueur joueur : partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){
                joueur.pV -= 1;
            }
        }
    }
}
