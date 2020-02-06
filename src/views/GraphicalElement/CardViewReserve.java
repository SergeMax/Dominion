package views.GraphicalElement;

import javafx.scene.image.ImageView;

public class CardViewReserve {

    private ImageView imageViewReserve;

    public CardViewReserve(String image){
        this.imageViewReserve = new ImageView(image);
        imageViewReserve.setFitHeight(100);
        imageViewReserve.setFitWidth(100);
    }

    public ImageView getImageViewReserve() {
        return imageViewReserve;
    }

}