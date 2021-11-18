package parser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import validator.Validator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileParser implements Parser {

    private ObjectMapper objectMapper;
    private String path;
    private Validator validator;

<<<<<<< Updated upstream:src/main/java/parser/JsonFileParser.java
    public JsonFileParser(String path, Validator validator) {
        this.objectMapper = new ObjectMapper();
        this.validator = validator;
=======
    public JsonFileScoreParser(String path) {
        // Assumption: Extra fields from JSON are ignored (fields that are not "id", "ip" and "score")
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
>>>>>>> Stashed changes:src/main/java/parser/JsonFileScoreParser.java
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

        return validator.filter(jsonObjects);
    }
}
