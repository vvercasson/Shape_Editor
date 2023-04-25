package xshape.shapes;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

import xshape.renderers.Renderer;
import xshape.utils.MyColor;

public class ShapeGroup implements Shape, Iterable<Shape> {
    /*
     * Composite pattern
     */
    private ArrayList<Shape> _shapes = new ArrayList<Shape>();
    private Point2D _rotationCenterOfGroup;

    /*
     * Composite pattern
     */
    public void add(Shape s) {
        _shapes.add(s);
        computeCenterOfRotation();
    }

    public void remove(Shape s) {
        _shapes.remove(s);
        computeCenterOfRotation();
    }

    /*
     * Getters and setters
     */
    @Override
    public Point2D getPos() {
        int x = 0, y = 0;
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            Point2D pos = it.next().getPos();
            x += pos.getX();
            y += pos.getY();
        }
        return new Point2D.Double(x / _shapes.size(), y / _shapes.size());
    }

    @Override
    public Shape setPos(Point2D position) {
        // TODO: Does this even have sense ?
        return this;
    }

    @Override
    public MyColor getColor() {
        Iterator<Shape> it = iterator();
        int r = 0, g = 0, b = 0;
        while (it.hasNext()) {
            MyColor c = it.next().getColor();
            r += c.getRed();
            g += c.getGreen();
            b += c.getBlue();
        }
        return new MyColor(r / _shapes.size(), g / _shapes.size(), b / _shapes.size());
    }

    @Override
    public void setColor(MyColor color) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().setColor(color);
        }
    }

    @Override
    public void setOpacity(int opacity) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().setOpacity(opacity);
        }
    }

    @Override
    public void computeCenterOfRotation() {
        Iterator<Shape> it = iterator();
        double x = 0, y = 0;
        while (it.hasNext()) {
            Point2D p = it.next().getRotationCenter();
            x += p.getX();
            y += p.getY();
        }
        setRotationCenter(new Point2D.Double(x / _shapes.size(), y / _shapes.size()));
    }

    @Override
    public Point2D getRotationCenter() {
        return _rotationCenterOfGroup;
    }

    @Override
    public void setRotationCenter(Point2D center) {
        _rotationCenterOfGroup = center;
    }

    /*
     * Methods
     */
    @Override
    public Shape translate(Point2D vec) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().translate(vec);
        }
        computeCenterOfRotation();
        return this;
    }

    @Override
    public Shape rotate(double angle) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().rotate(angle, getRotationCenter());
        }
        return this;
    }

    @Override
    public Shape rotate(double angle, Point2D center) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().rotate(angle, center);
        }
        return this;
    }

    @Override
    public Shape resize(int deisiredSize) {
        int realDesiredSize = deisiredSize / _shapes.size();
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().resize(realDesiredSize);
        }
        return this;
    }

    @Override
    public boolean belongsTo(Point2D p) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            if (it.next().belongsTo(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void drawInCanva(Renderer r) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().drawInCanva(r);
        }
    }

    /*
     * Iterable interface
     */
    public Iterator<Shape> shapes() {
        return iterator();
    }

    @Override
    public Iterator<Shape> iterator() {
        return _shapes.iterator();
    }

    /*
     * Clone method
     */
    @Override
    public Shape clone() {
        ShapeGroup clone = new ShapeGroup();
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            clone.add(it.next().clone());
        }
        return clone;
    }
}
