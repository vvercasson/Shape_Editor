package xshape.factory;

import xshape.shapes.Rectangle;

public interface ShapeFactory {
    Rectangle createRectangle(double posX, double posY, double height, double width);
}
