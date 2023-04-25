package xshape.command;

import xshape.factory.ShapeFactory;
import xshape.renderers.Renderer;
import xshape.shapes.Polygon;
import xshape.utils.MyColor;

public class AddDefaultPolygonCommand extends AbsShapeCreationCmd {

    private Polygon _p;

    public AddDefaultPolygonCommand(ShapeFactory f, Renderer r, double x, double y, double height, double width,
            MyColor c) {
        super(f, r);
        _p = getFactory().createDefaultPolygon(x, y, height, width, c);
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
