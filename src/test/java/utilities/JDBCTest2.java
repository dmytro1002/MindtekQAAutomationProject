package utilities;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest2 {

    public static void main(String[] args) throws SQLException {

        JDBCUtils.connectToDB("HR_production");
        List<Map<String,Object>> data=JDBCUtils.runQuery("select * from employees");
        System.out.println(data);


        JDBCUtils.connectToDB("elardb");
        List<Map<String,Object>> data2=JDBCUtils.runQuery("select * from core_company");
        System.out.println(data2);

    }

}
