package models.cartes.types.action;
import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Marche extends Carte {
    /*
        Donne 1 Carte, 1 Action, 1 Achat et 1 pièce
        Coût: 5 pièces
        Action
     */

    public Marche() {
        setCout(5);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(1);
                joueur.action += 1;
                joueur.achat += 1;
                joueur.monnaie += 1;
            }
        }
    }
}
