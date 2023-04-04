package xshape.shapes;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;

public interface Shape {
	Point2D getPos();

	Shape setPos(Point2D position);

	Shape translate(Point2D vec);

	Shape rotate(double angle);

	public void drawInCanva(Renderer r);
}
