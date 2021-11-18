package calculator;

import dto.ResultModel;

import java.util.List;

public interface ResultCalculator <T> {

    List<ResultModel> calculateResults(List<T> objects);
}
