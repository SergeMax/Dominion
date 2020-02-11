package models.cartes.types.action;
import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class ChambreDuConseil extends Carte {
    /*
        Donne 4 cartes et 1 Achat
        Effet: Tous vos adversaires piochent 1 Carte
        Coût: 5 pièces
        Action
     */

    public ChambreDuConseil() {
        setCout(5);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(4);
            }
            if (joueur.isEntrainDeJouer() == false){
                joueur.piocheDesCarte(4);
            }
        }
    }
    /*
        Reçoit 1 achat, faire différence entre joueur actuel et les autres (pas sûr que l'algo soit bon, faut vérifier mais je pense
        que ça ne vise pas les autres joueurs, ceux qui ne jouent pas)
     */

}
