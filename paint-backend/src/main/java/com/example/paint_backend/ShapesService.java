package com.example.paint_backend;

import com.example.paint_backend.shapes.Shape;
import com.example.paint_backend.shapes.*;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;


@Service
public class ShapesService {
    // use Deque instead of legacy synchronized Stack
    Deque<Map<Integer, Shape>> history = new ArrayDeque<>();
    Deque<Map<Integer, Shape>> redoHistory = new ArrayDeque<>();

    Map<Integer, Shape> shapes = new HashMap<>();

    // formatting constants
    private static final String NL = System.lineSeparator();
    private static final String INDENT = "  ";
    private static final String CHILD = "    ";

    public void putOrUpdate(Shape shape) {
        history.addLast(new HashMap<>(shapes));
        redoHistory.clear();
        shapes.put(shape.getId(), shape);


    }

    public Shape getById(int id) {
        return shapes.get(id);
    }

    public void remove(int id) {
        history.addLast(new HashMap<>(shapes));
        redoHistory.clear();
        shapes.remove(id);

    }

    public void undo() {

        redoHistory.addLast(new HashMap<>(shapes));
        if (history.isEmpty()) {
            shapes = new HashMap<>();
        } else {
            shapes = new HashMap<>(history.removeLast());
        }
    }

    public void redo() {
        if (redoHistory.isEmpty()) {
            return;
        }
        history.addLast(new HashMap<>(shapes));
        shapes = new HashMap<>(redoHistory.removeLast());
    }

    public Map<Integer, Shape> getShapesJson() {

        Map<Integer, Shape> snapshot = new HashMap<>();
        for (Map.Entry<Integer, Shape> entry : shapes.entrySet()) {
            Integer id = entry.getKey();
            Shape s = entry.getValue();
            snapshot.put(id, s == null ? null : s.clone());
        }
        return snapshot;
    }

    public String getShapesXml() {
        // Build an XML string representing the current shapes snapshot using helper methods
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(NL);
        sb.append("<shapes>").append(NL);

        Map<Integer, Shape> snapshot = getShapesJson();
        for (Map.Entry<Integer, Shape> entry : snapshot.entrySet()) {
            Integer id = entry.getKey();
            Shape s = entry.getValue();
            if (s == null) continue;

            String type = determineType(s);
            sb.append(INDENT).append("<shape id=\"").append(id).append("\" type=\"").append(escapeXml(type)).append("\">").append(NL);

            appendCommonFields(sb, s);
            appendSpecificFields(sb, s);

            sb.append(INDENT).append("</shape>").append(NL);
        }

        sb.append("</shapes>").append(NL);
        return sb.toString();
    }

    private static void appendTag(StringBuilder sb, String name, Object value) {
        if (value == null) return;
        sb.append(CHILD).append('<').append(name).append('>');
        if (value instanceof String) sb.append(escapeXml((String) value));
        else sb.append(value);
        sb.append("</").append(name).append('>').append(NL);
    }

    private static void appendCommonFields(StringBuilder sb, Shape s) {

        appendTag(sb, "x", s.getX());
        appendTag(sb, "y", s.getY());
        appendTag(sb, "fill", s.getFill());
        appendTag(sb, "opacity", s.getOpacity());
        appendTag(sb, "strokeWidth", s.getStrokeWidth());
        appendTag(sb, "strokeFill", s.getStrokeFill());
        appendTag(sb, "strokeOpacity", s.getStrokeOpacity());
        appendTag(sb, "rotation", s.getRotation());
    }

    private static void appendSpecificFields(StringBuilder sb, Shape s) {

        if (s instanceof Circle c) {
            appendTag(sb, "radius", c.getRadius());
            return;
        }
        if (s instanceof Rectangle r) {
            appendTag(sb, "width", r.getWidth());
            appendTag(sb, "height", r.getHeight());
            return;
        }
        if (s instanceof Square sq) {
            appendTag(sb, "edgeLength", sq.getEdgeLength());
            return;
        }
        if (s instanceof Ellipse e) {
            appendTag(sb, "rx", e.getRx());
            appendTag(sb, "ry", e.getRy());
            return;
        }
        if (s instanceof Polygon p) {
            appendTag(sb, "sidesCount", p.getSidesCount());
            appendTag(sb, "edgeLength", p.getEdgeLength());
            appendTag(sb, "radius", p.getRadius());
            return;
        }
        if (s instanceof LineSegment l) {
            appendPoints(sb, l.getpoints());
        }
    }

    private static void appendPoints(StringBuilder sb, float[] pts) {
        sb.append(CHILD).append("<points>");
        if (pts != null && pts.length > 0) {
            StringJoiner joiner = new StringJoiner(",");
            for (float v : pts) joiner.add(String.valueOf(v));
            sb.append(joiner.toString());
        }
        sb.append("</points>").append(NL);
    }

    private static String determineType(Shape s) {
        if (s instanceof Circle) return "CIRCLE";
        if (s instanceof Rectangle) return "RECTANGLE";
        if (s instanceof Square) return "SQUARE";
        if (s instanceof Ellipse) return "ELLIPSE";
        if (s instanceof Polygon) return "POLYGON";
        if (s instanceof FreeCurve) return "FREE-DRAW";
        if (s instanceof LineSegment) return "LINE";
        return "SHAPE";
    }

    private static String escapeXml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

}
