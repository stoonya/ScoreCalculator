package models;

public class ScoreModel {

    private String id;
    // Assumption: Score is an integer
    private int score;
    private String ip;

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getIp() {
        return ip;
    }
}
