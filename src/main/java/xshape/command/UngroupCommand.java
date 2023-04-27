package xshape.command;

import xshape.renderers.Renderer;
import xshape.shapes.ShapeGroup;
import xshape.shapes.Shape;
import java.util.ArrayList;
import java.util.Iterator;

public class UngroupCommand implements ICommand {

    private Renderer _renderer;
    private ShapeGroup _oldShapeGroup;
    private ArrayList<Shape> _shapes;

    public UngroupCommand(Renderer r, ArrayList<Shape> s) {
        _renderer = r;
        _shapes = s;
        _oldShapeGroup = new ShapeGroup();
        for (Shape shape : _shapes) {
            _oldShapeGroup.add(shape.clone());
        }
    }

    @Override
    public void apply() {
        System.out.println("Applying degroup");
        for (Shape s : _shapes) {
            if (s instanceof ShapeGroup) {
                Iterator<Shape> iterator = ((ShapeGroup) s).iterator();
                while (iterator.hasNext()) {
                    Shape shapeOfGroup = iterator.next();
                    Shape copy = shapeOfGroup.clone();
                    copy.setOpacity(255);
                    _renderer.getShapes().add(copy);
                    _renderer.getShapes().remove(shapeOfGroup);
                }
            }
        }
    }

    @Override
    public void undo() {
        System.out.println("Undoing degroup");
        Iterator<Shape> it = _oldShapeGroup.iterator();
        while (it.hasNext()) {
            Shape shape = it.next();
            _renderer.getShapes().remove(shape);
        }
        _renderer.getShapes().add(_oldShapeGroup);
    }

}
