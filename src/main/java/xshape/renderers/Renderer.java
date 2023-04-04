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
    public void drawPolygon(Point2D[] points) {
        System.out.println("Drawing polygon");
    }

    public void draw() {
        Rectangle r = new Rectangle(0, 0, 100, 100);
        _shapes.add(r);
        for (Shape s : _shapes) {
            s.drawInCanva(this);
        }
    }
}
