package xshape.command;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;

public class AddShapeToToolbarCommand implements ICommand {
    private Shape _shape;
    private Renderer _renderer;
    private Point2D oldPos;

    public AddShapeToToolbarCommand(Renderer r, Shape s) {
        _renderer = r;
        _shape = s;
        oldPos = s.getPos();
    }

    @Override
    public void apply() {
        _shape.setOpacity(255);
        _renderer.getShapeToolbar().addShapeToToolbar(_shape.resize(150));
        _renderer.refreshCanva();
    }

    @Override
    public void undo() {
        _renderer.getShapeToolbar().getToolbarShapes().remove(_shape);
        _renderer.getShapeToolbar().removedShapeFromToolbar();
        _shape.setPos(oldPos);
        _renderer.getShapes().add(_shape);
        _renderer.refreshCanva();

    }

}
