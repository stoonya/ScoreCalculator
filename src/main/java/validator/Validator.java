package validator;

import java.util.List;

public interface Validator<T> {
    List<T>filter(List<T> list);
}
