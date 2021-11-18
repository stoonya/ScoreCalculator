import models.ResultModel;
import models.ScoreModel;
import parser.JsonFileScoreParser;
import parser.ScoreParser;
import printer.Printer;
import printer.ResultsPrinter;
import calculator.ResultCalculator;
import calculator.ScoreResultCalculator;
import validator.ScoreObjectsFilter;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ScoreParser scoreParser = new JsonFileScoreParser("src/main/java/testData/testData.json");
        ResultCalculator calc = new ScoreResultCalculator();
        ScoreObjectsFilter validator = new ScoreObjectsFilter();

        List<ScoreModel> jsonObjects = validator.filter(scoreParser.parse());
        List<ResultModel> results = calc.calculateResults(jsonObjects);

        Printer printer = new ResultsPrinter(results);
        printer.print();
    }
}