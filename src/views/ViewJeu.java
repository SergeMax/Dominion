package views;

import controllers.ControllerJeu;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class ViewJeu {
    private Group root;

    public ViewJeu(Group root) {

        this.root = root;



    }

    public void clearAndInitRoot(){
        root.getChildren().clear();
        root.getChildren().add(new Text("THIS IS THE GAME VIEW"));
    }

    public void setEvent(ControllerJeu controllerJeu){

    }
}
