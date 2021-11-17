package calculator;

import dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ScoreResultCalculator implements ResultCalculator<ScoreDTO> {

    private ResultDTO addAsNewResult(ScoreDTO object) {
        ResultDTO result = new ResultDTO();

        result.id = object.id;

        result.ips = new HashMap<>();
        addIpToResult(result, object.ip, false);

        result.score = object.score;

        return result;
    }

    private void addToExistingResult(ResultDTO existingResult, ScoreDTO object) {
        existingResult.score += object.score;

        boolean isExistingIp = false;

        for (String ipKey: existingResult.ips.keySet()) {
            if (ipKey.equals(object.ip)) {
                addIpToResult(existingResult, ipKey, true);
                isExistingIp = true;
            }
        }

        if (!isExistingIp) {
            addIpToResult(existingResult, object.ip, false);
        }
    }

    private void addIpToResult(ResultDTO result, String ip, boolean isExistingIp) {

            if (!isExistingIp) {
                result.ips.put(ip, 1);
            } else {
                result.ips.put(ip, result.ips.get(ip) + 1);
            }
    }

    public List<ResultDTO> calculateResults(List<ScoreDTO> objects) {

        List<ResultDTO> results = new ArrayList<>();

        for (ScoreDTO object : objects) {

            if (results.size() == 0) {

                results.add(addAsNewResult(object));

                continue;
            }

            boolean isExistingId = false;

            for (ResultDTO result : results) {

                if (result.id.equals(object.id)) {

                    addToExistingResult(result, object);

                    isExistingId = true;

                    break;
                }
            }

            if (!isExistingId) {
                results.add(addAsNewResult(object));
            }
        }

        return results;
    }
}
