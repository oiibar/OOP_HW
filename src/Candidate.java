public class Candidate extends User {
    private int score;

    public Candidate(int id, String name, int score) {
        super(id, name);
        this.score = score;
    }

    @Override
    public void display() {
        System.out.println("Candidate details: " + this);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score < 0) {
            System.out.println("Invalid score");
        } else {
            this.score = score;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", score=" + score;
    }
}
