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
//TODO: Alors !! les CardViews sont appeller dans les methode update du ViewJeu (comme des View d'Article en PHP)
// On veut se rapporcher du rendu de Dominion Online
// Pour le moment On en a 3 View : les carte du Joueur(ViewPlayer)/ du Centre(ViewCentre) / de Gauche(ViewGauche)
// Ces cartes ce comportent presque de la même Facon (a voir pour faire de l'heritage, c'est pas obligatoire, je te laisse en decider)
// Tu peux tout modifier ameliorer le code, changer la taille sur toute les view card (On voulais que les cartes reserve soi carré)
public class CardViewReserve {

    private int width = 75;
    private Group grpContenairCard;
    private ImageView img;
    private Image front;
    /* BOX QUI CONTIENT LE NOMBRE DE CARTE DE LA PILE */
    private VBox vBoxNumber;
    private Label lblNumber;
    /* BOX QUI DEVRA CONTENIR SI L'UTILISATEUR PEUT OU PAS ACHETER LA CARTE */
    private VBox vBoxAcheterLaCarte;
    private Label lblAcheterLaCarte = new Label("+");

    public CardViewReserve(Joueur joueur, Pile pile){
        grpContenairCard = new Group();
        front = new Image(pile.getCarte().getUrlImgCarte());
        vBoxNumber = new VBox();
        lblNumber = new Label(String.valueOf(pile.getNombre()));
        lblNumber.getStyleClass().add("lbl_box_number");
        vBoxNumber.getChildren().add(lblNumber);
        vBoxNumber.getStyleClass().add("box_number");
        vBoxNumber.setPadding(new Insets(5));
        //TODO: INITIALISER LA VBOX ET L'AJOUTER AU GrpRootContenaire DE LA VIEW CARD SEULEMENT SI LE JOUEUR A ASSEZ DE PIECE D'OR*/


        //TODO: ESSAYE DE FAIRE UNE IMAGE CARRER CENTRER SUR L'IMG DE LA PILE DE CARTE */
        img = new ImageView(front);
        img.setPreserveRatio(true);
        img.setFitWidth(width);
        img.setId(pile.getCarte().getClass().getSimpleName());

        grpContenairCard.getChildren().addAll(img,vBoxNumber);
    }

    public void setImageViewFront() {
        img.setImage(front);
    }

    public Group getGrpContenairCard(){
        return grpContenairCard;
    }
}
