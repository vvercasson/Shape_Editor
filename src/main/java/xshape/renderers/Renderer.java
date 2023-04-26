package xshape.renderers;

import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import xshape.eventObserver.Observer;
import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.shapes.*;
import xshape.toolbar.*;
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
    private ArrayList<Shape> _shapes = new ArrayList<>();
    private ShapeToolBar _tb = new ShapeToolBar();
    private ButtonToolBar _btb = new ButtonToolBar();
    private ShapeFactory _factory = new ShapesFactory();

    private ArrayList<Shape> _selectedShapes = new ArrayList<>();
    private Shape _shapeToolBarSelected = null ;


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

    public ShapeToolBar getShapeToolbar() {
        return _tb;
    }

    public ButtonToolBar getButtonToolBar(){
        return _btb;
    }

    public void setShapes(ArrayList<Shape> shapes){
        _shapes=shapes;
    }

    public Shape getSelectedToolBarShape(){
        return _shapeToolBarSelected;
    }

    public void setSelectedToolBarShape(Shape shape){
        _shapeToolBarSelected=shape;
    }

    public void setShapeToolBar(ArrayList<Shape> shapes){
        _tb.setShapeTB(shapes);
    }

    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public ArrayList<Shape> getShapes() {
        return _shapes;
    }

    // TEST
    public ArrayList<Shape> getSelectedShapes() {
        return _selectedShapes;
    }

    public void addSelectedShape(Shape s) {
        _selectedShapes.add(s);
    }

    public void clearSelectedShape() {
        _selectedShapes.clear();
    }

    public void removeSelectedShape(Shape s) {
        _selectedShapes.remove(s);
    }

    public void loadShapeToolBar(){
        String fileToolbarSave = "./saveTollBar.bin";
        try {
            ArrayList<Shape> savedShapes = new ArrayList<>();
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileToolbarSave));
            savedShapes =(ArrayList<Shape>) is.readObject();
            is.close();
            setShapeToolBar(savedShapes);
        } catch (FileNotFoundException e){
            System.out.println("Pas de fichier save pour la tool bar, Tool bar par défaut");
        
        } catch (Exception e) {
            System.out.println("Problème avec le Load tool bar :" + e);
        }   
    }
            

    public void deleteShape(Shape s) {
        _shapes.remove(s);
    }

    /*
     * Methods to be implemented by every specific renderer
     */
    public abstract void run();

    public abstract void drawRectangle(Rectangle r);

    public abstract void drawText(Point2D pos, String text, MyColor c);

    public abstract void drawPolygon(Polygon p);

    public abstract void drawLine(Point2D start, Point2D end, MyColor c);

    public abstract void drawTrashToolBar(Trash t);

    public void drawButtonToolBar(ButtonToolBar btb) {
        for (Button b : btb.getButtons()) {
            drawRectangle(b.getBackground());
            Point2D textPosition = new Point2D.Double(b.getPosition().getX() + (double) b.getWidth() / 4,
                    b.getPosition().getY() + b.getHeight() / 1.5);
            drawText(textPosition, b.getLabel(), MyColor.BLACK);
        }
    }

    public void drawShapeToolbar(ShapeToolBar stb) {
        drawRectangle(stb.getBackground());
        for (Shape s : stb.getToolbarShapes()) {
            s.drawInCanva(this);
        }
        drawTrashToolBar(stb.getTrash());
    }

    public abstract void refreshCanva();

    public abstract void createContextMenu(Observer observer,boolean rightClick);

    /*
     * Function that says what to be displayed on open
     */
    public void draw() {

        if (!init) {
            MyColor c1 = new MyColor(0, 0, 255);
            MyColor c2 = new MyColor(255, 0, 0);

            loadShapeToolBar();
            if (_tb.getToolbarShapes().isEmpty()){
                System.out.println("tool bar shapes empty : adding default shapes");
                _tb.addShapeToToolbar(_factory.createCustomRectangle(0d, _tb.getNewShapePosition(), 20d, 40d, MyColor.RED, false));
                _tb.addShapeToToolbar(_factory.createDefaultPolygon(0, _tb.getNewShapePosition(), 50, 40, MyColor.BLACK));
            }
            Rectangle r = _factory.createCustomRectangle(100d, 100d, 100d, 100d, c1, false);

            // Shape pol = _factory.createDefaultPolygon(100, 100, 50, 40, MyColor.BLACK);

            ArrayList<Point2D> points = new ArrayList<>();
            points.add(new Point2D.Double(300, 300));
            points.add(new Point2D.Double(350, 300));
            points.add(new Point2D.Double(350, 350));

            Polygon p = _factory.createPolygon(points, c2);

            Shape p2 = p.clone();
            p2.translate(new Point2D.Double(100, 100));

            ShapeGroup g = new ShapeGroup();
            g.add(p);
            g.add(r);
            // g.add(pol);
            // Shape g2 = g.clone();
            g.rotate(20);

            // _shapes.add(p);
            // _shapes.add(g2);
            _shapes.add(p2);
            _shapes.add(g);
            // _shapes.add(r);
            init = true;
        }

        drawButtonToolBar(_btb);

        drawShapeToolbar(_tb);

        for (Shape s : _shapes) {
            s.drawInCanva(this);
        }
    }

    public abstract void hideMenu();
}
