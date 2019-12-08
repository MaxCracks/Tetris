package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Model of Piece
 */
public abstract class Piece {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    String name;
    Color color;
    int form;
    public static final int GRIDSPACE = 25; //This would be gotten from GameBoard
    public static final double WIDTH = 12 * GRIDSPACE; //This would be gotten from GameBoard

    /**
     * Creates a Piece object
     */
    public Piece() {
        a = new Rectangle(GRIDSPACE - 1, GRIDSPACE - 1);
        b = new Rectangle(GRIDSPACE - 1, GRIDSPACE - 1);
        c = new Rectangle(GRIDSPACE - 1, GRIDSPACE - 1);
        d = new Rectangle(GRIDSPACE - 1, GRIDSPACE - 1);
    }

    public abstract void rotate();

    /**
     * This function shifts a rectangle to the left by one grid space to the left
     * @param r - The rectangle being shifted
     */
    public void shiftLeft(Rectangle r){
        r.setX(r.getX() - GRIDSPACE);
    }

    /**
     * This function shifts a rectangle to the left by one grid space to the left
     * @param r - The rectangle being shifted
     */
    public void shiftRight(Rectangle r) {
        r.setX(r.getX() + GRIDSPACE);
    }

    public void shiftUp(Rectangle r) {
        r.setY(r.getY() - GRIDSPACE);
    }

    public void shiftDown(Rectangle r) {
        r.setY(r.getY() + GRIDSPACE);
    }

    public double getPos(String name, String coordinate) {
        switch (name){
            case "a":
                return coordinate.equals("x") ? a.getX() : a.getY();
            case "b":
                return coordinate.equals("x") ? b.getX() : b.getY();
            case "c":
                return coordinate.equals("x") ? c.getX() : c.getY();
            case "d":
                return coordinate.equals("x") ? d.getX() : d.getY();
        }
        return 0;
    }

    public void modPos(double x, double y){
        a.setX(a.getX() + x);
        a.setY(a.getY() + y);
        b.setX(b.getX() + x);
        b.setY(b.getY() + y);
        c.setX(c.getX() + x);
        c.setY(c.getY() + y);
        d.setX(d.getX() + x);
        d.setY(d.getY() + y);
    }
}
