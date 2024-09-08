package com.example.paintBackend.Shapes;

public class Ellipse extends AbstractShape{
    private final String type="Ellipse";
    private double radiusX;
    private double radiusY;
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


    @Override
    public AbstractShape Copy(String id) {
       Ellipse ellipse=new Ellipse();
       ellipse.setX(this.getX()-10);
       ellipse.setY(this.getY()-10);
       ellipse.setId(id);
       ellipse.setScaleX(this.getScaleX());
       ellipse.setScaleY(this.getScaleY());
       ellipse.setRadiusX(this.getRadiusX());
       ellipse.setRadiusY(this.getRadiusY());
       ellipse.setFill(this.getFill());
       ellipse.setStroke(this.getStroke());
       ellipse.setStrokeWidth(this.getStrokeWidth());
       ellipse.setRotation(this.getRotation());
       return ellipse;
    }
}
