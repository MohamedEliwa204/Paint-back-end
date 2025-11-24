package com.example.paint_backend.shapes;

public class Polygon extends Shape{
    private float sidesCount;
    private float edgeLength;

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

    public static class PolygonBuilder extends ShapeBuilder{
        private float sidesCount = Default.sidesCount;
        private float edgeLength = Default.polygonEdgeLength;

        public void setSidesCount(float newSidesCount){
            this.sidesCount = newSidesCount;
        }

        public void setSide(float newEdgeLength){
            this.edgeLength = newEdgeLength;
        }

        @Override
        public Polygon build(){
            return new Polygon(this);
        }
    }


}
