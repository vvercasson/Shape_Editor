package xshape.eventObserver;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;

import java.awt.geom.Point2D;

public class CanvaObserver implements Observer{
    Renderer renderer;

    public CanvaObserver(Renderer r){
        renderer = r;
    }

    @Override
    public void updateShapeColor(Shape shape, MyColor c){
        shape.setColor(c);
        shape.translate(new Point2D.Double(20.0,20.0));

    }

    @Override
    public void updateShapePosition(Shape shape, double x, double y) {
        shape.translate(new Point2D.Double(x,y));
    }

}
