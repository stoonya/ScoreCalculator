package printer;

import dto.ResultDTO;

import java.util.List;
import java.util.Map;

public class ResultsPrinter implements Printer {

    private List<ResultDTO> results;

    public ResultsPrinter(List<ResultDTO> results) {
        this.results = results;
    }

    public void print() {
        for (ResultDTO result : results) {

            System.out.println(result.id + "\n");
            for (Map.Entry<String, Integer> ipEntry: result.ips.entrySet()) {
                System.out.println(ipEntry.getKey() + ": " + ipEntry.getValue() + "\n");
            }
            System.out.println("score: " + result.score);
            System.out.println("\n");
        }
    }
}
