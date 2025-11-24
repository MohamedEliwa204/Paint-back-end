package com.example.paint_backend.shapes;

public class Square extends Shape{
    private float edgeLength;


    private Square(SquareBuilder builder){
        super(builder);
        this.edgeLength = builder.edgeLength;
 
    }

    //getters
    public float getEdgeLength(){
        return this.edgeLength;
    }

    public static class SquareBuilder extends ShapeBuilder{
        private float edgeLength = Default.edgeLength;

        public void setEdge(float newEdgeLength){
            this.edgeLength = newEdgeLength;
        }

        @Override
        public Square build(){
            return new Square(this);
        }
    }


}
