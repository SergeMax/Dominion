package models.cartes.types.victoire;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Province extends Carte {
    /*
        Donne 6 points de victoire
        Coût: 8 pièces
     */

    public Province() {
        setCout(8);
        setType(TypeDeCarte.victoire);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for (Joueur joueur : partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){
                joueur.pV += 6;
            }
        }
    }
}
