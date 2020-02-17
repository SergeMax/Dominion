package animations.birds;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.chart.Axis;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Screen;
import javafx.util.Duration;


public class Oiseau {
    private ImageView imgBirds;
    private Timeline flyTimeline; // Contenant l'animation de l'oiseau
    private Group grpContainerImgBirds; //
    private Group root; // La racine pour que ton oiseaux sache sur qu'elle paneau il évolue
    private double vitesseRandom ;
    private boolean sensOiseau;
    /**
     * Constructeur oiseau
     * @param root la racine de notre vue
     */
    public Oiseau(Group root){
        this.root = root;
        grpContainerImgBirds = new Group();
        imgBirds = new ImageView("assets/logo/oiseauvole.gif"); //1 TODO: indiquer le chemin de l'image
        imgBirds.setPreserveRatio(true);
        if(Math.random() < 0.5){
            sensOiseau = true;
        }else{
            sensOiseau = false;
            imgBirds.setRotationAxis(new Point3D(0,1,0));
            imgBirds.setRotate(-180);


        }
        vitesseRandom = (Math.random() * 10000 ) + 5000;
        double startRandom = -1 * Math.random() * 250;
        double sizeRandom = (Math.random() *  60 ) + 10 ;
        imgBirds.setFitWidth(sizeRandom); //2 TODO: donne une taille a l'oiseau :)
        grpContainerImgBirds.setLayoutX(startRandom);
        double hauteurRandom = Math.random() *  250  ;
        grpContainerImgBirds.setLayoutY(hauteurRandom);
        grpContainerImgBirds.getChildren().add(imgBirds);
        initflyAnimation();

    }

    //3 TODO: Direction le ControllerMenuPrincipal --->

    //4 TODO: Jete d'abord un coup d'oeil a la doc de la Class Timeline : https://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html
    // FORCE TOI A LIRE LA DOC EN ANGLAIS :P

    //5 TODO: Les grandes lignes de l'animation est bonne mais il faudra que tu modifie cette methode :P
    // Piste: il faudra toucher le KeyValue (passer des info dans le endValue pour connaitre son point de depart et d'arriver)
    // et Duration pour gerer au mieux l'animation

    private void initflyAnimation(){
        flyTimeline = new Timeline();
        if (sensOiseau){
            flyTimeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(grpContainerImgBirds.layoutXProperty(),-200)),
                    new KeyFrame(new Duration(vitesseRandom), new KeyValue(grpContainerImgBirds.layoutXProperty(), Screen.getPrimary().getBounds().getWidth())));
        }else{
            flyTimeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(grpContainerImgBirds.layoutXProperty(),Screen.getPrimary().getBounds().getWidth())),
                    new KeyFrame(new Duration(vitesseRandom), new KeyValue(grpContainerImgBirds.layoutXProperty(),-200 )));
        }
       // Indice: peut etre qu'on pourrait se servir la variable root pour connaitre la taille d'ecran :) ATTENTION A PRENDRE EN COMPTE LA TAILLE imgBird pour que l'oiseau rentre et sort bien de root
        flyTimeline.setCycleCount(Animation.INDEFINITE);
    }
    //5 TODO NIVEAU EXTREME : essaye de rajouter des KeyFrame pour que l'oiseau oscille de haut en bas (pour rajouter du realisme :P)



    //6 TODO NIVEAU ENCORE PLUS EXTREME: Fait en sorte qu'un nombre aléatoire generer pour l'axe des Y

    /**
     * Attache le conteneur de l'oiseau au root
     * Et commencer l'animation du vole
     */
    public void startFlying(){
        root.getChildren().add(grpContainerImgBirds);
        flyTimeline.play();
    }

    /**
     * Detache le conteneur de l'oiseau du root
     * Et stop l'animation du vole
     */
    public void stopFlying(){
        root.getChildren().remove(grpContainerImgBirds);
        flyTimeline.stop();
    }
}
