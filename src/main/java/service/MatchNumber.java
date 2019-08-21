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

public class MatchNumber {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public boolean matchRedNumber(Number number) {
        boolean matchResult = false;
        String sql = "select * from shuangseqiu where red1 = ? and red2 = ? and red3 = ? and red4 = ? and red5 = ? and red6 = ?";
        Connection connection = ConnectMysql.getConnnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, number.getRed1());
            preparedStatement.setInt(2, number.getRed2());
            preparedStatement.setInt(3, number.getRed3());
            preparedStatement.setInt(4, number.getRed4());
            preparedStatement.setInt(5, number.getRed5());
            preparedStatement.setInt(6, number.getRed6());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                matchResult = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询异常");
        } finally {
            ConnectMysql.closeConnection();
            return matchResult;
        }
    }

    public boolean matchNumber(Number number) {
        boolean matchResult = false;
        String sql = "select * from shuangseqiu where red1 = ? and red2 = ? and red3 = ? and red4 = ? and red5 = ? and red6 = ? and blue1 = ?";
        Connection connection = ConnectMysql.getConnnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, number.getRed1());
            preparedStatement.setInt(2, number.getRed2());
            preparedStatement.setInt(3, number.getRed3());
            preparedStatement.setInt(4, number.getRed4());
            preparedStatement.setInt(5, number.getRed5());
            preparedStatement.setInt(6, number.getRed6());
            preparedStatement.setInt(7, number.getBlue1());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                matchResult = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询异常");
        } finally {
            ConnectMysql.closeConnection();
            return matchResult;
        }
    }

    public int matchDoubleRedNumber(Number number) {
        int numberCount = 0;
        int redNumberArray[] = new int[6];
        redNumberArray[0] = number.getRed1();
        redNumberArray[1] = number.getRed2();
        redNumberArray[2] = number.getRed3();
        redNumberArray[3] = number.getRed4();
        redNumberArray[4] = number.getRed5();
        redNumberArray[5] = number.getRed6();
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 6; j++) {
                numberCount = numberCount + CountNumber.countDoubleRedNumberAgain(redNumberArray[i], redNumberArray[j]);
            }
        }
        return numberCount;
    }

    public int matchTripleRedNumber(Number number) {
        return 0;
    }

    public int matchUltraRedNumber(Number number) {
        return 0;
    }

    public int matchRampageRedNumber(Number number) {
        return 0;
    }
}
