package xshape.command;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;

public class AddShapeToToolbarCommand implements ICommand {
    private Shape _shape;
    private Renderer _renderer;

    public AddShapeToToolbarCommand(Renderer r, Shape s) {
        _renderer = r;
        _shape = s;
    }

    @Override
    public void apply() {
        _renderer.getShapeToolbar().addShapeToToolbar(_shape.resize(150));
        _renderer.refreshCanva();
    }

    @Override
    public void undo() {
        _renderer.getShapeToolbar().getToolbarShapes().remove(_shape);
        _renderer.getShapeToolbar().removedShapeFromToolbar();
        _renderer.refreshCanva();

    }

}
