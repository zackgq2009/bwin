package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMysql {

    private static String HOSTNAME;
    private static String DATABASE;
    private static String TABLE;

    public ConnectMysql() {
    }

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo?useSSL=false&serverTimezone=UTC","root","password");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常造成数据库连接失败");
        } finally {

        }
    }
}
