package sample;

import javafx.scene.paint.Color;

public class ZPiece extends Piece {
    public ZPiece(){
        super();
        name = "z";
        color = Color.BEIGE;
        form = 1;
        a.setX(WIDTH / 2 - GRIDSPACE);
        b.setX(WIDTH / 2);
        c.setX(WIDTH / 2);
        c.setY(GRIDSPACE);
        d.setX(WIDTH / 2 + GRIDSPACE);
        d.setY(GRIDSPACE);
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);
    }

    @Override
    public void rotate() {
        form++;
        if (form > 2) form = 1;
        if (form == 2){
            shiftRight(a);
            shiftUp(a);
            shiftLeft(c);
            shiftUp(c);
            shiftLeft(d);
            shiftLeft(d);
        }
        if (form == 2){
            shiftLeft(a);
            shiftDown(a);
            shiftDown(c);
            shiftRight(c);
            shiftRight(d);
            shiftRight(d);
        }
    }
}
