import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        JsonFileParser jsonParser = new JsonFileParser("src/main/java/testData/testData.json");

        ArrayList<ScoreObjectModel> jsonObjects = jsonParser.parse(ScoreObjectModel.class);

        List<Result> results = null;

        for (ScoreObjectModel object : jsonObjects) {

            if (results == null || results.size() < 1) {

                results = new ArrayList<Result>();

                Result result = new Result();

                result.id = object.id;

                result.ips = new HashMap<String, Integer>();
                result.ips.put(object.ip, 1);

                result.score = object.score;

                results.add(result);

                continue;
            }

            boolean isExistingId = false;

            for (Result result : results) {

                if (result.id.equals(object.id)) {

                    result.score += object.score;

                    boolean isExistingIp = false;

                    for (String ipKey: result.ips.keySet()) {
                        if (ipKey.equals(object.ip)) {
                            result.ips.put(ipKey, result.ips.get(ipKey) + 1);
                            isExistingIp = true;
                        }
                    }

                    if (!isExistingIp) {
                        result.ips.put(object.ip, 1);
                    }

                    isExistingId = true;

                    break;
                }
            }

            if (!isExistingId) {
                Result result = new Result();

                result.id = object.id;

                result.ips = new HashMap<String, Integer>();
                result.ips.put(object.ip, 1);

                result.score = object.score;

                results.add(result);
            }
        }

        for (Result result : results) {

            System.out.println(result.id + "\n");
            for (Map.Entry<String, Integer> ipEntry: result.ips.entrySet()) {
                System.out.println(ipEntry.getKey() + ": " + ipEntry.getValue() + "\n");
            }
            System.out.println("score: " + result.score);
            System.out.println("\n");

        }
    }
}

class Result {
    public String id;
    public HashMap <String, Integer> ips;
    public int score;
}