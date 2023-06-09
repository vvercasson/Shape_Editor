package xshape.eventObserver;

import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import xshape.toolbar.Button;
import xshape.command.AddShapeCommand;
import xshape.command.AddShapeToToolbarCommand;
import xshape.command.DeleteShapeCommand;
import xshape.command.Invoker;
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
    public void handleClicked(double x, double y, boolean rightClick) {
        // System.out.println("Clicked");
        originClicked = new Point2D.Double(x, y);
        boolean shapeClicked = false;
        if (getShapeClicked() != null) {
            shapeClicked = true;
        }

        Button b;
        if ((b = getButtonClicked()) != null) {
            switch (b.getLabel()) {
                case "Load":
                    loadCase();
                    break;
                case "Save":
                    saveCase();
                    break;
                case "Undo":
                    Invoker.getInstance().undo();
                    break;
                case "Redo":
                    Invoker.getInstance().redo();
                    break;
                default:
                    break;
            }
        }

        if (rightClick && !getRenderer().getSelectedShapes().isEmpty()) {
            System.out.println("Right click");
            if (shapeClicked) {
                getRenderer().createContextMenu(observer, rightClick);
            }
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
        renderer.hideMenu();
        originClicked = new Point2D.Double(x, y);
        Shape s;
        // ! Toolbar drag n drop
        if ((s = getShapeClickedToolbar()) != null) {
            System.out.println("Dragging shape from toolbar");
            renderer.setSelectedToolBarShape(s);
            Shape s2 = s.clone();
            observer.Unselect();
            observer.updateSelectedShape(s2);
            AddShapeCommand addShapeCommand = new AddShapeCommand(renderer, s2);
            Invoker.getInstance().apply(addShapeCommand);
            return;
        }

        // ! Canva shape pressed
        if ((s = getShapeClicked()) != null) {
            renderer.setSelectedToolBarShape(null);
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
                DeleteShapeCommand deleteShapeCommand = new DeleteShapeCommand(renderer, s);
                Invoker.getInstance().apply(deleteShapeCommand);
            }
            if (renderer.getSelectedToolBarShape() != null) {
                renderer.getShapeToolbar().getToolbarShapes().remove(renderer.getSelectedToolBarShape());
                renderer.getShapeToolbar().removedShapeFromToolbar();
                refreshToolBarSave();
            }
        }
        // RELEASE ON TOOLBAR
        else if (renderer.getShapeToolbar().getBackground().belongsTo(originClicked)) {
            if (renderer.getSelectedToolBarShape() == null) {
                if (renderer.getSelectedShapes().size() > 1) {
                    ShapeGroup g = new ShapeGroup();
                    for (Shape s : renderer.getSelectedShapes()) {
                        System.out.println("More then one shape dropped in toolbar");
                        g.add(s);
                    }
                    AddShapeToToolbarCommand addShapeToToolbarCommand = new AddShapeToToolbarCommand(renderer, g);
                    Invoker.getInstance().apply(addShapeToToolbarCommand);
                    refreshToolBarSave();
                } else {
                    System.out.println("Only one shape selected");
                    AddShapeToToolbarCommand addShapeToToolbarCommand = new AddShapeToToolbarCommand(renderer,
                            renderer.getSelectedShapes().get(0));
                    Invoker.getInstance().apply(addShapeToToolbarCommand);
                    renderer.getShapes().remove(renderer.getSelectedShapes().get(0));
                    refreshToolBarSave();

                }
            } else if (renderer.getSelectedToolBarShape() != null) {
                renderer.getShapes().remove(renderer.getSelectedShapes().get(0));
            }
            observer.updateUnselectedShape(renderer.getSelectedShapes().get(0));
        }
        renderer.refreshCanva();
    }

    // ***************************************************************************//
    public Renderer getRenderer() {
        return renderer;
    }

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

    public Button getButtonClicked() {
        for (Button b : renderer.getButtonToolBar().getButtons()) {
            if (b.getBackground().belongsTo(originClicked)) {
                return b;
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

    /*************************
     * Gestion des Load et Save
     *******************************************/

    public void loadCase() {
        String fileNameLoad;
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileNameLoad = fileChooser.getSelectedFile().getAbsolutePath();
        } else
            return;
        try {
            ArrayList<Shape> saveShapes = new ArrayList<>();
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileNameLoad));
            saveShapes = (ArrayList<Shape>) is.readObject();
            /*
             * if(saveShapes!=null){
             * System.out.println("il existe");
             * }
             */
            is.close();
            renderer.setShapes(saveShapes);
        } catch (Exception e) {
            System.out.println("Problème avec le Load");
        }
    }

    public void saveCase() {
        String fileNameSave;
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileNameSave = fileChooser.getSelectedFile().getAbsolutePath();
        } else
            return;
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileNameSave));
            observer.Unselect();
            os.writeObject(renderer.getShapes());
            os.close();
        } catch (Exception e) {
            System.out.println("Problème avec le Save");
        }
        System.out.println("done saving");
    }

    public void refreshToolBarSave() {
        String fileToolbarSave = "./saveTollBar.bin";
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileToolbarSave));
            os.writeObject(renderer.getShapeToolbar().getToolbarShapes());
            os.close();
            System.out.println("ShapeToolBar saved");
        } catch (Exception e) {
            System.out.println("Problème avec le Save toolbar");
        }
    }
}
