package com.example.paint_backend;

import java.util.Map;
import java.util.Stack;

import com.example.paint_backend.shapes.Circle;
import com.example.paint_backend.shapes.LineSegment;
import com.example.paint_backend.shapes.Ellipse;
import com.example.paint_backend.shapes.Polygon;
import com.example.paint_backend.shapes.Shape;
import com.example.paint_backend.shapes.Square;
import com.example.paint_backend.shapes.Rectangle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/calculator")              //to be changed
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    Stack history = new Stack();
    Stack redoHistory = new Stack();

    @PostMapping("/draw")
    public ResponseEntity<String> draw(@RequestBody Map<String, String> body) {
        try {
        /*
            String type = body.get("type");
            Shape.ShapeBuilder drawer = ShapeFactory.createShapeBuilder(type,
                                                                        Float.parseFloat(body.get("x")),
                                                                        Float.parseFloat(body.get("y")),
                                                                        body.get("param1") != null ? Float.parseFloat(body.get("param1")) : null,
                                                                        body.get("param2") != null ? Float.parseFloat(body.get("param2")) : null,
                                                                        body.get("param3") != null ? Float.parseFloat(body.get("param3")) : null,
                                                                        null // Points param to be handled later
            );
            for (Map.Entry<String, String> entry : body.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "fill":
                        drawer.setFill(value);
                        break;

                    case "opacity":
                        drawer.setOpacity(Float.parseFloat(value));
                        break;

                    case "strokeWidth":
                        drawer.setStrokeWidth(Float.parseFloat(value));
                        break;

                    case "strokeFill":
                        drawer.setStrokeFill(value);
                        break;

                    case "strokeOpacity":
                        drawer.setStrokeOpacity(Float.parseFloat(value));
                        break;

                    case "rotation":
                        drawer.setRotation(Float.parseFloat(value));
                        break;

                    default:
                        break;
                }


            }*/     //to be fixed

            return ResponseEntity.ok("temp");
        }

        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/colorfill")
    public ResponseEntity<String> colorfill(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/opacity")
    public ResponseEntity<String> opacity(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/strokeWidth")
    public ResponseEntity<String> strokeWidth(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/strokeFill")
    public ResponseEntity<String> strokeFill(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/strokeOpacity")
    public ResponseEntity<String> strokeOpacity(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/rotation")
    public ResponseEntity<String> rotation(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/resize")
    public ResponseEntity<String> resize(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/move")
    public ResponseEntity<String> move(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @DeleteMapping("/delete")   //yet to be implemented
    public ResponseEntity<String> delete(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/undo")
    public ResponseEntity<String> undo(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }

    @PutMapping("/redo")
    public ResponseEntity<String> redo(@RequestBody Map<String, String> body) {
        try {

            return ResponseEntity.ok("temp");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Unexpected error occurred");
        }
    }


}
