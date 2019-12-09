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
    GameBoard gameBoard = new GameBoard();
    Piece piece;
    Pane gridPane = new Pane();
    int score;

    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	score=0;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        ZPiece zPiece = new ZPiece();
        //zPiece.modPos(0, 50);
        //zPiece.rotate();
        //gridPane.getChildren().addAll(zPiece.a, zPiece.b, zPiece.c, zPiece.d);
       // zPiece.rotate();
       // zPiece.rotate();
       // OPiece oPiece = new OPiece();
        Piece p = gameBoard.makePiece();
        gridPane.getChildren().addAll(p.a, p.b, p.c, p.d);
        gameBoard.updatePiece(p);
        gameBoard.moveDown(p);
        gameBoard.moveRight(p);
        gameBoard.moveRight(p);
        gameBoard.moveRight(p);
        gameBoard.moveRight(p);
        gameBoard.moveRight(p);
        
       
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
    

	 
	public int checkRows() {
		int clearedRows = 0;
		for (int j=0;j<gameBoard.HEIGHT;j++) {
			int colFull=0;	//resets counter every row iteration
			for (int i=0;i<gameBoard.WIDTH;i++) {
				if (gameBoard.GRID[j][i]==true)	//occupied grid position
					colFull++;
			}
			if (colFull==gameBoard.WIDTH) {
				gameBoard.clearRow(j);	//clear the row and drop above
				j--;	//since rows above dropped one
				clearedRows++;	//number of cleared rows in one turn increment
			}
		}
		return clearedRows;
		
	}
	
	public void addScore(int clearedRows) {
		if (clearedRows==1)
			score+=40;
		if (clearedRows==2)
			score+=100;
		if (clearedRows==3)
			score+=300;
		if (clearedRows==4)
			score+=1200;
	/*	else if (clearedRows!=0)
		{
			//throw exception here should not be possible
		}
		*/
	}
	
}
