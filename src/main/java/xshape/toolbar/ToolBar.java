package xshape.toolbar;

import xshape.factory.ShapeFactory;
import xshape.factory.ShapesFactory;
import xshape.renderers.Renderer;
import xshape.shapes.Rectangle;
import xshape.shapes.Shape;
import xshape.shapes.ShapeGroup;
import xshape.utils.MyColor;

import java.util.Iterator;

public class ToolBar extends ShapeGroup {
    int width;
    ShapeFactory factory = new ShapesFactory();
    public ToolBar(int width){
        this.width = width;

        // draw line of

        // draw shapes
        Rectangle rectangle = factory.createRectangle(10,10,50,50,MyColor.RED);
        add(rectangle);

    }

    public void createToolBar(Renderer r){
        super.drawInCanva(r);
    }

    public void add(Shape s){
        super.add(s);
    }

    public void remove(Shape s) {
        super.remove(s);
    }

}
