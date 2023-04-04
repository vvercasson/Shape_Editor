package xshape.renderers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;

public class AwtRenderer extends Renderer {
    /*
     * Run function
     */
    @Override
    public void run() {
        JCanvas jc = new JCanvas(this);
        jc.setBackground(Color.WHITE);
        jc.setPreferredSize(new Dimension(500, 500));
        GUIHelper.showOnFrame(jc, "XShape Swing/AWT Rendering");
    }

    /*
     * Drawing methods
     */
    @Override
    public void drawLine(Point2D start, Point2D end) {
        AwtApp.instance().graphics().drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(),
                (int) end.getY());
    }

    @Override
    public void drawRectangle(Rectangle r) {
        ArrayList<Point2D> points = r.getPoints();
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = (int) points.get(i).getX();
            yPoints[i] = (int) points.get(i).getY();
        }
        AwtApp.instance().graphics().setColor(r.getColor().toAwt());
        AwtApp.instance().graphics().fillPolygon(xPoints, yPoints, points.size());
    }

    @Override
    public void drawPolygon(Polygon p) {
        ArrayList<Point2D> points = p.getPoints();
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = (int) points.get(i).getX();
            yPoints[i] = (int) points.get(i).getY();
        }
        AwtApp.instance().graphics().setColor(p.getColor().toAwt());
        AwtApp.instance().graphics().fillPolygon(xPoints, yPoints, points.size());
    }
}
