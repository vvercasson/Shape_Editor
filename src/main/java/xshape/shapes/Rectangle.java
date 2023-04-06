package xshape.shapes;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.renderers.Renderer;
import xshape.utils.MyColor;

public class Rectangle extends Polygon {
    /*
     * Constructors
     */
    public Rectangle(double posX, double posY, double height, double width) {
        super(new Point2D.Double(posX, posY), 4, new ArrayList<Point2D>() {
            {
                add(new Point2D.Double(posX, posY));
                add(new Point2D.Double(posX + width, posY));
                add(new Point2D.Double(posX + width, posY + height));
                add(new Point2D.Double(posX, posY + height));
            }
        });
    }

    public Rectangle(double posX, double posY, double height, double width, MyColor c) {
        super(new Point2D.Double(posX, posY), 4, new ArrayList<Point2D>() {
            {
                add(new Point2D.Double(posX, posY));
                add(new Point2D.Double(posX + width, posY));
                add(new Point2D.Double(posX + width, posY + height));
                add(new Point2D.Double(posX, posY + height));
            }
        }, c);
    }

    public Rectangle(double posX, double posY, double height, double width, MyColor c, boolean rounded) {
        super(new Point2D.Double(posX, posY), 4, new ArrayList<Point2D>() {
            {
                add(new Point2D.Double(posX, posY));
                add(new Point2D.Double(posX + width, posY));
                add(new Point2D.Double(posX + width, posY + height));
                add(new Point2D.Double(posX, posY + height));
            }
        }, c, rounded);
    }

    /*
     * Getters
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

    /*
     * Methods
     */
    @Override
    public Shape translate(Point2D vec) {
        getPos().setLocation(getPos().getX() + vec.getX(),
                getPos().getY() + vec.getY());
        return this;
    }

    @Override
    public Shape rotate(double angle) {
        super.rotate(angle);
        return this;
    }

    @Override
    public void drawInCanva(Renderer r) {
        r.drawRectangle(this);
    }
}
