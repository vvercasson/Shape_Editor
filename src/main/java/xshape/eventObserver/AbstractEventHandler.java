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
    public void handleClicked(double x, double y) {
        Point2D point = new Point2D.Double(x, y);
        Shape selected = renderer.getShapeSelected();
        if (selected != null && !selected.belongsTo(point)) {
            observer.Unselect();
        }
        for (Shape s : renderer.getShapes()) {
            if (s.belongsTo(point)) {
                observer.updateSelectedShape(s);
                break;
            }
        }
        renderer.refreshCanva();
    }
    // ***************************************************************************//

    // *****************HandleDragged************************************************//
    public void handleDragged(double x, double y) {
        if (renderer.getShapeSelected() != null) {
            double currentX = x;
            double currentY = y;
            double dx = currentX - originClicked.getX();
            double dy = currentY - originClicked.getY();
            observer.updateShapePosition(renderer.getShapeSelected(), (int) dx, (int) dy);
            originClicked = new Point2D.Double(currentX, currentY);
        }
        renderer.refreshCanva();
    }
    // ***************************************************************************//

    // *****************HandlePressed************************************************//
    public void handlePressed(double x, double y) {
        originClicked = new Point2D.Double(x, y);
        for (Shape s : renderer.getShapeToolbar().getToolbarShapes()) {
            if (s.belongsTo(originClicked)) {
                Shape s2 = s.clone();
                renderer.getShapes().add(s2);
                renderer.setShapeSelected(s2);
                observer.updateSelectedShape(s2);

            }
        }
        for (Shape s : renderer.getShapes()) {
            if (s.belongsTo(originClicked)) {
                renderer.setShapeSelected(s);
                observer.updateSelectedShape(s);

            }
        }
        renderer.refreshCanva();
    }
    // ***************************************************************************//

    // *****************HandleRelease************************************************//
    public void handleRelease(double x, double y) {
        originClicked = null;
        Point2D point = new Point2D.Double(x, y);
        if (renderer.getShapeToolbar().getTrash().getShape().belongsTo(point)) {
            renderer.deleteShape(renderer.getShapeSelected());
        } else if (renderer.getShapeToolbar().getBackground().belongsTo(point)) {
            Shape s = renderer.getShapeSelected();
            renderer.getShapeToolbar().addShapeToToolbar(s.resize(150));
        }
        renderer.refreshCanva();
    }
    // ***************************************************************************//
    public Renderer getRenderer() {
        return renderer;
    }

}
