package controllers;

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



        //4 TODO: Direction La Class Birds ---->


        //TODO HARDCORE DE LA MORT: modifie la Class Birds et prepare une ArrayList d'Oiseau et lache en plein xD
        this.viewHandler.getViewMenuPrincipal().setEvent(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
