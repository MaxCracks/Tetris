package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;




public class ZPiece extends Piece {


    Color color;
    private String name;
    public int form = 1;

    public IPiece(Rectangle a, Rectangle b, Rectangle c, Rectangle d)
    {
       super(a,b,c,d);
    }

    public IPiece (Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name)
    {
        super(a,b,c,d,name);
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