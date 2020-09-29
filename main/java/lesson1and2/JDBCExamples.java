package lesson1and2;

import java.sql.*;

public class JDBCExamples {


    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.cdljhcyb8kvt.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "9010qwer";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            boolean res = statement.execute("INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE) VALUES (1,'toy','for children',60)");
            System.out.println(res);
                    }  catch (SQLException e) {
                System.err.println("Something went wrong");
                e.printStackTrace();
            }

        }
    }
