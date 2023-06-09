package xshape.toolbar;

import xshape.shapes.Rectangle;
import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;
import xshape.utils.MyColor;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ShapeToolBar extends ShapeGroup {

    // ToolBar Components
    private final Rectangle background = new Rectangle(0, 0, 500, 80, MyColor.GRAY, false);
    private ArrayList<Shape> _shapesTB = new ArrayList<>();
    private Trash _trash;

    // Positionning
    private double shapeSpacing = 30;
    private double _newShapePos;
    private double _xPositionTB = 10;

    // Constructor
    public ShapeToolBar() {
        this._newShapePos = 10;
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
        Point2D.Double p = null;
        if(!_shapesTB.isEmpty())
            shapeSpacing = 60;

        if(s instanceof Rectangle)
            p = new Point2D.Double(_xPositionTB, _newShapePos);
        else{
            p = new Point2D.Double(_xPositionTB+20, _newShapePos);
        }
        _shapesTB.add(s.setPos(p));
        _newShapePos += shapeSpacing; // 60 sera la height
    }

    public void removedShapeFromToolbar() {
        _newShapePos -= shapeSpacing;
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

    public void setShapeTB(ArrayList<Shape> shapesTB){
        _shapesTB=shapesTB;
    }
}
