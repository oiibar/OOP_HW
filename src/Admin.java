public class Admin extends User {
    public Admin(int id, String name) {
        super(id, name);
    }

    @Override
    public void display() {
        System.out.println("Admin details: " + this);
    }

    public void addQuestion(Question question) {
        System.out.println("Question added: " + question);
    }
}
