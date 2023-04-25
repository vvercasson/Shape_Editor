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
	public Point2D getPos();

	public Shape setPos(Point2D position);

	// Color of the shape
	public MyColor getColor();

	public void setColor(MyColor color);

	public void setOpacity(int opacity);

	// Rotation center of the shape
	public Point2D getRotationCenter();

	public void setRotationCenter(Point2D center);

	// Compute the center of rotation of the shape
	public void computeCenterOfRotation();

	/*
	 * Methods
	 */
	public Shape translate(Point2D vec);

	public Shape rotate(double angle);

	public Shape rotate(double angle, Point2D center);

	public boolean belongsTo(Point2D p);

	public Shape resize(int deisiredSize);

	/*
	 * Draw method
	 */
	public void drawInCanva(Renderer r);

	/*
	 * Clone method
	 */
	public Shape clone();
}
