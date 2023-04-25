package xshape.command;

import xshape.factory.ShapeFactory;
import xshape.renderers.Renderer;

public abstract class AbsShapeCreationCmd implements ICommand {
    private ShapeFactory _fact;
    private Renderer _rend;

    public AbsShapeCreationCmd(ShapeFactory f, Renderer r) {
        _fact = f;
        _rend = r;
    }

    protected ShapeFactory getFactory() {
        return _fact;
    }

    protected Renderer getRenderer() {
        return _rend;
    }
}
