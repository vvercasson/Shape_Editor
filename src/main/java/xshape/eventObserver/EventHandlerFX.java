package xshape.eventObserver;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;

import javafx.event.EventHandler;
import java.awt.geom.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import xshape.renderers.FxCanva;

public class EventHandlerFX implements EventHandlerInterface {

    private Observer observer;
    private Renderer renderer;
    private Canvas canva;

    public EventHandlerFX(Renderer renderer, Observer observer, Canvas canva) {
        this.renderer = renderer;
        this.observer = observer;
        this.canva = canva;
    }

    @Override
    public void updateCanva() {
        canva.getGraphicsContext2D().clearRect(0, 0, canva.getWidth(), canva.getHeight());
        renderer.draw();
    }

    @Override
    public void addMoListener() {

        // CLICKED
        FxCanva._root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (Shape s : renderer.getShapes()) {
                    if (s.belongsTo(new Point2D.Double(event.getX(), event.getY()))) {
                        observer.updateSelectedShape(s);
                        updateCanva();
                    }
                }
            }
        });

        // PRESSED
        FxCanva._root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Fx mouse pressed");
                for (Shape s : renderer.getShapeToolbar().getToolbarShapes()) {
                    if (s.belongsTo(new Point2D.Double(event.getX(), event.getY()))) {
                        Shape s2 = s.clone();
                        renderer.getShapes().add(s2);
                        renderer.setShapeSelected(s2);
                    }
                }
                for (Shape s : renderer.getShapes()) {
                    if (s.belongsTo(new Point2D.Double(event.getX(), event.getY()))) {
                        renderer.setShapeSelected(s);
                    }
                }
            }
        });

        // DRAGGED
        FxCanva._root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Fx mouse dragged");
                if (renderer.getShapeSelected() != null) {
                    observer.updateShapePosition(renderer.getShapeSelected(), e.getX(), e.getY());
                    updateCanva();
                }
            }

        });

        // RELEASED
        FxCanva._root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Fx mouse released");
                renderer.setShapeSelected(null);
            }
        });
    }

}
