package models.cartes;

import models.Pile;
import models.cartes.types.action.*;
import models.cartes.types.tresor.*;
import models.cartes.types.victoire.*;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Class permetant de connaitre et gerer la distribution des cartes
 * */
public class DistributeurDeCarte {
    /**
     * dictionnaire de cartes
     */
    private static final HashMap<IdCarte, Class<? extends Carte>> dicoCards = new HashMap<IdCarte, Class<? extends Carte>>();

    static {
        dicoCards.put(IdCarte.ARTISANT, Artisan.class);
        dicoCards.put(IdCarte.ATELIER, Atelier.class);
        dicoCards.put(IdCarte.BRIGAND, Brigand.class);
        dicoCards.put(IdCarte.BIBLIOTHEQUE, Bibliotheque.class);
        dicoCards.put(IdCarte.BRACONIER, Braconnier.class);
        dicoCards.put(IdCarte.BUREAUCRATE, Bureaucrate.class);
        dicoCards.put(IdCarte.CAVE, Cave.class);
        dicoCards.put(IdCarte.CHANBRE_DU_CONSEIL, ChambreDuConseil.class);
        dicoCards.put(IdCarte.CHAPELLE, Chapelle.class);
        dicoCards.put(IdCarte.DOUVES, Douves.class);
        dicoCards.put(IdCarte.FESTIVAL, Festival.class);
        dicoCards.put(IdCarte.FORGERON, Forgeron.class);
        dicoCards.put(IdCarte.JARDIN, Jardin.class);
        dicoCards.put(IdCarte.LABORATOIRE, Laboratoire.class);
        dicoCards.put(IdCarte.MARCHAND, Marchand.class);
        dicoCards.put(IdCarte.MARCHE, Marche.class);
        dicoCards.put(IdCarte.MILICE, Millice.class);
        dicoCards.put(IdCarte.MINE, Mine.class);
        dicoCards.put(IdCarte.PRESAGE, Presage.class);
        dicoCards.put(IdCarte.PRETEUR_SUR_GAGE, PreteurSurGage.class);
        dicoCards.put(IdCarte.RENOVATION, Renovation.class);
        dicoCards.put(IdCarte.SALLE_DU_THRONE, SalleDuTrone.class);
        dicoCards.put(IdCarte.SENTINNELLE, Sentinelle.class);
        dicoCards.put(IdCarte.SORCIERE, Sorciere.class);
        dicoCards.put(IdCarte.VASSAL, Vassal.class);
        dicoCards.put(IdCarte.VILLAGE, Village.class);
        dicoCards.put(IdCarte.OR, Or.class);
        dicoCards.put(IdCarte.ARGENT, Argent.class);
        dicoCards.put(IdCarte.CUIVRE, Cuivre.class);
        dicoCards.put(IdCarte.DOMAINE, Domaine.class);
        dicoCards.put(IdCarte.DUCHE, Duche.class);
        dicoCards.put(IdCarte.MALEDICTION, Malediction.class);
        dicoCards.put(IdCarte.PROVINCE, Province.class);
    }

    /**
     * Renvoie une liste de cartes
     *
     * @param number : le nombre de cartes de la liste
     * @param idCarte : l'id de la carte à instancier (voir enum IdCarte)
     * @return une liste de cartes de même type
     */
    public static ArrayList<Carte> distribueDeck(int number, IdCarte idCarte) {
        ArrayList stack = new ArrayList();
        for (int i = 0; i < number; i++) {
            try {
                stack.add(dicoCards.get(idCarte).newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stack;
    }

    public static Carte distribueOne( IdCarte idCarte) {
        Carte carte = null;
            try {
                carte = dicoCards.get(idCarte).newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        return carte;
    }

    public static ArrayList<Pile> radomPileAction() {
        ArrayList stack = new ArrayList<Pile>();
        for (int i = 0; i < 10; i++) {
            int random = (int)(Math.random() * (dicoCards.size() - 1));
            //TODO: RandomPileAction
        }
        return stack;
    }

    public static ArrayList<Pile> distribuePileTresorVictoireMalediction() {
        ArrayList stack = new ArrayList<Pile>();
        for (int i = 0; i < 7; i++) {
            int random = (int)(Math.random() * (dicoCards.size() - 1));
            //TODO: Generer une Liste de Pile définis TresorVictoiremalediction
        }
        return stack;
    }
}
