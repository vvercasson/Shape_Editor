package xshape.renderers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;

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
        AwtApp.instance().graphics().fillRect((int) r.getPos().getX(), (int) r.getPos().getY(),
                (int) r.getSize().getX(),
                (int) r.getSize().getY());
    }
}
