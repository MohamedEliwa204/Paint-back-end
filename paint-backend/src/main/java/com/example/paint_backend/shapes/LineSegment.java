package com.example.paint_backend.shapes;

import org.springframework.data.geo.Point; 

public class LineSegment extends Shape{
    private Point points[];

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
    public Point[] getpoints(){
        return this.points;
    }

    public static class LineSegmentBuilder extends ShapeBuilder{
        private Point points[] = Default.points;

        public void setpoints(Point[] newpoints){
            this.points = newpoints;
        }

        @Override
        public LineSegment build(){
            return new LineSegment(this);
        }
    }
}

