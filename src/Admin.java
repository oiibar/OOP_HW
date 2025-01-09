public class Admin extends User {
    public Admin(int id, String name) {
        super(id, name);
    }

    @Override
    public void display() {
        System.out.println("Admin: " + this);
    }

    public void addQuestion(Question question) {
        System.out.println("Question added: " + question);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
