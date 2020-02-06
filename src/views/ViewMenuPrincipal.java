package views;

import controllers.ControllerMenuPrincipal;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ViewMenuPrincipal {
    private Group root;

    public ViewMenuPrincipal(Group root) {
        this.root = root;
    }

    public void clearAndInitRoot(){
        root.getChildren().clear();
        root.getChildren().add(new Text("THIS IS A TEST"));
    }

    public void setEvent(ControllerMenuPrincipal controllerMenuPrincipal){

    }
}
