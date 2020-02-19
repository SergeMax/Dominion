package models.cartes.types.action;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Douves extends Carte {
    /*
        Donne 2 Cartes
        Effet: Lorsqu'un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main.
               Dans ce cas, l'attaque n'a pas d'effet sur vous.
        Coût: 2 pièces
        Action - Réaction
     */

    public Douves() {
        setCout(2);
        setType(TypeDeCarte.reaction_action);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(2);
            }
        }
    }

    /*
        Pas sûr si ça marche dans cette situation. Le joueur peut utiliser la carte pendant le tour du joueur adverse mais
        l'algo ne lui permet de pas piocher vu qu'il n'est pas entrain de jouer.
        Pouvoir choisir d'activer la carte ou non, annule l'effet de la carte contre le joueur qui utilisé la carte.
     */
}
