
package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;




public class LPiece extends Piece {

    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color;
    private String name;
    public int form = 1;

    public LPiece(Rectangle a, Rectangle b, Rectangle c, Rectangle d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public LPiece (Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
    }


    //setting the color of the rectangles

    switch(name)
    {
        case "j":
            color = Color.BLUE;
            break;
        case "l":
            color = Color.BLACK;
            break;
        case "o":
            color = Color.GREEN;
            break;
        case "s":
            color = Color.ORANGE;
            break;
        case "t":
            color = Color.RED;
            break;
        case "z":
            color = Color.MAGENTA;
            break;
        case "i":
            color = Color.WHITE;
            break;

    }

    this.a.setFill(color);
    this.b.setFill(color);
    this.c.setFill(color);
    this.d.setFill(color);

    //getters

    public String getName()
    {
        return  name;
    }

    public void changeForm()
    {
        if(form !=4)
        {
            form++;
        }
        else
        {
            form = 1;
        }
    }
}