package xshape.eventObserver;

import java.awt.geom.Point2D;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;

public abstract class AbstractEventHandler {
    private Renderer renderer;
    private Observer observer;

    private Point2D originClicked = null;
    private boolean shiftHold = false;

    public AbstractEventHandler(Renderer renderer, Observer observer) {
        this.renderer = renderer;
        this.observer = observer;
    }

    public abstract void addMoListener();

    // *****************HandleClikced************************************************//
    public void handleClicked(double x, double y) {
        // System.out.println("Clicked");
        originClicked = new Point2D.Double(x, y);
        boolean shapeClicked = false;
        if (getShapeClicked() != null) {
            shapeClicked = true;
        }
        // ! DIDNT CLICK ON A SHAPE so we clear
        if (shapeClicked == false) {
            System.out.println("Clearing all selected shapes");
            observer.Unselect();
        }
        renderer.refreshCanva();

    }

    // ***************************************************************************//

    // *****************HandleDragged************************************************//
    public void handleDragged(double x, double y) {
        // System.out.println("Dragged");
        if (renderer.getSelectedShapes() != null) {
            double currentX = x;
            double currentY = y;
            double dx = currentX - originClicked.getX();
            double dy = currentY - originClicked.getY();
            observer.updateShapePosition((int) dx, (int) dy);
            originClicked = new Point2D.Double(currentX, currentY);
        }
        renderer.refreshCanva();
    }
    // ***************************************************************************//

    // *****************HandlePressed************************************************//
    public void handlePressed(double x, double y) {
        originClicked = new Point2D.Double(x, y);
        Shape s;
        // ! Toolbar drag n drop
        if ((s = getShapeClickedToolbar()) != null) {
            System.out.println("Dragging shape from toolbar");
            Shape s2 = s.clone();
            observer.Unselect();
            observer.updateSelectedShape(s2);
            renderer.getShapes().add(s2);
            renderer.refreshCanva();
            return;
        }

        // ! Canva shape pressed
        if ((s = getShapeClicked()) != null) {
            if (renderer.getSelectedShapes().contains(s) && getShiftHold()) {
                System.out.println("Removing shape from select group");
                observer.updateUnselectedShape(s);
            } else if (renderer.getSelectedShapes().contains(s) && !getShiftHold()) {
                System.out.println("Not doing anything");
            } else {
                if (s.belongsTo(originClicked)) {
                    System.out.println("A shape has been clicked");
                    // Shift clicked behavior
                    if (shiftHold) {
                        System.out.println("Adding clicked shape to selected group");
                        observer.updateSelectedShape(s);
                    }
                    // Normal click behavior
                    else {
                        System.out.println("Unselecting all shapes and adding the one clicked");
                        observer.Unselect();
                        observer.updateSelectedShape(s);
                    }

                }
            }
        }
        renderer.refreshCanva();
    }
    // ***************************************************************************//

    // *****************HandleRelease************************************************//
    public void handleRelease(double x, double y) {
        // System.out.println("Release");
        originClicked = new Point2D.Double(x, y);
        // RELEASE ON TRASH
        if (renderer.getShapeToolbar().getTrash().getShape().belongsTo(originClicked)) {
            for (Shape s : renderer.getSelectedShapes()) {
                renderer.deleteShape(s);
            }
        }
        // RELEASE ON TOOLBAR
        else if (renderer.getShapeToolbar().getBackground().belongsTo(originClicked)) {
            if (renderer.getSelectedShapes().size() > 1) {
                ShapeGroup g = new ShapeGroup();
                for (Shape s : renderer.getSelectedShapes()) {
                    System.out.println("More then one shape dropped in toolbar");
                    g.add(s);
                    renderer.getShapeToolbar().addShapeToToolbar(g.resize(150));
                }
            } else {
                System.out.println("Only one shape selected");
                renderer.getShapeToolbar().addShapeToToolbar(renderer.getSelectedShapes().get(0).resize(150));
            }
        }

        renderer.refreshCanva();
    }
    // ***************************************************************************//

    // Methods to limit code above
    public Shape getShapeClicked() {
        for (Shape s : renderer.getShapes()) {
            if (s.belongsTo(originClicked)) {
                return s;
            }
        }
        return null;
    }

    public Shape getShapeClickedToolbar() {
        for (Shape s : renderer.getShapeToolbar().getToolbarShapes()) {
            if (s.belongsTo(originClicked)) {
                return s;
            }
        }
        return null;
    }

    // Shift Hold
    public void setShiftHold(boolean shiftHold) {
        this.shiftHold = shiftHold;
    }

    public boolean getShiftHold() {
        return shiftHold;
    }
}
