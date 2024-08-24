package com.example.demo.controller;

import com.example.demo.model.Color;
import com.example.demo.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping("/{id}")
    public Color getColorById(@PathVariable String id) {
        return colorService.getColorById(id);
    }

    @GetMapping
    public List<Color> getAllColors() {
        return colorService.getAllColors();
    }

    @DeleteMapping("/{id}")
    public void deleteColorById(@PathVariable String id) {
        colorService.deleteColorById(id);
    }

    @DeleteMapping
    public void deleteAllColors() {
        colorService.deleteAllColors();
    }

    @PostMapping
    public ResponseEntity<Color> addColor(@RequestBody Color color) {
        try {
            Color addedColor = colorService.addColor(color);
            return ResponseEntity.ok(addedColor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public Color updateColor(@PathVariable String id, @RequestBody Color color) {
        return colorService.updateColor(id, color);
    }
}