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
import java.util.Iterator;

public class ToolBar extends ShapeGroup {
    int width;
    ShapeFactory factory = new ShapesFactory();
    public ToolBar(int width, Renderer r){
        this.width = width;

        // draw line
        Point2D startLine = new Point2D.Double(70,0);
        Point2D endLine = new Point2D.Double(70,500);
        r.drawLine(startLine,endLine,MyColor.BLACK);

        // draw shapes
        Rectangle rectangle = factory.createRectangle(10,10,50,50,MyColor.RED);
        add(rectangle);

        ArrayList<Point2D> points = new ArrayList<Point2D>();
        points.add(new Point2D.Double(10, 80));
        points.add(new Point2D.Double(35, 70));
        points.add(new Point2D.Double(60, 80));
        points.add(new Point2D.Double(60, 120));
        points.add(new Point2D.Double(10, 120));

        Polygon poly = factory.createPolygon(points,MyColor.BLUE);
        add(poly);

    }

    public void createToolBar(Renderer r){
        super.drawInCanva(r);
    }

    public void add(Shape s){
        super.add(s);
    }

    public void remove(Shape s) {
        super.remove(s);
    }

}
