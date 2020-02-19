package models.cartes.types.action;
import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Artisan extends Carte {
    /*
        Effet: Recevez en main une carte coûtant jusqu'à 5 pièces. Placez une carte de votre main sur votre pioche.
        Coût: 6 pièces
        Action
     */

    public Artisan() {
        setCout(6);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            /* On vérifie si le joueur est entrain de jouer et donc peut utiliser la carte*/
            if (joueur.isEntrainDeJouer()){
                /* On vérifie si le joueur peut-utiliser une carte action */
                if(joueur.action == 0){
                    break;
                }else{
                    joueur.recevoirUneCarteDeValeur(5);
                    //joueur.decrementeAction(1);
                    //joueur.poserUneCarte();
                }
            }
        }
    }
    /*
        Pour l'effet, il faudrait un algo qui permet au joueur de choisir une carte sur le terrain ayant un coût égal ou inférieur à 5,
        puis qu'une carte qu'il choisit dans sa main aille sur le top de son deck
     */
}
