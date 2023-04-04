package xshape.shapes;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;

public abstract class AShape implements Shape {
    private Point2D _pos;

    public AShape(Point2D pos) {
        _pos = pos;
    }

    public Point2D getPos() {
        return _pos;
    }

    public Shape setPos(Point2D _pos) {
        this._pos = _pos;
        return this;
    }

    public void drawInCanva(Renderer r) {
    }
}
