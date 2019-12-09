package sample;

import javafx.scene.paint.Color;

public class TPiece extends Piece {
    public TPiece(){
        name = "t";
        color = Color.GREEN;
        form = 1;
        a.setX(WIDTH / 2);
        b.setX(WIDTH / 2 - GRIDSPACE);
        b.setY(GRIDSPACE);
        c.setX(WIDTH / 2);
        c.setY(GRIDSPACE);
        d.setX(WIDTH / 2 + GRIDSPACE);
        d.setY(GRIDSPACE);
        a.setFill(color);
        b.setFill(Color.BLUE);
        c.setFill(Color.RED);
        d.setFill(Color.BLACK);
    }
    @Override
    public void rotate() {
        form++;
        if (form > 4) form = 1;
        if (form == 2){
            shiftRight(a);
            shiftDown(a);
            shiftUp(b);
            shiftRight(b);
            shiftDown(d);
            shiftLeft(d);
        } else if (form == 3){
            shiftLeft(a);
            shiftDown(a);
            shiftDown(b);
            shiftRight(b);
            shiftUp(d);
            shiftLeft(d);
        } else if (form == 4){
            shiftLeft(a);
            shiftUp(a);
            shiftDown(b);
            shiftLeft(b);
            shiftUp(d);
            shiftRight(d);
        } else if (form == 1){
            shiftRight(a);
            shiftUp(a);
            shiftUp(b);
            shiftLeft(b);
            shiftDown(d);
            shiftRight(d);
        }
    }
}
