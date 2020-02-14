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
        for(Carte carte: DistributeurDeCarte.distribueCarte(7, IdCarte.CUIVRE)){
            carte.setLocalisation(LocalisationDesCartes.deck);
            cartes.add(carte);
        };
        for(Carte carte: DistributeurDeCarte.distribueCarte(3, IdCarte.DOMAINE)){
            carte.setLocalisation(LocalisationDesCartes.deck);
            cartes.add(carte);
        };
    }

    public void melangeSesCartes(){
        Collections.shuffle(cartes);
    }


    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public int getIndiceDansLeDeck() {
        return indiceDansLeDeck;
    }
}
