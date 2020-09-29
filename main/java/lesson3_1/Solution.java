package lesson3_1;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {


    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.cdljhcyb8kvt.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "9010qwer";


    private static final String sqlRequestFindProductsWithEmptyDescription = "SELECT * FROM PRODUCT WHERE  Description is null";
    private static final String sqlRequestFindProductsByPrice = "SELECT * FROM PRODUCT WHERE  PRICE BETWEEN ? AND ? ";
    private static final String sqlRequestFindProductsByName = "SELECT * FROM PRODUCT WHERE  NAME =? ";


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


    public List<Product> findProductsByPrice(int price, int delta) {
        try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestFindProductsByPrice)) {

            prepareStatement.setInt(1, price - delta);
            prepareStatement.setInt(2, price + delta);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.equals(null)) throw new NullPointerException("Unable to get data");
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                products.add(product);
            }
            return products;

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> findProductsByName(String word) {

        try {
            validate(word);

            try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestFindProductsByName)) {
                prepareStatement.setString(1, word);
                ResultSet resultSet = prepareStatement.executeQuery();
                if (resultSet.equals(null)) throw new NullPointerException("Unable to get data");
                List<Product> products = new ArrayList<>();

                while (resultSet.next()) {
                    Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                    products.add(product);
                }
                return products;

            } catch (SQLException e) {
                System.err.println("Something went wrong");
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public List<Product> findProductsWithEmptyDescription() {
        try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestFindProductsWithEmptyDescription)) {

            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.equals(null)) throw new NullPointerException("Unable to get data");
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                products.add(product);
            }
            return products;

        }
        catch (NullPointerException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();}

        catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    private void validate(String string) throws Exception {
        if (string.isEmpty() || string == null)
            throw new Exception(string + " - did not enter the word");


        String[] words = string.split(" ");
        if (words.length > 1)
            throw new Exception(string + " - more than one word  !!!!");


        char[] c = string.toCharArray();
        if (c.length < 3)
            throw new Exception(string + " - less than three characters !!!!");


        for (char temp : c) {
            if (!Character.isLetter(temp) && !Character.isDigit(temp))
                throw new Exception(string + " - contains special characters !!!!");
        }

    }


}
