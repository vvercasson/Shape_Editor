package xshape.shapes;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.renderers.Renderer;

public class Polygon extends AShape {

    private int _nbPoints;
    private ArrayList<Point2D> _points;

    public Polygon(Point2D pos, int nbPoints, ArrayList<Point2D> points) {
        super(pos);
        _nbPoints = nbPoints;
        _points = points;
    }

    @Override
    public Shape translate(Point2D vec) {
        for (Point2D p : _points) {
            p.setLocation(p.getX() + vec.getX(), p.getY() + vec.getY());
        }
        return this;
    }

    @Override
    public Shape rotate(double angle) {
        // TODO: Implement rotate method to allow rotation of polygons
        throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    }

    @Override
    public void drawInCanva(Renderer r) {
        r.drawPolygon(_points);
    }

}
