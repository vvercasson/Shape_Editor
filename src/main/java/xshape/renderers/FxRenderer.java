package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.utils.MyColor;

public class FxRenderer extends Renderer {
    /*
     * JavaFX specific attributes
     */
    private GraphicsContext _gc;
    private Canvas _canvas;

    /*
     * Constructor
     */
    public FxRenderer(int width, int height) {
        super(width, height);
        _canvas = new Canvas(getWidth(), getHeight());
        _gc = _canvas.getGraphicsContext2D();
    }

    @Override
    public void run() {
        FxApp._root.getChildren().add(_canvas);
        draw();
        FxApp.launch(FxApp.class);
    }

    /*
     * Drawing methods
     */

    @Override
    public void drawRectangle(Rectangle r) {
        double[] xPoints = new double[r.getPoints().size()];
        double[] yPoints = new double[r.getPoints().size()];
        for (int i = 0; i < r.getPoints().size(); i++) {
            xPoints[i] = r.getPoints().get(i).getX();
            yPoints[i] = r.getPoints().get(i).getY();
        }
        _gc.setFill(r.getColor().toFx());
        _gc.fillPolygon(xPoints, yPoints, 4);
    }

    @Override
    public void drawText(Point2D pos, String text, MyColor c) {
        _gc.setFill(c.toFx());
        _gc.fillText(text, pos.getX(), pos.getY());
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

}
