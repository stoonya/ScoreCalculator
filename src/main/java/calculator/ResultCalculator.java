package calculator;

import dto.BaseDTO;
import dto.ResultDTO;

import java.util.List;

public interface ResultCalculator <T extends BaseDTO> {

    void calculateResults(List<ResultDTO> results, List<T> objects);
}
