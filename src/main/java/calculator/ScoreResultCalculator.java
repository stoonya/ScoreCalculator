package calculator;

import dto.*;
import java.util.HashMap;
import java.util.List;


public class ScoreResultCalculator implements ResultCalculator<ScoreDTO> {

    private ResultDTO addAsNewResult(ScoreDTO object) {
        ResultDTO result = new ResultDTO();

        result.id = object.id;

        result.ips = new HashMap<String, Integer>();
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

    public void calculateResults(List<ResultDTO> results, List<ScoreDTO> objects) {
        for (ScoreDTO object : objects) {

            if (results == null || results.size() < 1) {

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
    }
}
