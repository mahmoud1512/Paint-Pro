package com.example.paintBackend.Shapes;

public class Triangle extends AbstractShape{
    private String type="Triangle";
    private double radius;
    private String fill;

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public AbstractShape Copy() {
        return null;
    }
}
