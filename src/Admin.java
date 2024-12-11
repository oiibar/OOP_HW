public class Admin extends User {
    public Admin(int id, String name) {
        super(id, name);
    }

    public void addQuestion(Question question) {
        System.out.println("Question added: " + question);
    }
}
