package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.Number;
import util.ConnectMysql;
import util.PropertiesUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountNumber {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static final String TABLE = "shuangseqiu";

    public int countRedNumber(Number number) {
        return 0;
    }

    public static int countDoubleRedNumber(int firstOne, int secondOne) {
        int count = 0;
        java.lang.String sql = "select * from " + TABLE + " where (red1 = ? and red2 = ?) or (red1 = ? and red3 = ?) or (red1 = ? and red4 = ?) or (red1 = ? and red5 = ?) or (red1 = ? and red6 = ?) or (red2 = ? and red3 = ?) or (red2 = ? and red4 = ?) or (red2 = ? and red5 = ?) or (red2 = ? and red6 = ?) or (red3 = ? and red4 = ?) or (red3 = ? and red5 = ?) or (red3 = ? and red6 = ?) or (red4 = ? and red5 = ?) or (red4 = ? and red6 = ?) or (red5 = ? and red6 = ?);";
        Connection connection = ConnectMysql.getConnnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < 30; i++) {
                if ((i + 1) % 2 != 0) {
                    ps.setInt(i + 1, firstOne);
                } else {
                    ps.setInt(i+1, secondOne);
                }
            }
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常");
        } finally {
            return count;
        }
    }

    public static int countDoubleRedNumberAgain(int firstOne, int secondOne) {
        int count = 0;
        PreparedStatement ps = null;
        Connection connection = ConnectMysql.getConnnection();
        for (int i = 1; i <= 5; i++) {
            for (int j = i + 1; j <= 6; j++) {
                StringBuilder stringBuilder = new StringBuilder("select * from " + TABLE + " where red" + i + "=? and red" + j + "=?;");
                try {
                    ps = connection.prepareStatement(stringBuilder.toString());
                    ps.setInt(1, firstOne);
                    ps.setInt(2, secondOne);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        count++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    logger.error("查詢異常");
                }
            }
        }
        return count;
    }

    public int countTripleRedNumber(Number number) {
        return 0;
    }

    public int countUltraRedNumber(Number number) {
        return 0;
    }

    public int countRampageRedNumber(Number number) {
        return 0;
    }
}
