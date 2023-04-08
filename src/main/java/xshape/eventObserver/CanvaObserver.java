package xshape.eventObserver;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;

import java.awt.geom.Point2D;

public class CanvaObserver implements Observer {
    Renderer renderer;

    public CanvaObserver(Renderer r) {
        renderer = r;
    }

    /*
     * TODO: draw outline for the shape
     */
    @Override
    public void updateSelectedShape(Shape shape) {
        MyColor newColor = new MyColor(shape.getColor().getRed(), shape.getColor().getGreen(),
                shape.getColor().getBlue(), 125);
        shape.setColor(newColor);
    }

    @Override
    public void updateShapePosition(Shape shape, double x, double y) {
        shape.setPos(new Point2D.Double(x, y));
    }

}
