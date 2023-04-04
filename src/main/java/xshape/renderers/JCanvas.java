package xshape.renderers;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JCanvas extends JPanel {
    Renderer _r = null;

    public JCanvas(Renderer r) {
        _r = r;
    }

    public void paint(Graphics g) {
        super.paint(g);
        AwtApp.instance().graphics(g);
        _r.draw();
    }
}