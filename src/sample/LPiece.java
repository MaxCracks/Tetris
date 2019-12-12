package sample.Pieces;

import javafx.scene.paint.Color;
import sample.Pieces.Piece;

public class LPiece extends Piece {
    public LPiece() {
        name = "l";
        color = Color.INDIGO;
        form = 1;
        a.setX(WIDTH / 2 - GRIDSPACE);
        a.setY(GRIDSPACE);
        b.setX(WIDTH / 2);
        b.setY(GRIDSPACE);
        c.setX(WIDTH / 2 + GRIDSPACE);
        c.setY(GRIDSPACE);
        d.setX(WIDTH / 2 + GRIDSPACE);
    }
    @Override
    public void rotate() {
        form++;
        if (form > 4) form = 1;
    }
}
