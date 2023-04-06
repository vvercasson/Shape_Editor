package xshape.renderers;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import xshape.shapes.Polygon;
import xshape.shapes.Rectangle;
import xshape.toolbar.Trash;
import xshape.utils.MyColor;

import javax.imageio.ImageIO;
import javax.swing.*;

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
        FxCanva._root.getChildren().add(_canvas);
        draw();
        FxCanva.launch(FxCanva.class);
    }

    /*
     * Drawing methods
     */

    @Override
    public void drawRectangle(Rectangle r) {
        ArrayList<Point2D> points = r.getPoints();
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = (int) points.get(i).getX();
            yPoints[i] = (int) points.get(i).getY();
        }
        _gc.setFill(r.getColor().toFx());
        if (!r.isRounded())
            _gc.fillRect(xPoints[0], yPoints[0], xPoints[2], yPoints[2]);
        else
            _gc.fillRoundRect(xPoints[0], yPoints[0], xPoints[2], yPoints[2], 10, 10);
    }

    @Override
    public void drawText(Point2D pos, String text, MyColor c) {
        _gc.setFill(c.toFx());
        _gc.fillText(text, pos.getX(), pos.getY());
    }

    @Override
    public void drawTrashToolBar(Trash t){
        double width = 40;
        double height = 50;

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
        if (!p.isRounded()) {
            for (int i = 0; i < points.size(); i++) {
                xPoints[i] = points.get(i).getX();
                yPoints[i] = points.get(i).getY();
            }
            _gc.setFill(p.getColor().toFx());
            _gc.fillPolygon(xPoints, yPoints, points.size());
        } else {
            double centerX = p.getRotationCenter().getX();
            double centerY = p.getRotationCenter().getY();
            double radius = 80;
            double angle = Math.PI / 6; // 30 degrees
            double offset = Math.PI / 2; // 90 degrees
            for (int i = 0; i < p.getNbPoints(); i++) {
                double x = centerX + radius * Math.cos(i * angle + offset);
                double y = centerY + radius * Math.sin(i * angle + offset);
                xPoints[i] = x;
                yPoints[i] = y;
            }
            _gc.setFill(p.getColor().toFx());
            _gc.fillPolygon(xPoints, yPoints, p.getNbPoints());
        }

    }

    @Override
    public void drawLine(Point2D start, Point2D end, MyColor c) {
        _gc.setStroke(c.toFx());
        _gc.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

}
