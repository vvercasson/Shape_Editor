package xshape.eventObserver;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;

import java.awt.geom.Point2D;
import java.util.Iterator;

public class CanvaObserver implements Observer {
    Renderer renderer;

    public CanvaObserver(Renderer r) {
        renderer = r;
    }

    @Override
    public void updateSelectedShape(Shape shape) {
        renderer.addSelectedShape(shape);
        shape.setOpacity(125);
    }

    public void updateUnselectedShape(Shape s) {
        renderer.removeSelectedShape(s);
        s.setOpacity(255);
    }

    @Override
    public void Unselect() {
        for (Shape s : renderer.getSelectedShapes()) {
            s.setOpacity(255);
        }
        renderer.clearSelectedShape();
    }

    @Override
    public void updateShapePosition(int x, int y) {
        Point2D vec = new Point2D.Double(x, y);
        for (Shape s : renderer.getSelectedShapes()) {
            s.translate(vec);
        }
    }

    @Override
    public void de_group_shapes() {
        for (Shape s: renderer.getSelectedShapes()) {
            if (s instanceof ShapeGroup) {
                Iterator<Shape> iterator = ((ShapeGroup) s).iterator();
                while (iterator.hasNext()){
                    Shape shapeOfGroup = iterator.next();
                    shapeOfGroup.clone();
                    renderer.getShapes().add(shapeOfGroup);
                    ((ShapeGroup) s).remove(shapeOfGroup);
                }

            }
        }
    }

}
