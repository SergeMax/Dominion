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

    public VBox getFooter()
    {
        VBox vbox = new VBox();
        VBox boxDeckJActif = new VBox();
        boxDeckJActif.setPadding(new Insets(1));
        boxDeckJActif.setAlignment(Pos.TOP_RIGHT);

        boxDeckJActif.setMinHeight(180);
        boxDeckJActif.setMaxWidth(260);
        boxDeckJActif.getStyleClass().add("vbox_style");

        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(5));
        hbox.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(new Text("")
                , new Text(""), new Text(""));
        vbox.getChildren().addAll(hbox);


        vbox.getChildren().addAll(boxDeckJActif);




        vbox.setMinHeight(200);
        vbox.setMaxHeight(400);
        vbox.setPadding(new Insets(-15, 50, 0, 10));
        vbox.getStyleClass().add("vbox_style");

        return vbox;
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
