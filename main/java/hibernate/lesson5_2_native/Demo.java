package hibernate.lesson5_2_native;

public class Demo {
    public static void main(String[] args) {
        ProductDao productDao=new ProductDao();
        long ID=3;
          System.out.println( productDao.findById(ID));
          System.out.println( productDao.findByName("table  new"));
          System.out.println( productDao.findByContainedName("ab"));
          System.out.println( productDao.findByPrice(60,10));
          System.out.println( productDao.findByNameSortedAsc());
          System.out.println( productDao.findByNameSortedDecs());
          System.out.println( productDao.findByPriceSortedDesc(59,10));
    }
}
