import java.util.Objects;

public class Candidate extends User {
    private int score;
    public Candidate(){}
    public Candidate(int id, String name, int score) {
        super(id, name);
        this.score = score;
    }

    public Candidate(int id, String name) {
        super(id, name);
    }

    @Override
    public void display() {
        System.out.println("Candidate: " + this);
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
        return "Candidate{" +
                "score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candidate candidate = (Candidate) o;
        return score == candidate.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), score);
    }
}
