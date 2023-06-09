package xshape.command;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;

public class AddShapeCommand implements ICommand {

    private Shape _shape;
    private Renderer _renderer;

    public AddShapeCommand(Renderer r, Shape s) {
        _renderer = r;
        _shape = s;
    }

    @Override
    public void apply() {
        _renderer.getShapes().add(_shape);
        _renderer.refreshCanva();
    }

    @Override
    public void undo() {
        _renderer.getShapes().remove(_shape);
        _renderer.refreshCanva();
    }

}
