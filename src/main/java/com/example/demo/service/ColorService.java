package com.example.demo.service;

import com.example.demo.model.Color;
import com.example.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public Color getColorById(String id) {
        return colorRepository.findById(id).orElse(null);
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public void deleteColorById(String id) {
        colorRepository.deleteById(id);
    }

    public void deleteAllColors() {
        colorRepository.deleteAll();
    }

    public Color addColor(Color color) {
        Color existingColor = colorRepository.findByColorValue(color.getColorValue());
        if (existingColor != null) {
            throw new RuntimeException("Can't create duplicate ColorValue entries");
        }
        return colorRepository.save(color);
    }

    public Color updateColor(String id, Color color) {
        Color existingColor = colorRepository.findById(id).orElse(null);
        if (existingColor != null) {
            existingColor.setColorValue(color.getColorValue());
            existingColor.setColorCode(color.getColorCode());
            return colorRepository.save(existingColor);
        }
        return null;
    }
}