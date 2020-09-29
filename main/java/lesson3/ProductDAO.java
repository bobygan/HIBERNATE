package lesson3;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {


    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.cdljhcyb8kvt.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "9010qwer";


    private static final String sqlRequestSaveProduct = "INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE) VALUES (?,?,?,?)";
    private static final String sqlRequestUpdateProduct = "UPDATE PRODUCT SET NAME=?, DESCRIPTION=?, PRICE=? WHERE ID=?";
    private static final String sqlRequestGetProducts = "SELECT * FROM PRODUCT";
    private static final String sqlRequestDeleteProduct = "DELETE FROM PRODUCT WHERE  ID =?";

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


    public Product save(Product product) {
        try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestSaveProduct)) {
            prepareStatement.setLong(1, product.getId());
            prepareStatement.setString(2, product.getName());
            prepareStatement.setString(3, product.getDescription());
            prepareStatement.setInt(4, product.getPrice());

            int res = prepareStatement.executeUpdate();
            System.out.println("save was finished with result" + res);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return product;
    }


    public Product update(Product product) {
        try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestUpdateProduct)) {
            prepareStatement.setLong(4, product.getId());
            prepareStatement.setString(1, product.getName());
            prepareStatement.setString(2, product.getDescription());
            prepareStatement.setInt(3, product.getPrice());

            int res = prepareStatement.executeUpdate();
            System.out.println("update was finished with result  " + res);
            return product;

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProducts() throws Exception {
        try (Statement statement = connect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlRequestGetProducts);


            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                products.add(product);
            }
            return products;

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
            throw e;
        }

    }


    public void delete(long id) {
        try (PreparedStatement prepareStatement = connect().prepareStatement(sqlRequestDeleteProduct)) {
            prepareStatement.setLong(1, id);

            int res = prepareStatement.executeUpdate();
            System.out.println("delete was finished with result" + res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }


}
