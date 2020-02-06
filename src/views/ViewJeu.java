package views;

import controllers.ControllerJeu;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import views.GraphicalElement.CardViewPlayer;

import javax.swing.*;

public class ViewJeu {
    private BorderPane root;
private CardViewPlayer cardViewPlayer;
    private ImageView imageCardViewPlayer;


    public ViewJeu(BorderPane root) {

        root.setBackground(new Background( new BackgroundImage(new Image("assets/background/backgroundJeux.jpg"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        this.root = root;

    }

    public ImageView initCard(String cheminCard){
        cardViewPlayer = new CardViewPlayer(cheminCard);
        imageCardViewPlayer = cardViewPlayer.getImageViewCarte();

        return imageCardViewPlayer;
    }

    public VBox getMenu()
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

    public HBox getRightHBox()
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

    public HBox getLeftHBox()
    {
        HBox hbox = new HBox();

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(1));

        Text text = new Text("");
        text.setFont(Font.font("", FontWeight.BOLD, 20));

        VBox vboxText = new VBox(10);

        VBox boxPvLeft = new VBox();
        boxPvLeft.setPadding(new Insets(1));
        boxPvLeft.setAlignment(Pos.TOP_RIGHT);


        boxPvLeft.setMaxWidth(100);
        boxPvLeft.setMinWidth(100);
        boxPvLeft.getStyleClass().add("vbox_style");

        VBox boxPvRight = new VBox();
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

    public HBox getFooter()
    {
        HBox hbox = new HBox();
       // hbox.setAlignment(Pos.CENTER_LEFT);
        VBox boxDeckJActif = new VBox();
        boxDeckJActif.setPadding(new Insets(1));
        boxDeckJActif.setAlignment(Pos.CENTER_LEFT);

        boxDeckJActif.setMinHeight(180);
        boxDeckJActif.setMinWidth(260);
        boxDeckJActif.getStyleClass().add("vbox_style");

        //hbox2

        HBox boxMainActif = new HBox();
        boxMainActif.setPadding(new Insets(5));
        boxMainActif.getStyleClass().add("vbox_style");
        boxMainActif.setAlignment(Pos.CENTER);
        boxMainActif.setPrefWidth(1500);


        HBox hbox2 = new HBox(20);
        hbox2.setPadding(new Insets(5));
        hbox2.setAlignment(Pos.CENTER);


        ImageView imageCarte = initCard("assets/cartes/braconier.png");
        ImageView imageCarte2 = initCard("assets/cartes/atelier.png");
        ImageView imageCarte3 = initCard("assets/cartes/cuivre.png");
        ImageView imageCarte4 = initCard("assets/cartes/argent.png");
        ImageView imageCarte5 = initCard("assets/cartes/domaine.png");


        hbox.getChildren().addAll(boxDeckJActif);
        hbox.getChildren().addAll(boxMainActif);
        boxMainActif.getChildren().addAll(imageCarte, imageCarte2, imageCarte3, imageCarte4, imageCarte5);
       // hbox.getChildren().addAll(new Text("")
         //       , new Text(""), new Text(""));









        hbox.setMinHeight(200);
        hbox.setMaxHeight(400);
        hbox.setPadding(new Insets(-15, 50, 0, 10));
        hbox.getStyleClass().add("vbox_style");

        return hbox;
    }

    public StackPane getCenterPane()
    {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_CENTER);

        Rectangle rec = new Rectangle();
        rec.setOpacity(0.1);
        rec.widthProperty().bind(stackPane.widthProperty().subtract(5));
        rec.heightProperty().bind(stackPane.heightProperty().subtract(5));

        VBox boxCarteCentraleEtJoue = new VBox();
        boxCarteCentraleEtJoue.setPadding(new Insets(1));
       // boxCarteCentraleEtJoue.setAlignment(Pos.TOP_CENTER);


        boxCarteCentraleEtJoue.setSpacing(20);
        boxCarteCentraleEtJoue.getStyleClass().add("vbox_style");

        HBox boxCarteJoue = new HBox();
        boxCarteJoue.setPadding(new Insets(1));
        boxCarteJoue.setAlignment(Pos.BOTTOM_CENTER);

        boxCarteJoue.setPrefHeight(300);
        boxCarteJoue.setMinHeight(100);
        boxCarteJoue.setTranslateY(20);
        boxCarteJoue.getStyleClass().add("vbox_style");


        HBox boxCarteRandomLigne1 = new HBox();
        boxCarteRandomLigne1.setPadding(new Insets(1));
        boxCarteRandomLigne1.setAlignment(Pos.TOP_CENTER);
        boxCarteRandomLigne1.getStyleClass().add("vbox_style");
        boxCarteRandomLigne1.setMinHeight(150);



        HBox boxCarteRandomLigne2 = new HBox();
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
    public void clearAndInitRoot(){
        root.getChildren().clear();
        root.getChildren().add(new Text("THIS IS THE GAME VIEW"));
    }

    public void setEvent(ControllerJeu controllerJeu){

    }




}
