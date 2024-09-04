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
    public AbstractShape Copy() {
        return null;
    }
}
