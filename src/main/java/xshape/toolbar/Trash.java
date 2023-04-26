package xshape.toolbar;

import java.awt.geom.Point2D;
import java.io.Serializable;

import xshape.shapes.Rectangle;
import xshape.shapes.Shape;

public class Trash implements Serializable {
    private Point2D.Double _pos;
    private int width = 40;
    private int height = 50;
    private Shape trashShape;

    public Trash(Point2D.Double pos){
        this._pos = pos;
        trashShape = new Rectangle(pos.getX(), pos.getY(), height, width, null);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Shape getShape(){
        return trashShape;
    } 


    public Point2D.Double get_pos() {
        return _pos;
    }
}
