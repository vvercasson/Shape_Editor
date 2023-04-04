package xshape.utils;

public class MyColor implements Cloneable {
    /*
     * Attributes
     */
    double[] _rgb = new double[4];

    /*
     * Some predefined colors
     */
    public static final MyColor RED = new MyColor(255, 0, 0);
    public static final MyColor GREEN = new MyColor(0, 255, 0);
    public static final MyColor BLUE = new MyColor(0, 0, 255);
    public static final MyColor BLACK = new MyColor(0, 0, 0);
    public static final MyColor WHITE = new MyColor(255, 255, 255);
    public static final MyColor YELLOW = new MyColor(255, 255, 0);
    public static final MyColor CYAN = new MyColor(0, 255, 255);
    public static final MyColor MAGENTA = new MyColor(255, 0, 255);
    public static final MyColor ORANGE = new MyColor(255, 165, 0);
    public static final MyColor PINK = new MyColor(255, 192, 203);
    public static final MyColor GRAY = new MyColor(128, 128, 128);
    public static final MyColor LIGHT_GRAY = new MyColor(211, 211, 211);
    public static final MyColor DARK_GRAY = new MyColor(169, 169, 169);

    /*
     * Constructors
     */
    public MyColor(double r, double g, double b) {
        _rgb[0] = r;
        _rgb[1] = g;
        _rgb[2] = b;
        _rgb[3] = 255;
    }

    public MyColor(double r, double g, double b, double opacity) {
        _rgb[0] = r;
        _rgb[1] = g;
        _rgb[2] = b;
        _rgb[3] = opacity;
    }

    /*
     * Methods
     */
    public java.awt.Color toAwt() {
        return new java.awt.Color((float) _rgb[0] / 255, (float) _rgb[1] / 255, (float) _rgb[2] / 255,
                (float) _rgb[3] / 255);
    }

    public javafx.scene.paint.Color toFx() {
        return new javafx.scene.paint.Color(_rgb[0] / 255, _rgb[1] / 255, _rgb[2] / 255, _rgb[3] / 255);
    }

    public double[] clone() {
        return _rgb.clone();
    }

    public void setColor(double r, double g, double b, double opacity) {
        _rgb[0] = r;
        _rgb[1] = g;
        _rgb[2] = b;
        _rgb[3] = opacity;
    }

    public double getRed() {
        return _rgb[0];
    }

    public void setRed(double r) {
        _rgb[0] = r;
    }

    public double getGreen() {
        return _rgb[1];
    }

    public void setGreen(double g) {
        _rgb[1] = g;
    }

    public double getBlue() {
        return _rgb[2];
    }

    public void setBlue(double b) {
        _rgb[2] = b;
    }

    public double getOpacity() {
        return _rgb[3];
    }

    public void setOpacity(double opacity) {
        _rgb[3] = opacity;
    }
}
