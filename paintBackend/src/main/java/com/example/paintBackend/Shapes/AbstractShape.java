package com.example.paintBackend.Shapes;

//For polymorphic deserialization
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, //how to define name of class
        include = JsonTypeInfo.As.PROPERTY, // go to the properties
        property = "type" // use type property
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = Square.class, name = "Square"),
        @JsonSubTypes.Type(value = Circle.class, name = "Circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle"),
        @JsonSubTypes.Type(value = Triangle.class, name = "Triangle"),
        @JsonSubTypes.Type(value = Ellipse.class, name = "Ellipse"),
        @JsonSubTypes.Type(value = Star.class, name = "Star"),
        @JsonSubTypes.Type(value = LineSegment.class, name = "Line")
})

public abstract class AbstractShape {
    private double x;
    private double y;
    private String stroke;
    private double strokeWidth;
    private double rotation;
    private double scaleX;
    private double scaleY;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }



    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getScaleX() {
        return scaleX;
    }

    public void setScaleX(double scaleX) {
        this.scaleX = scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
    }
    public abstract AbstractShape Copy(String id);
}
