package xshape.factory;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.utils.MyColor;

public interface ShapeFactory {
    public Rectangle createRectangle(double posX, double posY, double height, double width, MyColor c);

    public Rectangle createRoundedRectangle(double posX, double posY, double height, double width, MyColor c);

    public Polygon createPolygon(ArrayList<Point2D> points, MyColor c);

    public Polygon createDefaultPolygon(double posX, double posY, double height, double width, MyColor c);

}
