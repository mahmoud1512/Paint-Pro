package com.example.paintBackend.Shapes;

public class Star extends AbstractShape{
    private String type="Star";
    private int numPoints;
    private double innerRadius;
    private double outerRadius;
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

    public void setType(String type) {
        this.type = type;
    }

    public int getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    public double getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(double outerRadius) {
        this.outerRadius = outerRadius;
    }

    @Override
    public AbstractShape Copy(String id) {
        Star star=new Star();
        star.setFill(this.getFill());
        star.setNumPoints(this.getNumPoints());
        star.setInnerRadius(this.getInnerRadius());
        star.setOuterRadius(this.getOuterRadius());
        star.setX(this.getX()-10);
        star.setY(this.getY()-10);
        star.setStroke(this.getStroke());
        star.setStrokeWidth(this.getStrokeWidth());
        star.setRotation(this.getRotation());
        star.setScaleX(this.getScaleX());
        star.setScaleY(this.getScaleY());
        star.setId(id);
        return star;
    }
}
