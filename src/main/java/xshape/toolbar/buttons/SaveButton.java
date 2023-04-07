package xshape.toolbar.buttons;

import xshape.renderers.Renderer;
import xshape.toolbar.ButtonToolBar;

public class SaveButton implements Button{
    public SaveButton(Renderer r, ButtonToolBar bar){
        r.drawButtonToolBar(bar,"Save");
    }
}
