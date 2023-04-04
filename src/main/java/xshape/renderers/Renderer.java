package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.*;

public abstract class Renderer {
    ArrayList<Shape> _shapes = new ArrayList<Shape>();

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
        Rectangle r = new Rectangle(0, 0, 100, 100);
        Point2D p1 = new Point2D.Double(250, 250);
        ArrayList<Point2D> p2 = new ArrayList<Point2D>();
        p2.add(new Point2D.Double(300, 300));
        p2.add(new Point2D.Double(350, 300));
        p2.add(new Point2D.Double(350, 350));
        _shapes.add(new Polygon(p1, 3, p2));
        _shapes.add(r);
        for (Shape s : _shapes) {
            s.drawInCanva(this);
        }
    }
}
