import java.sql.*;

public class Database {
    private Connection connection;
    private Statement statement;

    public Database() {
        try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cobaTP2DPBO", "root","");
             statement = connection.createStatement(); // SELECT * FROM mahasiswa, UPDATE, DELETE
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // digunakan untuk SELECT
    public ResultSet selectQuery(String sql) {
        try {
            statement.executeQuery(sql);
            return statement.getResultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // digunakan untuk INSERT, UPDATE, DAN DELETE
    public int insertUpdateDeleteQuery(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement() {
        return statement;
    }
}
