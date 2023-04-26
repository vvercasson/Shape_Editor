import java.awt.geom.Point2D;

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

}
