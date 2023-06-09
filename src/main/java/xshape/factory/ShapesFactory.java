package xshape.factory;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.utils.MyColor;

public class ShapesFactory implements ShapeFactory {

    /*
     * 
     * RECTANGLE FACTORY
     * 
     */

    // Customizable rectangle
    @Override
    public Rectangle createCustomRectangle(double posX, double posY, double height, double width, MyColor c,
            boolean rounded) {
        return new Rectangle(posX, posY, height, width, c, rounded);
    }

    // Default rectangle
    @Override
    public Rectangle createDefaultRectangle(int x, int y) {
        return new Rectangle(x, y, 100, 100, MyColor.RED, false);
    }

    /*
     * 
     * POLYGON FACTORY
     * 
     */

    // Customizable polygon
    @Override
    public Polygon createPolygon(ArrayList<Point2D> points, MyColor c) {
        return new Polygon(points.size(), points, c);
    }

    // Default polygon (Losange)
    @Override
    public Polygon createDefaultPolygon(double posX, double posY, double height, double width, MyColor c) {
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(posX + width / 2, posY));
        points.add(new Point2D.Double(posX + width, posY + height / 2));
        points.add(new Point2D.Double(posX + width / 2, posY + height));
        points.add(new Point2D.Double(posX, posY + height / 2));
        return createPolygon(points, c);
    }

}
