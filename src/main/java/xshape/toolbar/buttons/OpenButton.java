package xshape.toolbar.buttons;

import xshape.renderers.Renderer;
import xshape.toolbar.ButtonToolBar;

public class OpenButton implements Button {
    public OpenButton(Renderer r, ButtonToolBar bar){
        r.drawButtonToolBar(bar,"Open");
    }
}
