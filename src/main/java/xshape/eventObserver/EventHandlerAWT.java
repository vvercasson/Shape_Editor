package xshape.eventObserver;

import xshape.renderers.AwtCanva;
import xshape.renderers.Renderer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EventHandlerAWT extends AbstractEventHandler implements MouseMotionListener, MouseListener {

    private Renderer renderer;
    private AwtCanva canva;

    public EventHandlerAWT(Renderer renderer, AwtCanva canva) {
        super(renderer, new CanvaObserver(renderer));
        this.renderer = renderer;
        this.canva = canva;
    }

    @Override
    public void addMoListener() {
        canva.addMouseListener(this);
        canva.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        handleClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        handlePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        renderer.setShapeSelected(null);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        handleDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }
}
