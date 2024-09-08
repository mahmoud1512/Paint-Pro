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
    public String toString() {
        return "Rectangle{" +
                "type='" + type + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", fill='" + fill + '\'' +
                '}';
    }

    @Override
    public AbstractShape Copy(String id) {
        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(this.getWidth());
        rectangle.setHeight(this.getHeight());
        rectangle.setFill(this.getFill());
        rectangle.setX(this.getX()-10);
        rectangle.setY(this.getY()-10);
        rectangle.setStroke(this.getStroke());
        rectangle.setStrokeWidth(this.getStrokeWidth());
        rectangle.setRotation(this.getRotation());
        rectangle.setScaleX(this.getScaleX());
        rectangle.setScaleY(this.getScaleY());
        rectangle.setId(id);
        return rectangle;
    }
}
