package calculator;

import models.ResultModel;

import java.util.List;

public interface ResultCalculator <T> {

    List<ResultModel> calculateResults(List<T> objects);
}
