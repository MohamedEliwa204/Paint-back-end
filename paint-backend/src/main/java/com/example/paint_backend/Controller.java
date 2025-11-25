package com.example.paint_backend;

import java.util.Map;

import com.example.paint_backend.shapes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paint")              //to be changed
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired
    private ShapesService shapesService;
    int generated_id = 1000;

    @PostMapping("/draw")
    public ResponseEntity<?> draw(@RequestBody Map<String, String> body) {
        try {

            String type = body.get("type");

            // parse core params
            float x = Float.parseFloat(body.get("x"));
            float y = Float.parseFloat(body.get("y"));
            Float p1 = body.get("param1") != null ? Float.parseFloat(body.get("param1")) : null;
            Float p2 = body.get("param2") != null ? Float.parseFloat(body.get("param2")) : null;
            Float p3 = body.get("param3") != null ? Float.parseFloat(body.get("param3")) : null;

            // optional points parameter can be provided as a string (comma or space separated)
            float[] pointsParam = null;
            if (body.get("points") != null) {
                pointsParam = parseFloatArray(body.get("points"));
            }

            Shape.ShapeBuilder drawer = ShapeFactory.createShapeBuilder(type,
                    x,
                    y,
                    p1,
                    p2,
                    p3,
                    pointsParam // Points param
            );

            // dynamic mapping for builder-level setters (all shapes share these through Shape.ShapeBuilder)
            Map<String, java.util.function.Consumer<String>> builderSetters = Map.of(
                    "fill", drawer::setFill,
                    "opacity", val -> drawer.setOpacity(Float.parseFloat(val)),
                    "strokeWidth", val -> drawer.setStrokeWidth(Float.parseFloat(val)),
                    "strokeFill", drawer::setStrokeFill,
                    "strokeOpacity", val -> drawer.setStrokeOpacity(Float.parseFloat(val)),
                    "rotation", val -> drawer.setRotation(Float.parseFloat(val))
            );

            for (Map.Entry<String, String> entry : body.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (builderSetters.containsKey(key)) {
                    builderSetters.get(key).accept(value);
                }
            }

            Shape shape = drawer.build();
            shape.setId(generated_id++);
            shapesService.putOrUpdate(shape);
            return ResponseEntity.ok(shape);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected error occurred: " + e.getMessage());
        }
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Map<String, String> body) {
        try {
            int id = Integer.parseInt(body.get("id"));

            Shape shape = shapesService.getById(id);
            if (shape == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Shape not found"));
            }

            // start with a mutable map of generic Shape setters
            Map<String, java.util.function.Consumer<String>> setters = new java.util.HashMap<>();
            setters.put("id", val -> shape.setId(Integer.parseInt(val)));
            setters.put("x", val -> shape.setX(Float.parseFloat(val)));
            setters.put("y", val -> shape.setY(Float.parseFloat(val)));
            setters.put("fill", shape::setFill);
            setters.put("opacity", val -> shape.setOpacity(Float.parseFloat(val)));
            setters.put("rotation", val -> shape.setRotation(Float.parseFloat(val)));
            setters.put("strokeFill", shape::setStrokeFill);
            setters.put("strokeOpacity", val -> shape.setStrokeOpacity(Float.parseFloat(val)));
            setters.put("strokeWidth", val -> shape.setStrokeWidth(Float.parseFloat(val)));


            if (shape instanceof Circle) {
                com.example.paint_backend.shapes.Circle c = (com.example.paint_backend.shapes.Circle) shape;
                setters.put("radius", val -> c.setRadius(Float.parseFloat(val)));
            }

            if (shape instanceof Rectangle) {
                com.example.paint_backend.shapes.Rectangle r = (com.example.paint_backend.shapes.Rectangle) shape;
                setters.put("width", val -> r.setWidth(Float.parseFloat(val)));
                setters.put("height", val -> r.setHeight(Float.parseFloat(val)));
            }

            if (shape instanceof Square) {
                com.example.paint_backend.shapes.Square s = (com.example.paint_backend.shapes.Square) shape;
                setters.put("edgeLength", val -> s.setEdgeLength(Float.parseFloat(val)));
            }

            if (shape instanceof Ellipse) {
                com.example.paint_backend.shapes.Ellipse e = (com.example.paint_backend.shapes.Ellipse) shape;
                setters.put("rx", val -> e.setRx(Float.parseFloat(val)));
                setters.put("ry", val -> e.setRy(Float.parseFloat(val)));
            }

            if (shape instanceof Polygon) {
                com.example.paint_backend.shapes.Polygon p = (com.example.paint_backend.shapes.Polygon) shape;
                setters.put("sidesCount", val -> p.setSidesCount(Float.parseFloat(val)));
                setters.put("edgeLength", val -> p.setEdgeLength(Float.parseFloat(val)));
                setters.put("radius", val -> p.setRadius(Float.parseFloat(val)));
            }

            if (shape instanceof LineSegment) {
                com.example.paint_backend.shapes.LineSegment l = (com.example.paint_backend.shapes.LineSegment) shape;
                setters.put("points", val -> l.setpoints(parseFloatArray(val)));
            }


            for (Map.Entry<String, String> entry : body.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (setters.containsKey(key)) {
                    setters.get(key).accept(value);
                }
            }


            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Unexpected error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")   //yet to be implemented
    public ResponseEntity<String> delete(@RequestBody Map<String, String> body) {
        try {
            int id = Integer.parseInt(body.get("id"));
            shapesService.remove(id);
            return ResponseEntity.ok("temp");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Unexpected error occurred");
        }
    }

    @PutMapping("/undo")
    public ResponseEntity<String> undo(@RequestBody Map<String, String> body) {
        try {
            shapesService.undo();

            return ResponseEntity.ok("temp");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Unexpected error occurred");
        }
    }

    @PutMapping("/redo")
    public ResponseEntity<String> redo(@RequestBody Map<String, String> body) {
        try {
            shapesService.redo();
            return ResponseEntity.ok("temp");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Unexpected error occurred");
        }
    }

    // helper to parse a float array from a string like "100,100,150,150" or "100 100 150 150"
    private static float[] parseFloatArray(String s) {
        if (s == null || s.isEmpty()) return new float[0];
        String[] parts = s.split("[^0-9.-]+");
        java.util.List<Float> values = new java.util.ArrayList<>();
        for (String p : parts) {
            if (p == null || p.isEmpty()) continue;
            try {
                values.add(Float.parseFloat(p));
            } catch (NumberFormatException ignored) {
            }
        }
        float[] arr = new float[values.size()];
        for (int i = 0; i < values.size(); i++) arr[i] = values.get(i);
        return arr;
    }

}
