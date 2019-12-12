import javafx.scene.paint.Color;

public class IPiece extends Piece {


    public IPiece()
    {
        super();
        color = Color.BEIGE;
        name = "i";
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

    @Override
    public void rotate() {
        form++;
        if (form > 2) form = 1;
        if (form == 2){
            shiftRight(a);
            shiftUp(a);
            shiftDown(c);
            shiftLeft(c);
            shiftDown(d);
            shiftDown(d);
            shiftLeft(d);
            shiftLeft(d);
        }
        if (form == 1){
            shiftLeft(a);
            shiftDown(a);
            shiftDown(c);
            shiftRight(c);
            shiftRight(d);
            shiftRight(d);
            shiftUp(d);
            shiftUp(d);
        }
    }
}