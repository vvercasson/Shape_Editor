package xshape.command;

import xshape.factory.ShapeFactory;
import xshape.renderers.Renderer;
import xshape.shapes.*;
import xshape.utils.MyColor;

public class AddRectangleCommand extends AbsShapeCreationCmd {
    Rectangle _rectangle;

    // ! I hate the fact that i have to specify the Factory and the Renderer inevery
    // ! command
    // ? Maybe i should have a CommandFactory that would create the commands andpass
    // ? the factory and the renderer to the commands
    // TODO: To be Worked on

    public AddRectangleCommand(ShapeFactory f, Renderer r, int x, int y, int w, int h, MyColor c, boolean rounded) {
        super(f, r);
        _rectangle = getFactory().createCustomRectangle(x, y, w, h, c, rounded);
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