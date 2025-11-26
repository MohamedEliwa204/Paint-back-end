package com.example.paint_backend.shapes;

public class Circle extends Shape{

    private float radius;

    private Circle(CircleBuilder builder){
        super(builder);
        this.radius = builder.radius;
    }

    private Circle(Circle target){
        super(target);
        
        if (target != null){
            this.radius = target.radius;
        }
     }

    public Circle clone(){
        return new Circle(this);
    }

    public float getRadius(){
        return this.radius;
    }

    public void setRadius(float newRadius){
        this.radius = newRadius;
    }

    public static class CircleBuilder extends ShapeBuilder{
        private float radius = Default.radius;

        public CircleBuilder(float x, float y, float radius){
            super(x, y);
            this.radius = radius;
        }

        @Override
        public Circle build(){
            return new Circle(this);
        }
    }
}
