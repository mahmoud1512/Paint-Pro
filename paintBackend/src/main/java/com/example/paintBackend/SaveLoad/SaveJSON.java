package com.example.paintBackend.SaveLoad;

import com.example.paintBackend.Shapes.AbstractShape;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class SaveJSON {
    private final ObjectMapper mapper=new ObjectMapper();



    public void writeToFile(String path,Map<String,AbstractShape>map) throws IOException {
        if(path.contains("undefined"))
        {
            path=path.substring(9);
        }
        mapper.writeValue(new File(path),map);

    }
}
