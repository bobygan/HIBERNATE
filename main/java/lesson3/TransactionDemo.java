package lesson3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransactionDemo {

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


    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }


    public void save(List<Product> products) {

        try (Connection connection=getConnection()){
            saveList(products,connection);
        }

        catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void saveList(List<Product> products,Connection connection)throws SQLException {


        long ID=0;
        try (PreparedStatement prepareStatement = connection.prepareStatement(sqlRequestSaveProduct)) {
            connection.setAutoCommit(false);

            for(Product product:products) {
                ID=product.getId();
                prepareStatement.setLong(1, product.getId());
                prepareStatement.setString(2, product.getName());
                prepareStatement.setString(3, product.getDescription());
                prepareStatement.setInt(4, product.getPrice());

                int res = prepareStatement.executeUpdate();

            }
            connection.commit();

        } catch (SQLException e) {
            System.err.println("SAVE WITH ID = "+ID+" WRONG");
            connection.rollback();
            throw e;
        }
    }

}
