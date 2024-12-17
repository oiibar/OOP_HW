import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<User> users = getUsers();
        users.forEach(User::display);
        List<Candidate> sortedCandidates = users.stream()
                .filter(user -> user instanceof Candidate)
                .map(user -> (Candidate) user)
                .sorted(Comparator.comparingInt(Candidate::getScore).reversed())
                .toList();

        System.out.println("\nSorted candidates: " + sortedCandidates);

        List<Candidate> passedCandidates = sortedCandidates.stream()
                .filter(candidate -> candidate.getScore() >= 70)
                .toList();

        System.out.println("Passed candidates: " + passedCandidates);

        int searchId = 1111;
        Candidate failedStudent = findCandidateById(users, searchId);
        System.out.println(failedStudent != null ? "\nFailed candidate: " + failedStudent : "Candidate not found");
    }

    private static List<User> getUsers() {
        Admin admin = new Admin(1, "Professor");
        Candidate student1 = new Candidate(1111, "Aibar Tolegenov", 64);
        Candidate student2 = new Candidate(8, "Jack Smith", 70);

        admin.addQuestion(new Question(1, "Is Java interpreted or compiled language?", "Both", new String[]{"Interpreted", "Compiled", "Both"}));
        admin.addQuestion(new Question(2, "Are Java & JavaScript the same?", "No", new String[]{"Yes", "No"}));

        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(student1);
        users.add(student2);

        return users;
    }

    private static Candidate findCandidateById(List<User> users, int id) {
        return users.stream()
                .filter(user -> user instanceof Candidate && user.getId() == id)
                .map(user -> (Candidate) user)
                .findFirst()
                .orElse(null);
    }
}
