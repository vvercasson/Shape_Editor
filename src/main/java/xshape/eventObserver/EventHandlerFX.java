package xshape.eventObserver;

import xshape.renderers.Renderer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import xshape.renderers.FxCanva;

public class EventHandlerFX extends AbstractEventHandler {


    public EventHandlerFX(Renderer renderer) {
        super(renderer, new CanvaObserver(renderer));
    }

    @Override
    public void addMoListener() {

        // CLICKED
        FxCanva._root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleClicked(event);
            }
        });

        // PRESSED
        FxCanva._root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handlePressed(event);
            }
        });

        // DRAGGED
        FxCanva._root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                handleDragged(e);
            }

        });

        // RELEASED
        FxCanva._root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                handleRelease(e);
            }
        });
    }





}
