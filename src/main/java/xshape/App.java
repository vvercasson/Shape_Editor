package xshape;

import xshape.renderers.AwtRenderer;
import xshape.renderers.FxRenderer;
import xshape.renderers.Renderer;
import xshape.utils.MyColor;

public class App {

    public static void main(String[] args) {
        Renderer FxApp = new FxRenderer(500, 500);
        FxApp.run();
        Renderer AwtApp = new AwtRenderer(500, 500);
        AwtApp.run();
    }
}
