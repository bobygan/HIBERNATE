package lesson1and2;

import java.sql.*;

public class Solution {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.cdljhcyb8kvt.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "9010qwer";



    private static final String sqlRequestSaveProduct="INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE) VALUES (25,'toy8','for. aaaa. ssdd. dwejwneu. nghgbh. flkk. sfm ve. fklkmknkn.  fjrjr  revchildren.',600)";
    private static final String sqlRequestDeleteProducts="DELETE FROM PRODUCT WHERE  NAME  <>'toy'";
    private static final String sqlRequestDeleteProductsByPrice="DELETE FROM PRODUCT WHERE  PRICE < 100";

    private static final String sqlRequestChangeDescription="SELECT * FROM PRODUCT";
    private static final String sqlRequestIncreasePrice="SELECT * FROM PRODUCT WHERE PRICE <70";

    private static final String sqlRequestGetAllProducts="SELECT * FROM PRODUCT";
    private static  final String sqlRequestGetProductsDescription="SELECT * FROM PRODUCT";
    private static final String sqlRequestGetProductsByPrice="SELECT * FROM PRODUCT WHERE PRICE <100";

     {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + JDBC_DRIVER + " not found");
            //  return;
        }
    }


    private  Statement connect()throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement statement = connection.createStatement();
          return statement;
    }



    public void saveProduct() {
        try (Statement statement =  connect())
        {
            boolean res = statement.execute(sqlRequestSaveProduct);
            System.out.println(res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }

    }

    public void deleteProducts() {
        try (Statement statement =  connect())
        { statement.executeUpdate(sqlRequestDeleteProducts); }

        catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void deleteProductsByPrice() {
        try (Statement statement = connect())
            { statement.executeUpdate(sqlRequestDeleteProductsByPrice); }
        catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void getAllProducts() {
        try (ResultSet resultSet = connect().executeQuery(sqlRequestGetAllProducts))
             {
                while (resultSet.next()) {
                    Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                    System.out.println(product.toString());

            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void getProductsByPrice() {
        try (ResultSet resultSet = connect().executeQuery(sqlRequestGetProductsByPrice)) {
            {
                while (resultSet.next()) {
                    Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                    System.out.println(product.toString());
                }
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void getProductsDescription() {
        try (ResultSet resultSet = connect().executeQuery(sqlRequestGetProductsDescription)) {
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                if (product.getDescription().length() > 50) {
                    System.out.println(product.toString());
                }
            }
        }

         catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void increasePrice() {
        try (ResultSet resultSet = connect().executeQuery(sqlRequestIncreasePrice)) {
            {
                while (resultSet.next()) {
                    Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                    updateProductPrice(product);
                }
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void changeDescription() {
        try (ResultSet resultSet = connect().executeQuery(sqlRequestChangeDescription))
        {

                while (resultSet.next()) {
                    Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                    if ( countWords(product.getDescription())  > 50) {
                        updateProductDescription(product);
                    }
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }


    private void updateProductPrice(Product product) {

        String comand = "UPDATE PRODUCT SET PRICE=" + (product.getPrice() + 100) + "WHERE ID=" + product.getId();

        try (Statement statement = connect())
        {
            boolean res = statement.execute(comand);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    private void updateProductDescription(Product product) {

        String  tempString =textFormating(product.getDescription());
        String comand = "UPDATE PRODUCT SET DESCRIPTION = " +"'"+ tempString +"'"+ "WHERE ID =" + product.getId();

        System.out.println(comand);
        try (Statement statement =connect()) {
            boolean res = statement.execute(comand);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }



    public String textFormating (String text){

        //РАЗБИВКА СТРОК НА ПРЕДЛОЖЕНИЯ
        String[] words = text.split("\\s+");
        String OUT="";
        for (int i = 0; i < words.length-1; i++) {
            OUT+=words[i];
            }
        return OUT;
    }


    private int countWords(String input) {
        if (input == null)
            return 0;
        String[] words = input.split(" ");
        int res = 0;
        for (String temp : words) {
            if (validateWord(temp)) {
                res++;
            }
        }
        return res;
    }

    private boolean validateWord(String string) {
        if (string.isEmpty() || string == null)
            return false;

        char[] c = string.toCharArray();

        for (char temp : c) {
            if (!Character.isLetter(temp) && !Character.isDigit(temp))
                return false;
        }
        return true;
    }

}