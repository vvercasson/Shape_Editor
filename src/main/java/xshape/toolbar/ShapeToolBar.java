package xshape.toolbar;

import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.renderers.Renderer;
import xshape.shapes.Rectangle;
import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;
import xshape.utils.MyColor;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ShapeToolBar extends ShapeGroup {
    private ShapeFactory _factory;
    private Trash _t;

    private ArrayList<Shape> _shapesTB = new ArrayList<>();

    private double _newShapePos;

    private double _xPositionTB = 10;

    Renderer r;

    public ShapeToolBar(Renderer r) {
        this.r = r;

        _newShapePos = 10;
        ShapeFactory shapeFactory = new ShapesFactory();

        // draw container
        Rectangle background = shapeFactory.createCustomRectangle(0, 0, 500, 70, MyColor.GRAY, false);
        r.drawRectangle(background);
        // draw shapes
        add(shapeFactory.createCustomRectangle(10, _newShapePos, 20, 40, MyColor.RED, false));
        add(shapeFactory.createDefaultPolygon(10, _newShapePos, 50, 40, MyColor.BLACK));
        _factory = shapeFactory;
        // draw trash
        Trash t = new Trash(new Point2D.Double(10, 400));
        _t = t;
        r.drawTrashToolBar(t);
    }

    public void add(Shape s) {
        _newShapePos += 30; // 60 sera la height
        _shapesTB.add(s);
        // draw Line //TODO
        /*
         * Point2D.Double start = new Point2D.Double(0,_newShapePos);
         * Point2D.Double end = new Point2D.Double(70,_newShapePos);
         * 
         * r.drawLine(start,end,MyColor.RED);
         */

    }

    public void remove(Shape s) {
        super.remove(s);
    }

    public double get_xPositionTB() {
        return _xPositionTB;
    }

    public double get_newShapePos() {
        return _newShapePos;
    }

    public ArrayList<Shape> get_shapesTB() {
        return _shapesTB;
    }
}
