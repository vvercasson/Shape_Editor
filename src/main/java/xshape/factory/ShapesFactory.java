package xshape.factory;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;

public class ShapesFactory implements ShapeFactory {
    public ShapesFactory() {
    }

    @Override
    public Rectangle createRectangle(double posX, double posY,
            double height, double width) {
        return new Rectangle(posX, posY, height, width);
    }

    @Override
    public Polygon createPolygon(ArrayList<Point2D> points) {
        return new Polygon(points.get(0), points.size(), points);
    }

}
