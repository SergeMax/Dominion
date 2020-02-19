package models.cartes.types.victoire;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Domaine extends Carte {
    /*
        Donne 1 point de victoire
        Coût: 2 pièces
     */

    public Domaine() {
        setCout(2);
        setType(TypeDeCarte.victoire);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for (Joueur joueur : partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){
                joueur.pV += 1;
            }
        }
    }
}
