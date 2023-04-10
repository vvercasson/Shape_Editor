package xshape.eventObserver;


import xshape.shapes.Shape;

public interface Observer {

    void updateSelectedShape(Shape shape);

    void updateShapePosition(Shape shape, int x, int y);
}
