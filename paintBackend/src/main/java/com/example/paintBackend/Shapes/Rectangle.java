package com.example.paintBackend.Shapes;

public class Rectangle extends AbstractShape {

    private final String type="Rectangle";
    private double width;
    private double height;
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public AbstractShape Copy() {
        return null;
    }
}
