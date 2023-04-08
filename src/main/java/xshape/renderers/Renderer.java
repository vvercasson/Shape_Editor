package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.shapes.*;
import xshape.toolbar.ButtonToolBar;
import xshape.toolbar.ShapeToolBar;
import xshape.toolbar.Trash;
import xshape.toolbar.buttons.Button;
import xshape.utils.MyColor;

public abstract class Renderer {
    /*
     * Window attributes
     */
    private int _width, _height;
    private boolean init = false;

    /*
     * Rendering attributes
     */
    private ArrayList<Shape> _shapes = new ArrayList<Shape>();

    private ArrayList<Shape> _shapesToolBar = new ArrayList<>();
    private ShapeFactory _factory = new ShapesFactory();

    private Shape _shapeSelected;

    /*
     * Constructor
     */
    public Renderer(int width, int height) {
        _width = width;
        _height = height;
    }

    /*
     * Getters Setters
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

    public ArrayList<Shape> get_shapesToolBar() {
        return _shapesToolBar;
    }

    public void setShapeSelected(Shape s) {
        _shapeSelected = s;
    }

    public Shape getShapeSelected() {
        return _shapeSelected;
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

    public void drawTrashToolBar(Trash t) {
        System.out.println("Drawing trash");
    }

    public void drawButtonToolBar(ButtonToolBar bar, String nameButton) {
        System.out.println("Drawing ButtonToolBar");
    }

    /*
     * Function that says what to be displayed on open
     */
    public void draw() {

        if (!init) {
            ShapeToolBar toolBar = new ShapeToolBar(this);
            ButtonToolBar bar = new ButtonToolBar(this);

            MyColor c1 = new MyColor(0, 0, 255);
            MyColor c2 = new MyColor(255, 0, 0);

            Rectangle r = _factory.createCustomRectangle(100d, 100d, 100d, 100d, c1, true);

            ArrayList<Point2D> points = new ArrayList<Point2D>();
            points.add(new Point2D.Double(300, 300));
            points.add(new Point2D.Double(350, 300));
            points.add(new Point2D.Double(350, 350));

            Polygon p = _factory.createPolygon(points, c2);

            Shape p2 = p.clone();
            p2.translate(new Point2D.Double(100, 100));

            _shapesToolBar = toolBar.get_shapesTB();
            _shapes.add(p);
            _shapes.add(p2);
            _shapes.add(r);
            init = true;
        }

        for (Shape s : _shapesToolBar) {
            s.drawInCanva(this);
        }

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
