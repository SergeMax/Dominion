package animation.clouds;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.util.Duration;

public class Cloud {
    private ImageView imgCloud;
    private Timeline cloudPasse;
    private Group grpContainerImgCloud;
    private Group root;
    private double vitesseCloud;
    private boolean sensCloud;
    private double startCloud;

    public Cloud(Group root) {
        this.root = root;
        grpContainerImgCloud = new Group();
        imgCloud = new ImageView("assets/logo/nuage3.png");
        imgCloud.setOpacity(0.5);
        imgCloud.setPreserveRatio(true);

        vitesseCloud = (Math.random() * 50000) +30000;
        double sizeCloud = (Math.random() * 300) + 90;
        imgCloud.setFitWidth(sizeCloud);
        startCloud = (-1 * Math.random() * 500) - imgCloud.getFitWidth();
        grpContainerImgCloud.setLayoutX(startCloud);
        double hauteurCloud = Math.random() * 100;
        grpContainerImgCloud.setLayoutY(hauteurCloud);
        grpContainerImgCloud.getChildren().add(imgCloud);
        initpassageAnimation();
    }

    private void initpassageAnimation(){
        cloudPasse = new Timeline();
            cloudPasse.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(grpContainerImgCloud.layoutXProperty(),startCloud)),
                    new KeyFrame(new Duration(vitesseCloud), new KeyValue(grpContainerImgCloud.layoutXProperty(), Screen.getPrimary().getBounds().getWidth())));
        // Indice: peut etre qu'on pourrait se servir la variable root pour connaitre la taille d'ecran :) ATTENTION A PRENDRE EN COMPTE LA TAILLE imgBird pour que l'oiseau rentre et sort bien de root
        cloudPasse.setCycleCount(Animation.INDEFINITE);
    }

    public void startPassage(){
        root.getChildren().add(grpContainerImgCloud);
        cloudPasse.play();
    }

    public void stopPassage(){
        root.getChildren().add(grpContainerImgCloud);
        cloudPasse.stop();
    }
}