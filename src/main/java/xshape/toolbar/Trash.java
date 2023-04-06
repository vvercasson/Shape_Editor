package xshape.toolbar;

import java.awt.geom.Point2D;

public class Trash {
    private Point2D.Double _pos;
    public Trash(Point2D.Double pos){
        this._pos = pos;
    }


    public Point2D.Double get_pos() {
        return _pos;
    }
}
