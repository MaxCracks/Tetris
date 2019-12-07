package sample;

import javafx.scene.paint.Color;

public class OPiece  extends Piece{
    public OPiece(){
        name = "o";
        color = Color.RED;
        form = 1;
        a.setX(WIDTH / 2);
        b.setX(WIDTH / 2 + GRIDSPACE);
        c.setX(WIDTH / 2);
        c.setY(GRIDSPACE);
        d.setX(WIDTH / 2 + GRIDSPACE);
        d.setY(GRIDSPACE);
    }
    @Override
    public void rotate() {}
}
