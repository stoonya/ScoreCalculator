package parser;

import java.util.ArrayList;

public interface Parser {
    <T> ArrayList<T> parse(Class<T> classType);
}
