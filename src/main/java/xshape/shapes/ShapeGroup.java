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

    public void add(Shape s) {
        _shapes.add(s);
    }

    public void remove(Shape s) {
        _shapes.remove(s);
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
        // TODO: Wondering how to handle that, we clearly don't want to set all shapes
        // to the same positions
        return this;
    }

    @Override
    public MyColor getColor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getColor'");
    }

    @Override
    public void setColor(MyColor color) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().setColor(color);
        }
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
        return this;
    }

    @Override
    public Shape rotate(double angle) {
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            it.next().rotate(angle);
        }
        return this;
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

}
