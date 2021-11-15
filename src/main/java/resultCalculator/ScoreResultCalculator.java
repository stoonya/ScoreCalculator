package resultCalculator;

import dto.*;
import java.util.HashMap;
import java.util.List;


public class ScoreResultCalculator implements ResultCalculator<ScoreDTO> {

    private ResultDTO addAsNewResult(ScoreDTO jsonObject) {
        ResultDTO result = new ResultDTO();

        result.id = jsonObject.id;

        result.ips = new HashMap<String, Integer>();
        result.ips.put(jsonObject.ip, 1);

        result.score = jsonObject.score;

        return result;
    }

    private void addToExistingResult(ResultDTO existingResult, ScoreDTO object) {
        existingResult.score += object.score;

        boolean isExistingIp = false;

        for (String ipKey: existingResult.ips.keySet()) {
            if (ipKey.equals(object.ip)) {
                existingResult.ips.put(ipKey, existingResult.ips.get(ipKey) + 1);
                isExistingIp = true;
            }
        }

        if (!isExistingIp) {
            existingResult.ips.put(object.ip, 1);
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
