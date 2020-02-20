package models.cartes.types.tresor;
import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;


public class Cuivre extends Carte {
    /*
        Donne 1 pièce
        Coût: 0 pièce
     */

    public Cuivre() {
        setCout(0);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){
                joueur.monnaie += 1;
            }
        }
    }
}
