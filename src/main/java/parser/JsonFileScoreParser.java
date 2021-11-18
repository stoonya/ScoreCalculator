package parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ScoreModel;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileScoreParser implements ScoreParser {

    private ObjectMapper objectMapper;
    private String path;

    public JsonFileScoreParser(String path) {
        // Assumption: Extra fields from JSON are ignored (fields that are not "id", "ip" and "score")
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
        this.path = path;
    }

    public List<ScoreModel> parse() {

        List<ScoreModel> jsonObjects = null;

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, ScoreModel.class);
            jsonObjects =  objectMapper.readValue(new File(path), type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObjects;
    }
}