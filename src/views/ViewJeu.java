package views;

import controllers.ControllerJeu;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.Joueur;
import models.Pile;
import models.cartes.LocalisationDesCartes;
import views.GraphicalElement.CardViewCentre;
import views.GraphicalElement.CardViewPlayer;
import views.GraphicalElement.CardViewReserve;

import java.util.ArrayList;

//TODO: 1 Modifier la Class CardViewReserve pour qu'elles soit carré.
//TODO: 2 Afficher les Info du joueur (Nom, Or, Pv)
//TODO: 3 Modifier les Class CardView pour qu'il y est une icone (+) sur une carte de la reserve signifiant que le joueur peut l'acheter
// (Piste : Modifier les Class CardView en utilisant peut etre l'heritage et modifier les methode update au besoin)
//TODO: 4 Agencer l'affichage du BorderPane (Nettoyer element inutile, modifier les conteneurs au besoin,...)
public class ViewJeu {
    private BorderPane root;

    /* DECLARATION DES CONTENEUR DES 5 PARTIES DU BORDERPANE */
    private HBox hBoxFooter,hBoxRigth, hBoxLeft;
    private VBox boxMenu;
    private StackPane centerPane;

    /* DECLARATION DES CONTENEURS QUI ACCEUILLENT LES CARTES ENVOYER PAR LE CONTROLER*/
    private HBox boxMainActif;
    private VBox boxDeckJActif,boxCarteCentraleEtJoue, boxPvLeft, boxPvRight;
    private HBox boxCarteRandomLigne1, boxCarteRandomLigne2,boxCarteJoue, boxDefause, boxPioche;

    public ViewJeu(BorderPane root) {
        this.root = root;
        /* INIT DES ELEMENTS */
        boxMenu = initMenu();
        hBoxLeft = initLeftHBox();
        hBoxRigth = initRightHBox();
        centerPane = initCenterPane();
        hBoxFooter = initFooter();
    }

    /**
     * Methode appeller depuis le ViewHandler pour vider le root et initialiser les views
     */
    public void clearAndInitRoot(){
        root.getChildren().clear();
        root.setBackground(new Background( new BackgroundImage(new Image("assets/background/backgroundJeux.jpg"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        root.setTop(boxMenu);
        root.setRight(hBoxRigth);
        root.setBottom(hBoxFooter);
        root.setLeft(hBoxLeft);
        root.setCenter(centerPane);
    }

    //TODO: 4 Agencer l'affichage du BorderPane (Nettoyer element inutile, modifier les conteneurs au besoin,...)
    /**
     * Initialise le conteneur Top (Menu):
     * - NE CONTIENT RIEN POUR LE MOMENT
     * @return le conteneur menu
     */
    public VBox initMenu()
    {
        VBox vbox = new VBox();

        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(5));
        hbox.setAlignment(Pos.CENTER);



        HBox scoreJPassifHbox = new HBox();
        Text scoreJactifText = new Text("Joueur 2 : 9pv");
        scoreJactifText.setStyle("-fx-font: 24 arial;");
        scoreJactifText.setFill(Color.WHITE);
        scoreJPassifHbox.getChildren().add(scoreJactifText);
        scoreJPassifHbox.setStyle("-fx-background-color:rgba(0,0,0,0.5);");
        scoreJPassifHbox.setMaxWidth(100);
        scoreJPassifHbox.setMinHeight(30);
        scoreJPassifHbox.setPadding(new Insets(10, 10, 10, 10));



        vbox.getChildren().addAll(new Separator(),scoreJPassifHbox, hbox);

        vbox.setMaxHeight(100);
        vbox.setMinHeight(90);

        vbox.setTranslateX(200);
        vbox.getStyleClass().add("vbox_style");

        return vbox;
    }

    /**
     * Initialise le conteneur des cartes reserve contenant:
     * - NE CONTIENT RIEN POUR LE MOMENT
     * @return le conteneur droit
     */
    public HBox initRightHBox()
    {
        HBox hbox = new HBox();

        VBox vbox = new VBox(50);
        vbox.setPadding(new Insets(0, 20, 0, 20));
        vbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(new Text(""),
                new Text(""), new Text(""));
        hbox.getChildren().addAll(new Separator(Orientation.VERTICAL), vbox);
        hbox.getStyleClass().add("vbox_style");

        return hbox;
    }

    /**
     * Initialise le conteneur des cartes reserve contenant:
     * - box des carte Victoire Gauche
     * - box des carte Tresor Droit
     * @return le conteneur gauche des cartes reserves
     */
    public HBox initLeftHBox()
    {
        HBox hbox = new HBox();

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(1));

        Text text = new Text("");
        text.setFont(Font.font("", FontWeight.BOLD, 20));

        VBox vboxText = new VBox(10);

        boxPvLeft = new VBox();
        boxPvLeft.setPadding(new Insets(1));
        boxPvLeft.setAlignment(Pos.TOP_RIGHT);
        boxPvLeft.setMaxWidth(100);
        boxPvLeft.setMinWidth(100);
        boxPvLeft.getStyleClass().add("vbox_style");
        boxPvLeft.setSpacing(5);

        boxPvRight = new VBox();
        boxPvRight.setPadding(new Insets(1));
        boxPvRight.setAlignment(Pos.TOP_RIGHT);
        boxPvRight.getStyleClass().add("vbox_style");
        boxPvRight.setSpacing(5);
        boxPvRight.setMaxWidth(100);
        boxPvRight.setMinWidth(100);

        hbox.getChildren().addAll(vbox);
        hbox.getChildren().addAll(boxPvLeft, boxPvRight);

        hbox.setMinWidth(200);

        hbox.setMaxHeight(800);
        hbox.setTranslateY(-70);
        hbox.getStyleClass().add("vbox_style");

         return hbox;
    }

    /**
     * Initialise le conteneur footer contenant:
     * - box du la pioche
     * - box de la defause
     * - box de la main
     * @return le conteneur footer
     */
    public HBox initFooter()
    {
        HBox hbox = new HBox();
        boxDeckJActif = new VBox();
        boxMainActif = new HBox(); // Zone carte Main
       // hbox.setAlignment(Pos.CENTER_LEFT);
        boxDeckJActif = new VBox();
        boxDeckJActif.setPadding(new Insets(1));
        boxDeckJActif.setAlignment(Pos.CENTER_LEFT);

        boxDeckJActif.setMinHeight(180);
        boxDeckJActif.setMinWidth(260);
        boxDeckJActif.getStyleClass().add("vbox_style");

        boxMainActif.setPadding(new Insets(5));
        boxMainActif.getStyleClass().add("vbox_style");
        boxMainActif.setAlignment(Pos.CENTER);
        boxMainActif.setPrefWidth(1500);
        boxMainActif.setSpacing(-20);

        HBox hBoxDefausePioche = new HBox(20);
        hBoxDefausePioche.setPadding(new Insets(5));
        hBoxDefausePioche.setAlignment(Pos.CENTER);
        boxDefause = new HBox();
        boxPioche = new HBox();

        HBox scoreJActifHbox = new HBox();
        Text scoreJactifText = new Text("Joueur 1 : 9pv");
        scoreJactifText.setStyle("-fx-font: 24 arial;");
        scoreJactifText.setFill(Color.WHITE);
        scoreJActifHbox.getChildren().add(scoreJactifText);
        scoreJActifHbox.setStyle("-fx-background-color:rgba(0,0,0,0.5);");
        scoreJActifHbox.setMaxWidth(100);
        scoreJActifHbox.setMinHeight(30);
        scoreJActifHbox.setPadding(new Insets(10, 10, 10, 10));


        hBoxDefausePioche.getChildren().addAll(boxDefause,boxPioche);
        boxDeckJActif.getChildren().addAll(scoreJActifHbox, hBoxDefausePioche);
        hbox.getChildren().addAll(boxDeckJActif);
        hbox.getChildren().addAll(boxMainActif);

        hbox.setMinHeight(200);
        hbox.setMaxHeight(400);
        hbox.setTranslateY(50);

        hbox.setPadding(new Insets(-15, 50, 0, 10));
        hbox.getStyleClass().add("vbox_style");

        return hbox;
    }

    /**
     * Initialise le conteneur central contenant la boxCarteRandomLigne1 et la boxCarteRandomLigne2
     * @return le conteneur central
     */
    public StackPane initCenterPane()
    {
        StackPane stackPane = new StackPane();
        boxCarteCentraleEtJoue = new VBox(); // Zone Carte Central
        stackPane.setAlignment(Pos.TOP_CENTER);
        Rectangle rec = new Rectangle();
        rec.setOpacity(0.1);
        rec.widthProperty().bind(stackPane.widthProperty().subtract(5));
        rec.heightProperty().bind(stackPane.heightProperty().subtract(5));
        boxCarteCentraleEtJoue = new VBox();
        boxCarteCentraleEtJoue.setPadding(new Insets(1));
       // boxCarteCentraleEtJoue.setAlignment(Pos.TOP_CENTER);
        boxCarteCentraleEtJoue.setSpacing(20);
        boxCarteCentraleEtJoue.getStyleClass().add("vbox_style");
        boxCarteJoue = new HBox();
        boxCarteJoue.setPadding(new Insets(1));
        boxCarteJoue.setAlignment(Pos.BOTTOM_CENTER);
        boxCarteJoue.setPrefHeight(300);
        boxCarteJoue.setMinHeight(100);
        boxCarteJoue.setTranslateY(20);
        boxCarteJoue.getStyleClass().add("vbox_style");

        /* BOX CARTE ACTION LIGNE 1 */
        boxCarteRandomLigne1 = new HBox();
        boxCarteRandomLigne1.setPadding(new Insets(1));
        boxCarteRandomLigne1.setAlignment(Pos.TOP_CENTER);
        boxCarteRandomLigne1.getStyleClass().add("vbox_style");
        boxCarteRandomLigne1.setMinHeight(150);
        boxCarteRandomLigne1.setSpacing(-15);

        /* BOX CARTE ACTION LIGNE 2 */
        boxCarteRandomLigne2 = new HBox();
        boxCarteRandomLigne2.setPadding(new Insets(1));
        boxCarteRandomLigne2.setAlignment(Pos.TOP_CENTER);
        boxCarteRandomLigne2.setMinHeight(150);
        boxCarteRandomLigne2.setMinHeight(150);
        boxCarteRandomLigne2.setTranslateY(-20);
        boxCarteRandomLigne2.getStyleClass().add("vbox_style");
        boxCarteRandomLigne2.setSpacing(-15);

        boxCarteCentraleEtJoue.getChildren().addAll(boxCarteRandomLigne1, boxCarteRandomLigne2, boxCarteJoue );
        boxCarteCentraleEtJoue.setTranslateY(40);
        stackPane.getChildren().addAll(rec, boxCarteCentraleEtJoue);

        return stackPane;
    }

    /* METHODE D'UPDATE DES CONTENEURS UTILISEES DANS LE CONTROLLER POUR METTRE A JOUR VISUELLEMENT LES CARTES */
    /* CES METHODES SERONT A MODIFIER SI ON SOUHAITE FAIRE DES ANIMATIONS */
    /**
     * Met a jour l'interface graphique des cartes du joueur (refresh)
     * @param piles pile du joueur
     * @param controllerJeu Le controlleur de jeu (pour capturer le clique sur les cartes)
     */
    public void updateCarteJoueur(ArrayList<Pile> piles, ControllerJeu controllerJeu){
        /* ON COMMENCE PAR VIDER LES CONTENEURS DU JOUEUR */
        boxMainActif.getChildren().clear();
        boxCarteJoue.getChildren().clear();
        boxDefause.getChildren().clear();
        boxPioche.getChildren().clear();
        /* ON PARCOURS LES PILES */
        for(Pile pile: piles){
            /* ON CREER LA CARTE VIEWS */
            CardViewPlayer cardViewPlayer = new CardViewPlayer(pile);
            /* ON ATTACHE L'EVENT AU CLIC DU CONTROLER DE LA CARTE */
            cardViewPlayer.getGrpContenairCard().setOnMouseClicked(controllerJeu);
            /* ON ATTACHE LA CARTE VIEWS A LA BONNE BOX SUIVANT SA LOCALISATION */
            if(pile.getCarte().getLocalisation() == LocalisationDesCartes.mainJoueur){
                boxMainActif.getChildren().add(cardViewPlayer.getGrpContenairCard());
            }else if(pile.getCarte().getLocalisation() == LocalisationDesCartes.terrain) {
                boxCarteJoue.getChildren().add(cardViewPlayer.getGrpContenairCard()) ;
            }else if(pile.getCarte().getLocalisation() == LocalisationDesCartes.defausse) {
                boxDefause.getChildren().add(cardViewPlayer.getGrpContenairCard());
            }else if(pile.getCarte().getLocalisation() == LocalisationDesCartes.deck) {
                cardViewPlayer.setImageViewBack();
                boxPioche.getChildren().add(cardViewPlayer.getGrpContenairCard());
            }
        }
    }

    /**
     * Idem pour les cartes du centres
     * @param pileArrayList Pile de carte action de la reserve
     * @param controllerJeu Le controller de jeu
     */
    public void updateCarteCenter(Joueur joueur, ArrayList<Pile> pileArrayList, ControllerJeu controllerJeu){
        boxCarteRandomLigne1.getChildren().clear();
        boxCarteRandomLigne2.getChildren().clear();
        int i = 0;
        for(Pile pile: pileArrayList){
            CardViewCentre cardViewPlayer = new CardViewCentre(joueur,pile);
            cardViewPlayer.getGrpContenairCard().setOnMouseClicked(controllerJeu);
            if(i < 5 ){
                boxCarteRandomLigne1.getChildren().add(cardViewPlayer.getGrpContenairCard()) ;
            } else {
                boxCarteRandomLigne2.getChildren().add(cardViewPlayer.getGrpContenairCard()) ;
            }
            i++;
        }
    }

    /**
     * Idem pour les cartes reserve gauche
     * @param pileArrayList Pile de carte action de la reserve
     * @param controllerJeu Le controller de jeu
     */
    public void updateCarteReserveLeft(Joueur joueur, ArrayList<Pile> pileArrayList, ControllerJeu controllerJeu){
        boxPvLeft.getChildren().clear();
        boxPvRight.getChildren().clear();
        int i = 0;
        for(Pile pile: pileArrayList){
            //TODO:1 Modifier la Class CardViewReserve pour qu'elle soit carré
            CardViewReserve cardViewReserve = new CardViewReserve(joueur, pile);
            cardViewReserve.getGrpContenairCard().setOnMouseClicked(controllerJeu);
            if(i < 3 ){
                boxPvRight.getChildren().add(cardViewReserve.getGrpContenairCard()) ;
            } else {
                boxPvLeft.getChildren().add(cardViewReserve.getGrpContenairCard()) ;
            }
            i++;
        }
    }

    //TODO: 2 Afficher les Info du joueur (Nom, Or, Pv)
    /**
     * Idem pour un conteneur affichant les infos du joueur (Nom, Pv Or)
     * @param joueur
     */
    public void updateJoueurInfo(Joueur joueur){

    }

    /**
     * Attache des events au clique d'element statique (element qui ne changeront jamais comme le button pour quitter la partie)
     * @param controllerJeu Le controlleur de jeu
     */
    public void setEvent(ControllerJeu controllerJeu){

    }

}
