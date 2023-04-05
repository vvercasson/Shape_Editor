package xshape.renderers;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.utils.MyColor;

public class AwtRenderer extends Renderer {
    /*
     * Attributes
     */

    /*
     * Constructors
     */
    public AwtRenderer(int width, int height) {
        super(width, height);
    }

    /*
     * Run function
     */
    @Override
    public void run() {
        AwtCanva jc = new AwtCanva(this);
        jc.setBackground(MyColor.WHITE.toAwt());
        jc.setPreferredSize(new Dimension(getWidth(), getHeight()));
        AwtGUIHelper.showOnFrame(jc, "XShape Swing/AWT Rendering");
    }

    /*
     * Drawing methods
     */

    @Override
    public void drawText(Point2D pos, String text, MyColor c) {
        AwtApp.instance().graphics().setColor(c.toAwt());
        AwtApp.instance().graphics().drawString(text, (int) pos.getX(), (int) pos.getY());
    }

    @Override
    public void drawTrashToolBar(Point2D pos){
        int width = 40;
        int height = 50;

        // trash body
        AwtApp.instance().graphics().setColor(MyColor.BLACK.toAwt());
        AwtApp.instance().graphics().fillRect((int)pos.getX(),(int) pos.getY(), width, height);

        // top of the trash
        AwtApp.instance().graphics().setColor(MyColor.BLACK.toAwt());
        AwtApp.instance().graphics().fillRect((int) pos.getX() + 5, (int) pos.getY() - 10, width - 10, 10);

        AwtApp.instance().graphics().setColor(MyColor.WHITE.toAwt());
        AwtApp.instance().graphics().fillRect((int) pos.getX(),(int) pos.getY(), width, 5);

        // wheels of trash
        AwtApp.instance().graphics().setColor(MyColor.WHITE.toAwt());
        AwtApp.instance().graphics().fillOval((int) pos.getX() + 5,(int) pos.getY() + height - 15, 10, 10);
        AwtApp.instance().graphics().fillOval((int) pos.getX() + width - 15,(int) pos.getY() + height - 15, 10, 10);
    }

    @Override
    public void drawRectangle(Rectangle r) {
        // je suis stupide numero 2
        ArrayList<Point2D> points = r.getPoints();
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = (int) points.get(i).getX();
            yPoints[i] = (int) points.get(i).getY();
        }
        AwtApp.instance().graphics().setColor(r.getColor().toAwt());
        if (!r.isRounded())
            AwtApp.instance().graphics().fillRect(xPoints[0], yPoints[0], xPoints[2], yPoints[2]);
        else
            AwtApp.instance().graphics().fillRoundRect(xPoints[0], yPoints[0], xPoints[2], yPoints[2], 10, 10);
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

    @Override
    public void drawLine(Point2D start, Point2D end, MyColor c) {
        AwtApp.instance().graphics().setColor(c.toAwt());
        AwtApp.instance().graphics().drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(),
                (int) end.getY());
    }
}
