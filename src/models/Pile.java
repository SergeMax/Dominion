package models;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Pile {
    private Carte carte;
    private LocalisationDesCartes localisationDesCartes;
    private byte nombre;
    private boolean estVide;

    public Pile(Carte carte, byte nombre) {
        this.carte = carte;
        this.nombre = nombre;
        this.estVide = false;
        localisationDesCartes = carte.getLocalisation();
    }

    public static ArrayList<Pile> aggregationDeCarteEnPile(ArrayList<Carte> cartes){
        ArrayList piles = new ArrayList();
        ArrayList<Carte> carteFilterMain = cartes.stream().filter(items -> items.getLocalisation().equals(LocalisationDesCartes.mainJoueur)).collect(Collectors.toCollection(ArrayList::new));;
        Collections.sort(carteFilterMain,Comparator.comparing(Carte::getName));
        Carte previousCarte= null;
        byte turn = 1;
        byte nombreDeTypeDeCarte = 1;
        for(Carte carte: carteFilterMain){
            if(previousCarte == null){
                previousCarte = carte;
            }
            if(previousCarte.getClass().getSimpleName() != carte.getClass().getSimpleName()){
                piles.add(new Pile(previousCarte,nombreDeTypeDeCarte));
                previousCarte = carte;
                nombreDeTypeDeCarte = 0;
            } else if (carteFilterMain.size() == turn){
                piles.add(new Pile(carte,nombreDeTypeDeCarte));
                break;
            }
            nombreDeTypeDeCarte++;
            turn++;
        }
        ArrayList<Carte> carteFilterPioche = cartes.stream().filter(items -> items.getLocalisation().equals(LocalisationDesCartes.deck)).collect(Collectors.toCollection(ArrayList::new));;
        ArrayList<Carte> carteFilterDefause = cartes.stream().filter(items -> items.getLocalisation().equals(LocalisationDesCartes.defausse)).collect(Collectors.toCollection(ArrayList::new));;
        if(carteFilterDefause.size() != 0){
            piles.add(new Pile(carteFilterDefause.get(1),(byte)carteFilterPioche.size()));
        }
        if(carteFilterPioche.size() != 0){
            piles.add(new Pile(carteFilterPioche.get(1),(byte)carteFilterPioche.size()));
        }
        return piles;
    }

    public Carte getCarte() {
        return carte;
    }

    public byte getNombre() {
        return nombre;
    }

    public boolean isEstVide() {
        return estVide;
    }
}
