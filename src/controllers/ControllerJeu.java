package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import views.ViewHandler;

import java.util.Collections;

public class ControllerJeu implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;
    private Partie partie;

    public ControllerJeu(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        partie = new Partie(2);
        updateAllGUI();
        this.viewHandler.getViewJeu().setEvent(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try{
            //Carte selectedCarte = partie.getJoueurs().get(0).clicqueSurUneCarte(mouseEvent.getPickResult().getIntersectedNode().getId());
            //partie.getJoueurs().get(0).poserUneCarte(selectedCarte);
            //updateAllGUI();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }


    public void updateAllGUI(){
        updateJoueurInfoGUI();
        updateCarteReserveLeftGUI();
        updateCarteCenterGUI();
        updateCarteJoueurGUI();
    }

    public void updateJoueurInfoGUI(){
        viewHandler.getViewJeu().updateJoueurInfo(partie.getJoueurs().get(0));
    }

    public void updateCarteJoueurGUI(){
        viewHandler.getViewJeu().updateCarteJoueur(partie.getJoueurs().get(0).getAgregationDeCarteEnPile(),this);
    }

    public void updateCarteCenterGUI(){
        viewHandler.getViewJeu().updateCarteCenter(partie.getJoueurs().get(0),partie.getPilesReserveAction(),this);
    }

    public void updateCarteReserveLeftGUI(){
        viewHandler.getViewJeu().updateCarteReserveLeft(partie.getJoueurs().get(0),partie.getPilesReserveTresorVictoireMalediction(), this);
    }
}
