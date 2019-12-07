package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Piece {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    String name;
    Color color;
    int form;
    public static final int GRIDSPACE = 25;

    public Piece() {}

    public abstract void rotate();

    public void turnLeft(Rectangle r){
        r.setX(r.getX() - GRIDSPACE);
    }

    public void turnRight(Rectangle r) {
        r.setX(r.getX() + GRIDSPACE);
    }

    public void turnUp(Rectangle r) {
        r.setY(r.getY() + GRIDSPACE);
    }

    public void turnDown(Rectangle r) {
        r.setY(r.getY() - GRIDSPACE);
    }

    public double getPos(String name, String coord) {
        switch (name){
            case "a":
                return coord.equals("x") ? a.getX() : a.getY();
            case "b":
                return coord.equals("x") ? b.getX() : b.getY();
            case "c":
                return coord.equals("x") ? c.getX() : c.getY();
            case "d":
                return coord.equals("x") ? d.getX() : d.getY();
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
