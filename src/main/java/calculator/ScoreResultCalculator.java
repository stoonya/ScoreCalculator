package calculator;

import dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ScoreResultCalculator implements ResultCalculator<ScoreModel> {

    private void addAsNewResult(ScoreModel object, Map<String, ResultModel> results) {
        ResultModel result = new ResultModel();

        result.ips = new HashMap<>();
        addIpToResult(result, object.ip);
        result.id = object.id;
        result.score = object.score;

        results.put(result.id, result);
    }

    private void addToExistingResult(ScoreModel object, ResultModel result) {
        result.score += object.score;
        addIpToResult(result, object.ip);
    }

    private void addIpToResult(ResultModel result, String ip) {
        if (result.ips.containsKey(ip)) {
            result.ips.put(ip, result.ips.get(ip) + 1);
        } else {
            result.ips.put(ip, 1);
        }
    }

    public List<ResultModel> calculateResults(List<ScoreModel> objects) {

        Map<String, ResultModel> results = new HashMap<>();

        for (ScoreModel object : objects) {

            if (results.containsKey(object.id)) {
                addToExistingResult(object, results.get(object.id));
            } else {
                addAsNewResult(object, results);
            }
        }

        return new ArrayList<>(results.values());
    }
}
