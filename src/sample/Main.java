package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        //Pane pane = new Pane();
        Pane gridPane = new Pane();
        ZPiece oPiece = new ZPiece();
        oPiece.modPos(0, 50);
        oPiece.rotate();
        gridPane.getChildren().addAll(oPiece.a, oPiece.b, oPiece.c, oPiece.d);
        oPiece.rotate();
        oPiece.rotate();
        primaryStage.setScene(new Scene(gridPane, 300, 275));
        primaryStage.show();
        for(Node child : gridPane.getChildren()) {
            Rectangle rec = (Rectangle) child;
            System.out.println(child.toString());
            System.out.println(rec.getY());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
