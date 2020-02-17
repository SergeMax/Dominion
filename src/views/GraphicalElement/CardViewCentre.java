package views.GraphicalElement;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import models.Joueur;
import models.Pile;
import tools.Anim;
import tools.Paths;
import views.ViewJeu;

//TODO: Va voir dans CardReserve ---> :)
public class CardViewCentre {

    private final ImageView imgReset;
    private boolean imgClique;
    private int width = 100;
    private Group grpContenairCard;
    private ImageView img,imgPiece;
    private Image front;
    private VBox vBoxNumber,vboxPiece,vboxPrix;
    private Label lblNumber,lblPrix;
    private ViewJeu viewJeu;

    public CardViewCentre(Joueur joueur, Pile pile) {
        grpContenairCard = new Group();
        front = new Image(pile.getCarte().getUrlImgCarte());
        vBoxNumber = new VBox();
        lblNumber = new Label(String.valueOf(pile.getNombre()));
        lblNumber.getStyleClass().add("lbl_box_number");
        vBoxNumber.getChildren().add(lblNumber);
        vBoxNumber.getStyleClass().add("box_number");
        vBoxNumber.setPadding(new Insets(5));

        vboxPiece = new VBox();
        imgPiece = new ImageView(Paths.urlImgPiece);
        imgPiece.setFitWidth(40);
        imgPiece.setFitHeight(40);
        vboxPiece.setPadding(new Insets(80,0,0,0));


        vboxPrix = new VBox();
        lblPrix = new Label(String.valueOf(pile.getCarte().getCout()));
        lblPrix.getStyleClass().add("lbl_box_prix");
        vboxPrix.getChildren().add(lblPrix);
        vboxPrix.setPadding(new Insets(-35,0,0,14));


        vboxPiece.getChildren().addAll(imgPiece,vboxPrix);

        //TODO Ajouter le cout en bas a gauche des images carré centrale.
        // pile.getCarte().getCout();

        img = new ImageView(front);
        img.setPreserveRatio(true);
        img.setFitWidth(width);
        img.setId(String.valueOf(pile.hashCode()));

        // define crop in image coordinates:
        Rectangle2D croppedPortion = new Rectangle2D(0, 0, 800, 570);

        // target width and height:
        double scaledWidth = 170;
        double scaledHeight = 140;

        img.setViewport(croppedPortion);
        img.setFitWidth(scaledWidth);
        img.setFitHeight(scaledHeight);
        img.setSmooth(true);

        imgReset = img;

        img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (event.getButton() == MouseButton.PRIMARY)
                {

                    Anim anim = new Anim();
                    anim.animCarteCentraleToPioche(grpContenairCard, grpContenairCard, img);

                    PauseTransition delayRemove = new PauseTransition(Duration.seconds(0.33));
                    delayRemove.setOnFinished(eventt -> {
                        grpContenairCard.getChildren().addAll(imgReset, vBoxNumber);
                        grpContenairCard.setTranslateX(0);
                        grpContenairCard.setTranslateY(0);

                    });
                    delayRemove.play();

                } else if (event.getButton() == MouseButton.SECONDARY)
                {
                    if (imgClique == false) {

                        grpContenairCard.getChildren().removeAll(vBoxNumber,vboxPiece);
                        img.setViewport(null);
                        Anim anim = new Anim();
                        anim.animCarteCentraleUP(img, grpContenairCard);
                        imgClique = true;


                    } else {

                        Anim anim = new Anim();
                        anim.animCarteCentraleDown(img, grpContenairCard);

                        img.setScaleX(2);
                        img.setScaleY(2);
                        img.setViewport(croppedPortion);
                        imgClique = false;

                        PauseTransition delayRemove = new PauseTransition(Duration.seconds(0.4));
                        delayRemove.setOnFinished(eventt -> {
                            grpContenairCard.getChildren().addAll(vBoxNumber,vboxPiece);
                        });
                        delayRemove.play();

                    }
                }


            }
        });


        Rectangle clip = new Rectangle(
                img.getFitWidth(), img.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        img.setClip(clip);

        img.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 30, 0, 10, 10);" +
                " -fx-padding: 5;" +
                "-fx-background-color: sand;" +
                "-fx-background-radius: 3;"
        );

        grpContenairCard.getChildren().addAll(img, vBoxNumber,vboxPiece);
        grpContenairCard.getStyleClass().add("hoverCarteCentral");
    }

    public void setImageViewFront() {
        img.setImage(front);
    }

    public Group getGrpContenairCard() {
        return grpContenairCard;
    }
}
