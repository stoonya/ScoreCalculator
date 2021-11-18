package validator;

import com.google.common.net.InetAddresses;
import models.ScoreModel;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreObjectsFilter implements Validator<ScoreModel> {

    public List<ScoreModel> filter(List<ScoreModel> list) {
        return list.stream().filter(o -> isValidObject(o)).collect(Collectors.toList());
    }

    // assumption #1: if ip is null or not valid format, skip the entire result object
    // assumption #2: valid ip address means format xxx.xxx.xxx.xxx where xxx is a number from 0 to 255
    private boolean isValidIp(String ip) {
        return ip != null && InetAddresses.isInetAddress(ip);
    }

    // assumption #3: if score is null or not valid, skip the entire result object
    // assumption #4: valid score means positive integer or 0
    private boolean isValidScore(int score) {
        return score >= 0;
    }

    // assumption #5: if id is null, skip the entire result object
    private boolean isValidId(String id) {
        return id != null;
    }

    private boolean isValidObject(ScoreModel object) {
        return isValidId(object.getId()) && isValidScore(object.getScore()) && isValidIp(object.getIp());
    }
}
