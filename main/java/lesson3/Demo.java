package lesson3;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws Exception {

    //    Product product = new Product((long) 19, "HM", "SVITER", 1222);
      //  ProductDAO productDAO = new ProductDAO();
      //  System.out.println(productDAO.save(product).toString());
     //   productDAO.delete(19);
      //  System.out.println(productDAO.getProducts());
      //  System.out.println( productDAO.update(product));

        TransactionDemo transactionDemo=new TransactionDemo();
        Product produc1 = new Product((long) 121, "HM", "SVITER", 1222);
        Product produc2 = new Product((long) 122, "HM", "SVITER", 1222);
        Product produc3 = new Product((long) 123, "HM", "SVITER", 1222);



        ArrayList<Product>products=new ArrayList<>();

        products.add(produc1);
        products.add(produc2);
        products.add(produc3);
        transactionDemo.save(products);

    }

}

