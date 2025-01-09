import java.sql.*;

public class Main {
    public static void main(String[] args) {
        CandidateDAO candidateDAO = null;

        try {
            candidateDAO = new CandidateDAO();

            candidateDAO.createTable();
            candidateDAO.clearTable();

            candidateDAO.insertCandidate("Aibar", 70);
            candidateDAO.insertCandidate("Test", 80);
            candidateDAO.getAllCandidates();

            candidateDAO.updateCandidateScore("Aibar", 90);
            candidateDAO.getAllCandidates();

            candidateDAO.deleteCandidate("Test");
            candidateDAO.getAllCandidates();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            if (candidateDAO != null) {
                try {
                    candidateDAO.closeConnection();
                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                }
            }
        }
    }
}
