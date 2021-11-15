import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import parser.Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonFileParser implements Parser {

    private ObjectMapper objectMapper;
    private String path;

    public JsonFileParser(String path) {
        this.objectMapper = new ObjectMapper();
        this.path = path;
    }

    public <T> ArrayList<T> parse(Class<T> classType) {

        ArrayList<T> jsonObjects = null;

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, classType);
            jsonObjects =  objectMapper.readValue(new File(path),type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObjects;
    }
}
