package xshape.eventObserver;

import javafx.scene.input.MouseButton;
import xshape.renderers.Renderer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import xshape.renderers.FxCanva;

public class EventHandlerFX extends AbstractEventHandler {

    private static final String FX_SHIFT_CLICK_KEYCODE = "SHIFT";
    private static final String FX_CTRL_CLICK_KEYCODE = "CONTROL";

    public EventHandlerFX(Renderer renderer) {
        super(renderer, new CanvaObserver(renderer));
    }

    @Override
    public void addMoListener() {
        // CLICKED
        FxCanva._root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean rightClick = false;
                if (event.getButton() == MouseButton.SECONDARY) {
                    rightClick = true;
                }
                handleClicked(event.getX(), event.getY(), rightClick);
            }
        });

        // PRESSED
        FxCanva._root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handlePressed(event.getX(), event.getY());
            }
        });

        // DRAGGED
        FxCanva._root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                handleDragged(e.getX(), e.getY());
            }

        });

        // RELEASED
        FxCanva._root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                handleRelease(e.getX(), e.getY());
            }
        });

        FxCanva._root.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent e) {
                if (e.getCode().toString().equals(FX_SHIFT_CLICK_KEYCODE)
                        || e.getCode().toString().equals(FX_CTRL_CLICK_KEYCODE))
                    setShiftHold(true);
            }
        });

        FxCanva._root.setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent e) {
                if (e.getCode().toString().equals(FX_SHIFT_CLICK_KEYCODE)
                        || e.getCode().toString().equals(FX_CTRL_CLICK_KEYCODE))
                    setShiftHold(false);
            }
        });
    }
}
