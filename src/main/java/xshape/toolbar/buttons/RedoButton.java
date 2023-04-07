package xshape.toolbar.buttons;

import xshape.renderers.Renderer;
import xshape.toolbar.ButtonToolBar;

public class RedoButton implements Button{
    public RedoButton(Renderer r, ButtonToolBar bar){
        r.drawButtonToolBar(bar,"Redo");
    }
}
