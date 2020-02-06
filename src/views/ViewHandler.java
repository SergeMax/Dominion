package views;

import config.Config;
import controllers.ControllerJeu;
import controllers.ControllerMenuPrincipal;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class ViewHandler extends Application {
    private Scene scene;
    private Group root;
    private ViewMenuPrincipal viewMenuPrincipal;
    private ViewJeu viewJeu;
    private ControllerMenuPrincipal controllerMenuPrincipal;
    private ControllerJeu controllerJeu;
    private BorderPane rootGame;
    private URL css = getClass().getResource("../assets/css/styles.css");


    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        rootGame = new BorderPane();

        scene.getStylesheets().add(css.toExternalForm());
        scene = new Scene(root, 500, 500);


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
        viewMenuPrincipal = new ViewMenuPrincipal(root);
        viewMenuPrincipal.clearAndInitRoot();
        controllerMenuPrincipal = new ControllerMenuPrincipal(this);
    }

    public void afficherJeu() {


        viewJeu = new ViewJeu(rootGame);
        viewJeu.clearAndInitRoot();
        rootGame.setTop(viewJeu.getMenu());
        rootGame.setRight(viewJeu.getRightHBox());
        rootGame.setBottom(viewJeu.getFooter());
        rootGame.setLeft(viewJeu.getLeftHBox());
        rootGame.setCenter(viewJeu.getCenterPane());
        scene.setRoot(rootGame);
        controllerJeu = new ControllerJeu(this);

    }

    public ViewMenuPrincipal getViewMenuPrincipal() {
        return viewMenuPrincipal;
    }

    public ViewJeu getViewJeu() {
        return viewJeu;
    }
}
