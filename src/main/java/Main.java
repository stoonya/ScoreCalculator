import dto.ResultDTO;
import dto.ScoreDTO;
import parser.JsonFileParser;
import parser.Parser;
import printer.Printer;
import printer.ResultsPrinter;
import calculator.ResultCalculator;
import calculator.ScoreResultCalculator;
import validator.ScoreObjectsFilter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Parser parser = new JsonFileParser("src/main/java/testData/testData.json", new ScoreObjectsFilter());
        List<ScoreDTO> jsonObjects = parser.parse(ScoreDTO.class);

        ResultCalculator calc = new ScoreResultCalculator();
        List<ResultDTO> results = new ArrayList<>();
        calc.calculateResults(results, jsonObjects);

        Printer printer = new ResultsPrinter(results);
        printer.print();
    }
}