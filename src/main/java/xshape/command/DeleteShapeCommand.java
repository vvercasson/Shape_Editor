package xshape.command;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;

public class DeleteShapeCommand implements ICommand {

    private Renderer _renderer;
    private Shape _shape;

    public DeleteShapeCommand(Renderer r, Shape s) {
        _renderer = r;
        _shape = s;
    }

    @Override
    public void apply() {
        _renderer.deleteShape(_shape);
        _renderer.refreshCanva();
    }

    @Override
    public void undo() {
        _renderer.getShapes().add(_shape);
        _renderer.refreshCanva();
    }

}
