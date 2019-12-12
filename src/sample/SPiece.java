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
            shiftLeft(a);
            shiftLeft(a);
            shiftDown(a);
            shiftDown(c);
            shiftRight(c);
            shiftLeft(d);
            shiftLeft(d);
            shiftUp(d);
            shiftUp(d);
        }
        if (form == 1){
            shiftRight(a);
            shiftRight(a);
            shiftDown(a);
            shiftUp(c);
            shiftLeft(c);
            shiftRight(d);
            shiftRight(d);
            shiftDown(d);
            shiftDown(d);
        }
    }

    }