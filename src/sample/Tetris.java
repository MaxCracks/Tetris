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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Pieces.Piece;

import java.util.ArrayList;

/**
 * The Tetris Class
 */
public class Tetris extends Application {
    private GameBoard gameBoard = new GameBoard();
    private Piece piece;
    private Pane gridPane = new Pane();
    private Scene scene = new Scene(gridPane, gameBoard.WIDTH * gameBoard.GRIDSPACE + 150, gameBoard.HEIGHT * gameBoard.GRIDSPACE);
    private int score = 0;
    private Text scoreText = new Text("Score: ");
    private int count;
    private Timeline timeline;


    @Override
    public void start(Stage stage) throws Exception {
        scoreText.setX(gameBoard.WIDTH * gameBoard.GRIDSPACE + gameBoard.GRIDSPACE);
        scoreText.setY(gameBoard.GRIDSPACE);
        gridPane.getChildren().add(scoreText);
        addToUI();
        stage.setScene(scene);
        stage.show();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            moveDown(piece);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * This method adds the a Piece to the gridPane
     */
    private void addToUI() {
        count++;
        piece = gameBoard.makePiece();
        gridPane.getChildren().addAll(piece.getA(), piece.getB(), piece.getC(), piece.getD());
        moveOnKeyPress(piece);
        scoreText.setText("Score: " + score);
        score += 10;
        //Increase the rate at which pieces move down as the game progresses
        if(count > 50){
            timeline.setRate(5);
        }
        else if (count > 35){
            timeline.setRate(3);
        }
        else if(count > 10) {
            timeline.setRate(2);
        }
    }

    /**
     * This method adds an EventListener to a piece
     * @param p - The newly generated Piece that is currently in motion
     */
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

    /**
     *This method moves a piece down using the moveDown from Gameboard.
     * If a piece can not be moved, a new piece is generated and added to the board
     * @param p - The piece being moved
     */
    private void moveDown(Piece p){
        if(!gameBoard.moveDown(p)) {
            if(!gameBoard.updateBoard(p)){
                System.out.println("Game over! Score: " + score);
                System.exit(0);
            }
            checkRows();
            addToUI();
        }
    }

    /**
     * This piece checks all the rows of the of the 2D grid from Gameboard
     * If a row is completely true,
     */
    private void checkRows() {
        int clearedRows = 0;
        for (int j=0;j<gameBoard.HEIGHT;j++) {
            int colFull=0;	//resets counter every row iteration
            for (int i=0;i<gameBoard.WIDTH;i++) {
                if (gameBoard.GRID[j][i])	//occupied grid position
                    colFull++;
            }
            if (colFull==gameBoard.WIDTH) {
                clearedRows++;
                gameBoard.clearRow(j);	//clear the row and drop above
                clearRowsVisually(j);
            }
        }
        addScore(clearedRows);
    }

    /**
     * This function removes all the rectangle from the row that is full and moves all rectangles above the rows down
     * @param row - The row to be cleared
     */
    private void clearRowsVisually(int row){
        ArrayList<Node> nodes = new ArrayList<>();
        //Get the nodes on the row that is full
        for(Node child : gridPane.getChildren()) {
            if(child instanceof Rectangle){
                Rectangle rec = (Rectangle) child;
                if(rec.getY() / 25 == row) {
                    nodes.add(child);
                }
            }
        }
        //Remove the nodes from the pane
        for(Node node: nodes){
            gridPane.getChildren().remove(node);
        }
        //Move the nodes above the row that is full 1 step down
        for(Node child : gridPane.getChildren()) {
            if(child instanceof Rectangle){
                Rectangle rec = (Rectangle) child;
                if(rec.getY() / 25 < row) {
                    rec.setY(rec.getY() + gameBoard.GRIDSPACE);
                }
            }

        }
    }

    /**
     * This method adds a number to the players score based on the number of rows cleared
     * @param clearedRows - the number of rows cleared
     */
    private void addScore(int clearedRows) {
        if (clearedRows==1)
            score+=50;
        if (clearedRows==2)
            score+=100;
        if (clearedRows==3)
            score+=300;
        if (clearedRows==4)
            score+=1200;
    }
}
