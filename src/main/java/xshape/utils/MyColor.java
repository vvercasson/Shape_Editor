package xshape.utils;

public class MyColor implements Cloneable {
    double[] _rgb = new double[4];

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
