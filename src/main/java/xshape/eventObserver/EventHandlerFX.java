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

    public EventHandlerFX(Renderer renderer, Canvas canva) {
        this.renderer = renderer;
        observer = new CanvaObserver(renderer);
        this.canva = canva;
    }

    @Override
    public void updateCanva() {
        canva.getGraphicsContext2D().clearRect(0, 0, canva.getWidth(), canva.getHeight());
        renderer.draw();
    }

    @Override
    public void addMoListener() {
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
    }

}
