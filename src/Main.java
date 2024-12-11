import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Candidate> candidates = getCandidates();

        List<Candidate> sortedCandidates = candidates.stream().sorted(Comparator.comparingInt(Candidate::getScore).reversed()).toList();
        System.out.println("\nSorted candidates: " + sortedCandidates);

        List<Candidate> filteredCandidates = candidates.stream().filter(i -> i.getScore() >= 70).toList();
        System.out.println("Passed candidates: " + filteredCandidates);

        int failedStudentId = 1111;
        Candidate failedStudent = candidates.stream().filter(i -> i.getId() == failedStudentId).findFirst().orElse(null);
        System.out.println(failedStudent != null ? "\nFailed candidates: " + failedStudent : "Candidate not found");
    }

    private static List<Candidate> getCandidates() {
        Admin admin = new Admin(1, "Professor");
        Candidate student1 = new Candidate(7, "Jane Doe", 69);
        Candidate student2 = new Candidate(8, "Jack Smith", 70);
        Question question1 = new Question(1111, "Is Java interpreted or compiled language?", "Both", new String[]{"Interpreted", "Compiled", "Both"});
        Question question2 = new Question(1007, "Are Java & JavaScript the same?", "No", new String[]{"Yes", "No"});

        admin.addQuestion(question1);
        admin.addQuestion(question2);

        List<Candidate> candidates = new ArrayList<>();
        candidates.add(student1);
        candidates.add(student2);
        return candidates;
    }
}