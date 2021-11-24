package calculator;

import models.ResultModel;
import models.ScoreModel;
import org.junit.jupiter.api.Assertions;
import java.util.*;

class ScoreResultCalculatorTest {

    @org.junit.jupiter.api.Test
    void shouldGroupResultsById() {

        List<ScoreModel> objects = Arrays.asList(
                new ScoreModel("test", 0, "1.2.3.4"),
                new ScoreModel("", 0, "1.2.3.4"),
                new ScoreModel("2", 0, "1.2.3.4"),
                new ScoreModel("test", 0, "1.2.3.4"),
                new ScoreModel("!@#$%^", 0, "1.2.3.4"));

        List<ResultModel> actualResults = new ScoreResultCalculator().calculateResults(objects);
        List<String> expectedResultIds = Arrays.asList("", "2", "test", "!@#$%^");

        for (int i = 0; i < actualResults.size(); i++) {
            Assertions.assertEquals(actualResults.get(i).getId(), expectedResultIds.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void shouldSumScoreById() {

        List<ScoreModel> objects = Arrays.asList(
                new ScoreModel("test", 0, "1.2.3.4"),
                new ScoreModel("test", 99, "1.2.3.4"),
                new ScoreModel("test", 1, "1.2.3.4"),
                new ScoreModel("test", 2147483547, "1.2.3.4"),
                new ScoreModel("test2", 7, "1.2.3.4"));

        List<ResultModel> actualResults = new ScoreResultCalculator().calculateResults(objects);
        List<Integer> expectedResultScores = Arrays.asList(7, 2147483647);

        for (int i = 0; i < actualResults.size(); i++) {
            Assertions.assertEquals(actualResults.get(i).getScore(), expectedResultScores.get(i));
        }
    }
}