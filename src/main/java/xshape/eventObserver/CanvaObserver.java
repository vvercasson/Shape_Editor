package xshape.eventObserver;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;

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
        shape.setOpacity(125);
    }

    @Override
    public void Unselect(){
        for (Shape s : renderer.getShapes()) {
            s.setOpacity(255);
        }
    }

    @Override
    public void updateShapePosition(Shape shape, int x, int y) {
        Point2D vec = new Point2D.Double(x, y);
        shape.translate(vec);
        // shape.setPos(new Point2D.Double(x, y));
    }

}
