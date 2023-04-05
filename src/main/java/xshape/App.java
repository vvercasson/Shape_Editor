package xshape;

import xshape.renderers.AwtRenderer;
import xshape.renderers.FxRenderer;
import xshape.renderers.Renderer;

public class App {
    public static void main(String[] args) {
        Renderer AwtApp = new AwtRenderer(500, 500);
        AwtApp.run();
        Renderer FxApp = new FxRenderer(500, 500);
        FxApp.run();
    }
}
