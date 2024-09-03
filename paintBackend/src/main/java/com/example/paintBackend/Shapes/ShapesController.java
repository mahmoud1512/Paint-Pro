package com.example.paintBackend.Shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapesController {

    @Autowired
    ShapesService myApp;
}
