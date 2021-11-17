package printer;

import dto.ResultModel;

import java.util.Map;

public class ResultsPrinter implements Printer {

    private Map<String, ResultModel> results;

    public ResultsPrinter(Map<String, ResultModel> results) {
        this.results = results;
    }

    public void print() {
        results.forEach((key, result) -> {
            System.out.println(result.id + "\n");

            result.ips.forEach((ip, numberOfMatches) -> {
                System.out.println(ip + ": " + numberOfMatches + "\n");
            });

            System.out.println("score: " + result.score);
            System.out.println("\n");
        });
    }
}
