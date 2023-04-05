package xshape.shapes;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.renderers.Renderer;
import xshape.utils.MyColor;

public class Polygon extends AShape {
    /*
     * Attributes
     */
    private int _nbPoints;
    private ArrayList<Point2D> _points;

    /*
     * Constructors
     */
    public Polygon(Point2D pos, int nbPoints, ArrayList<Point2D> points) {
        super(pos);
        _nbPoints = nbPoints;
        _points = points;
        computeCenterOfRotation();
    }

    public Polygon(Point2D pos, int nbPoints, ArrayList<Point2D> points, MyColor c) {
        super(pos, c);
        _nbPoints = nbPoints;
        _points = points;
        computeCenterOfRotation();
    }

    /*
     * Methods
     */
    @Override
    public Shape translate(Point2D vec) {
        for (Point2D p : _points) {
            p.setLocation(p.getX() + vec.getX(), p.getY() + vec.getY());
        }
        return this;
    }

    @Override
    public Shape rotate(double angle) {
        double centerX = getRotationCenter().getX();
        double centerY = getRotationCenter().getY();
        double radians = Math.toRadians(angle);
        for (Point2D point : getPoints()) {
            double x = point.getX() - centerX;
            double y = point.getY() - centerY;
            double xPrime = x * Math.cos(radians) - y * Math.sin(radians);
            double yPrime = x * Math.sin(radians) + y * Math.cos(radians);
            point.setLocation(xPrime + centerX, yPrime + centerY);
        }
        return this;
    }

    @Override
    public Shape rotate(double angle, Point2D center) {
        double centerX = center.getX();
        double centerY = center.getY();
        double radians = Math.toRadians(angle);
        for (Point2D point : getPoints()) {
            double x = point.getX() - centerX;
            double y = point.getY() - centerY;
            double xPrime = x * Math.cos(radians) - y * Math.sin(radians);
            double yPrime = x * Math.sin(radians) + y * Math.cos(radians);
            point.setLocation(xPrime + centerX, yPrime + centerY);
        }
        return this;
    }

    @Override
    public boolean belongsTo(Point2D p) {
        Path2D path = new Path2D.Double();
        path.moveTo(getPoints().get(0).getX(), getPoints().get(0).getY());
        for (int i = 1; i < getPoints().size(); i++) {
            path.lineTo(getPoints().get(i).getX(), getPoints().get(i).getY());
        }
        path.closePath();
        return path.contains(p);
    }

    @Override
    public void drawInCanva(Renderer r) {
        r.drawPolygon(this);
    }

    public void computeCenterOfRotation() {
        double x = 0;
        double y = 0;
        for (Point2D p : _points) {
            x += p.getX();
            y += p.getY();
        }
        x /= _nbPoints;
        y /= _nbPoints;
        setRotationCenter(new Point2D.Double(x, y));
    }

    /*
     * Getters and Setters
     */
    public ArrayList<Point2D> getPoints() {
        return _points;
    }

    public void setPoints(ArrayList<Point2D> _points) {
        this._points = _points;
        this._nbPoints = _points.size();
    }

    public int getNbPoints() {
        return _nbPoints;
    }

}
