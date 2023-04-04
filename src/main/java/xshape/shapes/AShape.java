package xshape.shapes;

import java.awt.geom.Point2D;

import xshape.utils.MyColor;

public abstract class AShape implements Shape {
    /*
     * Shape Attributes
     */
    private Point2D _pos;
    MyColor _color;
    private Point2D _rotationCenter;

    /*
     * Constructors
     */
    public AShape(Point2D pos) {
        _pos = pos;
        _color = new MyColor(0, 0, 255, 255);
    }

    public AShape(Point2D pos, MyColor color) {
        _pos = pos;
        _color = color;
    }

    /*
     * Getters and setters
     */
    @Override
    public MyColor getColor() {
        return _color;
    }

    @Override
    public void setColor(MyColor color) {
        _color = color;
    }

    public Point2D getPos() {
        return _pos;
    }

    public Shape setPos(Point2D _pos) {
        this._pos = _pos;
        return this;
    }

    @Override
    public void setRotationCenter(Point2D center) {
        _rotationCenter = center;
    }

    @Override
    public Point2D getRotationCenter() {
        return _rotationCenter;
    }
}
