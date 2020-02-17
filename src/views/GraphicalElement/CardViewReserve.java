package views.GraphicalElement;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import models.Joueur;
import models.Pile;
import tools.Anim;
import tools.Paths;
import views.ViewJeu;

//TODO: Alors !! les CardViews sont appeller dans les methode update du ViewJeu (comme des View d'Article en PHP)
// On veut se rapporcher du rendu de Dominion Online
// Pour le moment On en a 3 View : les carte du Joueur(ViewPlayer)/ du Centre(ViewCentre) / de Gauche(ViewGauche)
// Ces cartes ce comportent presque de la même Facon (a voir pour faire de l'heritage, c'est pas obligatoire, je te laisse en decider)
// Tu peux tout modifier ameliorer le code, changer la taille sur toute les view card (On voulais que les cartes reserve soi carré)
public class CardViewReserve {

    private final ImageView imgReset;
    private int width = 90;
    private Group grpContenairCard;
    private ImageView img,imgPiece;
    private Image front;
    /* BOX QUI CONTIENT LE NOMBRE DE CARTE DE LA PILE */
    private VBox vBoxNumber,vboxPiece,vboxPrix;
    private Label lblNumber,lblPrix;
    /* BOX QUI DEVRA CONTENIR SI L'UTILISATEUR PEUT OU PAS ACHETER LA CARTE */
    private VBox vBoxAcheterLaCarte;
    private Label lblAcheterLaCarte = new Label("+");
    private boolean imgClique = false;

    public CardViewReserve(Joueur joueur, Pile pile) {
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
        imgPiece.setFitWidth(30);
        imgPiece.setFitHeight(30);
        vboxPiece.setPadding(new Insets(60,0,0,0));


        vboxPrix = new VBox();
        lblPrix = new Label(String.valueOf(pile.getCarte().getCout()));
        lblPrix.getStyleClass().add("lbl_box_prix");
        vboxPrix.getChildren().add(lblPrix);
        vboxPrix.setPadding(new Insets(-30,0,0,9));


        vboxPiece.getChildren().addAll(imgPiece,vboxPrix);
        //TODO: INITIALISER LA VBOX ET L'AJOUTER AU GrpRootContenaire DE LA VIEW CARD SEULEMENT SI LE JOUEUR A ASSEZ DE PIECE D'OR*/


        //TODO: ESSAYE DE FAIRE UNE IMAGE CARRER CENTRER SUR L'IMG DE LA PILE DE CARTE */
        img = new ImageView(front);
        img.setPreserveRatio(true);
        img.setFitWidth(width);
        img.setId(pile.getCarte().getClass().getSimpleName());


// define crop in image coordinates:
        Rectangle2D croppedPortion = new Rectangle2D(0, 0, 700, 600);


// target width and height:
        double scaledWidth = 100;
        double scaledHeight = 100;

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
                " -fx-padding: 5;" +
                "-fx-background-color: sand;" +
                "-fx-background-radius: 3;"
        );

        imgReset = img;


        img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                    Anim anim = new Anim();
                    anim.animCarteReserveToPioche(grpContenairCard, grpContenairCard, img );

                PauseTransition delayRemove = new PauseTransition(Duration.seconds(0.33));
                delayRemove.setOnFinished(eventt -> {
                    grpContenairCard.getChildren().addAll(imgReset, vBoxNumber ,vboxPiece);
                    grpContenairCard.setTranslateX(15);
                    grpContenairCard.setTranslateY(0);

                });
                delayRemove.play();

            }
        });

        grpContenairCard.getChildren().addAll(img, vBoxNumber,vboxPiece);

        grpContenairCard.setTranslateX(15);
    }

    public void setImageViewFront() {
        img.setImage(front);
    }

    public Group getGrpContenairCard() {
        return grpContenairCard;
    }
}
