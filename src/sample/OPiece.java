package sample.Pieces;

import javafx.scene.paint.Color;
import sample.Pieces.Piece;

/**
 * Model of OPiece
 */
public class OPiece  extends Piece {
    /**
     * This constructor creates a JPiece object
     * The a, b, c and d rectangles are positioned to form a j shape
     */
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
    /**
     * This method overrides the abstract rotate method in Piece
     * It is empty because the OPiece does not rotate
     */
    @Override
    public void rotate() {}
}
