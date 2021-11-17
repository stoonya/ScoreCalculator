package calculator;

import dto.BaseDTO;
import dto.ResultDTO;

import java.util.List;

public interface ResultCalculator <T extends BaseDTO> {

    List<ResultDTO> calculateResults(List<T> objects);
}
