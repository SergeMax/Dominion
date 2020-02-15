package views.GraphicalElement;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import models.Joueur;
import models.Pile;
import tools.Paths;

public class CardViewCentre {

    private int width = 100;
    private Group grpContenairCard;
    private ImageView img;
    private Image front, back;
    private VBox vBoxNumber;
    private Label lblNumber;
    //TODO: Pour le moment
    public CardViewCentre(Joueur joueur, Pile pile){
        grpContenairCard = new Group();
        front = new Image(pile.getCarte().getUrlImgCarte());
        back = new Image(Paths.urlImgBack);
        vBoxNumber = new VBox();
        lblNumber = new Label(String.valueOf(pile.getNombre()));
        lblNumber.getStyleClass().add("lbl_box_number");
        vBoxNumber.getChildren().add(lblNumber);
        vBoxNumber.getStyleClass().add("box_number");
        vBoxNumber.setPadding(new Insets(5));

        img = new ImageView(front);
        img.setPreserveRatio(true);
        img.setFitWidth(width);
        img.setId(pile.getCarte().getClass().getSimpleName());

        grpContenairCard.getChildren().addAll(img,vBoxNumber);
    }

    public void setImageViewFront() {
        img.setImage(front);
    }

    public void setImageViewBack() {
        img.setImage(back);
    }

    public Group getGrpContenairCard(){
        return grpContenairCard;
    }
}
