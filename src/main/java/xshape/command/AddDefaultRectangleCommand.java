package xshape.command;

import xshape.factory.ShapeFactory;
import xshape.renderers.Renderer;
import xshape.shapes.Rectangle;

public class AddDefaultRectangleCommand extends AbsShapeCreationCmd {

    private Rectangle _rectangle;

    public AddDefaultRectangleCommand(ShapeFactory f, Renderer r, int x, int y) {
        super(f, r);
        _rectangle = getFactory().createDefaultRectangle(x, y);
    }

    @Override
    public void apply() {
        getRenderer().getShapes().add(_rectangle);
        _rectangle.drawInCanva(getRenderer());
    }

    @Override
    public void undo() {
        getRenderer().getShapes().remove(_rectangle);
        getRenderer().refreshCanva();
    }

}
