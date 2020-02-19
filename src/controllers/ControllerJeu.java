package controllers;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import models.Partie;
import models.Pile;
import models.cartes.Carte;
import views.ViewHandler;


public class ControllerJeu implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;
    private Partie partie;

    public ControllerJeu(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        partie = new Partie(viewHandler.getListeNomJoueur());
        updateAllGUI();
        this.viewHandler.getViewJeu().setEvent(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if(mouseEvent.getSource().equals(viewHandler.getViewJeu().getBtnQuitGame())) {
            viewHandler.afficherMenuPrincipale();
        }else if(mouseEvent.getButton() == MouseButton.PRIMARY){
            PauseTransition delayRemove = new PauseTransition(Duration.seconds(0.33));
            delayRemove.setOnFinished(eventt -> {

                if(mouseEvent.getSource().equals(viewHandler.getViewJeu().getBtnSkipTurn())){

                    partie.endTurn();
                } else {

                    try{
                        Pile selectedPile = partie.cliqueSurUneCarte(mouseEvent.getPickResult().getIntersectedNode().getId());
                        partie.tour(selectedPile);
                    } catch (NullPointerException e){
                        e.printStackTrace();
                    }

                }
                updateAllGUI();

            });
            delayRemove.play();
        }
    }


    public void updateAllGUI(){
        updateJoueurInfoGUI();
        updateJoueurDetailGUI();
        updateCarteReserveLeftGUI();
        updateCarteCenterGUI();
        updateCarteJoueurGUI();
        updateJoueurPassifInfoGUI();
    }

    public void updateJoueurInfoGUI(){
        viewHandler.getViewJeu().updateJoueurInfo(partie.getJoueurs().get(partie.getAuTourDuJoueur()));
    }

    public void updateJoueurPassifInfoGUI(){
        viewHandler.getViewJeu().updateJoueurPassifInfo(partie.getJoueurs().get(partie.getJoueurAdverse()));
    }

    public void updateJoueurDetailGUI(){
        viewHandler.getViewJeu().updateJoueurDetail(partie.getJoueurs().get(partie.getAuTourDuJoueur()));
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
