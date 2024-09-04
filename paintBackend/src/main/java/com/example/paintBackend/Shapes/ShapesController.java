package com.example.paintBackend.Shapes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ShapesController {
    private final ShapesService shapesService;
    @Autowired
    public ShapesController(ShapesService shapesService) {

        this.shapesService = shapesService;
        this.shapesService.initialize();
    }
    @PostMapping("/create")
    public void CreateShape(@RequestBody String data)
    {



    }
}
