package com.example.paintBackend.SaveLoad;

import com.example.paintBackend.Shapes.AbstractShape;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;

@Service
public class LoadXML {
    private final ObjectMapper XmlMapper=new XmlMapper();  //mapper for XML data

    public Map<String, AbstractShape> loadFromXML(String path) throws IOException {
        if(path.contains("undefined"))
            path=path.substring(9);
        TypeReference<Map<String,AbstractShape>> ref= new TypeReference<Map<String, AbstractShape>>(){};
        return XmlMapper.readValue(new File(path),ref);

    }
}
