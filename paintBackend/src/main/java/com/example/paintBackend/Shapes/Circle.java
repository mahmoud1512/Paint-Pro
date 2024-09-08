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
    public AbstractShape Copy(String id) {
        Circle circle=new Circle();
        circle.setFill(this.fill);
        circle.setRadius(this.radius);
        circle.setRotation(this.getRotation());
        circle.setStrokeWidth(this.getStrokeWidth());
        circle.setStroke(this.getStroke());
        circle.setScaleX(this.getScaleX());
        circle.setScaleY(this.getScaleY());
        circle.setX(this.getX()-10);
        circle.setY(this.getY()-10);
        circle.setId(id);
        return circle;
    }
}
