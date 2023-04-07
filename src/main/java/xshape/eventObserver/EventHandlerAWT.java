package xshape.eventObserver;

import xshape.renderers.AwtCanva;
import xshape.renderers.AwtRenderer;
import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventHandlerAWT implements MouseListener,EventHandlerInterface {

    private Renderer renderer;
    private Observer observer;
    private AwtCanva canva;

    public EventHandlerAWT(Renderer renderer, Observer observer, AwtCanva canva) {
        this.renderer = renderer;
        this.observer = observer;
        this.canva = canva;
    }

    @Override
    public void addMoListener(){
        canva.addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        for (Shape s:
                renderer.getShapes()) {
                    System.out.println("s pos  :" + s.getPos() );
            if(s.belongsTo(e.getPoint())){
                observer.updateShapeColor(s, MyColor.ORANGE);
                if(renderer instanceof AwtRenderer){
                    ((AwtRenderer) renderer).getCanva().repaint();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
