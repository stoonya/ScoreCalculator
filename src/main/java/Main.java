import dto.ResultModel;
import dto.ScoreModel;
import parser.JsonFileParser;
import parser.Parser;
import printer.Printer;
import printer.ResultsPrinter;
import calculator.ResultCalculator;
import calculator.ScoreResultCalculator;
import validator.ScoreObjectsFilter;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Parser parser = new JsonFileParser("src/main/java/testData/testData.json", new ScoreObjectsFilter());
        List<ScoreModel> jsonObjects = parser.parse(ScoreModel.class);

        ResultCalculator calc = new ScoreResultCalculator();
        List<ResultModel> results = calc.calculateResults(jsonObjects);

        Printer printer = new ResultsPrinter(results);
        printer.print();
    }
}