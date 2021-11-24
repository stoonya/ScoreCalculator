package models;

public class ScoreModel {

    private String id;
    // Assumption: Score is an integer
    private int score;
    private String ip;

    public ScoreModel(String id, int score, String ip) {
        this.id = id;
        this.score = score;
        this.ip = ip;
    }

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
