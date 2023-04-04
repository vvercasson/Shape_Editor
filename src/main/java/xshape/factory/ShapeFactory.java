package xshape.factory;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;

public interface ShapeFactory {
    public Rectangle createRectangle(double posX, double posY, double height, double width);

    public Polygon createPolygon(ArrayList<Point2D> points);
}
