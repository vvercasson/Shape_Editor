package xshape.renderers;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.toolbar.Trash;
import xshape.utils.MyColor;

public class AwtRenderer extends Renderer {

    /*
     * Attributes
     */
    private AwtCanva canva;

    /*
     * Constructors
     */
    public AwtRenderer(int width, int height) {
        super(width, height);
        canva = new AwtCanva(this);
    }

    /*
     * Run function
     */
    @Override
    public void run() {
        canva.setBackground(MyColor.WHITE.toAwt());
        canva.setPreferredSize(new Dimension(getWidth(), getHeight()));
        AwtGUIHelper.showOnFrame(canva, "XShape Swing/AWT Rendering");
        super.draw();
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
    public void drawTrashToolBar(Trash t) {
        int width = 40;
        int height = 50;

        // trash body
        AwtApp.instance().graphics().setColor(MyColor.BLACK.toAwt());
        AwtApp.instance().graphics().fillRect((int) t.get_pos().getX(), (int) t.get_pos().getY(), width, height);

        // top of the trash
        AwtApp.instance().graphics().setColor(MyColor.BLACK.toAwt());
        AwtApp.instance().graphics().fillRect((int) t.get_pos().getX() + 5, (int) t.get_pos().getY() - 10, width - 10,
                10);

        AwtApp.instance().graphics().setColor(MyColor.WHITE.toAwt());
        AwtApp.instance().graphics().fillRect((int) t.get_pos().getX(), (int) t.get_pos().getY(), width, 5);

        // wheels of trash
        AwtApp.instance().graphics().setColor(MyColor.WHITE.toAwt());
        AwtApp.instance().graphics().fillOval((int) t.get_pos().getX() + 5, (int) t.get_pos().getY() + height - 15, 10,
                10);
        AwtApp.instance().graphics().fillOval((int) t.get_pos().getX() + width - 15,
                (int) t.get_pos().getY() + height - 15, 10, 10);
    }

    @Override
    public void drawRectangle(Rectangle r) {
        int x = (int) r.getX();
        int y = (int) r.getY();
        int width = (int) r.getWidth();
        int height = (int) r.getHeight();
        AwtApp.instance().graphics().setColor(r.getColor().toAwt());
        if (!r.isRounded())
            AwtApp.instance().graphics().fillRect(x, y, width, height);
        else
            AwtApp.instance().graphics().fillRoundRect(x, y, width, height, 10, 10);
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
    public AwtCanva getCanva() {
        return canva;
    }
}
