package com.example.paint_backend;

import com.example.paint_backend.shapes.Circle;
import com.example.paint_backend.shapes.LineSegment;
import com.example.paint_backend.shapes.Ellipse;
import com.example.paint_backend.shapes.Polygon;
import com.example.paint_backend.shapes.Shape;
import com.example.paint_backend.shapes.Square;
import com.example.paint_backend.shapes.Rectangle;

public class ShapeFactory {

    public enum ShapeType {
        CIRCLE,
        SQUARE,
        RECTANGLE,
        POLYGON,
        LINE_SEGMENT,
        ELLIPSE
    }

    public static Shape.ShapeBuilder createShapeBuilder(ShapeType shapeType) {
        switch(shapeType) {
            case CIRCLE:
                return new Circle.CircleBuilder();

            case SQUARE:
                return new Square.SquareBuilder();

            case RECTANGLE:
                return new Rectangle.RectangleBuilder();

            case POLYGON:
                return new Polygon.PolygonBuilder();

            case LINE_SEGMENT:
                return new LineSegment.LineSegmentBuilder();
            
            case ELLIPSE:
                return new LineSegment.LineSegmentBuilder();

            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}
