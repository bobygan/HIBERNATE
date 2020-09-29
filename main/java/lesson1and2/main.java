package lesson1and2;

public class main {
    public static void main(String[] args) {
       // JDBCFirstStep jdbcFirstStep=new JDBCFirstStep();
       // jdbcFirstStep.getClass();

        Solution solution=new Solution();
          solution.saveProduct();
          solution.deleteProducts();
          solution.deleteProductsByPrice();
          solution.getAllProducts();
          solution.getProductsByPrice();
       // solution.getProductsDescription();
//solution.getProductsByPrice();
         solution.increasePrice();
       //  solution.changeDescription();

        //System.out.println(solution.textFormating("kenicn. Kejfkcj. kefjckej. k"));
    }
}
