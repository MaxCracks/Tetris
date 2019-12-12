package sample;

import javafx.scene.paint.Color;
import sample.Piece;

/**
 * Model of IPiece
 */
public class IPiece extends Piece {

    /**
     * This constructor creates a IPiece object
     * The a, b, c and d rectangles are positioned to form a i shape
     */
    public IPiece(){
        name = "o";
        color = Color.PINK;
        form = 1;
        a.setX(WIDTH / 2 - GRIDSPACE);
        b.setX(WIDTH / 2);
        c.setX(WIDTH / 2 + GRIDSPACE);
        d.setX(WIDTH / 2 + GRIDSPACE + GRIDSPACE);
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);
    }
    /**
     * This method overrides the abstract rotate method in Piece
     */
    @Override
    public void rotate() {
        form++;
        if (form%2==0)
        	form = 2;
        else
        	form= 1;
        if (form == 1){
            shiftDown(a);
            shiftLeft(a);
            shiftRight(c);
            shiftUp(c);
            shiftRight(d);
            shiftRight(d);
            shiftUp(d);
            shiftUp(d);
        }
        if(form == 2){
            shiftUp(a);
            shiftRight(a);
            shiftLeft(c);
            shiftDown(c);
            shiftLeft(d);
            shiftLeft(d);
            shiftDown(d);
            shiftDown(d);
        }
    }
}