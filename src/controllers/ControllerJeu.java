package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.ViewHandler;

public class ControllerJeu implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;

    public ControllerJeu(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewHandler.getViewJeu().setEvent(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
