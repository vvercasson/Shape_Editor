package xshape.command;

import java.awt.geom.Point2D;
import xshape.shapes.Shape;

public class ChangeShapePos implements ICommand {

    private Shape _shape;
    private Point2D _oldPos;
    private Point2D _newPos;

    public ChangeShapePos(Shape s, Point2D newPos) {
        _shape = s;
        _oldPos = s.getPos();
        _newPos = newPos;
    }

    @Override
    public void apply() {
        _shape.setPos(_newPos);
    }

    @Override
    public void undo() {
        _shape.setPos(_oldPos);
    }

}
