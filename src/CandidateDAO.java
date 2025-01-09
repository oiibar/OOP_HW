import java.sql.*;

public class CandidateDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/OOPHW";
    private final Connection connection;

    public CandidateDAO() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL, "postgres", "123");
    }

    public void createTable() throws SQLException {
        String createTableQuery = """
                CREATE TABLE IF NOT EXISTS candidates (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(50),
                    score INT
                );
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
            System.out.println("Table created");
        }
    }

    public void clearTable() throws SQLException {
        String deleteAllQuery = "DELETE FROM candidates";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(deleteAllQuery);
            System.out.println("Cleared all\n");
        }
    }

    public void insertCandidate(String name, int score) throws SQLException {
        String insertQuery = "INSERT INTO candidates (name, score) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, score);
            preparedStatement.executeUpdate();
            System.out.println("Created");
        }
    }

    public void updateCandidateScore(String name, int newScore) throws SQLException {
        String updateQuery = "UPDATE candidates SET score = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, newScore);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            System.out.println("Updated");
        }
    }

    public void deleteCandidate(String name) throws SQLException {
        String deleteQuery = "DELETE FROM candidates WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Deleted");
        }
    }

    public void getAllCandidates() throws SQLException {
        String selectQuery = "SELECT * FROM candidates";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " +
                        resultSet.getString("name") + " " +
                        resultSet.getInt("score"));
            }
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Disconnected");
        }
    }
}
