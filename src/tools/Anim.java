package tools;

import javafx.animation.*;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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

    public void animGlissCarteMainToTerrain(Group grpContainerCardStart, ImageView img, Label urlImg) {


        /*Bound in scene permet de recuperer la position dans la scene du node*/

       // Bounds boundsInSceneStart = grpContainerCardStart.localToScreen(grpContainerCardStart.getBoundsInLocal());
         Bounds boundsInSceneStart = grpContainerCardStart.localToScene(grpContainerCardStart.getBoundsInLocal());


        double XPositionOfTheContainerCardStart = boundsInSceneStart.getMinX();
        double YPositionOfTheContainerCardStart = boundsInSceneStart.getMinY();

      //  double XPositionOfTheContainerCardEnd = boundsInSceneStart.getMinX();
    //    double YPositionOfTheContainerCardEnd = boundsInSceneEnd.getMinY();



        ImageView imgAnim = new ImageView("assets/cartes/cuivre.png");
      //  System.out.println(imgAnim);
        imgAnim.setPreserveRatio(true);

      //  imgAnim.setX(XPositionOfTheContainerCardStart);
      //  imgAnim.setY(YPositionOfTheContainerCardStart);

        imgAnim.setFitWidth(140);

             // if (/*Pile du groContainerStart est vite alors */) {
       // grpContainerCardStart.setOpacity(0);
        // }
        // car il faut mettre a zero l'opacité du groupe sur lequel va apparaitre la carte cloné
        //Il faut un delay avant d'enlever la pile vide du root car sinon les carte restante vont se
        //superposer sur celle qui est entrain de se déplacer dans l'animation**/

     //   ViewHandler viewHandler = new ViewHandler();

     //   viewHandler.getViewJeu().getBoxCarteJoue().getBoundsInLocal()

        grpContainerCardStart.getChildren().addAll(imgAnim);


        //Création des KeyFrame puis de la Timeline

        final KeyFrame XmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(grpContainerCardStart.translateXProperty(), XPositionOfTheContainerCardStart));
        final KeyFrame XmovementEnd = new KeyFrame(Duration.seconds(0.4), new KeyValue(grpContainerCardStart.translateXProperty(), XPositionOfTheContainerCardStart -100, Interpolator.LINEAR));

        final KeyFrame widthStart = new KeyFrame(Duration.ZERO, new KeyValue(imgAnim.fitWidthProperty(), widthDebut));
        final KeyFrame widthEnd = new KeyFrame(Duration.seconds(0.4), new KeyValue(imgAnim.fitWidthProperty(), 85, Interpolator.LINEAR));

        final KeyFrame YmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(grpContainerCardStart.translateYProperty(), YPositionOfTheContainerCardStart));
        final KeyFrame YmovementEnd = new KeyFrame(Duration.seconds(0.4), new KeyValue(grpContainerCardStart.translateYProperty(), YPositionOfTheContainerCardStart -250, Interpolator.LINEAR));

        timelineGlissement = new Timeline(XmovementStart, YmovementStart, widthStart, XmovementEnd, YmovementEnd, widthEnd);
        timelineGlissement.setCycleCount(1);

        timelineGlissement.play();


        /* Création du delay faisant disparaitre l'image crée (si besoin)*/

        PauseTransition delayRemove = new PauseTransition(Duration.seconds(2));
        delayRemove.setOnFinished(event -> {
           // grpContainerCardStart.getChildren().remove(imgAnim);
            grpContainerCardStart.getChildren().clear();

        });
        delayRemove.play();


    }

    //Animation du zoomm sur la carte. Prend en paramètre l'image et Le groupe conteneur de l'image. Utilisé dans CardviewCentre

    public void animCarteCentraleUP(ImageView img, Group group) {

        final KeyFrame widthmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(img.scaleXProperty(), 1.7));
        final KeyFrame widthmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(img.scaleXProperty(), 2.5, Interpolator.LINEAR));


        final KeyFrame XmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(group.translateXProperty(), 40));
        final KeyFrame XmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(group.translateXProperty(), 110, Interpolator.LINEAR));

        final KeyFrame YmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(group.translateYProperty(), -30));
        final KeyFrame YmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(group.translateYProperty(), -110, Interpolator.LINEAR));


        final KeyFrame heightmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(img.scaleYProperty(), 1.5));
        final KeyFrame heightmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(img.scaleYProperty(), 2.5, Interpolator.LINEAR));


        timelineGlissement = new Timeline(widthmovementStart, heightmovementStart, XmovementStart, YmovementStart, XmovementEnd, YmovementEnd, heightmovementEnd, widthmovementEnd);
        timelineGlissement.setCycleCount(1);
        timelineGlissement.play();

    }

    public void animCarteCentraleDown(ImageView img, Group group) {

        final KeyFrame widthmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(img.scaleXProperty(), 2));
        final KeyFrame widthmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(img.scaleXProperty(), 1, Interpolator.EASE_IN));

        final KeyFrame XmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(group.translateXProperty(), 110));
        final KeyFrame XmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(group.translateXProperty(), 0, Interpolator.EASE_IN));

        final KeyFrame YmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(group.translateYProperty(), -70));
        final KeyFrame YmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(group.translateYProperty(), 0, Interpolator.EASE_IN));


        final KeyFrame heigthMovementStart = new KeyFrame(Duration.ZERO, new KeyValue(img.scaleYProperty(), 2));
        final KeyFrame heigthMovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(img.scaleYProperty(), 1, Interpolator.EASE_IN));


        timelineGlissement = new Timeline(widthmovementStart, heigthMovementStart, XmovementStart, YmovementStart, YmovementEnd, XmovementEnd, heigthMovementEnd, widthmovementEnd);
        timelineGlissement.setCycleCount(1);
        timelineGlissement.play();

    }

    public void animCarteReserveToPioche(Group grpContainerCardStart, Group root, ImageView img) {

            /*Bound in scene permet de recuperer la position dans la scene du node*/

            Bounds boundsInSceneStart = img.localToScreen(img.getBoundsInLocal());
         //   Bounds boundsInSceneEnd = grpContainerCardEnd.localToScene(grpContainerCardStart.getBoundsInLocal());

            double XPositionOfTheContainerCardStart = boundsInSceneStart.getMinX();
            double YPositionOfTheContainerCardStart = boundsInSceneStart.getMinY();

            //double XPositionOfTheContainerCardEnd = boundsInSceneStart.getMinX();
          //  double YPositionOfTheContainerCardEnd = boundsInSceneEnd.getMinY();

            widthLarge = 100;
            widthShort = 75;
            widthIntermed = 130;

            ImageView imgAnim = new ImageView("assets/cartes/backCard.png");
            imgAnim.setPreserveRatio(true);
            System.out.println("hrllp");

          //  imgAnim.setX(XPositionOfTheContainerCardStart);
            //imgAnim.setY(YPositionOfTheContainerCardStart);

            //  if (/* ////taille du conteneur de base (ou de l'image)///// */) {
            imgAnim.setFitWidth(widthShort);
            widthDebut = widthShort;
            widthIntermed = 100;
            //   } else {
            imgAnim.setFitWidth(widthLarge);
            widthDebut = widthLarge;
            widthIntermed = 100;

        Rectangle2D croppedPortion = new Rectangle2D(0, 0, 700, 600);


// target width and height:
        double scaledWidth = 100;
        double scaledHeight = 100;

        imgAnim.setViewport(croppedPortion);
        imgAnim.setFitWidth(scaledWidth);
        imgAnim.setFitHeight(scaledHeight);
        imgAnim.setSmooth(true);

        javafx.scene.shape.Rectangle clip = new Rectangle(
                img.getFitWidth(), img.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        imgAnim.setClip(clip);

        imgAnim.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 30, 0, 10, 10);" +
                " -fx-padding: 5;" +
                "-fx-background-color: sand;" +
                "-fx-background-radius: 3;"
        );




            //    }


            // if (/*Pile du groContainerStart est vite alors */) {
          //  grpContainerCardStart.setOpacity(0);
            // }
            // car il faut mettre a zero l'opacité du groupe sur lequel va apparaitre la carte cloné
            //Il faut un delay avant d'enlever la pile vide du root car sinon les carte restante vont se
            //superposer sur celle qui est entrain de se déplacer dans l'animation**/


       // ViewHandler vhandler = new ViewHandler();
     //   vhandler.getViewJeu().getRoot().getChildren().addAll(imgAnim);
            grpContainerCardStart.getChildren().addAll(imgAnim);

            //Création des KeyFrame puis de la Timeline

            final KeyFrame XmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(grpContainerCardStart.translateXProperty(), XPositionOfTheContainerCardStart));
            final KeyFrame XmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(grpContainerCardStart.translateXProperty(), 100, Interpolator.LINEAR));
         //   final KeyFrame XmovementEndReset = new KeyFrame(Duration.seconds(0.31), new KeyValue(grpContainerCardStart.translateXProperty(), XPositionOfTheContainerCardStart-100, Interpolator.LINEAR));

       //     final KeyFrame widthStart = new KeyFrame(Duration.ZERO, new KeyValue(imgAnim.fitWidthProperty(), widthDebut));
         //   final KeyFrame widthIntermediaire = new KeyFrame(Duration.seconds(1), new KeyValue(imgAnim.fitWidthProperty(), widthIntermed));
           // final KeyFrame widthEnd = new KeyFrame(Duration.seconds(2), new KeyValue(imgAnim.fitWidthProperty(), widthDebut, Interpolator.LINEAR));

            final KeyFrame YmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(grpContainerCardStart.translateYProperty(), YPositionOfTheContainerCardStart-50));
            final KeyFrame YmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(grpContainerCardStart.translateYProperty(), 650, Interpolator.LINEAR));
   //      final KeyFrame YmovementEndReset = new KeyFrame(Duration.seconds(0.31), new KeyValue(grpContainerCardStart.translateYProperty(), YPositionOfTheContainerCardStart, Interpolator.LINEAR));

            timelineGlissement = new Timeline(XmovementStart, YmovementStart,  XmovementEnd, YmovementEnd);
            timelineGlissement.setCycleCount(1);

            timelineGlissement.play();


            /* Création du delay faisant disparaitre l'image crée (si besoin)*/

            PauseTransition delayRemove = new PauseTransition(Duration.seconds(0.32));
            delayRemove.setOnFinished(event -> {
                grpContainerCardStart.getChildren().clear();
              //  grpContainerCardStart.getChildren().remove(grpContainerCardStart);
            });
            delayRemove.play();


        }

    public void animCarteCentraleToPioche(Group grpContainerCardStart, Group root, ImageView img) {


        /*Bound in scene permet de recuperer la position dans la scene du node*/

        Bounds boundsInSceneStart = img.localToParent(grpContainerCardStart.getBoundsInLocal());
        //   Bounds boundsInSceneEnd = grpContainerCardEnd.localToScene(grpContainerCardStart.getBoundsInLocal());


        double XPositionOfTheContainerCardStart = boundsInSceneStart.getMinX()-600;
        double YPositionOfTheContainerCardStart = boundsInSceneStart.getMinY()-100;

        //double XPositionOfTheContainerCardEnd = boundsInSceneStart.getMinX();
        //  double YPositionOfTheContainerCardEnd = boundsInSceneEnd.getMinY();

        widthLarge = 100;
        widthShort = 75;
        widthIntermed = 130;

        ImageView imgAnim = new ImageView("assets/cartes/backCard.png");
        imgAnim.setPreserveRatio(true);

        //  imgAnim.setX(XPositionOfTheContainerCardStart);
        //imgAnim.setY(YPositionOfTheContainerCardStart);

        //  if (/* ////taille du conteneur de base (ou de l'image)///// */) {
        imgAnim.setFitWidth(widthShort);
        widthDebut = widthShort;
        widthIntermed = 100;
        //   } else {
        imgAnim.setFitWidth(widthLarge);
        widthDebut = widthLarge;
        widthIntermed = 100;

        Rectangle2D croppedPortion = new Rectangle2D(0, 0, 700, 600);


// target width and height:
        double scaledWidth = 100;
        double scaledHeight = 100;

        imgAnim.setViewport(croppedPortion);
        imgAnim.setFitWidth(scaledWidth);
        imgAnim.setFitHeight(scaledHeight);
        imgAnim.setSmooth(true);

        javafx.scene.shape.Rectangle clip = new Rectangle(
                img.getFitWidth(), img.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        imgAnim.setClip(clip);

        imgAnim.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 30, 0, 10, 10);" +
                " -fx-padding: 5;" +
                "-fx-background-color: sand;" +
                "-fx-background-radius: 3;"
        );




        //    }


        // if (/*Pile du groContainerStart est vite alors */) {
        //  grpContainerCardStart.setOpacity(0);
        // }
        // car il faut mettre a zero l'opacité du groupe sur lequel va apparaitre la carte cloné
        //Il faut un delay avant d'enlever la pile vide du root car sinon les carte restante vont se
        //superposer sur celle qui est entrain de se déplacer dans l'animation**/


        // ViewHandler vhandler = new ViewHandler();
        //   vhandler.getViewJeu().getRoot().getChildren().addAll(imgAnim);
        grpContainerCardStart.getChildren().addAll(imgAnim);

        //Création des KeyFrame puis de la Timeline

        final KeyFrame XmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(grpContainerCardStart.translateXProperty(), 0));
        final KeyFrame XmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(grpContainerCardStart.translateXProperty(), -700, Interpolator.LINEAR));
        //   final KeyFrame XmovementEndReset = new KeyFrame(Duration.seconds(0.31), new KeyValue(grpContainerCardStart.translateXProperty(), XPositionOfTheContainerCardStart-100, Interpolator.LINEAR));

        //     final KeyFrame widthStart = new KeyFrame(Duration.ZERO, new KeyValue(imgAnim.fitWidthProperty(), widthDebut));
        //   final KeyFrame widthIntermediaire = new KeyFrame(Duration.seconds(1), new KeyValue(imgAnim.fitWidthProperty(), widthIntermed));
        // final KeyFrame widthEnd = new KeyFrame(Duration.seconds(2), new KeyValue(imgAnim.fitWidthProperty(), widthDebut, Interpolator.LINEAR));

        final KeyFrame YmovementStart = new KeyFrame(Duration.ZERO, new KeyValue(grpContainerCardStart.translateYProperty(), YPositionOfTheContainerCardStart+90));
        final KeyFrame YmovementEnd = new KeyFrame(Duration.seconds(0.3), new KeyValue(grpContainerCardStart.translateYProperty(), 650, Interpolator.LINEAR));
        //      final KeyFrame YmovementEndReset = new KeyFrame(Duration.seconds(0.31), new KeyValue(grpContainerCardStart.translateYProperty(), YPositionOfTheContainerCardStart, Interpolator.LINEAR));

        timelineGlissement = new Timeline(XmovementStart, YmovementStart,  XmovementEnd, YmovementEnd);
        timelineGlissement.setCycleCount(1);

        timelineGlissement.play();


        /* Création du delay faisant disparaitre l'image crée (si besoin)*/

        PauseTransition delayRemove = new PauseTransition(Duration.seconds(0.32));
        delayRemove.setOnFinished(event -> {
            grpContainerCardStart.getChildren().clear();
            //  grpContainerCardStart.getChildren().remove(grpContainerCardStart);
        });
        delayRemove.play();


    }


}
