package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.shapes.*;
import xshape.toolbar.ToolBar;
import xshape.utils.MyColor;

public abstract class Renderer {
    /*
     * Window attributes
     */
    private int _width, _height;

    /*
     * Rendering attributes
     */
    private ArrayList<Shape> _shapes = new ArrayList<Shape>();
    private ShapeFactory _factory = new ShapesFactory();

    /*
     * Constructor
     */
    public Renderer(int width, int height) {
        _width = width;
        _height = height;
    }

    /*
     * Getters
     */
    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    /*
     * Methods to be implemented by every specific renderer
     */
    public void run() {
    }

    public void drawRectangle(Rectangle r) {
        System.out.println("Drawing rectangle");
    }

    public void drawText(Point2D pos, String text, MyColor c) {
        System.out.println("Drawing text");
    }

    public void drawPolygon(Polygon p) {
        System.out.println("Drawing polygon");
    }

    public void drawLine(Point2D start, Point2D end, MyColor c) {
        System.out.println("Drawing line");
    }

    /*
     * Function that says what to be displayed on open
     */
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

        Rectangle r = _factory.createRectangle(150, 150, 60, 50, MyColor.PINK);
        r.drawInCanva(this);
        r.setRotationCenter(new Point2D.Double(250, 250));
        drawText(new Point2D.Double(250, 250), ".", MyColor.RED);
        r.rotate(180);
        r.drawInCanva(this);

        drawText(startLine, "PoufBamBam", MyColor.GREEN);
        ToolBar toolBar = new ToolBar(20, this);
        toolBar.createToolBar(this);
    }
}
