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
        if(mouseEvent.getSource().equals(viewHandler.getViewJeu().getBtnSkipTurn())){
            partie.skipTurn();
        } else {
            try{
                Carte selectedCarte = partie.cliqueSurUneCarte(mouseEvent.getPickResult().getIntersectedNode().getId());
                partie.tour(selectedCarte);
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        updateAllGUI();
    }


    public void updateAllGUI(){
        updateJoueurInfoGUI();
        updateCarteReserveLeftGUI();
        updateCarteCenterGUI();
        updateCarteJoueurGUI();
    }

    public void updateJoueurInfoGUI(){
        viewHandler.getViewJeu().updateJoueurInfo(partie.getJoueurs().get(partie.getAuTourDuJoueur()));
    }

    public void updateCarteJoueurGUI(){
        viewHandler.getViewJeu().updateCarteJoueur(partie.getJoueurs().get(partie.getAuTourDuJoueur()).piles,this);
    }

    public void updateCarteCenterGUI(){
        viewHandler.getViewJeu().updateCarteCenter(partie.getJoueurs().get(partie.getAuTourDuJoueur()),partie.getPilesReserveAction(),this);
    }

    public void updateCarteReserveLeftGUI(){
        viewHandler.getViewJeu().updateCarteReserveLeft(partie.getJoueurs().get(partie.getAuTourDuJoueur()),partie.getPilesReserveTresorVictoireMalediction(), this);
    }
}
