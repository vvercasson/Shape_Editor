package xshape.toolbar;

import xshape.renderers.Renderer;
import xshape.toolbar.buttons.*;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ButtonToolBar {

    private double _newPos = 100;
    private ArrayList<Button> _buttons = new ArrayList<>();
    public ButtonToolBar(Renderer r){
        Button undo = new UndoButton(r,this);
        Button redo = new RedoButton(r,this);
        Button save = new SaveButton(r,this);
        Button open = new LoadButton(r,this);

        _buttons.add(undo);
        _buttons.add(redo);
        _buttons.add(save);
        _buttons.add(open);
    }

    public double get_newPos() {
        return _newPos;
    }

    public void set_newPos(double _newPos) {
        this._newPos = _newPos;
    }
}
