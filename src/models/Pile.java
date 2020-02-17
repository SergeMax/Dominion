package models;

import models.cartes.Carte;
import models.cartes.DistributeurDeCarte;
import models.cartes.IdCarte;
import models.cartes.LocalisationDesCartes;

import java.util.ArrayList;
import java.util.Map;
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
        Map<String, Long>groupByClassName = carteFilterMain.stream().collect(Collectors.groupingBy(Carte::getName, Collectors.counting()));
        for (Map.Entry<String, Long> carteMap : groupByClassName.entrySet()){
            Carte carte = DistributeurDeCarte.distribueOneCarte(IdCarte.valueOf(carteMap.getKey().toUpperCase()));
            carte.setLocalisation(LocalisationDesCartes.mainJoueur);
            piles.add(new Pile(carte,carteMap.getValue().byteValue()));
        }
        ArrayList<Carte> carteFilterTerrain = cartes.stream().filter(items -> items.getLocalisation().equals(LocalisationDesCartes.terrain)).collect(Collectors.toCollection(ArrayList::new));;
        groupByClassName = carteFilterTerrain.stream().collect(Collectors.groupingBy(Carte::getName, Collectors.counting()));
        for (Map.Entry<String, Long> carteMap : groupByClassName.entrySet()){
            Carte carte = DistributeurDeCarte.distribueOneCarte(IdCarte.valueOf(carteMap.getKey().toUpperCase()));
            carte.setLocalisation(LocalisationDesCartes.terrain);
            piles.add(new Pile(carte,carteMap.getValue().byteValue()));
        }
        ArrayList<Carte> carteFilterPioche = cartes.stream().filter(items -> items.getLocalisation().equals(LocalisationDesCartes.deck)).collect(Collectors.toCollection(ArrayList::new));;
        ArrayList<Carte> carteFilterDefause = cartes.stream().filter(items -> items.getLocalisation().equals(LocalisationDesCartes.defausse)).collect(Collectors.toCollection(ArrayList::new));;
        if(carteFilterDefause.size() != 0){
            piles.add(new Pile(carteFilterDefause.get(0),(byte)carteFilterDefause.size()));
        }
        if(carteFilterPioche.size() != 0){
            piles.add(new Pile(carteFilterPioche.get(0),(byte)carteFilterPioche.size()));
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
