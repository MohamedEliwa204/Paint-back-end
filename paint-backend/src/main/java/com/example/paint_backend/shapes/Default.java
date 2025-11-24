package com.example.paint_backend.shapes;

import org.springframework.data.geo.Point;

public class Default {
    
    public static String fill = "red";
    public static float opacity = 1.0f;

    public static float strokeWidth = 0.0f;
    public static String strokeFill = "black";
    public static float strokeOpacity = 1.0f;

    public static Point center = new Point(100, 100);

    public static float rx = 10;
    public static float ry = 10;
    public static float radius = 10;

    public static float width = 10;
    public static float height = 10;

    public static float edgeLength = 10;
    public static float polygonEdgeLength = 10;

    public static float sidesCount = 3;

    public static float length = 10 ;

    // Setters

    public static void setFill(String newFill) {
        fill = newFill;
    }

    public static void setOpacity(float newOpacity) {
        opacity = newOpacity;
    }

    public static void setStrokeWidth(float newStrokeWidth) {
        strokeWidth = newStrokeWidth;
    }

    public static void setStrokeFill(String newStrokeFill) {
        strokeFill = newStrokeFill;
    }

    public static void setStrokeOpacity(float newStrokeOpacity) {
        strokeOpacity = newStrokeOpacity;
    }

    public static void setCenter(Point newCenter) {
        center = newCenter;
    }

    public static void setRx(float newRx) {
        rx = newRx;
    }

    public static void setRy(float newRy) {
        ry = newRy;
    }

    public static void setRadius(float newRadius) {
        radius = newRadius;
    }

    public static void setWidth(float newWidth) {
        width = newWidth;
    }

    public static void setHeight(float newHeight) {
        height = newHeight;
    }

    public static void setEdge(float newEdgeLength) {
        edgeLength = newEdgeLength;
    }

    public static void setSidesCount(float newSidesCount) {
        sidesCount = newSidesCount;
    }

    public static void setPolygonEdgeLength(float newPolygonEdgeLength) {
        polygonEdgeLength = newPolygonEdgeLength;
    }

    public static void setLength(float newLength) {
        length = newLength;
    }


}
