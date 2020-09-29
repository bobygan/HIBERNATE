package lesson3_2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

public class Solution {


    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.cdljhcyb8kvt.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "9010qwer";


    {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + JDBC_DRIVER + " not found");
        }
    }


    private Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        // Statement statement = connection.createStatement();
        return connection;
    }

    TestSpeedDAO testSpeedDAO = new TestSpeedDAO();

    long startTime = 0;

    public long testSavePerformance() {
        startTime = System.currentTimeMillis();
        Random rend = new Random();
        String text;
        int number;

        for (int id = 1; id <= 10; id++) {
            number = rend.nextInt(1000);
            char[] temp = {(char) (rend.nextInt(26) + 'a')};
            text = String.valueOf(temp);

            TEST_SPEED test_speed = new TEST_SPEED((long) id, text, number);
            testSpeedDAO.save(test_speed);

        }
         return (System.currentTimeMillis() - startTime);
    }

    public long testDeleteByIdPerformance() {
        startTime = System.currentTimeMillis();
        for (long i = 1; i <= 10; i++) {
            testSpeedDAO.deleteById(i);
        }
        return (System.currentTimeMillis()-startTime);
    }

    public long testDeletePerformance() {
        startTime = System.currentTimeMillis();
        testSpeedDAO.deleteAll();
        return (System.currentTimeMillis()-startTime);
    }

    public long testSelectByIdPerformance() {
        startTime = System.currentTimeMillis();
        for (long i = 1; i <= 10; i++) {
            System.out.println( testSpeedDAO.getById(i));
        }
        return (System.currentTimeMillis()-startTime);
    }

    public long testSelectPerformance() {
        startTime = System.currentTimeMillis();
        System.out.println(testSpeedDAO.getAll());
        return (System.currentTimeMillis()-startTime);
    }
}

