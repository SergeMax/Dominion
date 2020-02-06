package views.GraphicalElement;

import javafx.scene.image.ImageView;

public class CardViewPlayer {

    private ImageView imageViewCarte;
    private ImageView imageViewBack;

    public CardViewPlayer(String image){
        this.imageViewCarte = new ImageView(image);
        this.imageViewBack = new ImageView("assets/cartes/backCard.png");
        imageViewCarte.setFitHeight(250);
        imageViewCarte.setFitWidth(180);
        imageViewBack.setFitHeight(250);
        imageViewBack.setFitWidth(200);
    }

    public ImageView getImageViewCarte() {
        return imageViewCarte;
    }

    public ImageView getImageViewBack() {
        return imageViewBack;
    }
}
