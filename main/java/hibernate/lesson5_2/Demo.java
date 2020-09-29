package hibernate.lesson5_2;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        Product product = new Product();
        product.setName("table  1");
        product.setDescription("grey & blue");
        product.setPrice(70);

        System.out.println(product);
        System.out.println(productDao.save(product));

        product.setDescription("ASDFG");
        product.setId(99);
        System.out.println(productDao.update(product));
        System.out.println(productDao.delete(product));

        Product product1 = new Product();
        product1.setId(100);
        product1.setName("table  11");
        product1.setDescription("grey & blue");
        product1.setPrice(1);

        Product product2 = new Product();
        product2.setName("table  12");
        product2.setDescription("grey & blue");
        product2.setPrice(2);

        Product product3 = new Product();
        product3.setName("table  13");
        product3.setDescription("grey & blue");
        product3.setPrice(3);


        product1.setId(103);
        product2.setId(105);
        product3.setId(107);

        List<Product> products = Arrays.asList(product1, product2, product3);
        //  ProductDao.saveAll(products);
        ProductDao.updateAll(products);
        //  ProductDao.deleteAll(products);
        //    delete(product1);
    }

}
