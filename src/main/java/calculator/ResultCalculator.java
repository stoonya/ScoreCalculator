package calculator;

import dto.ResultModel;

import java.util.List;
import java.util.Map;

public interface ResultCalculator <T> {

    Map<String, ResultModel> calculateResults(List<T> objects);
}
