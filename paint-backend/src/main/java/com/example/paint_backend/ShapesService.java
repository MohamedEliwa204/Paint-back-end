package com.example.paint_backend;

import com.example.paint_backend.shapes.Shape;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Stack;


@Service
public class ShapesService {
    Stack<HashMap<Integer, Shape>> history = new Stack<>();
    Stack<HashMap<Integer, Shape>> redoHistory = new Stack<>();

    HashMap<Integer, Shape> shapes = new HashMap<>();


    public void putOrUpdate(Shape shape) {
        shapes.put(shape.getId(), shape);

    }

    public Shape getById(int id) {
        return shapes.get(id);
    }

    public void remove(int id){
        shapes.remove(id);
    }
}

