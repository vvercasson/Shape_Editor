package xshape.toolbar.buttons;

import xshape.renderers.Renderer;
import xshape.toolbar.ButtonToolBar;

public class LoadButton implements Button {
    public LoadButton(Renderer r, ButtonToolBar bar){
        r.drawButtonToolBar(bar,"Load");
    }
}
