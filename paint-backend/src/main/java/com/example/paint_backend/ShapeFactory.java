package com.example.paint_backend;

import com.example.paint_backend.shapes.Circle;
import com.example.paint_backend.shapes.LineSegment;
import com.example.paint_backend.shapes.Ellipse;
import com.example.paint_backend.shapes.FreeCurve;
import com.example.paint_backend.shapes.Polygon;
import com.example.paint_backend.shapes.Shape;
import com.example.paint_backend.shapes.Square;
import com.example.paint_backend.shapes.Rectangle;

public class ShapeFactory {

    public static Shape.ShapeBuilder createShapeBuilder(String shapeType, float x, float y, Float param1, Float param2, Float param3, float[] pointsParam) {
    shapeType = shapeType.toUpperCase();

    if (pointsParam != null) {
        switch (shapeType) {
            case "LINE":
                return new LineSegment.LineSegmentBuilder(x, y, pointsParam);
            case "FREE-DRAW":
                return new FreeCurve.FreeCurveBuilder(x, y, pointsParam);
            default:
                throw new IllegalArgumentException("Points parameter is only valid for LINE and FREE-DRAW shapes");
        }
    }

    switch (shapeType) {
        case "CIRCLE":
            if (param1 == null)
                throw new IllegalArgumentException("CIRCLE requires a radius");
            return new Circle.CircleBuilder(x, y, param1);

        case "SQUARE":
            if (param1 == null)
                throw new IllegalArgumentException("SQUARE requires a side length");
            return new Square.SquareBuilder(x, y, param1);

        case "RECTANGLE":
            if (param1 == null || param2 == null)
                throw new IllegalArgumentException("RECTANGLE requires width and height");
            return new Rectangle.RectangleBuilder(x, y, param1, param2);

        case "ELLIPSE":
            if (param1 == null || param2 == null)
                throw new IllegalArgumentException("ELLIPSE requires two radii");
            return new Ellipse.EllipseBuilder(x, y, param1, param2);

        case "POLYGON":
            if (param1 == null || param2 == null || param3 == null)
                throw new IllegalArgumentException("POLYGON requires sides, radius, and rotation");
            return new Polygon.PolygonBuilder(x, y, param1, param2, param3);

        default:
            throw new IllegalArgumentException("Invalid shape type");
    }
}


}
