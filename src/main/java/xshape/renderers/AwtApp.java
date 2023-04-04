package xshape.renderers;

import java.awt.Graphics;

import javax.management.RuntimeErrorException;

public class AwtApp {
    static private AwtApp _singleton = null;
    private Graphics _graphics = null;

    static public AwtApp instance() {
        if (_singleton == null)
            _singleton = new AwtApp();
        return _singleton;
    }

    private AwtApp() {
    }

    public Graphics graphics() {
        if (_graphics == null)
            throw new RuntimeErrorException(null, "Graphics has not been set contex is not valid");
        return _graphics;
    }

    public AwtApp graphics(Graphics g) {
        _graphics = g;
        return this;
    }
}
