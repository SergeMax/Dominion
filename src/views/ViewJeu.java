package views;

import controllers.ControllerJeu;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javax.swing.*;

public class ViewJeu {
    private BorderPane root;


    public ViewJeu(BorderPane root) {

        this.root = root;

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
        vbox.setBackground(new Background(new BackgroundFill(
                Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        vbox.setMaxHeight(100);
        vbox.setMinHeight(90);

        vbox.setTranslateX(200);

        return vbox;
    }

    public HBox getRightHBox()
    {
        HBox hbox = new HBox();

        VBox vbox = new VBox(50);
        vbox.setPadding(new Insets(0, 20, 0, 20));
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(
            Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

        vbox.getChildren().addAll(new Text(""),
                new Text(""), new Text(""));
        hbox.getChildren().addAll(new Separator(Orientation.VERTICAL), vbox);

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
        boxPvLeft.setBackground(new Background(new BackgroundFill(
                Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

        boxPvLeft.setMaxWidth(100);
        boxPvLeft.setMinWidth(100);

        VBox boxPvRight = new VBox();
        boxPvRight.setPadding(new Insets(1));
        boxPvRight.setAlignment(Pos.TOP_RIGHT);
        boxPvRight.setBackground(new Background(new BackgroundFill(
                Color.DEEPPINK, CornerRadii.EMPTY, Insets.EMPTY)));

        boxPvRight.setMaxWidth(100);
        boxPvRight.setMinWidth(100);


        hbox.getChildren().addAll(vbox);
        hbox.getChildren().addAll(boxPvLeft, boxPvRight);

        hbox.setBackground(new Background(new BackgroundFill(
                Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        hbox.setMinWidth(200);

        hbox.setMaxHeight(800);
        hbox.setTranslateY(-100);

        return hbox;
    }

    public VBox getFooter()
    {
        VBox vbox = new VBox();
        VBox boxDeckJActif = new VBox();
        boxDeckJActif.setPadding(new Insets(1));
        boxDeckJActif.setAlignment(Pos.TOP_RIGHT);
        boxDeckJActif.setBackground(new Background(new BackgroundFill(
                Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        boxDeckJActif.setMinHeight(180);
        boxDeckJActif.setMaxWidth(260);

        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(5));
        hbox.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(new Text("")
                , new Text(""), new Text(""));
        vbox.getChildren().addAll(hbox);


        vbox.getChildren().addAll(boxDeckJActif);

        vbox.setBackground(new Background(new BackgroundFill(
                Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));


        vbox.setMinHeight(200);
        vbox.setMaxHeight(400);
        vbox.setPadding(new Insets(-15, 50, 0, 10));

        return vbox;
    }

    public StackPane getCenterPane()
    {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_CENTER);

        Rectangle rec = new Rectangle();
        rec.setFill(Color.DODGERBLUE);
        rec.widthProperty().bind(stackPane.widthProperty().subtract(5));
        rec.heightProperty().bind(stackPane.heightProperty().subtract(5));

        VBox boxCarteCentraleEtJoue = new VBox();
        boxCarteCentraleEtJoue.setPadding(new Insets(1));
       // boxCarteCentraleEtJoue.setAlignment(Pos.TOP_CENTER);
        boxCarteCentraleEtJoue.setBackground(new Background(new BackgroundFill(
                Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        boxCarteCentraleEtJoue.setSpacing(20);

        HBox boxCarteJoue = new HBox();
        boxCarteJoue.setPadding(new Insets(1));
        boxCarteJoue.setAlignment(Pos.BOTTOM_CENTER);
        boxCarteJoue.setBackground(new Background(new BackgroundFill(
                Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
        boxCarteJoue.setPrefHeight(300);
        boxCarteJoue.setMinHeight(100);
        boxCarteJoue.setTranslateY(20);


        HBox boxCarteRandomLigne1 = new HBox();
        boxCarteRandomLigne1.setPadding(new Insets(1));
        boxCarteRandomLigne1.setAlignment(Pos.TOP_CENTER);
        boxCarteRandomLigne1.setBackground(new Background(new BackgroundFill(
                Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        boxCarteRandomLigne1.setMinHeight(150);


        HBox boxCarteRandomLigne2 = new HBox();
        boxCarteRandomLigne2.setPadding(new Insets(1));
        boxCarteRandomLigne2.setAlignment(Pos.TOP_CENTER);
        boxCarteRandomLigne2.setBackground(new Background(new BackgroundFill(
                Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
        boxCarteRandomLigne2.setMinHeight(150);
        boxCarteRandomLigne2.setTranslateY(-20);

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
