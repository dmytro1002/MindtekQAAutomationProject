package utilities;

import io.cucumber.java.hu.Ha;
import io.cucumber.java.it.Ma;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    public static void main(String[] args) throws SQLException {

        /*
        3 Interfaces
            Connection
            Statement
            Resultset
         */

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/HR_production",
                "postgres",
                "Admin123"
        );

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employees");

//        while (resultSet.next()){
//        System.out.println(resultSet.getString("first_name"));
//        }
//
//        System.out.println("=====================");
//
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("last_name"));
//        }

        // ResultSetMetaDate will provide information of columns
        ResultSetMetaData rsMetaData = resultSet.getMetaData();

        System.out.println(rsMetaData.getColumnCount());
        System.out.println(rsMetaData.getColumnName(1));

        System.out.println("=========== Column Names ============");

        for (int i = 1; i<= rsMetaData.getColumnCount();i++){
            System.out.print(rsMetaData.getColumnName(i));
        }

        resultSet.next();
        System.out.println(resultSet.getString(rsMetaData.getColumnName(7)));

        List<Map<String, Object>> table = new ArrayList<>();

        // Looping through ROWS
        while (resultSet.next()){
            Map<String, Object> row = new HashMap<>();
            // In every row we are looping through COLUMNS
            for (int i=1; i<=rsMetaData.getColumnCount();i++){
                row.put(rsMetaData.getColumnName(i),resultSet.getString(rsMetaData.getColumnName(i)));
            }
            table.add(row);
        }
        System.out.println(table);
        System.out.println(table.get(9).get("hire_date"));
        System.out.println(table.get(12).get("last_name"));

        System.out.println("==================");

        for (int i=1;i< table.size();i++){
            if (Integer.parseInt(table.get(i).get("employee_id").toString())%2==1){
                System.out.println(table.get(i).get("first_name")+" "+table.get(i).get("last_name"));
            }
        }

        System.out.println("===Print employees first_name, hire_date who was hired before 1999 ========");

        for (int i=1;i< table.size();i++){
            if (Integer.parseInt(table.get(i).get("hire_date").toString().substring(0,4))<1999){
                System.out.println(table.get(i).get("first_name")+" "+table.get(i).get("hire_date"));
            }
        }



    }

}
