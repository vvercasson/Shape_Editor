package xshape.shapes;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;
import xshape.utils.MyColor;

/*
 * Interface for all shapes
 */
public interface Shape extends Cloneable {
	/*
	 * Getters and setters
	 */
	// Position of the shape
	Point2D getPos();

	Shape setPos(Point2D position);

	// Color of the shape
	MyColor getColor();

	void setColor(MyColor color);

	void setOpacity(int opacity);

	// Rotation center of the shape
	Point2D getRotationCenter();

	void setRotationCenter(Point2D center);

	// Compute the center of rotation of the shape
	void computeCenterOfRotation();

	/*
	 * Methods
	 */
	Shape translate(Point2D vec);

	Shape rotate(double angle);

	Shape rotate(double angle, Point2D center);

	boolean belongsTo(Point2D p);

	Shape resize(int deisiredSize);

	/*
	 * Draw method
	 */
	public void drawInCanva(Renderer r);

	/*
	 * Clone method
	 */
	public Shape clone();
}
