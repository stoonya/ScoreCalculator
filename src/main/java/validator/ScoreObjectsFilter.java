package validator;

import com.google.common.net.InetAddresses;
import models.ScoreModel;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreObjectsFilter implements Validator<ScoreModel> {

    public List<ScoreModel> filter(List<ScoreModel> list) {
        return list.stream().filter(o -> isValidObject(o)).collect(Collectors.toList());
    }

    // Assumption: If ip is null or not in valid format (IPv4 or IPv6), skip the entire result object
    private boolean isValidIp(String ip) {
        return ip != null && InetAddresses.isInetAddress(ip);
    }

    // Assumption: Score is an integer
    // Assumption: If score is null or less than 0, skip the entire result object
    private boolean isValidScore(int score) {
        return score >= 0;
    }

    // Assumption: If id is null, skip the entire result object
    private boolean isValidId(String id) {
        return id != null;
    }

    private boolean isValidObject(ScoreModel object) {
        return isValidId(object.getId()) && isValidScore(object.getScore()) && isValidIp(object.getIp());
    }
}