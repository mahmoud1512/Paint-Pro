package com.example.paintBackend.Shapes;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
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
       String[]operators=data.split(" ",2);
      this.shapesService.copyShape(operators[0],operators[1]);
        System.out.println(operators[0]);
        System.out.println(operators[1]);
      System.out.println(this.shapesService.getShapes());
      return this.shapesService.getShapes();
    }

    @GetMapping("/Clear")
    public void Clear()
    {
        this.shapesService.clear();
        System.out.println("Cleared");
    }
    @PostMapping("/Delete")
    public void DeleteShape (@RequestBody String data)
    {
        System.out.println("Hakai");
        this.shapesService.deleteShape(data);
    }
    @PostMapping("/Modify")
    public void ModifyShape(@RequestBody String data) throws JsonProcessingException {
        String[]operators=data.split(" ",3);
        System.out.println(operators[0]);
        System.out.println(operators[1]);
        System.out.println(operators[2]);
        System.out.println("Modifyyyyy");
        this.shapesService.modifyShape(operators[0],operators[1],operators[2]);
    }
    @GetMapping("/Reset")
    public void resetEnvironment()
    {
        this.shapesService.reset();
        System.out.println("make a reset");
    }
}
