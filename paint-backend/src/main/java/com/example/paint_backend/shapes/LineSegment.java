package com.example.paint_backend.shapes;

import org.springframework.data.geo.Point; 

public class LineSegment extends Shape{
    private float points[];

    protected LineSegment(LineSegmentBuilder builder){
        super(builder);
        this.points = builder.points;
    }

    protected LineSegment(LineSegment target){
        super(target);
        
        if (target != null){
            this.points = target.points;
        }
    }

    public LineSegment clone(){
        return new LineSegment(this);
    }

    //getters
    public float[] getpoints(){
        return this.points;
    }

    //setters
    public void setpoints(float[] newpoints){
        this.points = newpoints;
    }

    public static class LineSegmentBuilder extends ShapeBuilder{
        private float points[] = Default.points;

        public LineSegmentBuilder(float x, float y, float[] newPoints){
            super(x, y);
            this.points = newPoints;
        }

        @Override
        public LineSegment build(){
            return new LineSegment(this);
        }
    }
}

