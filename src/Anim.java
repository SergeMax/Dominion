import javafx.animation.*;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import models.Pile;
import views.GraphicalElement.CardViewPlayer;

import java.awt.*;

public class Anim {


    private static int widthLarge;
    private static int widthShort;
    private static Timeline timelineGlissement;
    private static int widthDebut;
    private static int vitesseGlissMovement;
    private static int widthIntermed;


    public Anim() {

    }

    /*
     * Animation du glissement. Start = position de départ End = positon d'arrivée
     * Plusieurs element vont changer lors de l'animation ; X position Y positon et width de l'image
     */

    public void animGlissCardToTheTarget(Group grpContainerCardStart, Group grpContainerCardEnd, Group root) {


        /*Bound in scene permet de recuperer la position dans la scene du node*/

        Bounds boundsInSceneStart = grpContainerCardStart.localToScene(grpContainerCardStart.getBoundsInLocal());
        Bounds boundsInSceneEnd = grpContainerCardEnd.localToScene(grpContainerCardStart.getBoundsInLocal());


        double XPositionOfTheContainerCardStart = boundsInSceneStart.getMinX();
        double YPositionOfTheContainerCardStart = boundsInSceneStart.getMinY();

        double XPositionOfTheContainerCardEnd = boundsInSceneStart.getMinX();
        double YPositionOfTheContainerCardEnd = boundsInSceneEnd.getMinY();

        widthLarge = 100;
        widthShort = 75;
        widthIntermed = 130;

        ImageView imgAnim = new ImageView(/*URL De l'image cliqué*/);
        imgAnim.setPreserveRatio(true);

        imgAnim.setX(XPositionOfTheContainerCardStart);
        imgAnim.setY(YPositionOfTheContainerCardStart);

      //  if (/* ////taille du conteneur de base (ou de l'image)///// */) {
            imgAnim.setFitWidth(widthShort);
            widthDebut = widthShort;
            widthIntermed = 100;
     //   } else {
            imgAnim.setFitWidth(widthLarge);
            widthDebut = widthLarge;
            widthIntermed = 130;
    //    }


       // if (/*Pile du groContainerStart est vite alors */) {
            grpContainerCardStart.setOpacity(0);
       // }
        // car il faut mettre a zero l'opacité du groupe sur lequel va apparaitre la carte cloné
        //Il faut un delay avant d'enlever la pile vide du root car sinon les carte restante vont se
        //superposer sur celle qui est entrain de se déplacer dans l'animation**/


        root.getChildren().add(imgAnim);


        //Création des KeyFrame puis de la Timeline

        final KeyFrame XmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(imgAnim.xProperty(), XPositionOfTheContainerCardStart));
        final KeyFrame XmovementEnd = new KeyFrame(Duration.seconds(2), new KeyValue(imgAnim.xProperty(), XPositionOfTheContainerCardEnd, Interpolator.LINEAR));

        final KeyFrame widthStart = new KeyFrame(Duration.ZERO, new KeyValue(imgAnim.fitWidthProperty(), widthDebut));
        final KeyFrame widthIntermediaire = new KeyFrame(Duration.seconds(1), new KeyValue(imgAnim.fitWidthProperty(), widthIntermed));
        final KeyFrame widthEnd = new KeyFrame(Duration.seconds(2), new KeyValue(imgAnim.fitWidthProperty(), widthDebut, Interpolator.LINEAR));

        final KeyFrame YmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(imgAnim.yProperty(), YPositionOfTheContainerCardStart));
        final KeyFrame YmovementEnd = new KeyFrame(Duration.seconds(2), new KeyValue(imgAnim.yProperty(), YPositionOfTheContainerCardEnd, Interpolator.LINEAR));

        timelineGlissement = new Timeline(XmovementStart, YmovementStart, widthStart, widthIntermediaire, XmovementEnd, YmovementEnd, widthEnd);
        timelineGlissement.setCycleCount(1);

        timelineGlissement.play();


        /* Création du delay faisant disparaitre l'image crée (si besoin)*/

        PauseTransition delayRemove = new PauseTransition(Duration.seconds(2));
        delayRemove.setOnFinished(event -> {
            root.getChildren().remove(imgAnim);
            root.getChildren().remove(imgAnim);

        });
        delayRemove.play();


    }


}
