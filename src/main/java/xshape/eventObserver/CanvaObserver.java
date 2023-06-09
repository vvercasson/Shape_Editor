package xshape.eventObserver;

import xshape.command.Invoker;
import xshape.command.UngroupCommand;
import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;

import java.awt.geom.Point2D;

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
        UngroupCommand ungroupCommand = new UngroupCommand(renderer, renderer.getSelectedShapes());
        Invoker.getInstance().apply(ungroupCommand);
    }

    @Override
    public void group_shapes() {
        ShapeGroup newShapeGroup = new ShapeGroup();
        for (Shape s : renderer.getSelectedShapes()) {
            newShapeGroup.add(s.clone());
            renderer.getShapes().remove(s);
        }
        renderer.getShapes().add(newShapeGroup);
        updateUnselectedShape(newShapeGroup);
    }

}
