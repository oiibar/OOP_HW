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
    public String toString() {
        return "Question{id=" + id + ", question='" + question + "'}";
    }
}
