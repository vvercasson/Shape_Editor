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
    public Rectangle createRectangle(double posX, double posY, double height, double width, MyColor c) {
        return new Rectangle(posX, posY, height, width, c, false);
    }

    @Override
    public Polygon createPolygon(ArrayList<Point2D> points, MyColor c) {
        return new Polygon(points.get(0), points.size(), points, c);
    }

    @Override
    public Polygon createDefaultPolygon(double posX, double posY, double height, double width, MyColor c) {
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(posX + width / 2, posY));
        points.add(new Point2D.Double(posX + width, posY + height / 2));
        points.add(new Point2D.Double(posX + width / 2, posY + height));
        points.add(new Point2D.Double(posX, posY + height / 2));
        return createPolygon(points, c);
    }

    @Override
    public Rectangle createRoundedRectangle(double posX, double posY, double height, double width, MyColor c) {
        return new Rectangle(posX, posY, height, width, c, true);
    }

}
