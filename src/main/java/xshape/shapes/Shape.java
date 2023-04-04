package xshape.shapes;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;
import xshape.utils.MyColor;

/*
 * Interface for all shapes
 */
public interface Shape {
	Point2D getPos();

	MyColor getColor();

	void setColor(MyColor color);

	Shape setPos(Point2D position);

	Shape translate(Point2D vec);

	Shape rotate(double angle);

	Point2D getRotationCenter();

	void setRotationCenter(Point2D center);

	public void drawInCanva(Renderer r);
}
