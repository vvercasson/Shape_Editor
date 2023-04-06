package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.shapes.*;
import xshape.toolbar.ToolBar;
import xshape.toolbar.Trash;
import xshape.utils.MyColor;

import javax.swing.*;

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

    public ArrayList<Shape> getShapes() {
        return _shapes;
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

    public void drawTrashToolBar(Trash t){System.out.println("Drawing trash");}

    /*
     * Function that says what to be displayed on open
     */
    public void draw() {

        ToolBar toolBar = new ToolBar(this);

        MyColor c1 = new MyColor(0, 0, 255);
        MyColor c2 = new MyColor(255, 0, 0);

        Rectangle r = _factory.createRoundedRectangle(100d, 100d, 100d, 100d, c1);

        ArrayList<Point2D> points = new ArrayList<Point2D>();
        points.add(new Point2D.Double(300, 300));
        points.add(new Point2D.Double(350, 300));
        points.add(new Point2D.Double(350, 350));

        Polygon p = _factory.createPolygon(points, c2);
        
        _shapes.add(toolBar);
        _shapes.add(p);
        _shapes.add(r);

        for (Shape s : _shapes) {
            s.drawInCanva(this);
        }
    }

    public void redraw() {
        for (Shape s : _shapes) {
            s.drawInCanva(this);
        }
    }
}
