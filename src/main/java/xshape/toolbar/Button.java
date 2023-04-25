package xshape.toolbar;

import java.awt.geom.Point2D;

import xshape.shapes.Rectangle;
import xshape.utils.MyColor;

public class Button {
    // The four types of button that we need
    public enum ButtonType {
        UNDO, REDO, LOAD, SAVE
    }

    // Button attributes
    private ButtonType _type;
    private String _label;
    private Point2D _position;

    // Button size
    private int width = 50;
    private int height = 25;

    /*
     * Constructor
     */
    public Button(ButtonType type, String label) {
        _type = type;
        _label = label;
    }

    // Getters Setters
    public Point2D getPosition() {
        return _position;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setPosition(Point2D _position) {
        this._position = _position;
    }

    public ButtonType getType() {
        return _type;
    }

    public String getLabel() {
        return _label;
    }

    public Rectangle getBackground() {
        return new Rectangle(_position.getX(), _position.getY(), height, width, MyColor.LIGHT_GRAY);
    }
}
