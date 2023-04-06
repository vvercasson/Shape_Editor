package xshape.toolbar;

import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.renderers.Renderer;
import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;
import xshape.utils.MyColor;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ToolBar extends ShapeGroup {
    private ShapeFactory _factory;
    private Trash _t;

    private double _newShapePos;

    private double _xPositionTB = 10;

    public ToolBar(Renderer r) {
        _newShapePos = 10;
        ShapeFactory shapeFactory = new ShapesFactory();

        // draw container
        Rectangle background = shapeFactory.createRectangle(0,0,500,70,MyColor.GRAY);
        r.drawRectangle(background);
        // draw shapes
        add(shapeFactory.createRectangle(10,_newShapePos,20,40,MyColor.RED));
        add(shapeFactory.createDefaultPolygon(10,_newShapePos,50,40,MyColor.BLACK));
        _factory = shapeFactory;
        // draw trash
        Trash t = new Trash(new Point2D.Double(10,400));
        _t = t;
        r.drawTrashToolBar(t);
    }

    public void add(Shape s) {
        super.add(s);
        _newShapePos += 30; // 60 sera la height

    }

    public void remove(Shape s) {
        super.remove(s);
    }

    public double get_xPositionTB() {
        return _xPositionTB;
    }

    public double get_newShapePos(){
        return _newShapePos;
    }
}
