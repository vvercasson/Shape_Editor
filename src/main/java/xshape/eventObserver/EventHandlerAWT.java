package xshape.eventObserver;

import xshape.renderers.AwtCanva;
import xshape.renderers.Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EventHandlerAWT extends AbstractEventHandler implements MouseMotionListener, MouseListener, KeyListener {

    private AwtCanva canva;
    private static final int AWT_SHIFT_CLICK_KEYCODE = 16;
    private static final int AWT_CTRL_CLICK_KEYCODE = 17;

    public EventHandlerAWT(Renderer renderer, AwtCanva canva) {
        super(renderer, new CanvaObserver(renderer));
        this.canva = canva;
    }

    @Override
    public void addMoListener() {
        canva.addMouseListener(this);
        canva.addMouseMotionListener(this);
        canva.addKeyListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean rightClick = false;
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightClick = true;
        }
        handleClicked(e.getX(), e.getY(), rightClick);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        handlePressed(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        handleRelease(e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        handleDragged(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

    // KEY LISTENER
    @Override
    public void keyPressed(KeyEvent k) {
        if (k.getKeyCode() == AWT_SHIFT_CLICK_KEYCODE || k.getKeyCode() == AWT_CTRL_CLICK_KEYCODE)
            setShiftHold(true);
    }

    @Override
    public void keyReleased(KeyEvent k) {
        if (k.getKeyCode() == AWT_SHIFT_CLICK_KEYCODE || k.getKeyCode() == AWT_CTRL_CLICK_KEYCODE)
            setShiftHold(false);
    }

    @Override
    public void keyTyped(KeyEvent k) {
    }
}
