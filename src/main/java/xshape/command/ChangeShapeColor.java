package xshape.command;

import xshape.shapes.Shape;
import xshape.utils.MyColor;

public class ChangeShapeColor implements ICommand {

    private Shape _shape;
    private MyColor _oldColor;
    private MyColor _newColor;

    public ChangeShapeColor(Shape s, MyColor newColor) {
        _shape = s;
        _oldColor = s.getColor();
        _newColor = newColor;
    }

    @Override
    public void apply() {
        _shape.setColor(_newColor);
    }

    @Override
    public void undo() {
        _shape.setColor(_oldColor);
    }

}
