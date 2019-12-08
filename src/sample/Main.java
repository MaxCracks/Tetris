package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        //Pane pane = new Pane();
        Pane gridPane = new Pane();
        ZPiece zPiece = new ZPiece();
        zPiece.modPos(0, 50);
        zPiece.rotate();
        //gridPane.getChildren().addAll(zPiece.a, zPiece.b, zPiece.c, zPiece.d);
        zPiece.rotate();
        zPiece.rotate();
        OPiece oPiece = new OPiece();
        Piece p = new TPiece();
        gridPane.getChildren().addAll(p.a, p.b, p.c, p.d);
        p.modPos(0, 25);
        p.rotate();
        p.rotate();
        p.rotate();
        p.rotate();
        //gridPane.getChildren().addAll(oPiece.a, oPiece.b, oPiece.c, oPiece.d);
        primaryStage.setScene(new Scene(gridPane, 300, 275));
        primaryStage.show();
//
//        for(Node child : gridPane.getChildren()) {
//            Rectangle rec = (Rectangle) child;
//            if(rec.getY() / 25 == 3){
//                rec.setFill(Color.WHITE);
//            } else if (rec.getY() / 25 < 3){
//                rec.setY(rec.getY() + 25);
//            }
//            System.out.println(child.toString());
//            System.out.println(rec.getY());
//        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
