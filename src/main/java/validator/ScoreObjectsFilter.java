package validator;

import dto.ScoreDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreObjectsFilter implements Validator<ScoreDTO> {

    public List<ScoreDTO> filter(List<ScoreDTO> list) {
        return list.stream().filter(o -> isValidObject(o)).collect(Collectors.toList());
    }

    // assumption #1: if ip is null or not valid format, skip the entire result object
    // assumption #2: valid ip address means format xxx.xxx.xxx.xxx where xxx is a number from 0 to 255
    private boolean isValidIp(String ip) {
        return ip != null && ip.matches("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
    }

    // assumption #3: if score is null or not valid, skip the entire result object
    // assumption #4: valid score means positive integer
    private boolean isValidScore(int score) {
        return score > 0;
    }

    // assumption #5: if id is null, skip the entire result object
    private boolean isValidId(String id) {
        return id != null;
    }

    private boolean isValidObject(ScoreDTO object) {
        return isValidId(object.id) && isValidScore(object.score) && isValidIp(object.ip);
    }
}
