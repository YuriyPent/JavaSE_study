package basejava.jdbc;

import java.sql.*;

public class Jdbc {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/store?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password);
                    Statement statement = connection.createStatement()) 
            {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM table");
                while (resultSet.next()) 
                {
                    System.out.println(resultSet.getString(2));
                }
                resultSet.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
    }
}
