package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Tetris extends Application {
    private GameBoard gameBoard = new GameBoard();
    private Piece piece;
    private Pane gridPane = new Pane();
    private Scene scene = new Scene(gridPane, gameBoard.WIDTH * gameBoard.GRIDSPACE, gameBoard.HEIGHT * gameBoard.GRIDSPACE);

    @Override
    public void start(Stage stage) throws Exception {
        addToUI();
        stage.setScene(scene);
        stage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            moveDown(piece);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void addToUI() {
        piece = gameBoard.makePiece();
        gridPane.getChildren().addAll(piece.a, piece.b, piece.c, piece.d);
        moveOnKeyPress(piece);
    }

    private void moveOnKeyPress(Piece p){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case RIGHT:
                        gameBoard.moveRight(p);
                        break;
                    case LEFT:
                        gameBoard.moveLeft(p);
                        break;
                    case UP:
                        gameBoard.rotate(p);
                        break;
                    case DOWN:
                        gameBoard.moveDown(p);
                        break;
                }
            }
        });
    }

    private void moveDown(Piece p){
        if(!gameBoard.moveDown(p)) {
            if(!gameBoard.updateBoard(p)){
                System.out.println("Game over");
                System.exit(0);
            }
            addToUI();
        }
    }
}
