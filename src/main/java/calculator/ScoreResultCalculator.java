package calculator;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ScoreResultCalculator implements ResultCalculator<ScoreModel> {

    private void addAsNewResult(ScoreModel object, Map<String, ResultModel> results) {

        ResultModel result = new ResultModel(object.getId(), object.getScore());
        addIpToResult(result, object.getIp());

        results.put(result.getId(), result);
    }

    private void addToExistingResult(ScoreModel object, ResultModel result) {
        result.setScore(result.getScore() + object.getScore());
        addIpToResult(result, object.getIp());
    }

    private void addIpToResult(ResultModel result, String ip) {
        if (result.getIps().containsKey(ip)) {
            result.getIps().put(ip, result.getIps().get(ip) + 1);
        } else {
            result.getIps().put(ip, 1);
        }
    }

    public List<ResultModel> calculateResults(List<ScoreModel> objects) {

        Map<String, ResultModel> results = new HashMap<>();

        for (ScoreModel object : objects) {

            if (results.containsKey(object.getId())) {
                addToExistingResult(object, results.get(object.getId()));
            } else {
                addAsNewResult(object, results);
            }
        }

        return new ArrayList<>(results.values());
    }
}
