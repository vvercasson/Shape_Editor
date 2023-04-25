package xshape.eventObserver;

import xshape.renderers.AwtCanva;
import xshape.renderers.Renderer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EventHandlerAWT extends AbstractEventHandler implements MouseMotionListener, MouseListener {

    private AwtCanva canva;

    public EventHandlerAWT(Renderer renderer, AwtCanva canva) {
        super(renderer, new CanvaObserver(renderer));
        this.canva = canva;
    }

    @Override
    public void addMoListener() {
        canva.addMouseListener(this);
        canva.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3 && (EventHandlerAWT.super.getRenderer().getShapeSelected() != null)){
            EventHandlerAWT.super.getRenderer().createContextMenu();
        }
        else{
            handleClicked(e.getX(),e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        handlePressed(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        handleRelease(e.getX(),e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        handleDragged(e.getX(),e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }
}
