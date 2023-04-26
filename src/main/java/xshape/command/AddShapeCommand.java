package xshape.command;

import xshape.factory.ShapeFactory;
import xshape.renderers.Renderer;
import xshape.shapes.Shape;

public class AddShapeCommand extends AbsShapeCreationCmd {

    private Shape _shape;

    public AddShapeCommand(ShapeFactory f, Renderer r, Shape s) {
        super(f, r);
        _shape = s;
    }

    @Override
    public void apply() {
        getRenderer().getShapes().add(_shape);
        getRenderer().refreshCanva();
    }

    @Override
    public void undo() {
        getRenderer().getShapes().remove(_shape);
        getRenderer().refreshCanva();
    }

}
