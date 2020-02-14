package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.Partie;
import views.ViewHandler;

public class ControllerJeu implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;
    private Partie partie;

    public ControllerJeu(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        partie = new Partie(2);

        this.viewHandler.getViewJeu().setEvent(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
