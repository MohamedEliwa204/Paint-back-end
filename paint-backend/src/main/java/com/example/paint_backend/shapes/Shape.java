package com.example.paint_backend.shapes;

import org.springframework.data.geo.Point;

public abstract class Shape {

    private String fill;
    private float opacity;

    private float strokeWidth;
    private String strokeFill;
    private float strokeOpacity;

    private Point center;

    protected Shape(ShapeBuilder builder) {
        this.strokeWidth = builder.strokeWidth;
        this.strokeFill = builder.strokeFill;
        this.strokeOpacity = builder.strokeOpacity;

        this.fill = builder.fill;
        this.opacity = builder.opacity;

        this.center = builder.center;
    }

    // GETTERS

    public String getFill() {
        return fill;
    }

    public float getOpacity() {
        return opacity;
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public String getStrokeFill() {
        return strokeFill;
    }

    public float getStrokeOpacity() {
        return strokeOpacity;
    }

    public Point getCenter() {
        return center;
    }

    // BUILDER CLASS
    public static class ShapeBuilder {

        // Default values — can be changed using Default class
        private float strokeWidth = Default.strokeWidth;
        private String strokeFill = Default.strokeFill;
        private float strokeOpacity = Default.strokeOpacity;

        private String fill = Default.fill;
        private float opacity = Default.opacity;

        private Point center = Default.center;

        public ShapeBuilder setStrokeWidth(float strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        public ShapeBuilder setStrokeFill(String strokeFill) {
            this.strokeFill = strokeFill;
            return this;
        }

        public ShapeBuilder setStrokeOpacity(float strokeOpacity) {
            this.strokeOpacity = strokeOpacity;
            return this;
        }

        public ShapeBuilder setFill(String fill) {
            this.fill = fill;
            return this;
        }

        public ShapeBuilder setOpacity(float opacity) {
            this.opacity = opacity;
            return this;
        }

        public ShapeBuilder setCenter(Point center) {
            this.center = center;
            return this;
        }

        // ─────────── BUILD METHOD ───────────
        // Shape is abstract, so subclasses override this
        public Shape build() {
            throw new UnsupportedOperationException("Cannot create abstract Shape directly.");
        }
    }

}
