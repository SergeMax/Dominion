package views;

import controllers.ControllerMenuPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private VBox vBoxForm;
    private VBox vBoxPseudo;
    private Button btnPlay, btnQuit, btnJouer, btnRetour;
    private ImageView titre;
    private Label joueur1, joueur2;
    private TextField textFjoueur1, textFjoueur2;




    public ViewMenuPrincipal(Group root) {
        this.root = root;

        //Vbox des boutons
        vBox = new VBox();
        vBox.setLayoutX(0);
        vBox.setLayoutY(0);
        vBox.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBox.setAlignment(Pos.CENTER);

        //Vbox images fond et titre
        vBox2 = new VBox();
        vBox2.setLayoutX(0);
        vBox2.setLayoutY(0);
        vBox2.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox2.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBox2.setAlignment(Pos.BOTTOM_CENTER);
        vBox2.setBackground(new Background( new BackgroundImage(new
                Image("assets/logo/background.jpg"),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        //Vbox de la page formulaire
        vBoxForm = new VBox();
        vBoxForm.getChildren().add(new Text("Cest le root du form"));
        vBoxForm.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxForm.setMinHeight(Screen.getPrimary().getBounds().getHeight());

        //Vbox du pseudo
        vBoxPseudo = new VBox();
        vBoxPseudo.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxPseudo.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxPseudo.setLayoutX(0);
        vBoxPseudo.setLayoutY(0);
        vBoxPseudo.setAlignment(Pos.CENTER);


        //initialisation
        btnPlay = initButton("PLAY",20);
        VBox.setMargin(btnPlay,new Insets(50,0,50,0));
        btnQuit = initButton("QUITTER",20);

        titre = new ImageView("assets/logo/logo_dominion.png");
        titre.getStyleClass().add("banniere");

        joueur1 = initLabel("Pseudo joueur 1");
        VBox.setMargin(joueur1, new Insets(10,0,10,0));
        textFjoueur1 = initTextField();
        VBox.setMargin(textFjoueur1, new Insets(0,0,0,0));

        joueur2 = initLabel("Pseudo joueur 2");
        VBox.setMargin(joueur2, new Insets(20,0,10,0));
        textFjoueur2 = initTextField();
        VBox.setMargin(textFjoueur2, new Insets(0,0,0,0));

        btnJouer = initButton("Jouer", 20);
        VBox.setMargin(btnJouer, new Insets(20,0,10,0));

        btnRetour = initButton("Retour", 20);

        vBox.getChildren().addAll(btnPlay,btnQuit);
        vBox2.getChildren().add(titre);
        vBoxPseudo.getChildren().addAll(joueur1, textFjoueur1,joueur2, textFjoueur2,btnJouer, btnRetour);

    }

    public void clearAndInitRootMenu(){
        root.getChildren().clear();
        root.getChildren().add(vBox2);
        root.getChildren().add(vBox);
    }
    public void clearAndInitRootFormulaire(){
        root.getChildren().remove(vBox);
        root.getChildren().add(vBoxForm);
        root.getChildren().add(vBoxPseudo);
    }

    public Button initButton(String texteBoutton, int size){
        Button b = new Button();
        b.setText(texteBoutton);
        b.setFont(Font.font(size));
        b.getStyleClass().add("btnMenu");
        return b;
    }
    private TextField initTextField( ){
        TextField f = new TextField();
        f.getStyleClass().add("textFieldMenu");
        return f;
    }
    private Label initLabel(String texteLabel){
        Label l = new Label();
        l.setTextFill(Color.WHITE);
        l.setText(texteLabel);
        l.getStyleClass().add("labelMenu");
        return l;
    }

    public void setEvent(ControllerMenuPrincipal controllerMenuPrincipal){
        btnPlay.setOnMouseClicked(controllerMenuPrincipal);
        btnQuit.setOnMouseClicked(controllerMenuPrincipal);
        btnJouer.setOnMouseClicked(controllerMenuPrincipal);
        btnRetour.setOnMouseClicked(controllerMenuPrincipal);
    }

    //setter
    public void setBtnPlay(Button btnPlay) { this.btnPlay = btnPlay; }
    public void setBtnQuit(Button btnQuit) { this.btnQuit = btnQuit; }

    //getter
    public Button getBtnPlay() { return btnPlay; }
    public Button getBtnQuit() { return btnQuit; }
    public Group getRoot(){ return root; }

    public Button getBtnJouer() { return btnJouer; }
    public Button getBtnRetour() { return btnRetour; }

    public TextField getTextFjoueur1() { return textFjoueur1; }
    public TextField getTextFjoueur2() { return textFjoueur2; }


}
