package sample.Pieces;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Model of Piece
 */
public abstract class Piece {
    protected Rectangle a;
    protected Rectangle b;
    protected Rectangle c;
    protected Rectangle d;
    protected String name;
    protected Color color;
    protected int form;
    protected static final int GRIDSPACE = 25;
    protected static final double WIDTH = 12 * GRIDSPACE;

    /**
     * Creates a Piece object
     */
    public Piece() {
        //Set the size of the rectangles to one less than GRIDSPACE to see the lines between the rectangles
        a = new Rectangle(GRIDSPACE - 1, GRIDSPACE - 1);
        b = new Rectangle(GRIDSPACE - 1, GRIDSPACE - 1);
        c = new Rectangle(GRIDSPACE - 1, GRIDSPACE - 1);
        d = new Rectangle(GRIDSPACE - 1, GRIDSPACE - 1);
    }

    /**
     * Gets a rectangle
     * @return the a Rectangle
     */
    public Rectangle getA() {
        return a;
    }
    /**
     * Gets a rectangle
     * @return the b Rectangle
     */
    public Rectangle getB() {
        return b;
    }

    /**
     * Gets a rectangle
     * @return the c Rectangle
     */
    public Rectangle getC() {
        return c;
    }

    /**
     * Gets a rectangle
     * @return the c Rectangle
     */
    public Rectangle getD() {
        return d;
    }

    /**
     * An abstract method to rotate a Piece object
     */
    public abstract void rotate();

    /**
     * This function shifts a rectangle to the left by one grid space to the left
     * @param r - The rectangle being shifted
     */
    protected void shiftLeft(Rectangle r){
        r.setX(r.getX() - GRIDSPACE);
    }

    /**
     * This function shifts a rectangle to the left by one grid space to the right
     * @param r - The rectangle being shifted
     */
    protected void shiftRight(Rectangle r) {
        r.setX(r.getX() + GRIDSPACE);
    }
    /**
     * This function shifts a rectangle to the left by one grid space up
     * @param r - The rectangle being shifted
     */
    protected void shiftUp(Rectangle r) {
        r.setY(r.getY() - GRIDSPACE);
    }

    /**
     * This function shifts a rectangle to the left by one grid space down
     * @param r - The rectangle being shifted
     */
    protected void shiftDown(Rectangle r) {
        r.setY(r.getY() + GRIDSPACE);
    }

    /**
     * Gets the x or y position of a rectangle
     * @param name - a String representing the name of the rectangle
     * @param coordinate - a String representing the x or y coordinate to be returned
     * @return - a double that represnts either the x or y coordinate
     */
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

    /**
     * Modifies the x and y coordinate of a Piece to move it down, left or right
     * @param x - a double that is added to the x coordinate of the a, b, c, and d Rectangles
     * @param y - a double that is added to the y coordinate of the a, b, c, and d Rectangles
     */
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
