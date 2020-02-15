package animations.birds;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Oiseau {
    private ImageView imgBirds;
    private Timeline flyTimeline; // Contenant l'animation de l'oiseau
    private Group grpContainerImgBirds; //
    private Group root; // La racine pour que ton oiseaux sache sur qu'elle paneau il évolue

    /**
     * Constructeur oiseau
     * @param root la racine de notre vue
     */
    public Oiseau(Group root){
        this.root = root;
        grpContainerImgBirds = new Group();
        imgBirds = new ImageView("assets/cartes/argent.png"); //1 TODO: indiquer le chemin de l'image
        imgBirds.setPreserveRatio(true);
        imgBirds.setFitWidth(100); //2 TODO: donne une taille a l'oiseau :)
        grpContainerImgBirds.getChildren().add(imgBirds);
        initflyAnimation();
    }

    //3 TODO: Direction le ControllerMenuPrincipal --->

    //4 TODO: Jete d'abord un coup d'oeil a la doc de la Class Timeline : https://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html
    // FORCE TOI A LIRE LA DOC EN ANGLAIS :P

    //5 TODO: Les grandes lignes de l'animation est bonne mais il faudra que tu modifie cette methode :P
    // Piste: il faudra toucher le KeyValue (passer des info dans le endValue pour connaitre son point de depart et d'arriver)
    // et Duration pour gerer au mieux l'animation

    public void initflyAnimation(){
        flyTimeline = new Timeline();
        flyTimeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(grpContainerImgBirds.layoutXProperty(),0)),
                new KeyFrame(new Duration(500), new KeyValue(grpContainerImgBirds.layoutXProperty(),1000)));
        flyTimeline.setCycleCount(99);
    }
    //5 TODO NIVEAU EXTREME : essaye de rajouter des KeyFrame pour que l'oiseau oscille de haut en bas (pour rajouter du realisme :P)

    //6 TODO NIVEAU ENCORE PLUS EXTREME: Fait en sorte qu'un nombre aléatoire generer pour l'axe des X

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
