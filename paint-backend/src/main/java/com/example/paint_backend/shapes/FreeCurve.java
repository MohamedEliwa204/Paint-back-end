package com.example.paint_backend.shapes;

public class FreeCurve extends LineSegment {
    private FreeCurve(FreeCurveBuilder builder) {
        super(builder);    
    }

    private FreeCurve(FreeCurve target) {
        super(target);
    }

    public FreeCurve clone() {
        return new FreeCurve(this);
    }

    public static class FreeCurveBuilder extends LineSegmentBuilder {

        @Override
        public FreeCurve build() {
            return new FreeCurve(this);
        }
    }

}
