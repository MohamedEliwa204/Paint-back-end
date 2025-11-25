package com.example.paint_backend.shapes;

public class Square extends Shape{
    private float edgeLength;


    private Square(SquareBuilder builder){
        super(builder);
        this.edgeLength = builder.edgeLength;
 
    }

    private Square(Square target){
        super(target);
        
        if (target != null){
            this.edgeLength = target.edgeLength;
        }
     }

    public Square clone(){
        return new Square(this);
    }

    //getters
    public float getEdgeLength(){
        return this.edgeLength;
    }

    //setters
    public void setEdgeLength(float newEdgeLength){
        this.edgeLength = newEdgeLength;
    }

    public static class SquareBuilder extends ShapeBuilder{
        private float edgeLength = Default.edgeLength;

        public SquareBuilder (float x, float y, float edgeLength){
            super(x, y);
            this.edgeLength = edgeLength;
        }

        @Override
        public Square build(){
            return new Square(this);
        }
    }


}
