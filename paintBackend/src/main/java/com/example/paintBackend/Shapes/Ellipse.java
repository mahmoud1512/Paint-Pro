package com.example.paintBackend.Shapes;

public class Ellipse extends AbstractShape{
    private final String type="Ellipse";
    private double radiusX;
    private String fill;

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getType() {
        return type;
    }

    public double getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }

    public double getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }

    private double radiusY;
    @Override
    public AbstractShape Copy() {
        return null;
    }
}
