package views.GraphicalElement;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import models.Joueur;
import models.Pile;
import tools.Paths;
//TODO: Va voir dans CardReserve ---> :)
public class CardViewCentre {

    private int width = 100;
    private Group grpContenairCard;
    private ImageView img;
    private Image front;
    private VBox vBoxNumber;
    private Label lblNumber;
    public CardViewCentre(Joueur joueur, Pile pile){
        grpContenairCard = new Group();
        front = new Image(pile.getCarte().getUrlImgCarte());
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

        // define crop in image coordinates:
        Rectangle2D croppedPortion = new Rectangle2D(0, 0, 800, 700);


// target width and height:
        double scaledWidth = 170;
        double scaledHeight = 140;

        img.setViewport(croppedPortion);
        img.setFitWidth(scaledWidth);
        img.setFitHeight(scaledHeight);
        img.setSmooth(true);

        Rectangle clip = new Rectangle(
                img.getFitWidth(), img.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        img.setClip(clip);

        img.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 30, 0, 10, 10);" +
                " -fx-padding: 5;"+
                "-fx-background-color: sand;"+
                "-fx-background-radius: 3;"
        );

        grpContenairCard.getChildren().addAll(img,vBoxNumber);
    }

    public void setImageViewFront() {
        img.setImage(front);
    }

    public Group getGrpContenairCard(){
        return grpContenairCard;
    }
}
