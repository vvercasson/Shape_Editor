package xshape.eventObserver;

import xshape.shapes.Shape;
import xshape.utils.MyColor;

public interface Observer {

    public abstract void updateShapeColor(Shape shape, MyColor c);
}
