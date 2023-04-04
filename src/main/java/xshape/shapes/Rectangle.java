package xshape.shapes;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;

public class Rectangle extends AShape {
    // TODO: Use 4 points instad of 2 set of points
    private Point2D _pos = new Point2D.Double(0, 0);
    private Point2D _size = new Point2D.Double(1, 1);

    public Rectangle(Point2D pos) {
        super(pos);
    }

    public Rectangle(double posX, double posY, double height, double width) {
        super(new Point2D.Double(posX, posY));
        _size.setLocation(width, height);
    }

    @Override
    public Shape translate(Point2D vec) {
        _pos.setLocation(_pos.getX() + vec.getX(),
                _pos.getY() + vec.getY());
        return this;
    }

    public Point2D getSize() {
        return _size;
    }

    public void setSize(Point2D _size) {
        this._size = _size;
    }

    // TODO: Implement this method
    @Override
    public Shape rotate(double angle) {
        return this;
    }

    @Override
    public void drawInCanva(Renderer r) {
        r.drawRectangle(this);
    }
}
