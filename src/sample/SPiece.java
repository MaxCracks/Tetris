package sample;

import javafx.scene.paint.Color;

public class SPiece extends Piece {
    public SPiece()
    {
        super();
        name = "s";
        color = Color.ORANGE;
        form = 1;
        a.setX(WIDTH / 2 + GRIDSPACE);
        b.setX(WIDTH / 2);
        c.setX(WIDTH / 2);
        c.setY(GRIDSPACE);
        d.setX(WIDTH / 2 - GRIDSPACE);
        d.setY(GRIDSPACE);
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);

    }
    @Override
    public void rotate()
    {
        form++;
        if (form > 2) form = 1;
        if (form == 2){
            shiftDown(a);
            shiftDown(a);
            shiftRight(b);
            shiftDown(b);
            shiftUp(d);
            shiftRight(d);
        }
        if (form == 1){
            shiftUp(a);
            shiftUp(a);
            shiftLeft(b);
            shiftUp(b);
            shiftDown(d);
            shiftLeft(d);
        }
    }

}