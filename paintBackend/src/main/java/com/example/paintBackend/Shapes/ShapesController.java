package com.example.paintBackend.Shapes;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ShapesController {
    private final ShapesService shapesService;
    @Autowired
    public ShapesController(ShapesService shapesService) {

        this.shapesService = shapesService;
        this.shapesService.initialize();
    }
    @PostMapping("/create")
    public void CreateShape(@RequestBody String data) throws JsonProcessingException {
           String[]operators=data.split(" ",3);
           shapesService.createShape(operators[0],operators[1],operators[2]);

    }
    @PostMapping("/Copy")
    public List<AbstractShape> CopyShape(@RequestBody String data)
    {
      this.shapesService.copyShape(data);
      return this.shapesService.getShapes();
    }

    @GetMapping("/Clear")
    public void Clear()
    {
        this.shapesService.clear();
    }
    @PostMapping("/Delete")
    public void DeleteShape (@RequestBody String data)
    {
        this.shapesService.deleteShape(data);
    }
    @PostMapping("/Modify")
    public void ModifyShape(@RequestBody String data) throws JsonProcessingException {
        String[]operators=data.split(" ",3);
        this.shapesService.modifyShape(operators[0],operators[1],operators[2]);
    }
}
