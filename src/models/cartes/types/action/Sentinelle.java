package models.cartes.types.action;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Sentinelle extends Carte {
    /*
        Donne 1 Carte et 1 Action
        Effet: Consultez les 2 premières cartes de votre pioche. Écartez-en et/ou défaussez-en autant que vous le voulez.
               Replacez le reste sur votre pioche dans l'ordre de votre choix.
        Coût: 5 pièces
        Action
     */

    public Sentinelle() {
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
            }
        }
    }
}
