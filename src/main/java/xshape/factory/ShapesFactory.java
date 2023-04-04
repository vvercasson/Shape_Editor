package xshape.factory;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.utils.MyColor;

public class ShapesFactory implements ShapeFactory {
    public ShapesFactory() {
    }

    @Override
    public Rectangle createRectangle(double posX, double posY,
            double height, double width, MyColor c) {
        return new Rectangle(posX, posY, height, width, c);
    }

    @Override
    public Polygon createPolygon(ArrayList<Point2D> points, MyColor c) {
        return new Polygon(points.get(0), points.size(), points, c);
    }

}
