import java.sql.*;

public class DBConnection
{
    // Connection variable setup.
    public Connection connection = null;
    public Statement statement;
    public ResultSet resultSet;

    // final variable setup.
    private final String url = "jdbc:mysql://localhost:3306/dbfood";
    private final String useername = "root";
    private final String password = "0123456788project";

    // Connect method.
    public ResultSet getConnect(String sql)
    {
        try {
            connection = DriverManager.getConnection(url, useername, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    // Update Database method.
    public void getUpdate(String sql)
    {
        try {
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Disconnect method.
    public void disconnect()
    {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
