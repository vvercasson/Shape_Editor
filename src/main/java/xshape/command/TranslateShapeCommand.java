package xshape.command;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;

public class TranslateShapeCommand implements ICommand {

    private Renderer _r;
    private Shape _s;
    private Point2D _transVec;

    public TranslateShapeCommand(Renderer r, Shape s, Point2D transVec) {
        _s = s;
        _transVec = transVec;
        _r = r;
    }

    @Override
    public void apply() {
        _s.translate(_transVec);
        _r.refreshCanva();
    }

    @Override
    public void undo() {
        _s.translate(new Point2D.Double(-_transVec.getX(), -_transVec.getY()));
        _r.refreshCanva();
    }

}
