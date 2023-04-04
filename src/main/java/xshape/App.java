package xshape;

import xshape.renderers.AwtRenderer;
import xshape.renderers.FxRenderer;
import xshape.renderers.Renderer;

public class App {

    public static void main(String[] args) {
        Renderer FxApp = new FxRenderer();
        FxApp.run();
        Renderer AwtApp = new AwtRenderer();
        AwtApp.run();
    }
}
