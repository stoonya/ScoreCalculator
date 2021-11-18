package printer;

import models.ResultModel;

import java.util.List;

public class ResultsPrinter implements Printer {

    private List<ResultModel> results;

    public ResultsPrinter(List<ResultModel> results) {
        this.results = results;
    }

    public void print() {
        for(ResultModel result: results) {
            System.out.println(result.getId() + "\n");

            result.getIps().forEach((ip, numberOfMatches) -> {
                System.out.println(ip + ": " + numberOfMatches + "\n");
            });

            System.out.println("score: " + result.getScore());
            System.out.println("\n");
        }
    }
}
