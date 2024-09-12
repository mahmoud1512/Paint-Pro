package com.example.paintBackend.SaveLoad;

import com.example.paintBackend.Shapes.AbstractShape;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class LoadJSON {
    private  final ObjectMapper mapper=new ObjectMapper();

    public Map<String, AbstractShape> ReadData(String path) throws IOException {
        if(path.contains("undefined"))
        {
            path=path.substring(9);
        }
        File file=new File(path);
        return mapper.readValue(file, new TypeReference<Map<String, AbstractShape>>() {});
    }
}
