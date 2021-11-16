package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"message"})
public class ScoreDTO extends BaseDTO {
    public String id;
    public int score;
    public String ip;
    public String message;
}
