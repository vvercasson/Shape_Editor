package xshape.eventObserver;

import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;


import javafx.event.EventHandler;
import java.awt.geom.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import xshape.renderers.FxCanva;

public class EventHandlerFX implements EventHandlerInterface{

    private Observer observer;
    private Renderer renderer;
    private Canvas canva;

    public EventHandlerFX(Renderer renderer, Observer observer, Canvas canva){
        this.renderer = renderer;
        this.observer = observer;
        this.canva = canva;
    }

    @Override
    public void addMoListener() {
        FxCanva._root.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (Shape s:
                renderer.getShapes()) {
                    System.out.println("s pos  :" + s.getPos() );
                    if(s.belongsTo(new Point2D.Double(event.getX(), event.getY()))){
                        observer.updateShapeColor(s, MyColor.ORANGE);
                        System.out.println("test");
                        canva.getGraphicsContext2D().clearRect(0, 0, canva.getWidth(), canva.getHeight());
                        renderer.draw();
                    }
                }
            }
        });
    }
    
}
