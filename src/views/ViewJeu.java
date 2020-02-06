package views;

import controllers.ControllerJeu;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ViewJeu {
    private BorderPane root;


    public ViewJeu(BorderPane root) {

        this.root = root;



    }
    public MenuBar getMenu()
    {
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);

        return menuBar;
    }

    public HBox getRightHBox()
    {
        HBox hbox = new HBox();

        VBox vbox = new VBox(50);
        vbox.setPadding(new Insets(0, 20, 0, 20));
        vbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(new Text("Additional Info 1"),
                new Text("Additional Info 2"), new Text("Additional Info 3"));
        hbox.getChildren().addAll(new Separator(Orientation.VERTICAL), vbox);

        return hbox;
    }

    public HBox getLeftHBox()
    {
        HBox hbox = new HBox();

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Text text = new Text("Navigation");
        text.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));

        VBox vboxText = new VBox(10);
        for (int i = 1; i <= 10; i++)
        {
            vboxText.getChildren().add(new Text("Category " + i));
        }
        vboxText.setTranslateX(10);

        vbox.getChildren().addAll(text, vboxText);
        hbox.getChildren().addAll(vbox, new Separator(Orientation.VERTICAL));

        return hbox;
    }

    public VBox getFooter()
    {
        VBox vbox = new VBox();

        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(5));
        hbox.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(new Text("Footer Item 1")
                , new Text("Footer Item 2"), new Text("Footer Item 3"));
        vbox.getChildren().addAll(new Separator(), hbox);

        return vbox;
    }

    public StackPane getCenterPane()
    {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);

        Rectangle rec = new Rectangle();
        rec.setFill(Color.DODGERBLUE);
        rec.widthProperty().bind(stackPane.widthProperty().subtract(50));
        rec.heightProperty().bind(stackPane.heightProperty().subtract(50));

        stackPane.getChildren().addAll(rec);

        return stackPane;
    }
    public void clearAndInitRoot(){
        root.getChildren().clear();
        root.getChildren().add(new Text("THIS IS THE GAME VIEW"));
    }

    public void setEvent(ControllerJeu controllerJeu){

    }




}
