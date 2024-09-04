package com.example.paintBackend.Shapes;

public class Circle extends AbstractShape{
    private final String type="Circle";
    private String fill;
    private double radius;

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getType() {
        return type;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public AbstractShape Copy() {
        return null;
    }
}
