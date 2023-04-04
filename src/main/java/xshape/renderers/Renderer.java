package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.shapes.*;

public abstract class Renderer {
    ArrayList<Shape> _shapes = new ArrayList<Shape>();
    ShapeFactory _factory = new ShapesFactory();

    public void run() {
    }

    public void drawLine(Point2D start, Point2D end) {
        System.out.println("Drawing line from " + start + " to " + end);
    }

    public void drawRectangle(Rectangle r) {
        System.out.println("Drawing rectangle at " + r.getPos() + " with size " + r.getSize());
    }

    public void drawText(Point2D pos, String text) {
        System.out.println("Drawing text at " + pos + ": " + text);
    }

    // TODO: change to Polygon as paramter once Polygon exists
    public void drawPolygon(ArrayList<Point2D> points) {
        System.out.println("Drawing polygon");
    }

    public void draw() {
        Rectangle r = _factory.createRectangle(0, 0, 100, 100);
        ArrayList<Point2D> points = new ArrayList<Point2D>();
        points.add(new Point2D.Double(300, 300));
        points.add(new Point2D.Double(350, 300));
        points.add(new Point2D.Double(350, 350));

        Polygon p = _factory.createPolygon(points);

        _shapes.add(p);
        _shapes.add(r);
        for (Shape s : _shapes) {
            s.drawInCanva(this);
        }
    }
}
