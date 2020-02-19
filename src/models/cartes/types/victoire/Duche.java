package models.cartes.types.victoire;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Duche extends Carte {
    /*
        Donne 3 points de victoire
        Coût: 5 pièces
     */

    public Duche() {
        setCout(5);
        setType(TypeDeCarte.victoire);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for (Joueur joueur : partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){
                joueur.pV += 3;
            }
        }
    }
}
