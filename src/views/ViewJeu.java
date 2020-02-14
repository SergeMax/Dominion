package views;

import controllers.ControllerJeu;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.Joueur;
import models.Pile;
import models.cartes.LocalisationDesCartes;
import views.GraphicalElement.CardView;
import views.GraphicalElement.CardViewReserve;

import java.util.ArrayList;


public class ViewJeu {
    private BorderPane root;
    private HBox boxMainActif;
    private VBox vBoxMenu, boxDeckJActif,boxCarteCentraleEtJoue, boxPvLeft, boxPvRight;
    private HBox boxCarteRandomLigne1, boxCarteRandomLigne2,boxCarteJoue, boxDefause, boxPioche;
    private HBox hBoxFooter,hBoxRigth, hBoxLeft;
    private StackPane centerPane;

    public ViewJeu(BorderPane root) {
        this.root = root;
        /* INIT DES ELEMENTS */
        boxDeckJActif = new VBox();
        boxMainActif = new HBox(); // Zone carte Main
        boxCarteCentraleEtJoue = new VBox(); // Zone Carte Central


        vBoxMenu = setMenu();
        hBoxLeft = setLeftHBox();
        hBoxRigth = setRightHBox();
        centerPane = setCenterPane();
        hBoxFooter = setFooter();
    }

    public void clearAndInitRoot(){
        root.getChildren().clear();
        root.setBackground(new Background( new BackgroundImage(new Image("assets/background/backgroundJeux.jpg"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        root.setTop(vBoxMenu);
        root.setRight(hBoxRigth);
        root.setBottom(hBoxFooter);
        root.setLeft(hBoxLeft);
        root.setCenter(centerPane);
    }

    public VBox setMenu()
    {
        VBox vbox = new VBox();

        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(5));
        hbox.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(new Text("")
                , new Text(""), new Text(""));
        vbox.getChildren().addAll(new Separator(), hbox);

        vbox.setMaxHeight(100);
        vbox.setMinHeight(90);

        vbox.setTranslateX(200);
        vbox.getStyleClass().add("vbox_style");

        return vbox;
    }

    public HBox setRightHBox()
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

    public HBox setLeftHBox()
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

        boxPvRight = new VBox();
        boxPvRight.setPadding(new Insets(1));
        boxPvRight.setAlignment(Pos.TOP_RIGHT);
        boxPvRight.getStyleClass().add("vbox_style");

        boxPvRight.setMaxWidth(100);
        boxPvRight.setMinWidth(100);

        hbox.getChildren().addAll(vbox);
        hbox.getChildren().addAll(boxPvLeft, boxPvRight);

        hbox.setMinWidth(200);

        hbox.setMaxHeight(800);
        hbox.setTranslateY(-100);
        hbox.getStyleClass().add("vbox_style");

        return hbox;
    }

    public HBox setFooter()
    {
        HBox hbox = new HBox();
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

        HBox hBoxDefausePioche = new HBox(20);
        hBoxDefausePioche.setPadding(new Insets(5));
        hBoxDefausePioche.setAlignment(Pos.CENTER);
        boxDefause = new HBox();
        boxPioche = new HBox();

        hBoxDefausePioche.getChildren().addAll(boxDefause,boxPioche);
        boxDeckJActif.getChildren().add(hBoxDefausePioche);
        hbox.getChildren().addAll(boxDeckJActif);
        hbox.getChildren().addAll(boxMainActif);

        hbox.setMinHeight(200);
        hbox.setMaxHeight(400);
        hbox.setPadding(new Insets(-15, 50, 0, 10));
        hbox.getStyleClass().add("vbox_style");

        return hbox;
    }



    public StackPane setCenterPane()
    {
        StackPane stackPane = new StackPane();
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

        /* BOX CARTE ACTION LIGNE 2 */
        boxCarteRandomLigne2 = new HBox();
        boxCarteRandomLigne2.setPadding(new Insets(1));
        boxCarteRandomLigne2.setAlignment(Pos.TOP_CENTER);
        boxCarteRandomLigne2.setMinHeight(150);
        boxCarteRandomLigne2.setMinHeight(150);
        boxCarteRandomLigne2.setTranslateY(-20);
        boxCarteRandomLigne2.getStyleClass().add("vbox_style");

        boxCarteCentraleEtJoue.getChildren().addAll(boxCarteRandomLigne1, boxCarteRandomLigne2, boxCarteJoue );
        stackPane.getChildren().addAll(rec, boxCarteCentraleEtJoue);

        return stackPane;
    }

    public void updateCarteJoueur(ArrayList<Pile> piles, ControllerJeu controllerJeu){
        boxMainActif.getChildren().clear();
        boxCarteJoue.getChildren().clear();
        boxDefause.getChildren().clear();
        boxPioche.getChildren().clear();

        for(Pile pile: piles){
            CardView cardViewPlayer = new CardView(pile);
            cardViewPlayer.getGrpContenairCard().setOnMouseClicked(controllerJeu);
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

    public void updateCarteCenter(ArrayList<Pile> pileArrayList, ControllerJeu controllerJeu){
        boxCarteRandomLigne1.getChildren().clear();
        boxCarteRandomLigne2.getChildren().clear();
        int i = 0;
        for(Pile pile: pileArrayList){
            CardView cardViewPlayer = new CardView(pile);
            cardViewPlayer.getGrpContenairCard().setOnMouseClicked(controllerJeu);
            if(i < 5 ){
                boxCarteRandomLigne1.getChildren().add(cardViewPlayer.getGrpContenairCard()) ;
            } else {
                boxCarteRandomLigne2.getChildren().add(cardViewPlayer.getGrpContenairCard()) ;
            }
            i++;
        }
    }

    //TODO: Faire des views Carré
    public void updateCarteReserveLeft(ArrayList<Pile> pileArrayList, ControllerJeu controllerJeu){
        boxPvLeft.getChildren().clear();
        boxPvRight.getChildren().clear();
        int i = 0;
        for(Pile pile: pileArrayList){
            CardViewReserve cardViewReserve = new CardViewReserve(pile);
            cardViewReserve.getGrpContenairCard().setOnMouseClicked(controllerJeu);
            if(i < 3 ){
                boxPvRight.getChildren().add(cardViewReserve.getGrpContenairCard()) ;
            } else {
                boxPvLeft.getChildren().add(cardViewReserve.getGrpContenairCard()) ;
            }
            i++;
        }
    }

    public void setEvent(ControllerJeu controllerJeu){

    }

}
