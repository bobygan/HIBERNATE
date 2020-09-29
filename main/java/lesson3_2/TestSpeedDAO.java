package lesson3_2;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestSpeedDAO {


    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.cdljhcyb8kvt.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "9010qwer";


    private static final String sqlRequestSave = "INSERT INTO TEST_SPEED (ID, SOME_STRING , SOME_NUMBER) VALUES (?,?,?)";
    private static final String sqlRequestGetAll = "SELECT * FROM TEST_SPEED";
    private static final String sqlRequestGetById = "SELECT * FROM TEST_SPEED WHERE ID =?";
    private static final String sqlRequestDeleteAll = "DELETE FROM TEST_SPEED";
    private static final String sqlRequestDeleteById = "DELETE FROM TEST_SPEED WHERE ID =?";

    {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + JDBC_DRIVER + " not found");
        }
    }


    private Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }


    public TEST_SPEED save(TEST_SPEED test_speed) {
        try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestSave)) {
            prepareStatement.setLong(1, test_speed.getId());
            prepareStatement.setString(2, test_speed.getSome_string());
            prepareStatement.setInt(3, test_speed.getSome_number());

            int res = prepareStatement.executeUpdate();
            if (res == 0) throw new IOException();
            System.out.println("save was finished with result " + res);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Unable to save data");
            e.printStackTrace();
        }
        return test_speed;
    }


    public List<TEST_SPEED> getAll() {
        try (Statement statement = connect().createStatement()) {

            ResultSet resultSet = statement.executeQuery(sqlRequestGetAll);
            if (resultSet.equals(null)) throw new NullPointerException();
            List<TEST_SPEED> test_speeds = new ArrayList<>();
            while (resultSet.next()) {
                TEST_SPEED test_speed = new TEST_SPEED(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3));
                test_speeds.add(test_speed);
            }
            return test_speeds;
        } catch (NullPointerException e) {
            System.err.println("Unable to get data");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }


    public TEST_SPEED getById(Long id) {
        try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestGetById)) {

            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.equals(null)) throw new NullPointerException();
            resultSet.next();
            TEST_SPEED test_speed = new TEST_SPEED(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3));
            return test_speed;

        } catch (NullPointerException e) {
            System.err.println("Unable to get data");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(long id) {
        try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestDeleteById)) {
            prepareStatement.setLong(1, id);

            int res = prepareStatement.executeUpdate();
            if (res == 0) throw new IOException();
            System.out.println("delete was finished with result " + res);
        } catch (IOException e) {
            System.err.println("Unable to delete data");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try (Statement statement = connect().createStatement()) {
            statement.executeUpdate(sqlRequestDeleteAll);
            if (statement.equals(null)) throw new NullPointerException();

        } catch (NullPointerException e) {
            System.err.println("Unable to delete data");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

}
