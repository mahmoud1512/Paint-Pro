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
    public AbstractShape Copy(String id) {
        Triangle triangle=new Triangle();
        triangle.setRadius(this.getRadius());
        triangle.setFill(this.getFill());
        triangle.setX(this.getX()-10);
        triangle.setY(this.getY()-10);
        triangle.setStroke(this.getStroke());
        triangle.setStrokeWidth(this.getStrokeWidth());
        triangle.setRotation(this.getRotation());
        triangle.setScaleX(this.getScaleX());
        triangle.setScaleY(this.getScaleY());
        triangle.setId(id);
        return triangle;
    }
}
