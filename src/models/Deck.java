package models;

import models.cartes.Carte;
import models.cartes.DistributeurDeCarte;
import models.cartes.IdCarte;
import models.cartes.LocalisationDesCartes;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Carte> cartes;
    private int indiceDansLeDeck;

    public Deck(){
        cartes = new ArrayList<Carte>();
        for(Carte carte: DistributeurDeCarte.distribueFewCarte(7, IdCarte.CUIVRE)){
            carte.setLocalisation(LocalisationDesCartes.mainJoueur);
            cartes.add(carte);
        };
        for(Carte carte: DistributeurDeCarte.distribueFewCarte(3, IdCarte.DOMAINE)){
            carte.setLocalisation(LocalisationDesCartes.mainJoueur);
            cartes.add(carte);
        };
        melangeSesCartes();
    }

    public void melangeSesCartes(){
        Collections.shuffle(cartes);
        for(int i = 0; i < cartes.size(); i++){
                cartes.get(i).setLocalisation(LocalisationDesCartes.deck);
        }
    }


    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public int getIndiceDansLeDeck() {
        return indiceDansLeDeck;
    }
}
