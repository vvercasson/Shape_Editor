package xshape.eventObserver;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;

public abstract class AbstractEventHandler {
    private Renderer renderer;
    private Observer observer;

    private Point2D originClicked = null;

    public AbstractEventHandler(Renderer renderer, Observer observer) {
        this.renderer = renderer;
        this.observer = observer;
    }

    public abstract void addMoListener();

    // *****************HandleClikced************************************************//

    // ****************FX version****************************//
    public void handleClicked(javafx.scene.input.MouseEvent e) {
        for (Shape s : renderer.getShapes()) {
            if (s.belongsTo(new Point2D.Double(e.getX(), e.getY()))) {
                observer.updateSelectedShape(s);
                renderer.refreshCanva();
            }
        }
    }

    // ****************AWT version****************************//
    public void handleClicked(java.awt.event.MouseEvent e) {
        for (Shape s : renderer.getShapes()) {
            if (s.belongsTo(e.getPoint())) {
                observer.updateSelectedShape(s);
                renderer.refreshCanva();
            }
        }
    }

    // ***************************************************************************//

    // *****************HandleDragged************************************************//

    // ****************FX version****************************//
    public void handleDragged(javafx.scene.input.MouseEvent e) {
        if (renderer.getShapeSelected() != null) {
            double currentX = e.getX();
            double currentY = e.getY();

            double dx = currentX - originClicked.getX();
            double dy = currentY - originClicked.getY();
            observer.updateShapePosition(renderer.getShapeSelected(), (int) dx, (int) dy);
            originClicked = new Point2D.Double(currentX, currentY);
            renderer.refreshCanva();
        }
    }

    // ****************AWT version****************************//
    public void handleDragged(java.awt.event.MouseEvent e) {
        if (renderer.getShapeSelected() != null) {
            int currentX = e.getX();
            int currentY = e.getY();

            double dx = currentX - originClicked.getX();
            double dy = currentY - originClicked.getY();
            observer.updateShapePosition(renderer.getShapeSelected(), (int) dx, (int) dy);
            originClicked = new Point2D.Double(currentX, currentY);
            renderer.refreshCanva();
            return;
        }
    }

    // ***************************************************************************//

    // *****************HandlePressed************************************************//

    // ****************FX version****************************//
    public void handlePressed(javafx.scene.input.MouseEvent e) {
        originClicked = new Point2D.Double(e.getX(), e.getY());
        for (Shape s : renderer.getShapeToolbar().getToolbarShapes()) {
            if (s.belongsTo(new Point2D.Double(e.getX(), e.getY()))) {
                Shape s2 = s.clone();
                renderer.getShapes().add(s2);
                renderer.setShapeSelected(s2);
                observer.updateSelectedShape(s2);

            }
        }
        for (Shape s : renderer.getShapes()) {
            if (s.belongsTo(new Point2D.Double(e.getX(), e.getY()))) {
                renderer.setShapeSelected(s);
                observer.updateSelectedShape(s);

            }
        }
    }

    // ****************AWT version****************************//
    public void handlePressed(java.awt.event.MouseEvent e) {
        originClicked = new Point2D.Double(e.getX(), e.getY());
        for (Shape s : renderer.getShapeToolbar().getToolbarShapes()) {
            if (s.belongsTo(new Point2D.Double(e.getX(), e.getY()))) {
                Shape s2 = s.clone();
                renderer.getShapes().add(s2);
                renderer.setShapeSelected(s2);
                observer.updateSelectedShape(s2);
            }
        }
        for (Shape s : renderer.getShapes()) {
            if (s.belongsTo(new Point2D.Double(e.getX(), e.getY()))) {
                renderer.setShapeSelected(s);
                observer.updateSelectedShape(s);

            }
        }
    }
    // ***************************************************************************//

    // *****************HandleRelease************************************************//

    // ****************FX version****************************//
    public void handleRelease(javafx.scene.input.MouseEvent e) {
        if (renderer.getShapeToolbar().getTrash().getShape().belongsTo(new Point2D.Double(e.getX(), e.getY()))) {
            renderer.deleteShape(renderer.getShapeSelected());
        }
        renderer.setShapeSelected(null);
        renderer.refreshCanva();
    }

    // ****************AWT version****************************//
    public void handleRelease(java.awt.event.MouseEvent e) {
        if (renderer.getShapeToolbar().getTrash().getShape().belongsTo(e.getPoint())) {
            renderer.deleteShape(renderer.getShapeSelected());
        }
        renderer.setShapeSelected(null);
        renderer.refreshCanva();
    }

    // ***************************************************************************//

}
