package com.example.paintBackend.SaveLoad;

import com.example.paintBackend.Shapes.AbstractShape;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class SaveXML {
    private final ObjectMapper XmlMapper=new XmlMapper();

    public void writeToXML(String path, Map<String, AbstractShape> map) throws IOException {
        if(path.contains("undefined"))
            path=path.substring(9);
        XmlMapper.writeValue(new File(path),map);
    }

}
