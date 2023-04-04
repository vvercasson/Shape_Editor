package xshape.factory;

import xshape.shapes.Rectangle;

public class ShapesFactory implements ShapeFactory {
    public ShapesFactory() {
    }

    @Override
    public Rectangle createRectangle(double posX, double posY,
            double height, double width) {
        return new Rectangle(posX, posY, height, width);
    }
}
