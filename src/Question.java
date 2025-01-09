import java.util.Arrays;
import java.util.Objects;

public class Question {
    private int id;
    private String question;
    private String answer;
    private String[] options;

    public Question(int id, String question, String answer, String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public int getId() {
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public String[] getOptions() {
        return options;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setOptions(String[] options) {
        this.options = options;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return id == question1.id && Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer) && Objects.deepEquals(options, question1.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, Arrays.hashCode(options));
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }
}
