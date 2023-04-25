package xshape.command;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import xshape.factory.ShapeFactory;
import xshape.renderers.Renderer;
import xshape.shapes.Polygon;
import xshape.utils.MyColor;

public class AddPolygonCommand extends AbsShapeCreationCmd {

    private Polygon _p;

    public AddPolygonCommand(ShapeFactory f, Renderer r, ArrayList<Point2D> points, MyColor c) {
        super(f, r);
        _p = getFactory().createPolygon(points, c);
    }

    @Override
    public void apply() {
        getRenderer().getShapes().add(_p);
        _p.drawInCanva(getRenderer());
    }

    @Override
    public void undo() {
        getRenderer().getShapes().remove(_p);
        getRenderer().refreshCanva();
    }

}
