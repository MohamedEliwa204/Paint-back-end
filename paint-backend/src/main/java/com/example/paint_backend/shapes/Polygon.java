package com.example.paint_backend.shapes;

public class Polygon extends Shape{
    private float sidesCount;
    private float edgeLength;
    private float radius;

    private Polygon(PolygonBuilder builder){
        super(builder);
        this.sidesCount = builder.sidesCount;
        this.edgeLength = builder.edgeLength;
 
    }

    private Polygon(Polygon target){
        super(target);
        
        if (target != null){
            this.sidesCount = target.sidesCount;
            this.edgeLength = target.edgeLength;
        }
     }

    public Polygon clone(){
        return new Polygon(this);
    }

    //getters
    public float getSidesCount(){
        return this.sidesCount;
    }

    public float getEdgeLength(){
        return this.edgeLength;
    }

    public float getRadius(){
        return this.radius;
    }

    //setters
    public void setSidesCount(float newSidesCount){
        this.sidesCount = newSidesCount;
    }

    public void setEdgeLength(float newEdgeLength){
        this.edgeLength = newEdgeLength;
    }

    public void setRadius(float newRadius){
        this.radius = newRadius;
    }

    public static class PolygonBuilder extends ShapeBuilder{
        private float sidesCount = Default.sidesCount;
        private float edgeLength = Default.polygonEdgeLength;
        private float radius = Default.polygonRadius;

        public PolygonBuilder (float x, float y, float sidesCount, float edgeLength, float radius){
            super(x, y);
            this.sidesCount = sidesCount;
            this.edgeLength = edgeLength;
            this.radius = radius;
        }

        @Override
        public Polygon build(){
            return new Polygon(this);
        }
    }


}
