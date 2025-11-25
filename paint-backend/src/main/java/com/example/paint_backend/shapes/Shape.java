package com.example.paint_backend.shapes;

import org.springframework.data.geo.Point;

public abstract class Shape {

     private String fill;
     private float opacity;

     private float strokeWidth;
     private String strokeFill;
     private float strokeOpacity;

     private float x;
     private float y;

     private float rotation;

     protected Shape(ShapeBuilder builder) {
          this.strokeWidth = builder.strokeWidth;
          this.strokeFill = builder.strokeFill;
          this.strokeOpacity = builder.strokeOpacity;

          this.fill = builder.fill;
          this.opacity = builder.opacity;

          this.x = builder.x;
          this.y = builder.y;
     }

     protected Shape(Shape target){
          if (target != null){
               this.strokeWidth = target.strokeWidth;
               this.strokeFill = target.strokeFill;
               this.strokeOpacity = target.strokeOpacity;
               
               this.fill = target.fill;
               this.opacity = target.opacity;
               
               this.x = target.x;
               this.y = target.y;
          }
     }

     public abstract Shape clone();

     // GETTERS

     public String getFill() {
          return fill;
     }

     public float getOpacity() {
          return opacity;
     }

     public float getStrokeWidth() {
          return strokeWidth;
     }

     public String getStrokeFill() {
          return strokeFill;
     }

     public float getStrokeOpacity() {
          return strokeOpacity;
     }

     public float getX() {
          return x;
     }

     public float getY() {
          return y;
     }

     public float getRotation() {
          return rotation;
     }

     // SETTERS

     public void setFill(String fill) {
          this.fill = fill;
     }

     public void setOpacity(float opacity) {
          this.opacity = opacity;
     }

     public void setStrokeWidth(float strokeWidth) {
          this.strokeWidth = strokeWidth;
     }

     public void setStrokeFill(String strokeFill) {
          this.strokeFill = strokeFill;
     }

     public void setStrokeOpacity(float strokeOpacity) {
          this.strokeOpacity = strokeOpacity;
     }

     public void setX(float x) {
          this.x = x;
     }

     public void setY(float y) {
          this.y = y;
     }

     public void setRotation(float rotation) {
          this.rotation = rotation;
     }

     // BUILDER CLASS
     public static class ShapeBuilder {

          // Default values — can be changed using Default class
          private float strokeWidth = Default.strokeWidth;
          private String strokeFill = Default.strokeFill;
          private float strokeOpacity = Default.strokeOpacity;

          private String fill = Default.fill;
          private float opacity = Default.opacity;

          private float x = Default.x;
          private float y = Default.y;

          private float rotation = 0.0f;

          public ShapeBuilder(float x, float y){
               this.x = x;
               this.y = y;
          }

          public ShapeBuilder setStrokeWidth(float strokeWidth) {
               this.strokeWidth = strokeWidth;
               return this;
          }

          public ShapeBuilder setStrokeFill(String strokeFill) {
               this.strokeFill = strokeFill;
               return this;
          }

          public ShapeBuilder setStrokeOpacity(float strokeOpacity) {
               this.strokeOpacity = strokeOpacity;
               return this;
          }

          public ShapeBuilder setFill(String fill) {
               this.fill = fill;
               return this;
          }

          public ShapeBuilder setOpacity(float opacity) {
               this.opacity = opacity;
               return this;
          }

          public ShapeBuilder setRotation(float rotation) {
               this.rotation = rotation;
               return this;
          }

          // ─────────── BUILD METHOD ───────────
          // Shape is abstract, so subclasses override this
          public Shape build() {
               throw new UnsupportedOperationException("Cannot create abstract Shape directly.");
          }
    }

}
