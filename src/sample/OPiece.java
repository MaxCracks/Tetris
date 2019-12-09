package sample;

import javafx.scene.paint.Color;

public class OPiece  extends Piece{
    public OPiece(){
        name = "o";
        color = Color.RED;
        form = 1;
        a.setX(WIDTH / 2 - GRIDSPACE);
        b.setX(WIDTH / 2);
        c.setX(WIDTH / 2 - GRIDSPACE);
        c.setY(GRIDSPACE);
        d.setX(WIDTH / 2);
        d.setY(GRIDSPACE);
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);
    }
    @Override
    public void rotate() {}
}
