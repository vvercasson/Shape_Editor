package xshape.toolbar.buttons;

import xshape.renderers.Renderer;
import xshape.toolbar.ButtonToolBar;


public class UndoButton implements Button{
    public UndoButton(Renderer r, ButtonToolBar bar){
        r.drawButtonToolBar(bar,"Undo");
    }
}
