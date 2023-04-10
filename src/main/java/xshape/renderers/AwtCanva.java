package xshape.renderers;

import xshape.eventObserver.CanvaObserver;
import xshape.eventObserver.*;

import javax.swing.*;
import java.awt.*;

public class AwtCanva extends JPanel {
    private Renderer _r = null;

    public AwtCanva(Renderer r) {
        _r = r;
        EventHandlerInterface eventHandler= new EventHandlerAWT(_r, this);
        eventHandler.addMoListener();
    }

    public void paint(Graphics g) {
        super.paint(g);
        AwtApp.instance().graphics(g);
        _r.draw();
    }

}