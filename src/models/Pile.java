package models;

import models.cartes.Carte;

public class Pile {
    private Carte carte;
    private byte nombre;
    private boolean estVide;

    public Pile(Carte carte, byte nombre) {
        this.carte = carte;
        this.nombre = nombre;
        this.estVide = false;
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
