package xshape.renderers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import xshape.shapes.Rectangle;

public class FxRenderer extends Renderer {
    /*
     * JavaFX specific attributes
     */
    private GraphicsContext _gc;
    private Canvas _canvas;

    /*
     * Constructor
     */
    public FxRenderer() {
        _canvas = new Canvas(500, 500);
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
    public void drawLine(Point2D start, Point2D end) {
        _gc.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

    @Override
    public void drawRectangle(Rectangle r) {
        _gc.fillRect(r.getPos().getX(), r.getPos().getY(), r.getSize().getX(),
                r.getSize().getY());
    }

    @Override
    public void drawText(Point2D pos, String text) {
        _gc.fillText(text, pos.getX(), pos.getY());
    }

    @Override
    public void drawPolygon(ArrayList<Point2D> points) {
        double[] xPoints = new double[points.size()];
        double[] yPoints = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = points.get(i).getX();
            yPoints[i] = points.get(i).getY();
        }
        _gc.fillPolygon(xPoints, yPoints, points.size());
    }

}
