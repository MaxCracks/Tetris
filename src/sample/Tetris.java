package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


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
            checkRows();
            addToUI();
        }
    }

    private void checkRows() {
        //int clearedRows = 0;
        for (int j=0;j<gameBoard.HEIGHT;j++) {
            int colFull=0;	//resets counter every row iteration
            for (int i=0;i<gameBoard.WIDTH;i++) {
                if (gameBoard.GRID[j][i])	//occupied grid position
                    colFull++;
            }
            if (colFull==gameBoard.WIDTH) {
                gameBoard.clearRow(j);	//clear the row and drop above
                clearRowsVisually(j);
                System.out.println(j);
            }
        }
        //return clearedRows;
    }

    private void clearRowsVisually(int row){
        ArrayList<Node> nodes = new ArrayList<>();
        //Get the nodes on the row that is full
        for(Node child : gridPane.getChildren()) {
            Rectangle rec = (Rectangle) child;
            if(rec.getY() / 25 == row) {
                nodes.add(child);
            }
        }
        //Remove the nodes from the pane
        for(Node node: nodes){
            gridPane.getChildren().remove(node);
        }
        //Move the nodes above the row that is full 1 step down
        for(Node child : gridPane.getChildren()) {
            Rectangle rec = (Rectangle) child;
            if(rec.getY() / 25 < row) {
                rec.setY(rec.getY() + gameBoard.GRIDSPACE);
            }
        }
    }
}
