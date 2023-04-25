package xshape.eventObserver;

import javafx.scene.input.MouseButton;
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

                if(event.getButton() == MouseButton.SECONDARY && !(EventHandlerFX.super.getRenderer().getSelectedShapes().isEmpty())){
                    EventHandlerFX.super.getRenderer().createContextMenu();
                }
                else{
                    handleClicked(event.getX(),event.getY());
                }
            }
        });

        // PRESSED
        FxCanva._root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handlePressed(event.getX(),event.getY());
            }
        });

        // DRAGGED
        FxCanva._root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                handleDragged(e.getX(),e.getY());
            }

        });

        // RELEASED
        FxCanva._root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                handleRelease(e.getX(),e.getY());
            }
        });
    }



}
