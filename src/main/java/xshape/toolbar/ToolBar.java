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
    int width;
    ShapeFactory factory = new ShapesFactory();

    public ToolBar(Renderer r) {
        // draw line
        Point2D startLine = new Point2D.Double(70, 0);
        Point2D endLine = new Point2D.Double(70, 500);
        r.drawLine(startLine, endLine, MyColor.BLACK);

        // draw shapes
        ShapeFactory shapeFactory = new ShapesFactory();
        add(shapeFactory.createRectangle(10,10,20,40,MyColor.RED));
        add(shapeFactory.createDefaultPolygon(10,50,50,40,MyColor.BLACK));

    }

    public void createToolBar(Renderer r) {
        super.drawInCanva(r);
    }

    public void add(Shape s) {
        super.add(s);
    }

    public void remove(Shape s) {
        super.remove(s);
    }

}
