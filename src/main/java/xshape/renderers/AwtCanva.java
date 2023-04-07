package xshape.renderers;

import xshape.eventObserver.CanvaObserver;
import xshape.eventObserver.*;

import javax.swing.*;
import java.awt.*;

public class AwtCanva extends JPanel {
    private Renderer _r = null;
    private CanvaObserver observer;

    public AwtCanva(Renderer r) {
        _r = r;
        observer = new CanvaObserver(_r);
        EventHandlerInterface eventHandler= new EventHandlerAWT(_r,observer, this);
        eventHandler.addMoListener();
    }

    public void paint(Graphics g) {
        super.paint(g);
        AwtApp.instance().graphics(g);
        _r.draw();
    }

}