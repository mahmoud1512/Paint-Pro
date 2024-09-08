package com.example.paintBackend.Shapes;

public class Square extends AbstractShape{

    private final String type="Square";
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
    public AbstractShape Copy(String id) {
        Square square=new Square();
        square.setWidth(this.getWidth());
        square.setHeight(this.getHeight());
        square.setFill(this.getFill());
        square.setX(this.getX()-10);
        square.setY(this.getY()-10);
        square.setStroke(this.getStroke());
        square.setStrokeWidth(this.getStrokeWidth());
        square.setRotation(this.getRotation());
        square.setScaleX(this.getScaleX());
        square.setScaleY(this.getScaleY());
        square.setId(id);
        return square;
    }
}
