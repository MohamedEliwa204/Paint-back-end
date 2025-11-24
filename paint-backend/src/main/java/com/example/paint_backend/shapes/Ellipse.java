package com.example.paint_backend.shapes;

public class Ellipse extends Shape {

    private float rx;
    private float ry;

    private Ellipse(EllipseBuilder builder) {
        super(builder);
        this.rx = builder.rx;
        this.ry = builder.ry;
    }

    private Ellipse(Ellipse target) {
        super(target);

        if (target != null) {
            this.rx = target.rx;
            this.ry = target.ry;
        }
    }

    public Ellipse clone() {
        return new Ellipse(this);
    }

    //getters
    public float getRx() {
        return rx;
    }

    public float getRy() {
        return ry;
    }

    // BUILDER CLASS
    public static class EllipseBuilder extends ShapeBuilder {

        private float rx = Default.rx;
        private float ry = Default.ry;

        public EllipseBuilder setRx(float newRx) {
            this.rx = newRx;
            return this;
        }

        public EllipseBuilder setRy(float newRy) {
            this.ry = newRy;
            return this;
        }

        @Override
        public Ellipse build() {
            return new Ellipse(this);
        }
    }
}
