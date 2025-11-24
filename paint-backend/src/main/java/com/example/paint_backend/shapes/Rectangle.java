package com.example.paint_backend.shapes;

public class Rectangle extends Shape{
    private float width;
    private float height;

    private Rectangle(RectangleBuilder builder){
        super(builder);
        this.width = builder.width;
        this.height = builder.height;
    }

    //getters
    public float getWidth(){
        return this.width;
    }

    public float getHeight(){
        return this.height;
    }

    public static class RectangleBuilder extends ShapeBuilder{
        private float width = Default.width;
        private float height = Default.height;

        public void setWidth(float newWidth){
            this.width = newWidth;
        }

        public void setHeight(float newHeight){
            this.height = newHeight;
        }

        @Override
        public Rectangle build(){
            return new Rectangle(this);
        }
    }


}
