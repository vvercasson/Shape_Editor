package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import xshape.eventObserver.*;
import javafx.scene.text.Font;
import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.toolbar.ButtonToolBar;
import xshape.toolbar.ShapeContextMenuFX;
import xshape.toolbar.Trash;
import xshape.utils.MyColor;

public class FxRenderer extends Renderer {
    /*
     * JavaFX specific attributes
     */
    private GraphicsContext _gc;
    private Canvas _canvas;
    private ShapeContextMenuFX _contextMenu;

    /*
     * Constructor
     */
    public FxRenderer(int width, int height) {
        super(width, height);
        _canvas = new Canvas(getWidth(), getHeight());
        _gc = _canvas.getGraphicsContext2D();
        _canvas.setFocusTraversable(true);
    }

    @Override
    public void run() {
        FxCanva._root.getChildren().add(_canvas);
        draw();
        EventHandlerFX eventHandler = new EventHandlerFX(this);
        eventHandler.addMoListener();
        FxCanva.launch(FxCanva.class);
        // *********Ne rien faire ici********* //
    }

    /*
     * Drawing methods
     */

    @Override
    public void refreshCanva() {
        _gc.clearRect(0, 0, _canvas.getWidth(), _canvas.getHeight());
        draw();
    }


    @Override
    public void drawRectangle(Rectangle r) {
        drawPolygon(r);
    }

    @Override
    public void drawText(Point2D pos, String text, MyColor c) {
        _gc.setFill(c.toFx());
        _gc.fillText(text, pos.getX(), pos.getY());
    }

    @Override
    public void drawTrashToolBar(Trash t) {
        double width = t.getWidth();
        double height = t.getHeight();

        // trash body
        _gc.setFill(MyColor.BLACK.toFx());
        _gc.fillRect(t.get_pos().getX(), t.get_pos().getY(), width, height);

        // top of the trash
        _gc.setFill(MyColor.BLACK.toFx());
        _gc.fillRect(t.get_pos().getX() + 5, t.get_pos().getY() - 10, width - 10, 10);

        _gc.setFill(MyColor.WHITE.toFx());
        _gc.fillRect(t.get_pos().getX(), t.get_pos().getY(), width, 5);

        // wheels of trash
        _gc.setFill(MyColor.WHITE.toFx());
        _gc.fillOval(t.get_pos().getX() + 5, t.get_pos().getY() + height - 15, 10, 10);
        _gc.fillOval(t.get_pos().getX() + width - 15, t.get_pos().getY() + height - 15, 10, 10);
    }

    @Override
    public void drawPolygon(Polygon p) {
        ArrayList<Point2D> points = p.getPoints();
        double[] xPoints = new double[points.size()];
        double[] yPoints = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = points.get(i).getX();
            yPoints[i] = points.get(i).getY();
        }
        _gc.setFill(p.getColor().toFx());
        _gc.fillPolygon(xPoints, yPoints, points.size());

    }

    @Override
    public void drawLine(Point2D start, Point2D end, MyColor c) {
        _gc.setStroke(c.toFx());
        _gc.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

    // ! TO DELETE
    public void drawButtonToolBar(ButtonToolBar bar, String nameButton) {
        _gc.setFill(MyColor.GRAY.toFx());
        _gc.setStroke(MyColor.BLACK.toFx());
        _gc.fillRect(bar.getNewPos(), 0, 50, 25);
        _gc.strokeRect(bar.getNewPos(), 0, 50, 25);

        // Draw the label for the button
        _gc.setFill(MyColor.WHITE.toFx());
        _gc.setFont(new Font(12));
        _gc.fillText(nameButton, bar.getNewPos() + 10, 16);
        bar.setNewPos(bar.getNewPos() + 60);
    }

    @Override
    public void createContextMenu(Observer observer,boolean rightClick){

        _contextMenu = new ShapeContextMenuFX();

        _contextMenu.showMenu(_canvas,this,observer);
    }

    @Override
    public void hideMenu() {
        if (_contextMenu!= null)
            _contextMenu.getMenu().hide();
    }


}
