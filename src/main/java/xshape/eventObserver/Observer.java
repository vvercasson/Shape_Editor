package xshape.eventObserver;

import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;

public interface Observer {

    void updateSelectedShape(Shape shape);

    void updateUnselectedShape(Shape s);

    void Unselect();

    void updateShapePosition(int x, int y);

    void de_group_shapes();
}
