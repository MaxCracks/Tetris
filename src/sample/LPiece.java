package sample.Pieces;

import javafx.scene.paint.Color;

public class LPiece extends Piece {

    public LPiece()
    {

        super();
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
        if (form > 4)
            form = 1;
        if (form == 2){
            shiftDown(a);
            shiftDown(a);
            shiftRight(b);
            shiftUp(b);
            shiftLeft(d);
            shiftDown(d);
        }
        if (form == 3){
            shiftLeft(a);
            shiftLeft(a);
            shiftRight(b);
            shiftDown(b);
            shiftLeft(d);
            shiftUp(d);
        }
        if(form == 4)
        {
            shiftUp(a);
            shiftUp(a);
            shiftDown(b);
            shiftLeft(b);
            shiftUp(d);
            shiftRight(d);


        }
        if(form == 1)
        {
            shiftRight(a);
            shiftRight(a);
            shiftLeft(b);
            shiftUp(b);
            shiftRight(d);
            shiftDown(d);
        }

    }


}