package views.GraphicalElement;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import models.Pile;
import tools.Anim;
import tools.Paths;
//TODO: Va voir dans CardReserve ---> :)
public class CardViewPlayer extends Pane {

    private final ImageView imgReset;
    private int width = 140;
    private Group grpContenairCard;
    private ImageView img;
    private Image front, back;
    private VBox vBoxNumber;
    private Label lblNumber;
    private Pile pile;
    /**/


    public CardViewPlayer(Pile pile){
        this.pile = pile;
        grpContenairCard = new Group();
        this.getChildren().add(grpContenairCard);
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


        img.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 30, 0, 10, 10);" +
                " -fx-padding: 5;"+
                "-fx-background-color: sand;"+
                "-fx-background-radius: 3;"
        );

        Label urlImg = new Label(String.valueOf(pile.getCarte().getUrlImgCarte()));

        img.setId(String.valueOf(pile.hashCode()));
        imgReset = img;
        img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Anim anim = new Anim();
                anim.animGlissCarteMainToTerrain(grpContenairCard, img, urlImg );

                PauseTransition delayRemove = new PauseTransition(Duration.seconds(0.33));
                delayRemove.setOnFinished(eventt -> {

                   // grpContenairCard.getChildren().addAll(imgReset);
                    grpContenairCard.setTranslateX(0);
                    grpContenairCard.setTranslateY(0);
                });
                delayRemove.play();

            }
        });


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
