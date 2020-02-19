package models.cartes;

import models.Pile;
import models.cartes.types.action.*;
import models.cartes.types.tresor.*;
import models.cartes.types.victoire.*;
import views.GraphicalElement.CardViewPlayer;

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
        dicoCards.put(IdCarte.ARTISAN, Artisan.class);
        dicoCards.put(IdCarte.ATELIER, Atelier.class);
        dicoCards.put(IdCarte.BRIGAND, Brigand.class);
        dicoCards.put(IdCarte.BIBLIOTHEQUE, Bibliotheque.class);
        dicoCards.put(IdCarte.BRACONIER, Braconnier.class);
        dicoCards.put(IdCarte.BUREAUCRATE, Bureaucrate.class);
        dicoCards.put(IdCarte.CAVE, Cave.class);
        dicoCards.put(IdCarte.CHAMBREDUCONSEIL, ChambreDuConseil.class);
        dicoCards.put(IdCarte.CHAPELLE, Chapelle.class);
        dicoCards.put(IdCarte.DOUVES, Douves.class);
        dicoCards.put(IdCarte.FESTIVAL, Festival.class);
        dicoCards.put(IdCarte.FORGERON, Forgeron.class);
        dicoCards.put(IdCarte.JARDIN, Jardin.class);
        dicoCards.put(IdCarte.LABORATOIRE, Laboratoire.class);
        dicoCards.put(IdCarte.MARCHAND, Marchand.class);
        dicoCards.put(IdCarte.MARCHE, Marche.class);
        dicoCards.put(IdCarte.MILLICE, Millice.class);
        dicoCards.put(IdCarte.MINE, Mine.class);
        dicoCards.put(IdCarte.PRESAGE, Presage.class);
        dicoCards.put(IdCarte.PRETEURSURGAGE, PreteurSurGage.class);
        dicoCards.put(IdCarte.RENOVATION, Renovation.class);
        dicoCards.put(IdCarte.SALLEDUTRONE, SalleDuTrone.class);
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
    public static ArrayList<Carte> distribueFewCarte(int number, IdCarte idCarte) {
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

    public static Carte distribueOneCarte(IdCarte idCarte) {
        Carte carte = null;
            try {
                carte = dicoCards.get(idCarte).newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        return carte;
    }

    public static ArrayList<Pile> radomPileAction() {
        ArrayList<Pile> stack = new ArrayList<Pile>();
        Carte carte = null;
        int random = 0;
        boolean carteIsNotUnique = false;
        for (int i = 0; i < 10; i++) {
            do {
                carteIsNotUnique = false;
                random = (int) (Math.random() * (dicoCards.size()));
                carte = distribueOneCarte(IdCarte.values()[random]);
                if(i != 0){
                    for(Pile pile: stack){
                        if(carte.getName().equals(pile.getCarte().getName())){
                            carteIsNotUnique = true;
                            break;
                        }
                    }
                }
            }while (carte.getType().equals(TypeDeCarte.tresor) || carte.getType().equals(TypeDeCarte.victoire) || carteIsNotUnique);
            carte.setLocalisation(LocalisationDesCartes.reserve);
            stack.add(new Pile(carte,(byte)10));
        }
        return stack;
    }

    public static ArrayList<Pile> distribuePileTresorVictoireMalediction() {
        ArrayList<Pile> stack = new ArrayList<Pile>();
        stack.add(new Pile(distribueOneCarte(IdCarte.OR),(byte)30));
        stack.add(new Pile(distribueOneCarte(IdCarte.ARGENT),(byte)40));
        stack.add(new Pile(distribueOneCarte(IdCarte.CUIVRE),(byte)48));
        stack.add(new Pile(distribueOneCarte(IdCarte.PROVINCE),(byte)8));
        stack.add(new Pile(distribueOneCarte(IdCarte.DUCHE),(byte)8));
        stack.add(new Pile(distribueOneCarte(IdCarte.DOMAINE),(byte)8));
        stack.add(new Pile(distribueOneCarte(IdCarte.MALEDICTION),(byte)10));
        for(Pile pile: stack){
            pile.getCarte().setLocalisation(LocalisationDesCartes.reserve);
        }
        return stack;
    }
}
