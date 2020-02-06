package views.GraphicalElement;

import javafx.scene.image.ImageView;

public class CardViewPlayer {

    private ImageView imageViewCarte;
    private ImageView imageViewBack;

    public CardViewPlayer(String image){
        this.imageViewCarte = new ImageView(image);
        this.imageViewBack = new ImageView("../assets/backCard.png");
        imageViewCarte.setFitHeight(150);
        imageViewCarte.setFitWidth(100);
        imageViewBack.setFitHeight(150);
        imageViewBack.setFitWidth(100);
    }

    public ImageView getImageViewCarte() {
        return imageViewCarte;
    }

    public ImageView getImageViewBack() {
        return imageViewBack;
    }
}
