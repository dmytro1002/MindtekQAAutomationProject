package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {


    /*
.connectToDB("HR_production"); -> method should connect to database
.runQuery("Select * from departments"); -> method runs query and returns as List of Maps
 */

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void connectToDB(String dbName) throws SQLException {
        if (dbName.equalsIgnoreCase("HR_production")){
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/HR_production",
                        "postgres",
                        "Admin123"
                );
                statement = connection.createStatement();
            }catch (SQLException e) {
                System.out.println("Connection database was unsuccessful." + e.getMessage());
            }
        }else if (dbName.equalsIgnoreCase("elardb")){
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://3.135.206.245:5432/elardb",
                        "impleyer",
                        "ciforest"
                );
                statement = connection.createStatement();
            }catch (SQLException e) {
                System.out.println("Connection database was unsuccessful." + e.getMessage());
            }
        }
    }
    public static List<Map<String, Object>> runQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<Map<String, Object>> table = new ArrayList<>();

        while (resultSet.next()){
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                row.put(resultSetMetaData.getColumnName(i), resultSet.getString(resultSetMetaData.getColumnName(i)));
            }
            table.add(row);
        }
        return table;
    }
}
