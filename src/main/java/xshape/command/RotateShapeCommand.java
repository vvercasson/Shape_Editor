package xshape.command;

import java.awt.geom.Point2D;

import xshape.shapes.Shape;

public class RotateShapeCommand implements ICommand {

    private double _angle;
    private Shape _shape;
    private Point2D _rotation;

    public RotateShapeCommand(Shape s, double angle) {
        _shape = s;
        _angle = angle;
        _rotation = s.getRotationCenter();
    }

    public RotateShapeCommand(Shape s, int angle, Point2D rotationPoint) {
        _shape = s;
        _angle = angle;
        _rotation = rotationPoint;
    }

    @Override
    public void apply() {
        _shape.rotate(_angle, _rotation);
    }

    @Override
    public void undo() {
        _shape.rotate(-_angle, _rotation);
    }

}
