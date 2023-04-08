package xshape.toolbar;

import xshape.toolbar.Button.ButtonType;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ButtonToolBar {

    private double _newPos = 100;
    private static int buttonSpacing = 60;
    private ArrayList<Button> _buttons = new ArrayList<>();

    public ButtonToolBar() {
        Button undo = new Button(ButtonType.UNDO, "Undo");
        Button redo = new Button(ButtonType.REDO, "Redo");
        Button save = new Button(ButtonType.SAVE, "Save");
        Button open = new Button(ButtonType.LOAD, "Load");

        addButton(open);
        addButton(save);
        addButton(undo);
        addButton(redo);
    }

    public void addButton(Button b) {
        b.setPosition(new Point2D.Double(getNewPos(), 0));
        _buttons.add(b);
        // Increase for next button
        setNewPos(_newPos + buttonSpacing);
    }

    public double getNewPos() {
        return _newPos;
    }

    public void setNewPos(double _newPos) {
        this._newPos = _newPos;
    }

    public ArrayList<Button> getButtons() {
        return _buttons;
    }
}
