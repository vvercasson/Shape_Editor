package xshape.renderers;

import xshape.eventObserver.CanvaObserver;
import xshape.eventObserver.EventHandler;

import javax.swing.*;
import java.awt.*;

public class AwtCanva extends JPanel {
    private Renderer _r = null;
    private CanvaObserver observer;

    public AwtCanva(Renderer r) {
        _r = r;
        observer = new CanvaObserver(_r);
        EventHandler eventHandler= new EventHandler(_r,observer);
        addMouseListener(eventHandler);
    }

    public void paint(Graphics g) {
        super.paint(g);
        AwtApp.instance().graphics(g);
        _r.draw();
    }

}