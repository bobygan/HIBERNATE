package hibernate.lesson5_1;

public class Demo {
    public static void main(String[] args) {
        ProductRepository productRepository=new ProductRepository();
        Product product=new Product();
        product.setId(25);
        product.setName("te-!!!!!!1");
        product.setDescription("grey & blue!!!!!!!!1");
        product.setPrice(700);

        productRepository.save(product);
        product.setPrice(300);
        ProductRepository.update(product);
        productRepository.delete(product.getId());
    }

}
