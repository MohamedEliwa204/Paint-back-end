package com.example.paint_backend.shapes;

public class Circle extends Shape{

    private float radius;

    private Circle(CircleBuilder builder){
        super(builder);
        this.radius = builder.radius;
    }

    public float getRadius(){
        return this.radius;
    }

    //builder
    public static class CircleBuilder extends ShapeBuilder{
        private float radius = Default.radius;

        public void setRadius(float newRadius){
            this.radius = newRadius;
        }

        @Override
        public Circle build(){
            return new Circle(this);
        }
    }
}
