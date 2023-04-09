package xshape.shapes;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.renderers.Renderer;
import xshape.utils.MyColor;

public class Rectangle extends Polygon {
    /*
     * Constructors
     */
    public Rectangle(double posX, double posY, double height, double width, MyColor c) {
        super(4, new ArrayList<Point2D>() {
            {
                add(new Point2D.Double(posX, posY));
                add(new Point2D.Double(posX + width, posY));
                add(new Point2D.Double(posX + width, posY + height));
                add(new Point2D.Double(posX, posY + height));
            }
        }, c);
    }

    public Rectangle(double posX, double posY, double height, double width, MyColor c, boolean rounded) {
        super(4, new ArrayList<Point2D>() {
            {
                add(new Point2D.Double(posX, posY));
                add(new Point2D.Double(posX + width, posY));
                add(new Point2D.Double(posX + width, posY + height));
                add(new Point2D.Double(posX, posY + height));
            }
        }, c, rounded);
    }

    /*
     * Getters Setters
     */
    public int getX() {
        return (int) getPoints().get(0).getX();
    }

    public int getY() {
        return (int) getPoints().get(0).getY();
    }

    public int getWidth() {
        return (int) (getPoints().get(2).getX() - getX());
    }

    public int getHeight() {
        return (int) (getPoints().get(2).getY() - getY());
    }

    @Override
    public Shape setPos(Point2D _pos) {
        return super.setPos(_pos);
    }

    /*
     * Methods
     */
    @Override
    public Shape translate(Point2D vec) {
        return super.translate(vec);
    }

    @Override
    public Shape rotate(double angle) {
        return super.rotate(angle);
    }

    @Override
    public void drawInCanva(Renderer r) {
        r.drawRectangle(this);
    }

    /*
     * Prototype pattern
     */
    @Override
    public Shape clone() {
        return new Rectangle(getX(), getY(), getHeight(), getWidth(), getColor(), isRounded());
    }
}
