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
    private boolean _rounded = false;

    /*
     * Constructors
     */
    public Polygon(int nbPoints, ArrayList<Point2D> points) {
        super(points.get(0));
        _nbPoints = nbPoints;
        _points = points;
        computeCenterOfRotation();
    }

    public Polygon(int nbPoints, ArrayList<Point2D> points, MyColor c) {
        super(points.get(0), c);
        _nbPoints = nbPoints;
        _points = points;
        computeCenterOfRotation();
    }

    public Polygon(int nbPoints, ArrayList<Point2D> points, MyColor c, boolean rounded) {
        super(points.get(0), c);
        _nbPoints = nbPoints;
        _points = points;
        _rounded = rounded;
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
    public boolean isRounded() {
        return _rounded;
    }

    public void setRounded(boolean _rounded) {
        this._rounded = _rounded;
    }

    @Override
    public Shape setPos(Point2D _pos) {
        double dx = _pos.getX() - _points.get(0).getX();
        double dy = _pos.getY() - _points.get(0).getY();
        for (Point2D p : _points) {
            p.setLocation(p.getX() + dx, p.getY() + dy);
        }
        return this;
    }

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

    // Side length functions
    public double getSideLength(int indexFirstPoint, int indexSecondPoint) {
        if (indexFirstPoint < 0 || indexFirstPoint >= _nbPoints || indexSecondPoint < 0
                || indexSecondPoint >= _nbPoints)
            return -1;
        return _points.get(indexFirstPoint).distance(_points.get(indexSecondPoint));
    }

    public void setSideLength(int indexFirstPoint, int indexSecondPoint, double length) {
        if (indexFirstPoint < 0 || indexFirstPoint >= _nbPoints || indexSecondPoint < 0
                || indexSecondPoint >= _nbPoints) {
            System.err.println("Error: index out of bounds");
            return;
        }
        double dx = _points.get(indexSecondPoint).getX() - _points.get(indexFirstPoint).getX();
        double dy = _points.get(indexSecondPoint).getY() - _points.get(indexFirstPoint).getY();
        double angle = Math.atan2(dy, dx);
        double x = _points.get(indexFirstPoint).getX() + length * Math.cos(angle);
        double y = _points.get(indexFirstPoint).getY() + length * Math.sin(angle);
        _points.get(indexSecondPoint).setLocation(x, y);
    }

    /*
     * Prototype pattern
     */
    @Override
    public Shape clone() {
        ArrayList<Point2D> points = new ArrayList<Point2D>();
        for (Point2D p : _points) {
            points.add((Point2D) p.clone());
        }
        return new Polygon(getNbPoints(), points, getColor(), isRounded());
    }

}
