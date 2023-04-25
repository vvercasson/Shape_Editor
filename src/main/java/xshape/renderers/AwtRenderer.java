package xshape.renderers;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.toolbar.AbstractSCMenu;
import xshape.toolbar.ButtonToolBar;
import xshape.toolbar.ShapeContextMenuAWT;
import xshape.toolbar.Trash;
import xshape.utils.MyColor;


public class AwtRenderer extends Renderer {

    /*
     * Attributes
     */
    private AwtCanva canva;

    private ShapeContextMenuAWT _contextMenu;

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
    }

    /*
     * Drawing methods
     */

    @Override
    public void refreshCanva() {
        canva.repaint();
    }

    @Override
    public void createContextMenu() {
        if (_contextMenu!= null)
            _contextMenu.getMenu().setVisible(false);

        _contextMenu = new ShapeContextMenuAWT();

        _contextMenu.showMenu(canva,this);
    }

    @Override
    public AbstractSCMenu get_contextMenu() {
        return _contextMenu;
    }

    @Override
    public void drawText(Point2D pos, String text, MyColor c) {
        AwtApp.instance().graphics().setColor(c.toAwt());
        AwtApp.instance().graphics().drawString(text, (int) pos.getX(), (int) pos.getY());
    }

    @Override
    public void drawTrashToolBar(Trash t) {
        int width = t.getWidth();
        int height = t.getHeight();

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
        drawPolygon(r);
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

    // ! TO DELETE
    public void drawButtonToolBar(ButtonToolBar bar, String nameButton) {

        Graphics g = AwtApp.instance().graphics();

        g.setColor(MyColor.GRAY.toAwt());
        g.fillRect((int) bar.getNewPos(), 0, 50, 25);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        g2d.draw(new Rectangle2D.Double(bar.getNewPos(), 0, 50, 25));

        // Draw the label for the button
        g.setColor(MyColor.WHITE.toAwt());
        g.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g.drawString(nameButton, (int) (bar.getNewPos() + 10), 16);
        bar.setNewPos(bar.getNewPos() + 60);
    }

    public AwtCanva getCanva() {
        return canva;
    }
}
