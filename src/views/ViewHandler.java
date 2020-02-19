package views;

import config.Config;
import controllers.ControllerJeu;
import controllers.ControllerMenuPrincipal;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewHandler extends Application {
    public Stage primaryStage;
    private Scene scene;
    private Group root;
    private ViewMenuPrincipal viewMenuPrincipal;
    private ViewJeu viewJeu;
    private ControllerMenuPrincipal controllerMenuPrincipal;
    private ControllerJeu controllerJeu;
    private BorderPane rootGame;
    private ArrayList<String> listeNomJoueur = new ArrayList<>();


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        root = new Group();
        rootGame = new BorderPane();

        scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("assets/css/styles.css");

        /** ON EDITE LA SCENE */
        primaryStage.setTitle("Dominion");

        //primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreen(true);
        //primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();

        if (Config.vueMenuPrincipal) {
            afficherMenuPrincipale();
        } else {
            afficherJeu();
        }


    }

    public void afficherMenuPrincipale() {
        scene.setRoot(root);
        viewMenuPrincipal = new ViewMenuPrincipal(root);
        viewMenuPrincipal.clearAndInitRootMenu();
        controllerMenuPrincipal = new ControllerMenuPrincipal(this);
    }

    public void afficherJeu() {
        scene.setRoot(rootGame);
        viewJeu = new ViewJeu(rootGame);
        viewJeu.clearAndInitRoot();
        controllerJeu = new ControllerJeu(this);

    }

    public void quitterJeu(){
        primaryStage.close();
    }

    public ViewMenuPrincipal getViewMenuPrincipal() {
        return viewMenuPrincipal;
    }

    public ViewJeu getViewJeu() {
        return viewJeu;
    }

    public ArrayList<String> getListeNomJoueur() {
        return listeNomJoueur;
    }

    public void setListeNomJoueur(ArrayList<String> listeNomJoueur) {
        this.listeNomJoueur = listeNomJoueur;
    }
}
