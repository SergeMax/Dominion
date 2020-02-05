package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.ViewHandler;

public class ControllerMenuPrincipal implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;

    public ControllerMenuPrincipal(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewHandler.getViewMenuPrincipal().setEvent(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
