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
    public static float polygonRadius = 10;

    public static float width = 10;
    public static float height = 10;

    public static float edgeLength = 10;
    public static float polygonEdgeLength = 10;

    public static float sidesCount = 3;

    public static Point points[] = {new Point(200, 200), new Point(250, 250)} ;

}
