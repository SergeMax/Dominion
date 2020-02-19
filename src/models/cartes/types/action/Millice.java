package models.cartes.types.action;
import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Millice extends Carte {
    /*
        Donne 2 pièce
        Effet: Tous vos adversaires défaussent jusqu'à avoir 3 cartes en main.
        Coût: 4 pièces
        Action - Attaque
     */

    public Millice() {
        setCout(4);
        setType(TypeDeCarte.attaque_action);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for (Joueur joueur : partie.getJoueurs()) {
            if (joueur.isEntrainDeJouer()){
                joueur.monnaie += 1;
            }
        }
        int joueurAdvNbCarteDef = 0;
        for (Joueur joueur : partie.getJoueurs()){
            if(!joueur.isEntrainDeJouer()){
                joueurAdvNbCarteDef = joueur.getDeck().getCartes().stream().filter(item -> item.getLocalisation().equals(LocalisationDesCartes.mainJoueur)).collect(Collectors.toCollection(ArrayList::new)).size() -3;
                break;
            }
        }
        partie.setHasSpecialEffect(this,joueurAdvNbCarteDef);
    }
}
