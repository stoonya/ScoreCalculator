import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFileParser implements Parser {

    private Model model;
    private ObjectMapper objectMapper;
    private String path;

    public JsonFileParser(Model model, String path) {
        this.objectMapper = new ObjectMapper();
        this.model = model;
    }

    public void parse() {
        try {
            model = objectMapper.readValue(new File(path), model.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
