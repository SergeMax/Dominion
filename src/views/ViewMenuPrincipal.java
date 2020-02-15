package views;

import controllers.ControllerMenuPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewMenuPrincipal {
    private Group root;
    private VBox vBox, vBox2;
    private Button btnPlay, btnQuit;
    private ImageView titre;




    public ViewMenuPrincipal(Group root) {
        this.root = root;
        vBox = new VBox();
        vBox2 = new VBox();
        vBox.setLayoutX(0);
        vBox.setLayoutY(0);
        vBox2.setLayoutX(0);
        vBox2.setLayoutY(0);
        vBox.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBox2.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox2.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBox.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setBackground(new Background( new BackgroundImage(new
                Image("assets/logo/background.jpg"),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));



        btnPlay = initButton("PLAY",20);
        VBox.setMargin(btnPlay,new Insets(50,0,50,0));
        btnQuit = initButton("QUITTER",20);

        titre = new ImageView("assets/logo/logo_dominion.png");
        //titre.setFitWidth(380);
        //titre.setFitHeight(200);


        titre.getStyleClass().add("banniere");

        vBox.getChildren().addAll(btnPlay,btnQuit);
        vBox2.getChildren().add(titre);
    }

    public void clearAndInitRoot(){
        root.getChildren().clear();
        root.getChildren().add(vBox);
        root.getChildren().add(vBox2);
    }
    public ImageView initImageView(int width, int heignt){
        ImageView im = new ImageView();
        im.setFitWidth(width);
        im.setFitHeight(heignt);
        return im;
    }

    public Button initButton(String texteBoutton, int size){
        Button b = new Button();
        b.setText(texteBoutton);
        b.setFont(Font.font(size));
        b.getStyleClass().add("btnMenu");

        return b;

    }


    public void setEvent(ControllerMenuPrincipal controllerMenuPrincipal){
        btnPlay.setOnMouseClicked(controllerMenuPrincipal);
        btnQuit.setOnMouseClicked(controllerMenuPrincipal);
    }

    //setter
    public void setBtnPlay(Button btnPlay) { this.btnPlay = btnPlay; }
    public void setBtnQuit(Button btnQuit) { this.btnQuit = btnQuit; }


    //getter
    public Button getBtnPlay() { return btnPlay; }
    public Button getBtnQuit() { return btnQuit; }
    public Group getRoot(){
        return root;
    }
}
