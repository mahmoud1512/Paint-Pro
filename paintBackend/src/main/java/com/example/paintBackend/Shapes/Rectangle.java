package com.example.paintBackend.Shapes;

public class Rectangle extends AbstractShape {

    private  String type;
    private double width;

    private double height;
    private String fill;

    public void setType(String type) {
        this.type = type;
    }

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
    public String toString() {
        return "Rectangle{" +
                "type='" + type + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", fill='" + fill + '\'' +
                '}';
    }

    @Override
    public AbstractShape Copy() {
        return null;
    }
}
