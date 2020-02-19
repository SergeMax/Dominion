package controllers;

import animation.clouds.Cloud;
import animations.birds.Oiseau;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.ViewHandler;

public class ControllerMenuPrincipal implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;
    private Oiseau oiseau;

    public ControllerMenuPrincipal(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;

        //3 TODO: construire l'objet Oiseau et demarer son animation (en deux ligne c'est fait :))
        for (int i = 0; i < 20; i++) {
            Oiseau toto = new Oiseau(viewHandler.getViewMenuPrincipal().getRoot());
            toto.startFlying();
        }
        for (int i = 0; i < 15; i++) {
            Cloud nuage = new Cloud(viewHandler.getViewMenuPrincipal().getRoot());
            nuage.startPassage();
        }

        //4 TODO: Direction La Class Birds ---->


        //TODO HARDCORE DE LA MORT: modifie la Class Birds et prepare une ArrayList d'Oiseau et lache en plein xD
        this.viewHandler.getViewMenuPrincipal().setEvent(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getSource().equals(viewHandler.getViewMenuPrincipal().getBtnPlay())){
            viewHandler.getViewMenuPrincipal().clearAndInitRootFormulaire();
        }
        if (mouseEvent.getSource().equals(viewHandler.getViewMenuPrincipal().getBtnQuit())){
            viewHandler.quitterJeu();
        }
        if (mouseEvent.getSource().equals(viewHandler.getViewMenuPrincipal().getBtnJouer())){
            viewHandler.getListeNomJoueur().clear();
            viewHandler.getListeNomJoueur().add(viewHandler.getViewMenuPrincipal().getTextFjoueur1().getText());
            viewHandler.getListeNomJoueur().add(viewHandler.getViewMenuPrincipal().getTextFjoueur2().getText());
            viewHandler.afficherJeu();
        }
    }
}
