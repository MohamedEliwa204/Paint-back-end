package com.example.paint_backend.shapes;

public class LineSegment extends Shape{
    private float length;

    private LineSegment(LineSegmentBuilder builder){
        super(builder);
        this.length = builder.length;
    }

    private LineSegment(LineSegment target){
        super(target);
        
        if (target != null){
            this.length = target.length;
        }
    }

    public LineSegment clone(){
        return new LineSegment(this);
    }

    //getters
    public float getLength(){
        return this.length;
    }

    public static class LineSegmentBuilder extends ShapeBuilder{
        private float length = Default.length;

        public void setLength(float newLength){
            this.length = newLength;
        }

        @Override
        public LineSegment build(){
            return new LineSegment(this);
        }
    }
}
