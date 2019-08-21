package util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectMysql {

//    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static BasicDataSource dataSource;

    private static Connection connection;

    private static String URL = PropertiesUtil.getProperty("db.url", "jdbc:mysql://localhost:3306/mysql");
    private static String USERNAME = PropertiesUtil.getProperty("db.username", "root");
    private static String PASSWORD = PropertiesUtil.getProperty("db.password", "password");
    private static String initialSize = PropertiesUtil.getProperty("db.initialSize", "20");
    private static String maxActive = PropertiesUtil.getProperty("db.maxActive", "50");
    private static String maxIdle = PropertiesUtil.getProperty("db.maxIdle", "20");
    private static String minIdel = PropertiesUtil.getProperty("db.minIdle", "10");
    private static String maxWait = PropertiesUtil.getProperty("db.maxWait", "10");
    private static String defaultAutoCommit = PropertiesUtil.getProperty("db.defaultAutoCommit", "true");
    private static String minEvictableIdelTimeMillis = PropertiesUtil.getProperty("db.minEvictableIdleTimeMillis", "3600000");
    private static String driverName = PropertiesUtil.getProperty("db.driverClassName", "com.mysql.cj.jdbc.Driver");
    private static String driverLocation = PropertiesUtil.getProperty("db.driverLocation", "C:\\Users\\zackg\\Documents\\lib\\mysql-connector-java-5.1.46\\mysql-connector-java-5.1.46-bin.jar");

    static{
        if (dataSource == null)
        {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName(driverName);
            ds.setUrl(URL);
            ds.setUsername(USERNAME);
            ds.setPassword(PASSWORD);

            ds.setMinIdle(Integer.parseInt(minIdel));
            ds.setMaxIdle(Integer.parseInt(maxIdle));
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }
    }

    public static Connection getConnnection() {
        if (dataSource == null) {
            return null;
        } else {
            try {
                connection = dataSource.getConnection();
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
//                logger.error("连接数据库有异常");
                return null;
            }
        }
    }

    public static void closeConnection() {
        if (dataSource != null) {
            try {
                connection.close();
                dataSource.close();
            } catch (Exception e) {
                e.printStackTrace();
//                logger.error("关闭数据库异常");
            }
        }
    }

}
