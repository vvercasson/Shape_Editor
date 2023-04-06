package xshape.eventObserver;

import xshape.renderers.AwtApp;
import xshape.renderers.AwtCanva;
import xshape.renderers.AwtRenderer;
import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventHandler implements MouseListener {

    private Renderer renderer;
    private Observer observer;

    public EventHandler(Renderer renderer, Observer observer) {
        this.renderer = renderer;
        this.observer = observer;
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
