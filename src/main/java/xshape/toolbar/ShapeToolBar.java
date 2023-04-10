package xshape.toolbar;

import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.shapes.Rectangle;
import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;
import xshape.utils.MyColor;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ShapeToolBar extends ShapeGroup {
    // Factory
    // ! To be changed i think
    ShapeFactory _factory = new ShapesFactory();

    // ToolBar Components
    private Rectangle background = new Rectangle(0, 0, 500, 80, MyColor.GRAY, false);
    private ArrayList<Shape> _shapesTB = new ArrayList<>();
    private Trash _trash;

    // Positionning
    private double shapeSpacing = 40;
    private double _newShapePos;
    private double _xPositionTB = 10;

    // Constructor
    public ShapeToolBar() {
        this._newShapePos = 10;
        addShapeToToolbar(_factory.createCustomRectangle(10d, _newShapePos, 20d, 40d, MyColor.RED, false));
        addShapeToToolbar(_factory.createDefaultPolygon(10, _newShapePos, 50, 40, MyColor.BLACK));
        this._trash = new Trash(new Point2D.Double(10, 400));
    }

    // COMPONENTS getters
    public Rectangle getBackground() {
        return background;
    }

    public Trash getTrash() {
        return _trash;
    }

    // Toolbar shapes management
    public void addShapeToToolbar(Shape s) {
        _newShapePos += shapeSpacing; // 60 sera la height
        Point2D.Double p = new Point2D.Double(_xPositionTB, _newShapePos);
        _shapesTB.add(s.setPos(p));
    }

    public void removeShapeFromToolbar(Shape s) {
        super.remove(s);
    }

    // GETTERS
    public double getXPosition() {
        return _xPositionTB;
    }

    public double getNewShapePosition() {
        return _newShapePos;
    }

    public ArrayList<Shape> getToolbarShapes() {
        return _shapesTB;
    }
}
