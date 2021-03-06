package models.cartes.types.tresor;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;


public class Or extends Carte {
    /*
        Donne 3 pièces
        Coût: 6 pièces
     */

    public Or() {
        setCout(6);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){
                joueur.monnaie += 3;
            }
        }
    }
}
