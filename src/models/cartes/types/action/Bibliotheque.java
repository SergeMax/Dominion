package models.cartes.types.action;
import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Bibliotheque extends Carte {
    /*
        Effet: Piochez jusqu'à ce que vous ayez 7 cartes en main.
               Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
        Coût: 5 pièces
        Action
     */

    public Bibliotheque() {
        setCout(5);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if (joueur.isEntrainDeJouer()){

            }
        }
    }

    /*
        Besoin de la valeur du nombre de carte en main du joueur, que ça atteint 7. Si il y a une carte action, le joueur a le choix entre
        garder la carte en main ou la défausser.
     */
}
