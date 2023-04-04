package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.shapes.*;
import xshape.toolbar.ToolBar;
import xshape.utils.MyColor;

public abstract class Renderer {
    ArrayList<Shape> _shapes = new ArrayList<Shape>();
    ShapeFactory _factory = new ShapesFactory();

    public void run() {
    }

    public void drawRectangle(Rectangle r) {
        System.out.println("Drawing rectangle");
    }

    public void drawText(Point2D pos, String text, MyColor c) {
        System.out.println("Drawing text");
    }

    // TODO: change to Polygon as paramter once Polygon exists
    public void drawPolygon(Polygon p) {
        System.out.println("Drawing polygon");
    }

    public void drawLine(Point2D start, Point2D end, MyColor c) {
        System.out.println("Drawing line");
    }

    public void draw() {
        /*
         * MyColor c1 = new MyColor(0, 0, 255);
         * MyColor c2 = new MyColor(255, 0, 0);
         * 
         * Rectangle r = _factory.createRectangle(0, 0, 100, 100, c1);
         * 
         * ArrayList<Point2D> points = new ArrayList<Point2D>();
         * points.add(new Point2D.Double(300, 300));
         * points.add(new Point2D.Double(350, 300));
         * points.add(new Point2D.Double(350, 350));
         * 
         * Polygon p = _factory.createPolygon(points, c2);
         * 
         * _shapes.add(p);
         * _shapes.add(r);
         * for (Shape s : _shapes) {
         * s.drawInCanva(this);
         * }
         */

        Point2D startLine = new Point2D.Double(70, 300);

        drawText(startLine, "PoufBamBam", MyColor.GREEN);
        ToolBar toolBar = new ToolBar(20, this);
        toolBar.createToolBar(this);
    }
}
