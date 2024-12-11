public class Candidate extends User {
    private int score;

    public Candidate (int id, String name, int score) {
        super(id, name);
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return super.toString() + ", score=" + score;
    }
}
