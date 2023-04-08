package xshape.eventObserver;

import xshape.shapes.Shape;
import xshape.utils.MyColor;

import java.awt.geom.Point2D;

public interface Observer {

    void updateShapeColor(Shape shape, MyColor c);
    void updateShapePosition(Shape shape,double x, double y);
}
