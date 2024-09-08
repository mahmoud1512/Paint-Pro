package com.example.paintBackend.Shapes;

public class LineSegment extends AbstractShape{

    private final String type="Line";
    private double[]points;

    public String getType() {
        return type;
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    @Override
    public AbstractShape Copy(String id) {
        LineSegment line=new LineSegment();
        line.setPoints(this.getPoints());
        line.setX(this.getX()-10);
        line.setY(this.getY()-10);
        line.setStroke(this.getStroke());
        line.setStrokeWidth(this.getStrokeWidth());
        line.setRotation(this.getRotation());
        line.setScaleX(this.getScaleX());
        line.setScaleY(this.getScaleY());
        line.setId(id);
        return line;
    }
}
