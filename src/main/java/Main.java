import dto.ResultDTO;
import dto.ScoreDTO;
import parser.JsonFileParser;
import parser.Parser;
import printer.Printer;
import printer.ResultsPrinter;
import resultCalculator.ResultCalculator;
import resultCalculator.ScoreResultCalculator;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Parser parser = new JsonFileParser("src/main/java/testData/testData.json");
        List<ScoreDTO> jsonObjects = parser.parse(ScoreDTO.class);

        ResultCalculator calc = new ScoreResultCalculator();
        List<ResultDTO> results = new ArrayList<ResultDTO>();
        calc.calculateResults(results, jsonObjects);

        Printer printer = new ResultsPrinter(results);
        printer.print();
    }
}