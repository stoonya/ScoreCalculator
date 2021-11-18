package models;

import java.util.HashMap;

public class ResultModel {

    private String id;
    private HashMap<String, Integer> ips;
    private int score;

    public ResultModel(String id, int score) {
        this.id = id;
        this.ips = new HashMap<>();
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, Integer> getIps() {
        return ips;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
