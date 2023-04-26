import java.awt.geom.Point2D;
import java.util.Iterator;

import org.junit.Test;

import xshape.factory.ShapesFactory;
import xshape.shapes.*;
import xshape.utils.MyColor;

public class unitTest {

    @Test
    public void translateShapeTest() {
        ShapesFactory f = new ShapesFactory();
        Rectangle s = f.createDefaultRectangle(0, 0);
        s.translate(new Point2D.Double(10, 10));
        assert (s.getPos().getX() == 10 && s.getPos().getY() == 10);
    }

    @Test
    public void changeShapeColorTest() {
        ShapesFactory f = new ShapesFactory();
        Rectangle s = f.createDefaultRectangle(0, 0);
        s.setColor(MyColor.RED);
        assert (s.getColor() == MyColor.RED);
    }

    @Test
    public void changeShapeOpacityTest() {
        ShapesFactory f = new ShapesFactory();
        Rectangle s = f.createDefaultRectangle(0, 0);
        s.setOpacity(125);
        assert (s.getColor().getOpacity() == 125);
    }

    @Test
    public void createShapeGroup() {
        // Init
        int expectedNumberOfShape = 2;
        ShapeGroup sg = new ShapeGroup();
        ShapesFactory f = new ShapesFactory();

        // Adding shapes to group
        Shape r = f.createDefaultRectangle(0, 0);
        Shape r2 = f.createDefaultRectangle(100, 100);
        sg.add(r);
        sg.add(r2);

        // Counting
        Iterator<Shape> it = sg.iterator();
        int shapeCounter = 0;
        while (it.hasNext()) {
            it.next();
            ++shapeCounter;
        }

        // Checking
        assert (shapeCounter == expectedNumberOfShape);
    }

}
