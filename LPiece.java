package sample;

import javafx.scene.paint.Color;

public class LPiece extends Piece {

    public LPiece()
    {

     spuer();
     name = "l";
     color = Color.BLACK;
     form = 1;
        a.setX(WIDTH / 2 + GRIDSPACE);
        b.setX(WIDTH / 2 - GRIDSPACE);
        b.setY(GRIDSPACE);
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
            shiftRight(a);
            shiftDown(a);
            shiftRight(b);
            shiftDown(b);
            shiftDown(c);
            shiftLeft(d);
            shiftDown(d);
            shiftDown(d);
        }
        if (form == 1){
            shiftLeft(a);
            shiftDown(a);
            shiftRught(c);
            shiftRight(c);
            shiftRight(d);
            shiftRight(d);
            shiftUp(d);
            shiftUp(d);
        }
    }


}