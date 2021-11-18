package parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileParser implements Parser {

    private ObjectMapper objectMapper;
    private String path;

    public JsonFileParser(String path) {
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
        this.path = path;
    }

    public <T> List<T> parse(Class<T> classType) {

        List<T> jsonObjects = null;

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, classType);
            jsonObjects =  objectMapper.readValue(new File(path), type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObjects;
    }
}
